package com.qdqtrj.pay.https.request.impl;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.AccpPayException;
import com.qdqtrj.pay.https.request.AccpPayRequest;
import com.qdqtrj.pay.https.request.AccpResponseResult;
import com.qdqtrj.pay.util.AccpPayHttpClient;
import com.qdqtrj.pay.util.SignatureUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Accp支付平台接口统一的请求封装:
 * 1. https实现
 * 2. ca证书签名加密请求报文的实现
 * 3. ca证书验证返回数据报文的实现
 * 不包括数据去冲和https异步回调的实现，因涉及业务逻辑，需接口使用者自己实现
 * 采用枚举单例模式
 * @author yinbin
 */
@Slf4j
public final class AccpSignRequestImpl implements AccpPayRequest {

    //私有化构造函数
    private AccpSignRequestImpl() {
    }

    //对外暴露一个获取User对象的静态方法
    public static AccpSignRequestImpl getInstance() {
        return SingletonEnum.INSTANCE.getInstnce();
    }

    @Override
    public AccpResponseResult doRequest(AccpPayConfig accpPayConfig, String apiPath, String jsonData) throws AccpPayException {
        HttpClient httpClient = AccpPayHttpClient.getInstance(accpPayConfig.getReqTimeout());
        log.debug("请求报文:" + jsonData);
        HttpPost post = new HttpPost(accpPayConfig.getPayDomainServerUrl() + apiPath);
        log.debug("请求URL [" + apiPath + "]");
        post.setHeader("Content-Type", "application/text;charset=UTF-8");
        try {
            String signatureData = SignatureUtil.getInstance().sign(accpPayConfig.getRsaPrivateKey(), jsonData);
            log.debug("请求signatureData [" + signatureData + "]");
            post.addHeader(SIGNATURE_TYPE, "RSA");
            post.addHeader(SIGNATURE_DATA, signatureData);
            StringEntity formEntiry = new StringEntity(jsonData, "UTF-8");
            // 设置请求参数
            post.setEntity(formEntiry);
            // 发起交易
            HttpResponse resp = httpClient.execute(post);
            // 响应分析
            HttpEntity entity = resp.getEntity();
            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8));
            StringBuilder responseString = new StringBuilder();
            String result = br.readLine();
            while (result != null) {
                responseString.append(result);
                result = br.readLine();
            }
            // 直接获取返回的字符串
            String responseJson = responseString.toString();
            log.debug("返回报文:" + responseJson);
            String resSignatureData = "";
            Header[] headers = resp.getAllHeaders();
            int i = 0;
            while (i < headers.length) {
                log.debug(headers[i].getName() + ":  " + headers[i].getValue());
                if (SIGNATURE_DATA.equals(headers[i].getName())) {
                    resSignatureData = headers[i].getValue();
                }
                i++;
            }
            boolean checkSign = SignatureUtil.getInstance().checksign(accpPayConfig.getRsaPublicKey(), responseJson, resSignatureData);
            log.debug("验证签名结果:" + checkSign);
            return new AccpResponseResult(checkSign, responseJson);
        } catch (Exception cte) {
            throw new AccpPayException(cte.getMessage());
        }
    }

    //定义一个静态枚举类
    enum SingletonEnum {
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private final AccpSignRequestImpl impl;

        //私有化枚举的构造函数
        SingletonEnum() {
            impl = new AccpSignRequestImpl();
        }

        public AccpSignRequestImpl getInstnce() {
            return impl;
        }
    }

}

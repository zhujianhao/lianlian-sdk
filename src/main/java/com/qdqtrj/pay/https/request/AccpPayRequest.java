package com.qdqtrj.pay.https.request;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.AccpPayException;

/**
 * accp支付平台统一请求接口
 * @author yinbin
 */
public interface AccpPayRequest {

    /**
     * header请求头name，用于标识签名加密类型，默认为：RSA
     */
    String SIGNATURE_TYPE = "Signature-Type";

    /**
     * response 的 header头name，用于标识ca证书加密的请求报文
     */
    String SIGNATURE_DATA = "Signature-Data";

    /**
     * 初步抽象封装accp所有接口，更深层次封装直接返回json对应Bean
     *
     * @param apiPath  accp支付平台某个接口的地址,不包括通用域名和通用的地址部分
     * @param jsonData 向accp支付平台发送的json报文（未加密过的，由相应的Bean序列化）
     * @return 返回请求报文json字符串
     */
    AccpResponseResult doRequest(AccpPayConfig accpPayConfig, String apiPath, String jsonData) throws AccpPayException;

}

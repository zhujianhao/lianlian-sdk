package com.qdqtrj.pay.api.notify;

import com.alibaba.fastjson.JSON;
import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.util.SignatureUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * notify and return url，预处理工具类
 * 减少回调非业务代码的编写
 * @author yinbin
 */
public abstract class AccpNotifyCallback<T> {

    public static final String SUCCESS = "Success";
    public static final String FAILED = "";

    private static String getBody(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }
        return wholeStr;
    }

    /**
     * 通用回调预处理方法
     *
     * @param accpPayConfig
     * @param request       spring中获取的或者servlet容器传递的  request封装对象
     * @param notifyClass   异步通知javabean class
     * @return
     */
    public String pretreatment(AccpPayConfig accpPayConfig, HttpServletRequest request,
                               Class<T> notifyClass) throws IOException {

        // 1. 获取返回数据
        String notifyJsonStr = getBody(request);
        System.out.println("json-------------->:" + notifyJsonStr);

        // 2. 验签，失败抛出异常（属于配置错误)
        StringBuilder resSignData = new StringBuilder();
        Enumeration<String> headers = request.getHeaders("Signature-Data");
        while (headers.hasMoreElements()) {
            String s = headers.nextElement();
            resSignData.append(s);
        }
        System.out.println("signData-------------->:" + resSignData);

        boolean checkSign = SignatureUtil.getInstance()
                .checksign(accpPayConfig.getRsaPublicKey(), notifyJsonStr, resSignData.toString());
        System.out.println("checkSign result ----------------->:" + checkSign);
        if (!checkSign) return FAILED;// 验签失败

        // 3. 解析 json 到 java bean
        T notifyBean = JSON.parseObject(notifyJsonStr, notifyClass);
        try {

            // 4. 调用 notifyCallback 给业务代码传递 解析后的 java bean(需要将去冲做到业务方法中，去冲处理,队列缓冲)
//            boolean isSuccess = notifyCallback.doCallback(notifyBean);
            boolean isSuccess = businessCode(notifyBean);

            // 5. 返回给accp成功或失败标识字符
            return isSuccess ? SUCCESS : FAILED;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 你需要new 此抽象类的子类，实现业务逻辑的处理。
     * <p>
     * businessCode 前后做了一些通用处理：
     * 1. 验签
     * 2. 解码json
     * 3. 调用 你自己编写的业务方法
     * 4. 处理异常
     * 5. 返回accp结果
     */
    protected abstract boolean businessCode(T notifyBean);

}

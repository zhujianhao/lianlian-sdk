package com.qdqtrj.pay;

/**
 * Accp支付平台请求报文验证异常
 * @author yinbin
 */
public class AccpReqParamException extends Exception {

    public AccpReqParamException() {
        super();
    }

    public AccpReqParamException(String str) {
        super("Accp支付平台请求报文验证异常, " + str);
    }
}

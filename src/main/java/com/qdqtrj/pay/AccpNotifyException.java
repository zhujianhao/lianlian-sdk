package com.qdqtrj.pay;

/**
 * Accp支付平台异步通知异常
 * @author yinbin
 */
public class AccpNotifyException extends Exception {

    public AccpNotifyException() {
        super();
    }

    public AccpNotifyException(String str) {
        super("Accp支付平台异步通知异常, " + str);
    }
}

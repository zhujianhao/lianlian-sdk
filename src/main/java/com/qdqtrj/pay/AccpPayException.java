package com.qdqtrj.pay;

/**
 * Accp支付平台异常
 * @author yinbin
 */
public class AccpPayException extends Exception {

    public AccpPayException() {
        super();
    }

    public AccpPayException(String str) {
        super("Accp支付平台异常, " + str);
    }
}

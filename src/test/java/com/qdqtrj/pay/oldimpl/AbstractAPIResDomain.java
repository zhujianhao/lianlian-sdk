package com.qdqtrj.pay.oldimpl;

import java.io.Serializable;

public class AbstractAPIResDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ret_code; // 交易结果代码
    private String ret_msg; // 交易结果描述

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

}

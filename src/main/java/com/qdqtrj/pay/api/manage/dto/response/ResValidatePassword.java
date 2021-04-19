package com.qdqtrj.pay.api.manage.dto.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 3.21. 支付密码校验 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/validate-password
 */
@Data
public class ResValidatePassword implements Serializable {
    /**
     * ret_code,交易结果代码,Y,String,交易返回码,0000:验证成功
     */
    @NotBlank()
    private String ret_code;
    /**
     * ret_msg,交易结果描述,Y,String,交易返回描述
     */
    @NotBlank()
    private String ret_msg;
    /**
     * oid_partner,商户号,Y,String,ACCP 系统分配给平台商户的唯一编号
     */
    @NotBlank()
    private String oid_partner;
    /**
     * user_id,商户用户唯一编号,Y,String,用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户
     */
    @NotBlank()
    private String user_id;
}


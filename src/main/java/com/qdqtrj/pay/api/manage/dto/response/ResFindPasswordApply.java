package com.qdqtrj.pay.api.manage.dto.response;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 3.12. 找回密码 3.12.1.  申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/find-password-apply
 */
@Data
public class ResFindPasswordApply implements Serializable {
    /**
     * ret_code,交易结果代码,Y,String(4)
     */
    @NotBlank()
    @Length(min = 1, max = 4)
    private String ret_code;
    /**
     * ret_msg,交易结果描述,Y,String(32)
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String ret_msg;
    /**
     * oid_partner,商户号,Y,String(18),账户+分配给商户的唯一编号
     */
    @NotBlank()
    @Length(min = 1, max = 18)
    private String oid_partner;
    /**
     * user_id,商户用户唯一编号,Y,String(64),用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String user_id;
    /**
     * token,授权令牌,N,String(32)
     */
    @Length(min = 1, max = 32)
    private String token;
    /**
     * reg_phone,接收短验手机号,N,String(11),手机号脱敏处理，举例：183****5737
     */
    @Length(min = 1, max = 11)
    private String reg_phone;
}


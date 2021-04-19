package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 3.3.2. 开户验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/openacct-verify-individual
 */
@Data
public class ReqOpenacctVerifyIndividual implements Serializable {
    /**
     * timestamp,时间戳,Y,String(14),交易服务器时间戳,格式：yyyyMMddHHmmss,有效期30分钟,包含服务器之间的时间差
     */
    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;
    /**
     * oid_partner,商户号,Y,String(18),ACCP 系统分配给平台商户的唯一编号
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
     * txn_seqno,交易流水号,Y,String(64),商户系统唯一交易流水号
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String txn_seqno;
    /**
     * token,授权令牌,Y,String(32),申请接口返回的交易授权令牌
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String token;
    /**
     * verify_code,银行预留手机短信验,N,String(20),开户申请时提供的绑卡信息中的银行证码,预留手机发送的短信验证码，用于验证开户绑卡; 商户配置无验预留手机号，则非必 填；反之，必送
     */
    @Length(min = 1, max = 20)
    private String verify_code;
    /**
     * password,密码,Y,String,密码
     */
    @NotBlank()
    private String password;
    /**
     * random_key,密码随机因子key,Y,String,通过3.13随机因子获取接口获取
     */
    @NotBlank()
    private String random_key;
}

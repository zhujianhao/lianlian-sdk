package com.qdqtrj.pay.api.manage.dto.response;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 3.13. 随机因子获取 3.13.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/get-random
 */
@Data
public class ResGetRandom implements Serializable {
    /**
     * ret_code,交易结果代码,Y,String(4),交易返回码
     */
    @NotBlank()
    @Length(min = 1, max = 4)
    private String ret_code;
    /**
     * ret_msg,交易结果描述,Y,String(32),交易返回描述
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String ret_msg;
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
     * random_key,随机因子key,N,String,交易成功时必填,有效期10分钟
     */
    private String random_key;
    /**
     * random_value,随机因子值,N,String(32),交易成功时必填,有效期10分钟
     */
    @Length(min = 1, max = 32)
    private String random_value;
    /**
     * license,license,N,String(1024),交易成功且flag_chnl为,ANDROID、IOS与H5时返回
     */
    @Length(min = 1, max = 1024)
    private String license;
    /**
     * map_arr,映射数组,N,String(1024),交易成功且flag_chnl为H5时返回
     */
    @Length(min = 1, max = 1024)
    private String map_arr;
    /**
     * rsa_public_content,连连RSA公钥,N,String(1024),交易成功时必填
     */
    @Length(min = 1, max = 1024)
    private String rsa_public_content;
    /**
     * 使用国密算法返回
     *
     */
    private String sm2_key_hex;
}


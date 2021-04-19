package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 3.13. 随机因子获取 3.13.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/get-random
 */
@Data
public class ReqGetRandom implements Serializable {
    public final static String ANDROID = "ANDROID";
    public final static String IOS = "IOS";
    public final static String H5 = "H5";
    public final static String PC = "PC";

    /**
     * timestamp,时间戳,Y,String(14),交易服务器时间戳格式：yyyyMMddHHmmss,有效期 30 分钟（包含服务器之间的时间差）
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
     * flag_chnl,应用渠道,Y,String(10),交易发起渠道 ANDROID IOS H5 PC
     */
    @NotBlank()
    @Length(min = 1, max = 10)
    private String flag_chnl;
    /**
     * pkg_name,APP包名,N,String(256),flag_chnl为H5时，送商户一级域名,（支持ip）
     */
    @Length(min = 1, max = 256)
    private String pkg_name;
    /**
     * app_name,APP应用名,N,String(256),flag_chnl为H5时，送商户一级域名,（支持IP）
     */
    @Length(min = 1, max = 256)
    private String app_name;
}

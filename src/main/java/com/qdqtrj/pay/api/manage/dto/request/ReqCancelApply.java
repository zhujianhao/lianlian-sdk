package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 3.10. 销户 3.10.1.  销户申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/cancel-apply
 */
@Data
public class ReqCancelApply implements Serializable {
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
     * txn_time,交易时间,Y,String(14),商户系统交易时间格式：yyyyMMddHHmmss
     */
    @NotBlank()
    @Length(min = 1, max = 14)
    private String txn_time;
    /**
     * notify_url,异步通知地址,Y,String(512),交易结果异步通知接收地址，建议HTTPS协议
     */
    @NotBlank()
    @Length(min = 1, max = 512)
    private String notify_url;
    /**
     * user_name,用户名称,Y,String(85),姓名/企业名称
     */
    @NotBlank()
    @Length(min = 1, max = 85)
    private String user_name;
    /**
     * id_type,证件类型,Y,String(32),身份证：ID_CARD,统一社会信用代码证：UNIFIED_SOCIAL_CREDIT_CODE
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String id_type;
    /**
     * id_no,证件号码,Y,String(64),证件号码
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String id_no;
    /**
     * reg_phone,绑定手机号,Y,String(11)
     */
    @NotBlank()
    @Length(min = 1, max = 11)
    private String reg_phone;
    /**
     * password,密码,Y,String xxx
     */
    @NotBlank()
    private String password;
    /**
     * random_key,密码随机因子key,Y,String
     */
    @NotBlank()
    private String random_key;
}

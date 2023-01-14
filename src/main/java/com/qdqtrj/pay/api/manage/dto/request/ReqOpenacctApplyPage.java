package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


/**
 *  开户申请(页面) 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/openacct-apply
 */
@Data
public class ReqOpenacctApplyPage implements Serializable {

    private static final long serialVersionUID = -5767409172741135479L;
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
     * user_id,商户用户唯一编 Y,String(64),用户在商户系统中的唯一编号，要求号该编号在商户系统能唯一标识用户
     */
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
     * 交易发起渠道。
     * ANDROID
     * IOS
     * H5
     * PC
     * 目前只支持H5。
     */
    private String flag_chnl;

    private String return_url;

    /**
     * notify_url,异步通知地址,Y,String(512),交易结果异步通知接收地址，建议HTTPS协议
     */
    @NotBlank()
    @Length(min = 1, max = 512)
    private String notify_url;

    /**
     * 用户类型。
     * INNERUSER：个人用户
     * INNERCOMPANY：企业用户
     */
    private String user_type;
    /**
     * open_sms_flag,开户成功短信通 N,String(1),开户成功短信通知通知,Y：发送,N：不发送,默认是N,注：：该功能需要商户合作银行支持，暂只满足富民银行
     */
    private String open_sms_flag;
    /**
     * risk_item,风控参数,N,String,参见‘风控参数’
     */
    private String risk_item;

    /**
     * 开户基本信息 basicInfo
     */
    private BasicInfo basicInfo;
    /**
     * 开户绑卡信息 linkedAcctInfo
     */
    private LinkedAcctInfo linkedAcctInfo;
    /**
     * 企业法定代表人信息 legalreptInfo
     */
    private LegalreptInfo legalreptInfo;
    /**
     * 企业联系人信息 contactsInfo
     */
    private ContactsInfo contactsInfo;
    /**
     * 企业经营信息 businessInfo
     */
    private BusinessInfo businessInfo;

    private AccountInfo accountInfo;


    /**
     * 开户基本信息 basicInfo
     */
    @Data
    public static class BasicInfo {

        /**
         * reg_phone,绑定手机号码,Y,String(11),用户开户绑定手机号
         */
        @NotBlank()
        @Length(min = 1, max = 11)
        private String reg_phone;
        /**
         * user_name,用户名称,Y,String(85),用户名称（企业用户则是企业名称，个人用户则是姓名）
         */
        @NotBlank()
        @Length(min = 1, max = 85)
        private String user_name;
        /**
         * id_type,证件类型,Y,String(32),统一社会信用代码证：UNIFIED_SOCIAL_CREDIT_CODE
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
         * id_exp,证件有效期,Y,String(8),证件到期日，格式：yyyyMMdd,长期有效则设置为：99991231
         */
        @NotBlank()
        @Length(min = 1, max = 8)
        private String id_exp;
        /**
         * address,地址,Y,String(85),企业地址
         */
        @NotBlank()
        @Length(min = 1, max = 85)
        private String address;
        /**
         * reg_email,注册邮箱,Y,String(32) xx
         */
        @NotBlank()
        @Length(min = 1, max = 32)
        private String reg_email;

        /**
         * 职业，个人用户必填。
         */
        @NotBlank()
        private String occupation;
    }

    /**
     * 开户绑卡信息 linkedAcctInfo
     */
    @Data
    public static class LinkedAcctInfo {

        /**
         * 绑定账户类型。
         * 企业对公户：ENTERPRISE_BANK_ACCT
         * 法人银行卡：LEGALREPT_BANK_CARD
         * 注：值为空，默认为企业对公户
         * 行业代码为400个体工商户时允许法人银行卡。
         */
        private String linked_accttype;
        /**
         * linked_acctno,绑定银行帐号,Y,String(32),企业用户绑定的银行帐号
         */
        @NotBlank()
        @Length(min = 1, max = 32)
        private String linked_acctno;
        /**
         * linked_bankcode,银行编码,Y,String(8)
         */
        @NotBlank()
        @Length(min = 1, max = 8)
        private String linked_bankcode;
        /**
         * linked_brbankname,对公账户开户行 N,String(85),企业用户绑定账户开户支行名称名
         */
        private String linked_brbankname;
        /**
         * linked_brbankno,对公账户开户行 Y,String(12),企业用户开户行行号，企业用户必填号
         */
        private String linked_brbankno;
        /**
         * linked_acctname,对公账户名,Y,String(85),企业用户必填
         */
        @NotBlank()
        @Length(min = 1, max = 85)
        private String linked_acctname;

        /**
         * 银行预留手机号。个人用户绑卡必传。
         */
        @NotBlank()
        private String linked_phone;
    }

    /**
     * 企业法定代表人信息 legalreptInfo
     */
    @Data
    class LegalreptInfo {


        /**
         * legalrept_name,法定代表人姓名,Y,String(85),法定代表人姓名
         */
        @NotBlank()
        @Length(min = 1, max = 85)
        private String legalrept_name;
        /**
         * legalrept_phone,法定代表人手机 Y,String(11),法定代表人手机号号
         */
        private String legalrept_phone;
        /**
         * legalrept_idno,法定代表人身份 Y,String(64),法定代表人身份证号证号
         */
        private String legalrept_idno;
        /**
         * legalrept_idexp,法定代表人身份 Y,String(8),法定代表人身份证到期日，格式：yyyyMMdd,长期有效则设置为：99991231
         */
        private String legalrept_idexp;
    }

    /**
     * 企业联系人信息 contactsInfo
     */
    @Data
    public static class ContactsInfo {
        /**
         * contacts_name,联系人姓名,Y,String(85),联系人姓名
         */
        @NotBlank()
        @Length(min = 1, max = 85)
        private String contacts_name;
        /**
         * contacts_phone,联系人手机号,Y,String(11),联系人手机号
         */
        @NotBlank()
        @Length(min = 1, max = 11)
        private String contacts_phone;
    }

    /**
     * 企业经营信息 businessInfo
     */
    @Data
    public static class BusinessInfo {

        /**
         * scale,企业规模,N,String(170),企业规模
         */
        @Length(min = 1, max = 170)
        private String scale;
        /**
         * industry_code,行业代码,N,String(32),行业代码
         */
        @Length(min = 1, max = 32)
        private String industry_code;

        /**
         * 用户名称。企业用户传企业名称，个人用户传姓名。
         */
        @Length(min = 1, max = 85)
        private String user_name;
        /**
         * registered_capital,注册资本,N,String(32),注册资本，单位：万元
         */
        @Length(min = 1, max = 32)
        private String registered_capital;
        /**
         * business_scope,经营范围,N,String(170),经营范围
         */
        @Length(min = 1, max = 170)
        private String business_scope;
    }

    /**
     * 企业基本户信息 basicAcctInfo
     */
    @Data
    public static class AccountInfo {

        /**
         *
         * ACCOUNT_BOOK	账簿
         * PERSONAL_PAYMENT_ACCOUNT	个人支付账户
         * ENTERPRISE_PAYMENT_ACCOUNT	企业支付账户
         * 账户属性。若该字段未上传，默认账户类型为账簿。
         */
        @NotBlank()
        @Length(min = 1, max = 32)
        private String account_type;
        /**
         * 当账户属性为个人支付账户时，需要上传账户等级，建议传V3。
         * 注：该字段表示商户请求的个人支付账户需求等级，真实开户结果以ACCP返回等级为准。
         */
        @Length(min = 1, max = 32)
        private String account_need_level;
    }
}

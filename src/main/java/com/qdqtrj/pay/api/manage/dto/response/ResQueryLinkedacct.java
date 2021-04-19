package com.qdqtrj.pay.api.manage.dto.response;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


/**
 * 3.14. 绑卡信息查询 3.14.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-linkedacct
 */
@Data
public class ResQueryLinkedacct implements Serializable {
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
     * linked_acctlist 绑定银行帐号列表
     * fixme 这个地方需要跟接口方确认
     */
    private List<LinkedAcct> linked_acctlist;

    /**
     * linked_acctlist 绑定银行帐号列表
     */
    @Data
    public static class LinkedAcct {

        /**
         * linked_acctlist,绑定银行帐号列表 N String(64) xxx
         */
        private String linked_acctlist;
        /**
         * linked_acctno,绑定银行帐号,N,String(32),个人用户绑定的银行卡号，企业用户绑定的银行帐号
         */
        @Length(min = 1, max = 32)
        private String linked_acctno;
        /**
         * linked_bankcode,银行编码,N,String(8),企业用户必填
         */
        @Length(min = 1, max = 8)
        private String linked_bankcode;
        /**
         * linked_brbankno,对公账户开户行号,N,String(12),企业用户开户行行号，企业用户必填
         */
        @Length(min = 1, max = 12)
        private String linked_brbankno;
        /**
         * linked_brbankname,对公账户开户行名,N,String(85),企业用户绑定账户开户支行名称
         */
        @Length(min = 1, max = 85)
        private String linked_brbankname;
        /**
         * linked_phone,银行预留手机号,N,String(11),个人用户绑卡必填
         */
        @Length(min = 1, max = 11)
        private String linked_phone;
        /**
         * linked_agrtno,绑卡协议号,N,String(32),绑卡协议号
         */
        @Length(min = 1, max = 32)
        private String linked_agrtno;
    }
}


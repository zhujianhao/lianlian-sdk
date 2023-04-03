package com.qdqtrj.pay.api.manage.dto.response;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 3.16. 账户信息查询 3.16.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-acctinfo
 */
@Data
public class ResQueryAcctinfo implements Serializable {
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
     * oid_userno,ACCP系统用户编号,N,String(32),个人用户注册成功后的用户编号
     */
    @Length(min = 1, max = 32)
    private String oid_userno;
    /**
     * bank_account,合作银行账号,N,String,ACCP合作银行账户,注：新网、通商、富民合作银行有效
     */
    private String bank_account;
    /**
     * acctinfo_list,账户列表
     */
    private List<AccountInfo> acctinfo_list;


    @Data
    public static class AccountInfo implements Serializable{

        private static final long serialVersionUID = 3370322379225680363L;

        /**
         * oid_acctno,账户号,N,String(32),账户号
         */
        @Length(min = 1, max = 32)
        private String oid_acctno;
        /**
         * acct_state,账户状态,N,String(32),账户状态
         */
        @Length(min = 1, max = 32)
        private String acct_state;
        /**
         * acct_type,账户类型,N,String(32),账户类型
         */
        @Length(min = 1, max = 32)
        private String acct_type;
        /**
         * amt_balcur,资金余额,N,String,单位 元
         */
        private String amt_balcur;
        /**
         * amt_balaval,可用余额,N,String,单位 元
         */
        private String amt_balaval;
        /**
         * amt_balfrz,冻结金额,N,String,单位 元
         */
        private String amt_balfrz;
        /**
         * amt_lastbal,昨日资金余额,N,String,单位 元
         */
        private String amt_lastbal;
        /**
         * amt_lastaval,昨日可用余额,N,String,单位 元
         */
        private String amt_lastaval;
        /**
         * amt_lastfrz,昨日冻结金额,N,String,单位 元
         */
        private String amt_lastfrz;
    }
}


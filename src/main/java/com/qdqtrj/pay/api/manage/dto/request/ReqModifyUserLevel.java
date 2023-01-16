package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


/**
 * 3.10. 销户 3.10.1.  销户申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/cancel-apply
 */
@Data
public class ReqModifyUserLevel implements Serializable {
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

    private AccountInfo accountInfo;

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

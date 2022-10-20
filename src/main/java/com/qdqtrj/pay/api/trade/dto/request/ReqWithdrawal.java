package com.qdqtrj.pay.api.trade.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 3.3. 提现 用户/平台商户将账户可用余额提现至开户绑定的银行账户。 3.3.1. 提现申请 请求地址https://accpapi.lianlianpay.com/v1/txn/withdrawal
 */
@Data
public class ReqWithdrawal implements Serializable {
    /**
     * timestamp,时间戳,Y,Date,交易服务器时间戳,格式：yyyyMMddHHmms,有效期30分钟（包含服务器之间的时间差）
     */
    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;
    /**
     * oid_partner,商户号,Y,String,ACCP 系统分配给平台商户的唯一编号
     */
    @NotBlank()
    private String oid_partner;
    /**
     * notify_url,异步通知地址,N,String,交易结果异步通知接收地址，建议HTTPS协议
     */
    private String notify_url;
    /**
     * pay_expire,订单有效期,N,Number,订单有效期，逾期将会关闭交易,单位：分钟，默认：3天,注：提现确认有效时间，超期将关单
     */
    private String pay_expire;
    /**
     * risk_item,风控参数,N,String,参见‘风控参数’
     */
    private String risk_item;
    /**
     * linked_acctno,绑定银行帐号,N,String,个人用户可绑定多张银行卡，提现
     */
    private String linked_acctno;
    /**
     * linked_agrtno,绑卡协议号,N,String,时可指定具体的卡号或者对应的绑卡协议号，二者选其一；企业用户建议上传，若为空则以默认绑定提现银行账号为准。
     */
    private String linked_agrtno;
    /**
     * funds_flag,垫资标识,N,String,标识该笔提现交易是否支持平台商户垫资，适用于用户提现业务场景，默认：N,Y：支持垫资,N：不支持垫资
     */
    private String funds_flag;
    /**
     * check_flag,审核标识,N,String,标识该笔订单是否需要审核，默认：N,Y：需要提现确认,N：无需提现确认
     */
    private String check_flag;
    /**
     * pay_time_type,到账类型,N,String,参见‘到账类型列表’,默认：实时到账 todo
     */
    private String pay_time_type;

    /**
     * 商户订单信息 orderInfo
     */
    private OrderInfo orderInfo;
    /**
     * 付款方信息 payerInfo
     */
    private PayerInfo payerInfo;

    /**
     * 商户订单信息 orderInfo
     */
    @Data
    public static class OrderInfo {
        /**
         * txn_seqno,商户交易流水号,Y,String(64),商户系统唯一交易流水号
         */
        @NotBlank()
        @Length(min = 1, max = 64)
        private String txn_seqno;
        /**
         * txn_time,商户交易时间,Y,String(14),商户系统交易时间,格式：yyyyMMddHHmmss
         */
        @NotBlank()
        @Length(min = 1, max = 14)
        private String txn_time;
        /**
         * total_amount,订单总金额,Y,Number(8,2),订单总金额，单位为元，精确到小数点后两位
         */
        @NotBlank()
        @Digits(integer = 8, fraction = 2)
        private BigDecimal total_amount;
        /**
         * fee_amount,手续费金额,N,Number(8,2),手续费金额，单位为元，精确到小数点后两位。会自动收取到商户的自有资金账户。不允许超过订单总金额的20%
         */
        @Digits(integer = 8, fraction = 2)
        private BigDecimal fee_amount;
        /**
         * order_info,订单信息,N,String,订单信息，在查询API和支付通知中原样返回，可作为自定义参数使用
         */
        private String order_info;
        /**
         * postscript,交易附言,N,String,提现交易附言，单笔金额大于等于5w必须提供
         */
        private String postscript;
    }

    /**
     * 付款方信息 payerInfo
     */
    @Data
    public static class PayerInfo {

        /**
         * payer_type,付款方类型,Y,String,用户：USER,平台商户：MERCHANT
         */
        @NotBlank()
        private String payer_type;
        /**
         * payer_id,付款方标识,Y,String,付款方为用户时设置user_id付款方为商户时设置平台商户号
         */
        @NotBlank()
        private String payer_id;
        /**
         * payer_accttype,付款方账户类型,N,String,付款方类型为商户时需要指定平台商户账户类型参见‘账户类型列表’
         */
        private String payer_accttype;
        /**
         * password,支付密码,N,String,支付密码，用户提现时必须
         */
        private String password;
        /**
         * random_key,密码随机因子key,N,String,密码随机因子 key，随机因子获取接口返回，用户提现时必须
         */
        private String random_key;

        /**
         * 委托代发协议号。用户在ACCP开通的委托提现协议号。
         * 通过用户委托协议签约接口获取。
         * 授权免密提现时必输。该字段需要RSA公钥加密传输。
         */
        private String pap_agree_no;
    }
}
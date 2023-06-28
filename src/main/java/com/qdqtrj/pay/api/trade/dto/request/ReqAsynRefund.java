package com.qdqtrj.pay.api.trade.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 3.7. 退款 3.7.1. 异步退款申请 该接口只支持普通消费交易、担保消费交易退款。 退款规则： 1.  每次发起退款只能唯一指定原消费交易一个收款方进行处理，分账类交易退款需要按照 收款方多次发起退款； 2.  支持全额或者部分退款； 3.  组合类消费交易，每次退款需要明确指定原付款方式对应的退款金额。 4.  异步退款申请在渠道真实退款结果获取之前状态为处理中，且该笔资金将被冻结 请求地址https://accpapi.lianlianpay.com/v1/txn/asyn-refund
 */
@Data
public class ReqAsynRefund implements Serializable {
    /**
     * timestamp,时间戳,Y,Date,交易服务器时间戳,格式：yyyyMMddHHmmss,有效期30分钟（包含服务器之间的时间差）
     */
    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;
    /**
     * oid_partner,商户号,Y,String,ACCP系统分配给平台商户的唯一编号
     */
    @NotBlank()
    private String oid_partner;
    /**
     * user_id,商户用户唯一编号,Y,String,用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户
     */
    @NotBlank()
    private String user_id;
    /**
     * notify_url,异步通知地址,N,String,交易结果异步通知接收地址，建议HTTPS协议
     */
    private String notify_url;
    /**
     * refund_reason,退款原因,N,String,退款原因
     */
    private String refund_reason;

    /**
     * 原商户订单信息 originalOrderInfo
     */
    private OriginalOrderInfo originalOrderInfo;

    /**
     * 退款订单信息 refundOrderInfo
     */
    private RefundOrderInfo refundOrderInfo;

    /**
     * 原付款方式退款规则信息 refundMethods
     */
    private List<RefundMethods> refundMethods;

    private List<PyeeRefundInfo> pyeeRefundInfos;

    /**
     * 原商户订单信息 originalOrderInfo
     */
    @Data
    public static class OriginalOrderInfo {

        /**
         * txn_seqno,商户交易流水号,Y,String(64),原担保支付交易商户系统唯一交易流水号
         */
        @NotBlank()
        @Length(min = 1, max = 64)
        private String txn_seqno;
        /**
         * total_amount,订单总金额,Y,Number(8,2),订单总金额，单位为元，精确到小数点后两位
         */
        @Digits(integer = 8, fraction = 2)
        private BigDecimal total_amount;
    }

    /**
     * 退款订单信息 refundOrderInfo
     */
    @Data
    public static class RefundOrderInfo {

        /**
         * refund_seqno,退款订单号,Y,String(64),标识一次退款请求，商户系统需保证唯一
         */
        @NotBlank()
        @Length(min = 1, max = 64)
        private String refund_seqno;
        /**
         * refund_time,退款订单时间,Y,String(14),退款交易商户系统交易时间,格式：yyyyMMddHHmmss
         */
        @NotBlank()
        @Length(min = 1, max = 14)
        private String refund_time;
        /**
         * payee_id,原收款方id,Y,String,本次退款需要处理的原交易收款方id,对于担保类交易，确认前退款收,款方指定为担保平台商户号；已确认交易的退款指定担保交易真实收款方id
         */
        @NotBlank()
        private String payee_id;
        /**
         * payee_type,原收款方类型,Y,String,USER：用户,MERCHANT：商户
         */
        @NotBlank()
        private String payee_type;
        /**
         * payee_accttype,原收款方账户类型,N,String,原收款方方式为商户时必须,参见‘账户类型列表’
         */
        private String payee_accttype;
        /**
         * refund_amount,退款总金额,Y,Number(8,2),本次需要退款的金额，不允许超过对应原收款方的收款金额,单位为元，精确到小数点后两位,原付款方式退款规则信息refundMethods
         */
        @Digits(integer = 8, fraction = 2)
        private BigDecimal refund_amount;
    }

    /**
     * 原付款方式退款规则信息 refundMethods
     */
    @Data
    public static class RefundMethods {

        /**
         * method,付款方式,Y,String,参见‘付款方式列表’
         */
        @NotBlank()
        private String method;
        /**
         * amount,退款金额,Y,Number(8,2),付款方式对应的退款金额，单位为元，精确到小数点后两位,所有的付款方式退款金额相加必须和退款总金额一致
         */
        @Digits(integer = 8, fraction = 2)
        private BigDecimal amount;
    }

    /**
     * 原收款方退款信息pyeeRefundInfos
     */
    @Data
    public static class PyeeRefundInfo{

        @NotBlank()
        private String payee_id;
        /**
         * payee_type,原收款方类型,Y,String,USER：用户,MERCHANT：商户
         */
        @NotBlank()
        private String payee_type;
        /**
         * payee_accttype,原收款方账户类型,N,String,原收款方方式为商户时必须,参见‘账户类型列表’
         */
        private String payee_accttype;

        /**
         * 退款金额。本次需要退款的金额，不允许超过对应原收款方的收款金额。
         * 单位为元，精确到小数点后两位
         */
        @Digits(integer = 8, fraction = 2)
        private BigDecimal payee_refund_amount;

        /**
         * 垫资标识。当原收款方金额不足时，是否由平台垫资的标识，默认:N
         * Y:垫资
         * N：不垫资
         */
        private String is_advance_pay;
    }
}

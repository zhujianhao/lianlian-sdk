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
 * 3.3.2. 提现确认 请求地址https://accpapi.lianlianpay.com/v1/txn/withdrawal-check
 */
@Data
public class ReqWithdrawalCheck implements Serializable {
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
     * txn_seqno,商户交易流水号,Y,String(64),商户系统唯一交易流水号，即申请的流水号
     */
    @NotBlank()
    @Length(min = 1, max = 64)

    /**
     * 原订单信息 orderInfo
     */
    private OrderInfo orderInfo;
    /**
     * 确认信息 checkInfo
     */
    private CheckInfo checkInfo;

    /**
     * 原订单信息 orderInfo
     */
    @Data
    public static class OrderInfo {

        private String txn_seqno;
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
    }

    /**
     * 确认信息 checkInfo
     */
    @Data
    public static class CheckInfo {
        /**
         * check_result,订单确认结果,Y,String,订单确认状态，是否审核通过,ACCEPT 确认通过,CANCEL 确认不通过注：若商户撤销该笔提现申请，需要调用确认不通过接口，否则直到该笔交易超时关单，资金都会冻结
         */
        @NotBlank()
        private String check_result;
        /**
         * check_reason,订单确认描述,N,String(256),订单确认通过或不通过的原因，商户可用视情况填写
         */
        @Length(min = 1, max = 256)
        private String check_reason;
        /**
         * check_user,订单确认操作员,N,String(64),操作确认的人员，商户可视情况填写
         */
        @Length(min = 1, max = 64)
        private String check_user;
    }
}

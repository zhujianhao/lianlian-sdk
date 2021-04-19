package com.qdqtrj.pay.api.trade.dto.response;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 3.7.2. 退款结果查询 该接口提供发起提现申请后的订单查询，商户可以通过该接口主动查询提现申请订单状态， 完成下一步的业务逻辑。 请求地址https://accpapi.lianlianpay.com/v1/txn/query-refund
 */
@Data
public class ResQueryRefund implements Serializable {
    /**
     * ret_code,交易结果代码,Y,String,交易返回码,此字段为本次查询交易结果标识，非原退款交易结果标识，退款是否,成功需要根据txn_status字段来判断
     */
    @NotBlank()
    private String ret_code;
    /**
     * ret_msg,交易结果描述,Y,String,交易返回描述
     */
    @NotBlank()
    private String ret_msg;
    /**
     * oid_partner,商户号,Y,String,ACCP 系统分配给平台商户的唯一编号
     */
    @NotBlank()
    private String oid_partner;
    /**
     * accounting_date,账务日期,N,String,ACCP系统交易账务日期，交易成功时返回，格式：yyyyMMdd
     */
    private String accounting_date;
    /**
     * accp_txno,ACCP系统退款单号,N,String,ACCP系统退款单号
     */
    private String accp_txno;
    /**
     * chnl_txno,渠道退款单号,N,String,渠道退款单号
     */
    private String chnl_txno;
    /**
     * refund_amount,退款金额,N,Number(8,2),退款金额，单位为元，精确到小数点后两位
     */
    @Digits(integer = 8, fraction = 2)
    private BigDecimal refund_amount;
    /**
     * txn_status,退款交易状态,N,String, TRADE_SUCCESS：退款成功,TRADE_FAILURE：退款失败,TRADE_PROCESSING：退款处理中,退款结果以此为准，商户按此进行后续业务逻辑处理
     */
    private String txn_status;
}


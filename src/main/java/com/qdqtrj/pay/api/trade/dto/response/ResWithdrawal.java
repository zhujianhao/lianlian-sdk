package com.qdqtrj.pay.api.trade.dto.response;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 3.3. 提现 用户/平台商户将账户可用余额提现至开户绑定的银行账户。 3.3.1. 提现申请 请求地址https://accpapi.lianlianpay.com/v1/txn/withdrawal
 */
@Data
public class ResWithdrawal implements Serializable {
    /**
     * ret_code,交易结果代码,Y,String,交易返回码,0000表示提现申请成功，最终提现处理结果以异步通知接口为准；8889表示提现申请待确认成功，需要调用提现确认完成提现创单申请；8888表示提现需要再次进行短信验证码校验
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
     * user_id,商户用户唯一编号,Y,String,用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户
     */
    @NotBlank()
    private String user_id;
    /**
     * txn_seqno,交易流水号,Y,String,商户系统唯一交易流水号
     */
    @NotBlank()
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
    /**
     * accp_txno,ACCP系统交易单号,N,String,ACCP系统交易单号
     */
    private String accp_txno;
    /**
     * token,交易token,N,String,支付授权令牌，有效期：30分钟,当交易需要二次验证时，需要通过token调用3.6交易二次短信验证接口
     */
    private String token;
}


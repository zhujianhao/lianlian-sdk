package com.qdqtrj.pay.api.trade.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 3.6. 交易二次短信验证 对于充值、消费、提现、代发类交易需要二次进行付款方短信验证时，根据申请接口的交易 返回码进行判断，统一调用该接口完成交易验证。
 * 请求地址https://accpapi.lianlianpay.com/v1/txn/validation-sms
 */
@Data
public class ReqValidationSms implements Serializable {
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
     * payer_type,付款方类型,Y,String,用户：USER,平台商户：MERCHANT
     */
    @NotBlank()
    private String payer_type;
    /**
     * payer_id,付款方标识,Y,String,付款方为用户时设置user_id,付款方为商户时设置平台商户号
     */
    @NotBlank()
    private String payer_id;
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
     * token,交易token,Y,String,支付授权令牌，有效期：30分钟,交易申请接口响应的token
     */
    @NotBlank()
    private String token;
    /**
     * verify_code,短信验证码,Y,String,首次交易需要验证时发送给用户绑定手机的验证码
     */
    @NotBlank()
    private String verify_code;
}

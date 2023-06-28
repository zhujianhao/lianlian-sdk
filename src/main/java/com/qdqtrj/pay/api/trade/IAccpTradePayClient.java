package com.qdqtrj.pay.api.trade;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.AccpPayException;
import com.qdqtrj.pay.AccpReqParamException;
import com.qdqtrj.pay.api.CommonApi;
import com.qdqtrj.pay.api.trade.dto.callback.NotifyPaymentPapay;
import com.qdqtrj.pay.api.trade.dto.callback.NotifyQueryRefund;
import com.qdqtrj.pay.api.trade.dto.callback.NotifyWithdrawalCheck;
import com.qdqtrj.pay.api.trade.dto.request.*;
import com.qdqtrj.pay.api.trade.dto.response.*;

/**
 * 采用 单例模式获取交易类接口实例
 * 包括所有 doc/《ACCP产品商户接口说明书-交易类（API）V2.3.pdf》 接口
 *
 * @author yinbin
 */
public interface IAccpTradePayClient {


    String URL_TRADECREATE = "/v1/txn/tradecreate";
    String URL_PAYMENT_BALANCE = "/v1/txn/payment-balance";
    String URL_PAYMENT_BANKCARD = "/v1/txn/payment-bankcard";
    String URL_PAYMENT_GW = "/v1/txn/payment-gw";
    String URL_PAYMENT_PAPAY = "/v1/txn/payment-papay";
    String URL_QUERY_PAYMENT = "/v1/txn/query-payment";
    String URL_WITHDRAWAL = "/v1/txn/withdrawal";
    String URL_WITHDRAWAL_CHECK = "/v1/txn/withdrawal-check";
    String URL_QUERY_WITHDRAWAL = "/v1/txn/query-withdrawal";
    String URL_TRANSFER = "/v1/txn/transfer";
    String URL_SECURED_CONFIRM = "/v1/txn/secured-confirm";
    String URL_SECURED_QUERY = "/v1/txn/secured-query";
    String URL_VALIDATION_SMS = "/v1/txn/validation-sms";
    String URL_ASYN_REFUND = "/v1/txn/asyn-refund";
    String URL_QUERY_REFUND = "/v1/txn/query-refund";
    String URL_PAP_AGREE_APPLY = "/v1/txn/pap-agree-apply";
    String URL_TRANSFER_MOREPYEE = "/v1/txn/transfer-morepyee";
    String URL_MORE_REFUND = "/v1/txn/more-payee-refund";

    /**
     * 3.2. 充值/消费 3.2.1. 支付统一创单 商户在充值/消费交易模式一场景下使用，先通过该接口完成支付统一创单，后续根据业务 场景调用不同的支付接口完成付款。 请求地址https://accpapi.lianlianpay.com/v1/txn/tradecreate
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_TRADECREATE
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqTradecreate实例
     * @return ResTradecreate实例
     * @see AccpPayConfig
     * @see ReqTradecreate
     * @see ResTradecreate
     */
    ResTradecreate tradecreate(AccpPayConfig accpPayConfig, ReqTradecreate req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.2.2. 余额支付 用户账户余额支付接口，支持附加优惠券组合支付。 请求地址https://accpapi.lianlianpay.com/v1/txn/payment-balance
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_PAYMENT_BALANCE
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqPaymentBalance实例
     * @return ResPaymentBalance实例
     * @see AccpPayConfig
     * @see ReqPaymentBalance
     * @see ResPaymentBalance
     */
    ResPaymentBalance paymentBalance(AccpPayConfig accpPayConfig, ReqPaymentBalance req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.2.3. 银行卡快捷支付 银行卡快捷支付接口，支持附加优惠券、余额组合支付；适用于如下几种场景：   已开户绑定银行卡的个人用户支付   未注册的匿名用户首次/历次支付 请求地址https://accpapi.lianlianpay.com/v1/txn/payment-bankcard
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_PAYMENT_BANKCARD
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqPaymentBankcard实例
     * @return ResPaymentBankcard实例
     * @see AccpPayConfig
     * @see ReqPaymentBankcard
     * @see ResPaymentBankcard
     */
    ResPaymentBankcard paymentBankcard(AccpPayConfig accpPayConfig, ReqPaymentBankcard req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.2.4. 网关类支付 微信、支付宝、网银类支付申请，通过该接口唤起相应渠道的支付界面，用户确认并支付，支持附加优惠券、余额组合支付。支持以下主支付方式：==== 编码  描述,EBANK_DEBIT_CARD  网银借记卡,EBANK_CREDIT_CARD  网银信用卡,EBANK_B2B  企业网银,WECHAT_APP  微信APP,WECHAT_JSAPI  微信公众号,WECHAT_NATIVE  微信扫码,WECHAT_H5  微信H5,WECHAT_WXA  微信小程序,ALIPAY_NATIVE  支付宝扫码,ALIPAY_APP  支付宝APP,ALIPAY_H5  支付宝H5,ALIPAY_WEB  支付宝WEB,ALIPAY_WXA  支付宝小程序,ALIPAY_NATIVE_ICBC  支付宝扫码-工银e支付,WECHAT_NATIVE_ICBC  微信扫码-工银e支付 请求地址https://accpapi.lianlianpay.com/v1/txn/payment-gw
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_PAYMENT_GW
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqPaymentGw实例
     * @return ResPaymentGw实例
     * @see AccpPayConfig
     * @see ReqPaymentGw
     * @see ResPaymentGw
     */
    ResPaymentGw paymentGw(AccpPayConfig accpPayConfig, ReqPaymentGw req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.2.5. 委托代扣 微信、支付宝提交委托代扣，通过使用与用户签约获得的微信、支付宝代扣协议号，由商户后台调用该接口发起创单并支付，暂不支持组合支付。 支持以下主支付方式： 编码  描述,WECHAT_PAPAY  微信委托代扣,BALANCE  余额代扣/余额,ALIPAY_PAPAY  支付宝商户代扣 请求地址https://accpapi.lianlianpay.com/v1/txn/payment-papay
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpTradePayClient.URL_PAYMENT_PAPAY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqPaymentPapay实例
     * @return ResPaymentPapay实例
     * @see NotifyPaymentPapay
     * @see AccpPayConfig
     * @see ReqPaymentPapay
     * @see ResPaymentPapay
     */
    ResPaymentPapay paymentPapay(AccpPayConfig accpPayConfig, ReqPaymentPapay req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.2.8. 支付结果查询 该接口提供所有消费/充值场景下的支付订单查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。需要调用查询接口的情况：商户后台、网络、服务器等出现异常，商户最终未接收到支付结果通知；调用支付接口后，返回系统错误或者未知交易、处理中交易状态情况。 请求地址https://accpapi.lianlianpay.com/v1/txn/query-payment
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_QUERY_PAYMENT
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryPayment实例
     * @return ResQueryPayment实例
     * @see AccpPayConfig
     * @see ReqQueryPayment
     * @see ResQueryPayment
     */
    ResQueryPayment queryPayment(AccpPayConfig accpPayConfig, ReqQueryPayment req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.3. 提现 用户/平台商户将账户可用余额提现至开户绑定的银行账户。 3.3.1. 提现申请 请求地址https://accpapi.lianlianpay.com/v1/txn/withdrawal
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_WITHDRAWAL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqWithdrawal实例
     * @return ResWithdrawal实例
     * @see AccpPayConfig
     * @see ReqWithdrawal
     * @see ResWithdrawal
     */
    ResWithdrawal withdrawal(AccpPayConfig accpPayConfig, ReqWithdrawal req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.3.2. 提现确认 请求地址https://accpapi.lianlianpay.com/v1/txn/withdrawal-check
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpTradePayClient.URL_WITHDRAWAL_CHECK
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqWithdrawalCheck实例
     * @return ResWithdrawalCheck实例
     * @see NotifyWithdrawalCheck
     * @see AccpPayConfig
     * @see ReqWithdrawalCheck
     * @see ResWithdrawalCheck
     */
    ResWithdrawalCheck withdrawalCheck(AccpPayConfig accpPayConfig, ReqWithdrawalCheck req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.3.4. 提现结果查询 该接口提供所有提现场景下的订单查询，包括提现及代发到银行账户；商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。需要调用查询接口的情况：商户后台、网络、服务器等出现异常，商户最终未接收到提现结果通知；调用提现及代发申请接口后，返回系统错误或者未知交易、处理中交易状态情况。 请求地址https://accpapi.lianlianpay.com/v1/txn/query-withdrawal
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_QUERY_WITHDRAWAL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryWithdrawal实例
     * @return ResQueryWithdrawal实例
     * @see AccpPayConfig
     * @see ReqQueryWithdrawal
     * @see ResQueryWithdrawal
     */
    ResQueryWithdrawal queryWithdrawal(AccpPayConfig accpPayConfig, ReqQueryWithdrawal req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.4. 代发 支持内部代发和外部代发两种场景交易。 内部代发：用户/平台商户A将账户可用余额代发至用户/平台商户B可用余额账户，业务场 景为佣金代发、红包奖励代发、供应商货款付款等。 外部代发：用户/平台商户A将账户可用余额代发至用户/平台商户B实体银行账户；业务场 景为佣金代发、红包奖励代发、供应商货款付款等。 3.4.1. 代发申请 请求地址https://accpapi.lianlianpay.com/v1/txn/transfer
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_TRANSFER
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqTransfer实例
     * @return ResTransfer实例
     * @see AccpPayConfig
     * @see ReqTransfer
     * @see ResTransfer
     */
    ResTransfer transfer(AccpPayConfig accpPayConfig, ReqTransfer req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.5. 担保 担保交易支持两类场景： 1.  在支付交易统一创单时指定担保收款方信息，担保确认时支持全额及部分金额多次确认； 对于创单时指定的担保收款方不支持确认时修改； 2.  在支付交易统一创单时不指定担保收款方信息，担保交易确认时动态指定收款方并进行 交易确认，资金从担保平台商户账户转入担保收款方账户。 3.5.1. 担保交易确认 请求地址https://accpapi.lianlianpay.com/v1/txn/secured-confirm
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_SECURED_CONFIRM
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqSecuredConfirm实例
     * @return ResSecuredConfirm实例
     * @see AccpPayConfig
     * @see ReqSecuredConfirm
     * @see ResSecuredConfirm
     */
    ResSecuredConfirm securedConfirm(AccpPayConfig accpPayConfig, ReqSecuredConfirm req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.5.3. 担保交易信息查询 针对担保交易的担保支付和担保交易确认多次操作，为商户提供某笔担保单的真实收款方金 额确认情况以及多次确认、退款操作的查询接口。 注：本接口只用于担保支付获取该交易相关确认单、退款单等信息与卖方确认金额信息，具 体担保支付交易、担保确认交易的结果，请参考【支付结果查询】 与 【担保确认结果查询】。 请求地址https://accpapi.lianlianpay.com/v1/txn/secured-query
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_SECURED_QUERY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqSecuredQuery实例
     * @return ResSecuredQuery实例
     * @see AccpPayConfig
     * @see ReqSecuredQuery
     * @see ResSecuredQuery
     */
    ResSecuredQuery securedQuery(AccpPayConfig accpPayConfig, ReqSecuredQuery req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.6. 交易二次短信验证 对于充值、消费、提现、代发类交易需要二次进行付款方短信验证时，根据申请接口的交易 返回码进行判断，统一调用该接口完成交易验证。 请求地址https://accpapi.lianlianpay.com/v1/txn/validation-sms
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_VALIDATION_SMS
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqValidationSms实例
     * @return ResValidationSms实例
     * @see AccpPayConfig
     * @see ReqValidationSms
     * @see ResValidationSms
     */
    ResValidationSms validationSms(AccpPayConfig accpPayConfig, ReqValidationSms req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.7. 退款 3.7.1. 异步退款申请 该接口只支持普通消费交易、担保消费交易退款。 退款规则： 1.  每次发起退款只能唯一指定原消费交易一个收款方进行处理，分账类交易退款需要按照 收款方多次发起退款； 2.  支持全额或者部分退款； 3.  组合类消费交易，每次退款需要明确指定原付款方式对应的退款金额。 4.  异步退款申请在渠道真实退款结果获取之前状态为处理中，且该笔资金将被冻结 请求地址https://accpapi.lianlianpay.com/v1/txn/asyn-refund
     * 接口类型：非异步通知接口
     * 地址常量：IAccpTradePayClient.URL_ASYN_REFUND
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqAsynRefund实例
     * @return ResAsynRefund实例
     * @see AccpPayConfig
     * @see ReqAsynRefund
     * @see ResAsynRefund
     */
    ResAsynRefund asynRefund(AccpPayConfig accpPayConfig, ReqAsynRefund req) throws AccpPayException, AccpReqParamException;

    ResAsynRefund moreRefund(AccpPayConfig accpPayConfig, ReqAsynRefund req) throws AccpPayException, AccpReqParamException;

    /**
     * 3.7.2. 退款结果查询 该接口提供发起提现申请后的订单查询，商户可以通过该接口主动查询提现申请订单状态， 完成下一步的业务逻辑。 请求地址https://accpapi.lianlianpay.com/v1/txn/query-refund
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpTradePayClient.URL_QUERY_REFUND
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryRefund实例
     * @return ResQueryRefund实例
     * @see NotifyQueryRefund
     * @see AccpPayConfig
     * @see ReqQueryRefund
     * @see ResQueryRefund
     */
    ResQueryRefund queryRefund(AccpPayConfig accpPayConfig, ReqQueryRefund req) throws AccpPayException, AccpReqParamException;


    ResPapAgreeApply papAgreeApply(AccpPayConfig accpPayConfig, ReqPapAgreeApply req) throws AccpPayException, AccpReqParamException;

    ResTransferMorepyee transferMorepyee(AccpPayConfig accpPayConfig, ReqTransferMorepyee req) throws AccpPayException, AccpReqParamException;

}

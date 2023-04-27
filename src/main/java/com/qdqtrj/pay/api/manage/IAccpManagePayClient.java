package com.qdqtrj.pay.api.manage;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.AccpPayException;
import com.qdqtrj.pay.AccpReqParamException;
import com.qdqtrj.pay.api.manage.dto.callback.*;
import com.qdqtrj.pay.api.manage.dto.request.*;
import com.qdqtrj.pay.api.manage.dto.response.*;

/**
 * 采用 单例模式获取账户管理类接口实例
 * 包括所有 doc/《ACCP产品商户接口说明书-账户管理类（API）V1.4-标准版.pdf》 接口
 *
 * @author yinbin
 */
public interface IAccpManagePayClient {


    String URL_REGPHONE_VERIFYCODE_APPLY = "/v1/acctmgr/regphone-verifycode-apply";

    /**
     * 3. 交易接口定义 3.1. 绑定手机验证码申请 3.1.1. 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/regphone-verifycode-apply
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_REGPHONE_VERIFYCODE_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqRegphoneVerifycodeApply实例
     * @return ResRegphoneVerifycodeApply实例
     * @see AccpPayConfig
     * @see ReqRegphoneVerifycodeApply
     * @see ResRegphoneVerifycodeApply
     */
    ResRegphoneVerifycodeApply regphoneVerifycodeApply(AccpPayConfig accpPayConfig, ReqRegphoneVerifycodeApply req) throws AccpPayException, AccpReqParamException;


    String URL_REGPHONE_VERIFYCODE_VERIFY = "/v1/acctmgr/regphone-verifycode-verify";

    /**
     * 3.2. 绑定手机验证码验证 3.2.1. 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/regphone-verifycode-verify
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_REGPHONE_VERIFYCODE_VERIFY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqRegphoneVerifycodeVerify实例
     * @return ResRegphoneVerifycodeVerify实例
     * @see AccpPayConfig
     * @see ReqRegphoneVerifycodeVerify
     * @see ResRegphoneVerifycodeVerify
     */
    ResRegphoneVerifycodeVerify regphoneVerifycodeVerify(AccpPayConfig accpPayConfig, ReqRegphoneVerifycodeVerify req) throws AccpPayException, AccpReqParamException;


    String URL_OPENACCT_APPLY_INDIVIDUAL = "/v1/acctmgr/openacct-apply-individual";

    /**
     * 3.3. 个人用户开户 3.3.1. 开户申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/openacct-apply-individual
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_OPENACCT_APPLY_INDIVIDUAL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqOpenacctApplyIndividual实例
     * @return ResOpenacctApplyIndividual实例
     * @see AccpPayConfig
     * @see ReqOpenacctApplyIndividual
     * @see ResOpenacctApplyIndividual
     */
    ResOpenacctApplyIndividual openacctApplyIndividual(AccpPayConfig accpPayConfig, ReqOpenacctApplyIndividual req) throws AccpPayException, AccpReqParamException;


    String URL_OPENACCT_VERIFY_INDIVIDUAL = "/v1/acctmgr/openacct-verify-individual";

    /**
     * 3.3.2. 开户验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/openacct-verify-individual
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_OPENACCT_VERIFY_INDIVIDUAL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqOpenacctVerifyIndividual实例
     * @return ResOpenacctVerifyIndividual实例
     * @see NotifyOpenacctVerifyIndividual
     * @see AccpPayConfig
     * @see ReqOpenacctVerifyIndividual
     * @see ResOpenacctVerifyIndividual
     */
    ResOpenacctVerifyIndividual openacctVerifyIndividual(AccpPayConfig accpPayConfig, ReqOpenacctVerifyIndividual req) throws AccpPayException, AccpReqParamException;


    String URL_OPENACCT_APPLY_ENTERPRISE = "/v1/acctmgr/openacct-apply-enterprise";

    /**
     * 3.4. 企业用户开户 3.4.1. 开户申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/openacct-apply-enterprise
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_OPENACCT_APPLY_ENTERPRISE
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqOpenacctApplyEnterprise实例
     * @return ResOpenacctApplyEnterprise实例
     * @see NotifyOpenacctApplyEnterprise
     * @see AccpPayConfig
     * @see ReqOpenacctApplyEnterprise
     * @see ResOpenacctApplyEnterprise
     */
    ResOpenacctApplyEnterprise openacctApplyEnterprise(AccpPayConfig accpPayConfig, ReqOpenacctApplyEnterprise req) throws AccpPayException, AccpReqParamException;


    String URL_OPENACCT_VERIFY_ENTERPRISE = "/v1/acctmgr/openacct-verify-enterprise";
    ResOpenacctVerifyEnterprise openacctVerifyEnterprise(AccpPayConfig accpPayConfig,ReqOpenAccountVerifyEnterprise reqOpenAccountVerifyEnterprise)throws AccpPayException, AccpReqParamException;


    String URL_INDIVIDUAL_BINDCARD_APPLY = "/v1/acctmgr/individual-bindcard-apply";

    /**
     * 3.5. 个人用户新增绑卡 3.5.1. 绑卡申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/individual-bindcard-apply
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_INDIVIDUAL_BINDCARD_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqIndividualBindcardApply实例
     * @return ResIndividualBindcardApply实例
     * @see AccpPayConfig
     * @see ReqIndividualBindcardApply
     * @see ResIndividualBindcardApply
     */
    ResIndividualBindcardApply individualBindcardApply(AccpPayConfig accpPayConfig, ReqIndividualBindcardApply req) throws AccpPayException, AccpReqParamException;


    String URL_INDIVIDUAL_BINDCARD_VERIFY = "/v1/acctmgr/individual-bindcard-verify";

    /**
     * 3.5.2. 绑卡验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/individual-bindcard-verify
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_INDIVIDUAL_BINDCARD_VERIFY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqIndividualBindcardVerify实例
     * @return ResIndividualBindcardVerify实例
     * @see NotifyIndividualBindcardVerify
     * @see AccpPayConfig
     * @see ReqIndividualBindcardVerify
     * @see ResIndividualBindcardVerify
     */
    ResIndividualBindcardVerify individualBindcardVerify(AccpPayConfig accpPayConfig, ReqIndividualBindcardVerify req) throws AccpPayException, AccpReqParamException;


    String URL_ENTERPRISE_CHANGECARD_APPLY = "/v1/acctmgr/enterprise-changecard-apply";

    /**
     * 3.6. 企业用户更换绑定账号 3.6.1. 更换申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/enterprise-changecard-apply
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_ENTERPRISE_CHANGECARD_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqEnterpriseChangecardApply实例
     * @return ResEnterpriseChangecardApply实例
     * @see NotifyEnterpriseChangecardApply
     * @see AccpPayConfig
     * @see ReqEnterpriseChangecardApply
     * @see ResEnterpriseChangecardApply
     */
    ResEnterpriseChangecardApply enterpriseChangecardApply(AccpPayConfig accpPayConfig, ReqEnterpriseChangecardApply req) throws AccpPayException, AccpReqParamException;


    String URL_ENTERPRISE_CHANGECARD_VERIFY = "/v1/acctmgr/enterprise-changecard-verify";

    /**
     * 企业用户绑定账户类型是法人银行卡时，需要调用此接口验证。
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqEnterpriseChangecardApply实例
     * @return ResEnterpriseChangecardApply实例
     * @see NotifyEnterpriseChangecardApply
     * @see AccpPayConfig
     * @see ReqEnterpriseChangecardVerify
     * @see ResEnterpriseChangecardVerify
     */
    ResEnterpriseChangecardVerify enterpriseChangecardVerify(AccpPayConfig accpPayConfig, ReqEnterpriseChangecardVerify req) throws AccpPayException, AccpReqParamException;


    String URL_UNLINKEDACCT_IND_APPLY = "/v1/acctmgr/unlinkedacct-ind-apply";

    /**
     * 3.7. 个人用户解绑银行卡 3.7.1. 解绑 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/unlinkedacct-ind-apply
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_UNLINKEDACCT_IND_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqUnlinkedacctIndApply实例
     * @return ResUnlinkedacctIndApply实例
     * @see NotifyUnlinkedacctIndApply
     * @see AccpPayConfig
     * @see ReqUnlinkedacctIndApply
     * @see ResUnlinkedacctIndApply
     */
    ResUnlinkedacctIndApply unlinkedacctIndApply(AccpPayConfig accpPayConfig, ReqUnlinkedacctIndApply req) throws AccpPayException, AccpReqParamException;


    String URL_CHANGE_LINKEDPHONE_APPLY = "/v1/acctmgr/change-linkedphone-apply";

    /**
     * 3.8. 个人用户修改预留手机号 3.8.1. 申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/change-linkedphone-apply
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_CHANGE_LINKEDPHONE_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqChangeLinkedphoneApply实例
     * @return ResChangeLinkedphoneApply实例
     * @see AccpPayConfig
     * @see ReqChangeLinkedphoneApply
     * @see ResChangeLinkedphoneApply
     */
    ResChangeLinkedphoneApply changeLinkedphoneApply(AccpPayConfig accpPayConfig, ReqChangeLinkedphoneApply req) throws AccpPayException, AccpReqParamException;


    String URL_CHANGE_LINKEDPHONE_VERIFY = "/v1/acctmgr/change-linkedphone-verify";

    /**
     * 3.8.2. 验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/change-linkedphone-verify
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_CHANGE_LINKEDPHONE_VERIFY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqChangeLinkedphoneVerify实例
     * @return ResChangeLinkedphoneVerify实例
     * @see NotifyChangeLinkedphoneVerify
     * @see AccpPayConfig
     * @see ReqChangeLinkedphoneVerify
     * @see ResChangeLinkedphoneVerify
     */
    ResChangeLinkedphoneVerify changeLinkedphoneVerify(AccpPayConfig accpPayConfig, ReqChangeLinkedphoneVerify req) throws AccpPayException, AccpReqParamException;


    String URL_CHANGE_REGPHONE_APPLY = "/v1/acctmgr/change-regphone-apply";

    /**
     * 3.9. 修改绑定手机 3.9.1. 申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/change-regphone-apply
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_CHANGE_REGPHONE_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqChangeRegphoneApply实例
     * @return ResChangeRegphoneApply实例
     * @see AccpPayConfig
     * @see ReqChangeRegphoneApply
     * @see ResChangeRegphoneApply
     */
    ResChangeRegphoneApply changeRegphoneApply(AccpPayConfig accpPayConfig, ReqChangeRegphoneApply req) throws AccpPayException, AccpReqParamException;


    String URL_CHANGE_REGPHONE_VERIFY = "/v1/acctmgr/change-regphone-verify";

    /**
     * 3.9.2. 验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/change-regphone-verify
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_CHANGE_REGPHONE_VERIFY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqChangeRegphoneVerify实例
     * @return ResChangeRegphoneVerify实例
     * @see NotifyChangeRegphoneVerify
     * @see AccpPayConfig
     * @see ReqChangeRegphoneVerify
     * @see ResChangeRegphoneVerify
     */
    ResChangeRegphoneVerify changeRegphoneVerify(AccpPayConfig accpPayConfig, ReqChangeRegphoneVerify req) throws AccpPayException, AccpReqParamException;


    String URL_CANCEL_APPLY = "/v1/acctmgr/cancel-apply";

    /**
     * 3.10. 销户 3.10.1.  销户申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/cancel-apply
     * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
     * 地址常量：IAccpManagePayClient.URL_CANCEL_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqCancelApply实例
     * @return ResCancelApply实例
     * @see NotifyCancelApply
     * @see AccpPayConfig
     * @see ReqCancelApply
     * @see ResCancelApply
     */
    ResCancelApply cancelApply(AccpPayConfig accpPayConfig, ReqCancelApply req) throws AccpPayException, AccpReqParamException;


    String URL_CHANGE_PASSWORD = "/v1/acctmgr/change-password";

    /**
     * 3.11. 重置密码 3.11.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/change-password
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_CHANGE_PASSWORD
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqChangePassword实例
     * @return ResChangePassword实例
     * @see AccpPayConfig
     * @see ReqChangePassword
     * @see ResChangePassword
     */
    ResChangePassword changePassword(AccpPayConfig accpPayConfig, ReqChangePassword req) throws AccpPayException, AccpReqParamException;


    String URL_FIND_PASSWORD_APPLY = "/v1/acctmgr/find-password-apply";

    /**
     * 3.12. 找回密码 3.12.1.  申请 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/find-password-apply
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_FIND_PASSWORD_APPLY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqFindPasswordApply实例
     * @return ResFindPasswordApply实例
     * @see AccpPayConfig
     * @see ReqFindPasswordApply
     * @see ResFindPasswordApply
     */
    ResFindPasswordApply findPasswordApply(AccpPayConfig accpPayConfig, ReqFindPasswordApply req) throws AccpPayException, AccpReqParamException;


    String URL_FIND_PASSWORD_VERIFY = "/v1/acctmgr/find-password-verify";

    /**
     * 3.12.2.  验证 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/find-password-verify
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_FIND_PASSWORD_VERIFY
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqFindPasswordVerify实例
     * @return ResFindPasswordVerify实例
     * @see AccpPayConfig
     * @see ReqFindPasswordVerify
     * @see ResFindPasswordVerify
     */
    ResFindPasswordVerify findPasswordVerify(AccpPayConfig accpPayConfig, ReqFindPasswordVerify req) throws AccpPayException, AccpReqParamException;


    String URL_GET_RANDOM = "/v1/acctmgr/get-random";

    /**
     * 3.13. 随机因子获取 3.13.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/get-random
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_GET_RANDOM
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqGetRandom实例
     * @return ResGetRandom实例
     * @see AccpPayConfig
     * @see ReqGetRandom
     * @see ResGetRandom
     */
    ResGetRandom getRandom(AccpPayConfig accpPayConfig, ReqGetRandom req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_LINKEDACCT = "/v1/acctmgr/query-linkedacct";

    /**
     * 3.14. 绑卡信息查询 3.14.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-linkedacct
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_LINKEDACCT
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryLinkedacct实例
     * @return ResQueryLinkedacct实例
     * @see AccpPayConfig
     * @see ReqQueryLinkedacct
     * @see ResQueryLinkedacct
     */
    ResQueryLinkedacct queryLinkedacct(AccpPayConfig accpPayConfig, ReqQueryLinkedacct req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_USERINFO = "/v1/acctmgr/query-userinfo";

    /**
     * 3.15. 用户信息查询 3.15.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-userinfo
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_USERINFO
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryUserinfo实例
     * @return ResQueryUserinfo实例
     * @see AccpPayConfig
     * @see ReqQueryUserinfo
     * @see ResQueryUserinfo
     */
    ResQueryUserinfo queryUserinfo(AccpPayConfig accpPayConfig, ReqQueryUserinfo req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_ACCTINFO = "/v1/acctmgr/query-acctinfo";

    /**
     * 3.16. 账户信息查询 3.16.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-acctinfo
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_ACCTINFO
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryAcctinfo实例
     * @return ResQueryAcctinfo实例
     * @see AccpPayConfig
     * @see ReqQueryAcctinfo
     * @see ResQueryAcctinfo
     */
    ResQueryAcctinfo queryAcctinfo(AccpPayConfig accpPayConfig, ReqQueryAcctinfo req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_ACCTSERIAL = "/v1/acctmgr/query-acctserial";

    /**
     * 3.17. 资金流水查询 3.17.1.  资金流水列表查询 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-acctserial
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_ACCTSERIAL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryAcctserial实例
     * @return ResQueryAcctserial实例
     * @see AccpPayConfig
     * @see ReqQueryAcctserial
     * @see ResQueryAcctserial
     */
    ResQueryAcctserial queryAcctserial(AccpPayConfig accpPayConfig, ReqQueryAcctserial req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_ACCTSERIALDETAIL = "/v1/acctmgr/query-acctserialdetail";

    /**
     * 3.17.2.  资金流水详情查询 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-acctserialdetail
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_ACCTSERIALDETAIL
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryAcctserialdetail实例
     * @return ResQueryAcctserialdetail实例
     * @see AccpPayConfig
     * @see ReqQueryAcctserialdetail
     * @see ResQueryAcctserialdetail
     */
    ResQueryAcctserialdetail queryAcctserialdetail(AccpPayConfig accpPayConfig, ReqQueryAcctserialdetail req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_TXN = "/v1/acctmgr/query-txn";

    /**
     * 3.18. 交易流水结果查询 3.18.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-txn
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_TXN
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryTxn实例
     * @return ResQueryTxn实例
     * @see AccpPayConfig
     * @see ReqQueryTxn
     * @see ResQueryTxn
     */
    ResQueryTxn queryTxn(AccpPayConfig accpPayConfig, ReqQueryTxn req) throws AccpPayException, AccpReqParamException;


    String URL_QUERY_CNAPSCODE = "/v1/acctmgr/query-cnapscode";

    /**
     * 3.19. 大额行号查询 3.19.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-cnapscode
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_QUERY_CNAPSCODE
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqQueryCnapscode实例
     * @return ResQueryCnapscode实例
     * @see AccpPayConfig
     * @see ReqQueryCnapscode
     * @see ResQueryCnapscode
     */
    ResQueryCnapscode queryCnapscode(AccpPayConfig accpPayConfig, ReqQueryCnapscode req) throws AccpPayException, AccpReqParamException;


    String URL_UPLOAD_PHOTOS = "/v1/acctmgr/upload-photos";

    /**
     * 3.20. 上传照片 该接口用于上传个人用户的身份证照片及企业用户的统一社会信用代码证照片和企业法人 身份证照片。 3.20.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/upload-photos
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_UPLOAD_PHOTOS
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqUploadPhotos实例
     * @return ResUploadPhotos实例
     * @see AccpPayConfig
     * @see ReqUploadPhotos
     * @see ResUploadPhotos
     */
    ResUploadPhotos uploadPhotos(AccpPayConfig accpPayConfig, ReqUploadPhotos req) throws AccpPayException, AccpReqParamException;


    String URL_VALIDATE_PASSWORD = "/v1/acctmgr/validate-password";

    /**
     * 3.21. 支付密码校验 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/validate-password
     * 接口类型：非异步通知接口
     * 地址常量：IAccpManagePayClient.URL_VALIDATE_PASSWORD
     *
     * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
     * @param req           ReqValidatePassword实例
     * @return ResValidatePassword实例
     * @see AccpPayConfig
     * @see ReqValidatePassword
     * @see ResValidatePassword
     */
    ResValidatePassword validatePassword(AccpPayConfig accpPayConfig, ReqValidatePassword req) throws AccpPayException, AccpReqParamException;


    String URL_OPENACCT_APPLY_PAGE = "/v1/acctmgr/openacct-apply";

    /**
     * 页面开户
     */
    ResOpenacctApplyPage openacctApplyPage(AccpPayConfig accpPayConfig, ReqOpenacctApplyPage req) throws AccpPayException, AccpReqParamException;

    String MODIFY_USER_LEVEL = "/v1/acctmgr/modify-user-level";

    /**
     *修改用户等级
     */
    ResModifyUserLevel modifyUserLevel(AccpPayConfig accpPayConfig, ReqModifyUserLevel req) throws AccpPayException, AccpReqParamException;

    /**
     * 上传文件
     */
    String DOCUMENT_UPLOAD = "/v1/documents/upload";
    ResDocumentUpload documentUpload(AccpPayConfig accpPayConfig, ReqDocumentUpload req)throws AccpPayException, AccpReqParamException;
}

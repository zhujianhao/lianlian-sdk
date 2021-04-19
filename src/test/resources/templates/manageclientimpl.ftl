${packageName}

import AccpPayConfig;
import AccpPayException;
import AccpReqParamException;
import CommonApi;
import IAccpManagePayClient;
import com.qdqtrj.pay.api.manage.dto.request.*;
import com.qdqtrj.pay.api.manage.dto.response.*;

/**
* 采用 单例模式获取账户管理类接口实例
* 包括所有 doc/《ACCP产品商户接口说明书-账户管理类（API）V1.4-标准版.pdf》 接口
*
* @author yinbin
*/
public final class DefaultManagePayClientImpl implements IManagePayClient {

<#list apiMethodList as a>

    /**
    * ${a["desc"]}
    <#if a["isHaveNotify"]>
        * 接口类型：异步通知接口 响应（返回） Success 字符串则视为成功，停止通知；否则Accp支付平台会按照通知策略发起重试，直到通知机制完成。
    <#else>
        * 接口类型：非异步通知接口
    </#if>
    * 地址常量：IManagePayClient.URL_${a["constantUrl"]}
    *
    * @param accpPayConfig 通用配置对象，可通过spring clould配置中心配置其子类实例
    * @param req ${a["reqClassName"]}实例
    * @return ${a["resClassName"]}实例
    <#if a["isHaveNotify"]>
        * @see com.qdqtrj.pay.api.manage.dto.callback.${a["notifyClassName"]}
    </#if>
    * @see AccpPayConfig
    * @see com.qdqtrj.pay.api.manage.dto.request.${a["reqClassName"]}
    * @see com.qdqtrj.pay.api.manage.dto.response.${a["resClassName"]}
    */
    @Override
    public ${a["resClassName"]} ${a["methodName"]}(AccpPayConfig accpPayConfig, ${a["reqClassName"]} req) throws AccpPayException, AccpReqParamException{
    return CommonApi.doCommonRequest(accpPayConfig, URL_${a["constantUrl"]}, req, ${a["resClassName"]}.class);
    }
</#list>

}
package com.qdqtrj.pay;

import lombok.Data;

/**
 * @author yinbin
 * Accp支付平台配置对象
 * 非spring使用方式：直接new实例
 * spring使用方式：extends此类，复写set方法增加注解：@Value("xxx")
 */
@Data
public class AccpPayConfig {

    /**
     * 发送至Accp平台的支付报文加密用 私钥
     */
    private String rsaPrivateKey;

    /**
     * Accp支付平台返回的报文 解密用 公钥
     */
    private String rsaPublicKey;

    /**
     * 支付平台域名地址，不包括具体接口path，调用时需要拼接具体接口path
     */
    private String payDomainServerUrl;

    /**
     * 请求超时时间
     * 单位：毫秒
     * 可以不传递，默认为：30秒
     */
    private Integer reqTimeout;
}

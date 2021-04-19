package com.qdqtrj.pay.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yinbin
 */
@Data
public class ParentResResult implements Serializable {

    /**
     * Accp系统分配的唯一商户编号
     */
    private String oidPartner;

    /**
     * 错误编码
     *
     * @see 《ACCP产品商户接口说明书-交易类（API）V2.3.pdf》
     * @see 《ACCP产品商户接口说明书-账户管理类（API）V1.4-标准版.pdf》
     */
    private String retCode;

    /**
     * 错误消息
     */
    private String retMsg;
}

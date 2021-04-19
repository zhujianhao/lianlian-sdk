package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 3.19. 大额行号查询 3.19.1.  请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-cnapscode
 */
@Data
public class ReqQueryCnapscode implements Serializable {
    /**
     * timestamp,时间戳,Y,String(14),交易服务器时间戳,格式：yyyyMMddHHmmss,有效期30分钟,包含服务器之间的时间差
     */
    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;
    /**
     * oid_partner,商户号,Y,String(18),ACCP 系统分配给平台商户的唯一编号
     */
    @NotBlank()
    @Length(min = 1, max = 18)
    private String oid_partner;
    /**
     * bank_code,银行编码,Y,String(8)
     */
    @NotBlank()
    @Length(min = 1, max = 8)
    private String bank_code;
    /**
     * brabank_name,支行关键字,Y,String
     */
    @NotBlank()
    private String brabank_name;
    /**
     * city_code,开户行所在市编码,Y,String(6)
     */
    @NotBlank()
    @Length(min = 1, max = 6)
    private String city_code;
}

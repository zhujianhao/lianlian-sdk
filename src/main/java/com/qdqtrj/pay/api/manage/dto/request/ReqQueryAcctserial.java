package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 3.17. 资金流水查询 3.17.1.  资金流水列表查询 请求地址https://accpapi.lianlianpay.com/v1/acctmgr/query-acctserial
 */
@Data
public class ReqQueryAcctserial implements Serializable {
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
     * user_id,商户用户唯一编号,N,String(64),用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户;user_id不送，则查询商户资金流水信息
     */
    @Length(min = 1, max = 64)
    private String user_id;
    /**
     * user_type,用户类型,Y,String(32),INNERMERCHANT:商户,INNERUSER：个人用户,INNERCOMPANY：企业用户
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String user_type;
    /**
     * acct_type,账户类型,Y,String(32),账户类型
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String acct_type;
    /**
     * date_start,账期开始时间,Y,String(14),交易账期查询开始时间，必须小于等于当前时间，闭区间,格式：yyyyMMddHHmmss
     */
    @NotBlank()
    @Length(min = 1, max = 14)
    private String date_start;
    /**
     * date_end,账期结束时间,Y,String(14),交易账期查询结束时间，必须大于等于开始时间且小于等于当前时间，闭区间,格式：yyyyMMddHHmmss
     */
    @NotBlank()
    @Length(min = 1, max = 14)
    private String date_end;
    /**
     * flag_dc,出入账标识,N,String(16),账户出入账标识，DEBIT：出账,CREDIT：入账,若不填写则表示不区分出入账
     */
    @Length(min = 1, max = 16)
    private String flag_dc;
    /**
     * page_no,请求页码,Y,Int,表示当前请求第几页，从1开始计数
     */
    @NotBlank()
    private Integer page_no;
    /**
     * page_size,每页记录数,Y,Int,每页最大记录数为100
     */
    @NotBlank()
    private Integer page_size;
    /**
     * sort_type,排序方式,N,String(16),DESC:按交易时间降序,ASC:按交易时间升序,默认DESC
     */
    @Length(min = 1, max = 16)
    private String sort_type;
}

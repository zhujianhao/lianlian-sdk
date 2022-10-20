package com.qdqtrj.pay.api.trade.dto.response;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Zhu Jianhao
 * @date 2022年10月12日 17:10
 * @description
 */
@Data
public class ResPapAgreeApply implements Serializable {

    private static final long serialVersionUID = -6048222469305707855L;

    /**
     * ret_code,交易结果代码,Y,String,交易返回码
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
     * accp_txno,ACCP 系统交易单 N,String,ACCP系统交易单号号
     */
    private String accp_txno;

    private String gateway_url;
}

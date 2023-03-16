package com.qdqtrj.pay.api.manage.dto.response;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author Zhu Jianhao
 * @date 2023年03月16日 17:20
 * @description
 */
@Data
public class ResDocumentUpload implements Serializable {

    private static final long serialVersionUID = -4641816931435473729L;

    /**
     * ret_code,交易结果代码,Y,String(4)
     */
    @NotBlank()
    @Length(min = 1, max = 4)
    private String ret_code;
    /**
     * ret_msg,交易结果描述,Y,String(32)
     */
    @NotBlank()
    @Length(min = 1, max = 32)
    private String ret_msg;
    /**
     * oid_partner,商户号,Y,String(18),ACCP 系统分配给平台商户的唯一编号
     */
    @NotBlank()
    @Length(min = 1, max = 18)
    private String oid_partner;
    /**
     * 商户系统唯一交易流水号。
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String txn_seqno;

    private String doc_id;
}

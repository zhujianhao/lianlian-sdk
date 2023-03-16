package com.qdqtrj.pay.api.manage.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author Zhu Jianhao
 * @date 2023年03月16日 17:16
 * @description
 */
@Data
public class ReqDocumentUpload implements Serializable {

    private static final long serialVersionUID = -1300653915123570905L;
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
     * user_id,商户用户唯一编号,Y,String(64),用户在商户系统中的唯一编号，要求该编号在商户系统能唯一标识用户
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String user_id;

    /**
     * txn_seqno,交易流水号,Y,String(64),商户系统唯一交易流水号
     */
    @NotBlank()
    @Length(min = 1, max = 64)
    private String txn_seqno;
    /**
     * txn_time,交易时间,Y,String(14),商户系统交易时间格式：yyyyMMddHHmmss
     */
    @NotBlank()
    @Length(min = 1, max = 14)
    private String txn_time;

    /**
     * 文件类型。支持bmp、png、jpeg、jpg、gif。
     */
    private String file_type;
    /**
     * UBO_IMAGE	受益所有人文件	受益所有人相关文件，包括其身份证、证明函等
     * USER_IMAGE	用户相关影印文件	包括个人/企业用户身份证、法人身份证、统一社会信用代码证等
     * JIEHUIBAO_MATERIALS	结汇宝证明材料	结汇宝证明材料
     * SUPPLEMENT_CSV	补单对账CSV文件	用于补单核对的交易文件
     * RECEIPT_IMAGE	电子回单影印文件	电子回单影印文件
     */
    private String context_type;

    private String file_name;

    /**
     * 文件内容。文件流通过Base64编码后传输，字符编码UTF-8；最大6M。
     * Base64编码后的字符串需去掉前缀，前缀示例：data:image/png;base64
     * 响应参数
     */
    private String file_context;
}

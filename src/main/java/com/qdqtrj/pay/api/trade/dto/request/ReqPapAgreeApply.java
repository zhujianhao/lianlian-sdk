package com.qdqtrj.pay.api.trade.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Zhu Jianhao
 * @date 2022年10月12日 16:18
 * @description
 */
@Data
public class ReqPapAgreeApply implements Serializable {

    private static final long serialVersionUID = 1363914157314083685L;

    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;

    private String oid_partner;

    private String txn_seqno;

    @JSONField(format = "yyyyMMddHHmmss")
    private Date txn_time;

    private String user_id;

    private String flag_chnl;

    private String return_url;

    private String notify_url;

    private PapSignInfo papSignInfo;

    @Data
    public static class PapSignInfo implements Serializable{

        private static final long serialVersionUID = 178620810649128098L;

        private String sign_start_time;

        private String sign_invalid_time;

        @Digits(integer = 8, fraction = 2)
        private BigDecimal single_limit;

        @Digits(integer = 8, fraction = 2)
        private BigDecimal daily_limit;

        @Digits(integer = 8, fraction = 2)
        private BigDecimal monthly_limit;

        private String agreement_type;

    }
}

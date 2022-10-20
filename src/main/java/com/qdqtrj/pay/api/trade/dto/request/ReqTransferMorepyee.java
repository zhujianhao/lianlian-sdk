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
 * @date 2022年10月19日 13:47
 * @description
 */
@Data
public class ReqTransferMorepyee implements Serializable {

    private static final long serialVersionUID = -4765364868107586434L;

    @NotNull()
    @JSONField(format = "yyyyMMddHHmmss")
    private Date timestamp;

    private String oid_partner;

    private String notify_url;

    private String funds_flag;

    private String directionalpay_flag;

    private String continuously_flag;

    private String risk_item;

    private OrderInfo orderInfo;

    private PayerInfo payerInfo;

    private PayeeInfo payeeInfo;


    @Data
    public static class OrderInfo implements Serializable{

        private static final long serialVersionUID = -5923819801830580712L;

        private String txn_seqno;

        @JSONField(format = "yyyyMMddHHmmss")
        private Date txn_time;

        @Digits(integer = 8, fraction = 2)
        private BigDecimal total_amount;

        private String txn_purpose;

        private String order_info;
    }

    @Data
    public static class PayerInfo implements Serializable{

        private static final long serialVersionUID = 7424536331343106977L;

        private String payer_type;

        private String payer_id;

        private String payer_accttype;

        private String password;

        private String random_key;

        private String pap_agree_no;
    }

    @Data
    public static class PayeeInfo implements Serializable{

        private static final long serialVersionUID = -3470404599328046444L;

        private String payee_type;

        private String payee_id;

        private String payee_accttype;

        private BigDecimal payee_amount;
    }
}

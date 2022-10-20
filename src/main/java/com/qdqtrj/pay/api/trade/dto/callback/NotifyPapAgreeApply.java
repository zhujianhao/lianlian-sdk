package com.qdqtrj.pay.api.trade.dto.callback;

import com.sun.jmx.snmp.SnmpTooBigException;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @author Zhu Jianhao
 * @date 2022年10月13日 11:33
 * @description
 */
@Data
public class NotifyPapAgreeApply implements Serializable {

    private static final long serialVersionUID = -5448325918733113463L;

    /**
     * oid_partner  商户号  Y  String  ACCP系统分配给平台商户的唯一编号
     */
    private String oid_partner;

    /**
     * accp_txno  ACCP 系统订 Y  String  ACCP系统加款订单号,同一笔线下加款的多次通知的accp_txno  不变，商户需根据该字段进行幂等性控制
     */
    private String accp_txno;
    /**
     *userId
     */
    private String user_id;

    /**
     * 签约信息papSignInfo
     */
    private PapSignInfo papSignInfo;


    @Data
    public static class PapSignInfo implements Serializable{

        private static final long serialVersionUID = -6988746457606127484L;

        /**
         *	委托代发协议号。用户在ACCP开通的委托代扣协议号。
         * 通过用户委托协议签约接口获取。
         */
        private String pap_agree_no;

        /**
         * 授权开始时间。授权生效日期：yyyyMMdd
         */
        private String sign_start_time;

        /**
         * 授权结束时间。授权结束日期：yyyyMMdd。
         */
        private String sign_invalid_time;

        /**
         * 单笔限额。委托代扣单笔最大交易额度，单位为元。
         */
        private BigDecimal single_limit;

        /**
         * 单日限额。委托代扣每日最大交易额度，单位为元。
         */
        private BigDecimal daily_limit;

        /**
         * 单月限额。委托代扣每月最大交易额度，单位为元。
         */
        private BigDecimal monthly_limit;

        /**
         * 协议状态。请参阅协议状态列表
         */
        private String status;


        /**
         * 免密协议类型。
         * WITH_HOLD：免密代扣
         * WITH_WITHDRAW：免密提现
         */
        private String agreement_type;
    }
}

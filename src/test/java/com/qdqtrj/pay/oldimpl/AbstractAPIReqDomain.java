package com.qdqtrj.pay.oldimpl;

import java.io.Serializable;

/**
 * @author KENT ligr@yintong.com.cn
 * @ClassName: AbstractAPIReqDomain
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年1月6日 上午11:42:04
 */
public abstract class AbstractAPIReqDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String timestamp;
    protected String oid_partner;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOid_partner() {
        return oid_partner;
    }

    public void setOid_partner(String oid_partner) {
        this.oid_partner = oid_partner;
    }

}

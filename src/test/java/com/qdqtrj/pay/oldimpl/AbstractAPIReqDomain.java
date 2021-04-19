package com.qdqtrj.pay.oldimpl;

import java.io.Serializable;

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

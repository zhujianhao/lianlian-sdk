package com.qdqtrj.pay.oldimpl;


public class GetPasswordRandomReqDomain extends AbstractAPIReqDomain {
    private static final long serialVersionUID = 1L;

    private String flag_chnl;
    private String pkg_name;
    private String app_name;

    public String getFlag_chnl() {
        return flag_chnl;
    }

    public void setFlag_chnl(String flag_chnl) {
        this.flag_chnl = flag_chnl;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

}

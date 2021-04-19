package com.qdqtrj.pay.oldimpl;

public class GetPasswordRandomResDomain extends AbstractAPIResDomain {
    private static final long serialVersionUID = 1L;
    /**
     * 平台商户号
     */
    private String oid_partner;//理财平台编号
    /**
     * 随机因子key
     */
    private String random_key;//随机因子KEY
    /**
     * 随机因子value
     */
    private String random_value;//随机因子VALUE
    /**
     * 证书
     */
    private String license;
    /**
     * 连连rsa公钥
     */
    private String rsa_public_content;
    /**
     * 映射数组
     */
    private String mapArr;

    public String getRandom_key() {
        return random_key;
    }

    public void setRandom_key(String random_key) {
        this.random_key = random_key;
    }

    public String getRandom_value() {
        return random_value;
    }

    public void setRandom_value(String random_value) {
        this.random_value = random_value;
    }

    public String getOid_partner() {
        return oid_partner;
    }

    public void setOid_partner(String oid_partner) {
        this.oid_partner = oid_partner;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRsa_public_content() {
        return rsa_public_content;
    }

    public void setRsa_public_content(String rsa_public_content) {
        this.rsa_public_content = rsa_public_content;
    }

    public String getMapArr() {
        return mapArr;
    }

    public void setMapArr(String mapArr) {
        this.mapArr = mapArr;
    }

}

package com.qdqtrj.pay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RSA签名公共类
 */
public class SignatureUtil {

    private static final String CHARSET = "UTF-8";
    private static final Logger log = LoggerFactory.getLogger(SignatureUtil.class);
    private static SignatureUtil instance;

    private SignatureUtil() {

    }

    public static SignatureUtil getInstance() {
        if (null == instance)
            return new SignatureUtil();
        return instance;
    }

    public static void main(String[] args) {
        String rsa_public = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqsEbJDbhe64JnkHNcpSljhkrE6rZekhE1cDklh/GLdoK4Gsd6/n/8icHNIIn6b8R3Ba+/3S5GxiuGfEc4rhBAffLKZPV2QNh0DafbWDHnu2S6PYGLrrWINawnKJJu5NLcLA0n5As8ZYmwCe5oO1rwCf2reoNWfd+K3b4LV/yTVwIDAQAB";
        String oid_str = "api_version=1.0&no_order=20170216200007&oid_plat=201704100000005002&sign_type=RSA";
        String signed_str = "oqqEKP2NMP15fPU1Z7ecOI5GXA213cx3ylTYkEQuLIF9tKkt6pRDNMxYmqiC1j96l0MJKBkIVYy/Nx86Il4mYiP/ZG+2buGLQ8sHhicz6Q16P1htcsV3sEauoYvTZ3jMfkTObce/adf9hHYx0OGnjbvhpDjnFi6ohGz5WnNT2jo=";
        System.out.print(SignatureUtil.getInstance().checksign(rsa_public, oid_str, signed_str));
    }

    /**
     * 签名处理
     *
     * @param prikeyvalue ：私钥
     * @param sign_str    ：签名源内容
     * @return
     */
    public String sign(String prikeyvalue, String sign_str) {
        try {
            String hash = Md5Algorithm.getInstance().md5Digest(sign_str.getBytes(CHARSET));
            return RSAUtil.getInstance().sign(prikeyvalue, hash);
        } catch (Exception e) {
            log.error("签名失败,{}", e.getMessage());
        }
        return null;
    }

    /**
     * 签名验证
     *
     * @param pubkeyvalue ：公钥
     * @param sign_str    ：源串
     * @param signed_str  ：签名结果串
     * @return
     */
    public boolean checksign(String pubkeyvalue, String sign_str, String signed_str) {
        try {
            String hash = Md5Algorithm.getInstance().md5Digest(sign_str.getBytes(CHARSET));
            return RSAUtil.getInstance().checksign(pubkeyvalue, hash, signed_str);
        } catch (Exception e) {
            log.error("签名验证异常,{}", e.getMessage());
        }
        return false;
    }
}

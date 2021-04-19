package com.qdqtrj.pay.api.manage.impl;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.AccpPayException;
import com.qdqtrj.pay.AccpReqParamException;
import com.qdqtrj.pay.api.ReturnCodeEnum;
import com.qdqtrj.pay.api.manage.IAccpManagePayClient;
import com.qdqtrj.pay.api.manage.dto.request.ReqGetRandom;
import com.qdqtrj.pay.api.manage.dto.response.ResGetRandom;
import junit.framework.TestCase;

import java.util.Date;

public class DefaultManagePayClientImplTest extends TestCase {

    private IAccpManagePayClient accpManagePayClient;
    private AccpPayConfig accpPayConfig;

    public void setUp() throws Exception {
        super.setUp();

        this.accpManagePayClient = new AccpManagePayClientImpl();

        this.accpPayConfig = new AccpPayConfig();
        this.accpPayConfig.setPayDomainServerUrl("https://accptest.lianlianpay-inc.com/openapi/");
        this.accpPayConfig.setRsaPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPD+malK2W3UJXfX5rO79gRUbLe+kwCskw7VzETXA4Qf/5VWlPxOb16SlflkE4zyInhGwehjUTvXPvebNtZJJpKS+Q/7oWw6hMQ1cIC99DWmV6Orjtz61Tmi5A/4QnYqUm2GRScfrnyILQw9/qikkvyjo0pPsIMT2rhmu31LSySNAgMBAAECgYEAokaubeKq2lu6ByLohCqTFINM2cWH8zJBrAGnFMu74GIzlfnBRMwEDiiiuFX9HDGHqHns5HDMKIFeMxjfKhgD0exp3S06xpSbmkIbvWLM+xBl70/+SLG7wztZ4KtdKu7PR26xJht6zM/KDrovuRzFYNB6ZbyO3My9CJXaZS6GU/kCQQD+/wsf0M7Byp+sPzy3SEn8katFopVOz8oESBBuSNNXl1rgyWfgVXBUKRDAus8oa/Nhx2zWNqpuchrHerPp5McHAkEA8fFyidW4nMkL3x4ULQmbsZBqsNEXoKv3fDDvHWRljX0AElel+XaVuxrtpYiDxwqFSM0s92nCBj2ZXt4O+d2eywJAS5mFzMr1YZMXP9QHxjcSaGUvqBeJuLH2LMrIxEmnDuL6uIY928643NrH8rvvywYmRCkB5YiTgucldVq1mHSRZQJAYny8+WrsqbYVhQ/DesnsfQ2iwLN9AMTAC+gHjlluFXiK7OyM/c3OCcpebwHxUrbvpsEOyvBcMRomMr4GLqSOnQJAcDKoXpkYFGakejn6LQj57EBtMgfVNatTipBnQxPaHMGGO9V9SzedbkgNg0NBSzsNsauKnFOy+yFwFqf6oGHm0A==");
        this.accpPayConfig.setRsaPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB");
    }

    public void tearDown() throws Exception {
        this.accpManagePayClient = null;
    }

    public void testRegphoneVerifycodeApply() throws AccpPayException {
    }

    public void testRegphoneVerifycodeVerify() {
    }

    public void testOpenacctApplyIndividual() {
    }

    public void testOpenacctVerifyIndividual() {
    }

    public void testOpenacctApplyEnterprise() {
    }

    public void testIndividualBindcardApply() {
    }

    public void testIndividualBindcardVerify() {
    }

    public void testEnterpriseChangecardApply() {
    }

    public void testUnlinkedacctIndApply() {
    }

    public void testChangeLinkedphoneApply() {
    }

    public void testChangeLinkedphoneVerify() {
    }

    public void testChangeRegphoneApply() {
    }

    public void testChangeRegphoneVerify() {
    }

    public void testCancelApply() {
    }

    public void testChangePassword() {
    }

    public void testFindPasswordApply() {
    }

    public void testFindPasswordVerify() {
    }

    public void testGetRandom() throws AccpPayException, AccpReqParamException {
        ReqGetRandom req = new ReqGetRandom();
        req.setOid_partner("2019082100299004");
        req.setFlag_chnl(ReqGetRandom.H5);
        req.setPkg_name("test");
        req.setUser_id("2019082100299004iii");
        req.setApp_name("test");
        req.setTimestamp(new Date());

        ResGetRandom random = this.accpManagePayClient.getRandom(accpPayConfig, req);
        System.out.println(random);
        System.out.println(random.getRet_code());
        assert ReturnCodeEnum.SUCCESS.code().equals(random.getRet_code());
    }

    public void testQueryLinkedacct() {
    }

    public void testQueryUserinfo() {
    }

    public void testQueryAcctinfo() {
    }

    public void testQueryAcctserial() {
    }

    public void testQueryAcctserialdetail() {
    }

    public void testQueryTxn() {
    }

    public void testQueryCnapscode() {
    }

    public void testUploadPhotos() {
    }

    public void testValidatePassword() {
    }
}
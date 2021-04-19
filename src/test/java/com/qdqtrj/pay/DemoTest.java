package com.qdqtrj.pay;

import com.alibaba.fastjson.JSON;
import com.qdqtrj.pay.api.manage.IAccpManagePayClient;
import com.qdqtrj.pay.api.manage.dto.callback.NotifyCancelApply;
import com.qdqtrj.pay.api.manage.impl.AccpManagePayClientImpl;
import com.qdqtrj.pay.util.SignatureUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class DemoTest extends TestCase {


    private IAccpManagePayClient accpManagePayClient;
    private AccpPayConfig accpPayConfig;

    public void setUp() throws Exception {
        super.setUp();

        this.accpManagePayClient = new AccpManagePayClientImpl();

        this.accpPayConfig = new AccpPayConfig();
        this.accpPayConfig.setPayDomainServerUrl("https://accptest.lianlianpay-inc.com/openapi/");
        //this.accpPayConfig.setRsaPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPD+malK2W3UJXfX5rO79gRUbLe+kwCskw7VzETXA4Qf/5VWlPxOb16SlflkE4zyInhGwehjUTvXPvebNtZJJpKS+Q/7oWw6hMQ1cIC99DWmV6Orjtz61Tmi5A/4QnYqUm2GRScfrnyILQw9/qikkvyjo0pPsIMT2rhmu31LSySNAgMBAAECgYEAokaubeKq2lu6ByLohCqTFINM2cWH8zJBrAGnFMu74GIzlfnBRMwEDiiiuFX9HDGHqHns5HDMKIFeMxjfKhgD0exp3S06xpSbmkIbvWLM+xBl70/+SLG7wztZ4KtdKu7PR26xJht6zM/KDrovuRzFYNB6ZbyO3My9CJXaZS6GU/kCQQD+/wsf0M7Byp+sPzy3SEn8katFopVOz8oESBBuSNNXl1rgyWfgVXBUKRDAus8oa/Nhx2zWNqpuchrHerPp5McHAkEA8fFyidW4nMkL3x4ULQmbsZBqsNEXoKv3fDDvHWRljX0AElel+XaVuxrtpYiDxwqFSM0s92nCBj2ZXt4O+d2eywJAS5mFzMr1YZMXP9QHxjcSaGUvqBeJuLH2LMrIxEmnDuL6uIY928643NrH8rvvywYmRCkB5YiTgucldVq1mHSRZQJAYny8+WrsqbYVhQ/DesnsfQ2iwLN9AMTAC+gHjlluFXiK7OyM/c3OCcpebwHxUrbvpsEOyvBcMRomMr4GLqSOnQJAcDKoXpkYFGakejn6LQj57EBtMgfVNatTipBnQxPaHMGGO9V9SzedbkgNg0NBSzsNsauKnFOy+yFwFqf6oGHm0A==");
        this.accpPayConfig.setRsaPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPD+malK2W3UJXfX5rO79gRUbLe+kwCskw7VzETXA4Qf/5VWlPxOb16SlflkE4zyInhGwehjUTvXPvebNtZJJpKS+Q/7oWw6hMQ1cIC99DWmV6Orjtz61Tmi5A/4QnYqUm2GRScfrnyILQw9/qikkvyjo0pPsIMT2rhmu31LSySNAgMBAAECgYEAokaubeKq2lu6ByLohCqTFINM2cWH8zJBrAGnFMu74GIzlfnBRMwEDiiiuFX9HDGHqHns5HDMKIFeMxjfKhgD0exp3S06xpSbmkIbvWLM+xBl70/+SLG7wztZ4KtdKu7PR26xJht6zM/KDrovuRzFYNB6ZbyO3My9CJXaZS6GU/kCQQD+/wsf0M7Byp+sPzy3SEn8katFopVOz8oESBBuSNNXl1rgyWfgVXBUKRDAus8oa/Nhx2zWNqpuchrHerPp5McHAkEA8fFyidW4nMkL3x4ULQmbsZBqsNEXoKv3fDDvHWRljX0AElel+XaVuxrtpYiDxwqFSM0s92nCBj2ZXt4O+d2eywJAS5mFzMr1YZMXP9QHxjcSaGUvqBeJuLH2LMrIxEmnDuL6uIY928643NrH8rvvywYmRCkB5YiTgucldVq1mHSRZQJAYny8+WrsqbYVhQ/DesnsfQ2iwLN9AMTAC+gHjlluFXiK7OyM/c3OCcpebwHxUrbvpsEOyvBcMRomMr4GLqSOnQJAcDKoXpkYFGakejn6LQj57EBtMgfVNatTipBnQxPaHMGGO9V9SzedbkgNg0NBSzsNsauKnFOy+yFwFqf6oGHm0A==");
        //this.accpPayConfig.setRsaPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB");
        this.accpPayConfig.setRsaPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDw/pmpStlt1CV31+azu/YEVGy3vpMArJMO1cxE1wOEH/+VVpT8Tm9ekpX5ZBOM8iJ4RsHoY1E71z73mzbWSSaSkvkP+6FsOoTENXCAvfQ1plejq47c+tU5ouQP+EJ2KlJthkUnH658iC0MPf6opJL8o6NKT7CDE9q4Zrt9S0skjQIDAQAB");
    }

    public void tearDown() throws Exception {
        this.accpManagePayClient = null;
    }

    @Test
    public void testSubApiPath() {
        String url = "https://accpapi.lianlianpay.com/v1/acctmgr/regphone-verifycode-verify";
        String substring = url.substring(url.indexOf(".com") + 4);
        System.out.println(substring);
    }

    public void testPrintSignBody() {
        //        String jsonData = "{\n" +
        //                "    \"did_partner\":\"jksldfklsdfjksd\",\n" +
        //                "    \"user_id\":\"jskldfjklsdfjklasjdfklsadfjk\",\n" +
        //                "    \"txn_seqno\":\"jskldfjksldfjskldfjl\",\n" +
        //                "    \"accp_txno\":\"jsdklfjklsdf\",\n" +
        //                "    \"result\":\"SUCCESS\"\n" +
        //                "}";

        NotifyCancelApply notifyCancelApply = new NotifyCancelApply();
        notifyCancelApply.setOid_partner("ooooooooooooooo");
        notifyCancelApply.setUser_id("uuuuuuuuuuuuuuuuuuuu");
        notifyCancelApply.setTxn_seqno("tttttttttttttt");
        notifyCancelApply.setAccp_txno("aaaaaaaaaaaaa");
        notifyCancelApply.setResult("SUCCESS");
        String jsonData = JSON.toJSONString(notifyCancelApply);
        System.out.println(jsonData);

        String signatureData = SignatureUtil.getInstance().sign(accpPayConfig.getRsaPrivateKey(), jsonData);
        System.out.println(signatureData);

    }
}

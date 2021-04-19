package com.qdqtrj.pay;

import com.alibaba.fastjson.JSON;
import com.qdqtrj.pay.https.request.AccpPayRequest;
import com.qdqtrj.pay.https.request.AccpResponseResult;
import com.qdqtrj.pay.https.request.impl.AccpSignRequestImpl;
import com.qdqtrj.pay.oldimpl.GetPasswordRandomReqDomain;
import com.qdqtrj.pay.oldimpl.HttpAbstractUtil;
import org.junit.Test;

/**
 *
 */
public class RandomApiNewTest extends HttpAbstractUtil {

    /**
     * 输出验证成功，标示接口测试通过
     */
    @Test
    public void testGetRandom() {
        AccpPayConfig LLPayConfig = new AccpPayConfig();
        LLPayConfig.setPayDomainServerUrl("https://accptest.lianlianpay-inc.com/openapi/");
        LLPayConfig.setRsaPrivateKey(HttpAbstractUtil.TRADER_PRI_KEY);
        LLPayConfig.setRsaPublicKey(HttpAbstractUtil.YT_RSA_PUBLIC);

        // post data bean
        GetPasswordRandomReqDomain reqObj = new GetPasswordRandomReqDomain();
        reqObj.setOid_partner("2019082100299004");
//        reqObj.setFlag_chnl("PC");
        reqObj.setFlag_chnl("ANDROID");
        reqObj.setPkg_name("test");
        reqObj.setApp_name("test");
        reqObj.setTimestamp(getTimeStamp());

        AccpPayRequest req = AccpSignRequestImpl.getInstance();
        try {
            String jsonData = JSON.toJSONString(reqObj);
            AccpResponseResult rr = req.doRequest(LLPayConfig, "v1/acctmgr/get-random", jsonData);
            if (rr.isCheckSign()) {
                String responseJson = rr.getResponseJson();
                System.out.println(responseJson);
            }
            assert rr.isCheckSign();
        } catch (AccpPayException e) {
            e.printStackTrace();
        }
    }
}

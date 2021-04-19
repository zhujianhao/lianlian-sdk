package com.qdqtrj.pay;

import com.alibaba.fastjson.JSON;
import com.qdqtrj.pay.oldimpl.GetPasswordRandomReqDomain;
import com.qdqtrj.pay.oldimpl.HttpAbstractUtil;
import org.junit.Test;

/**
 */
public class RandomApiOldTest extends HttpAbstractUtil {


    /**
     * 输出验证成功，标示接口测试通过
     */
    @Test
    public void testGetRandom() {

        GetPasswordRandomReqDomain reqObj = new GetPasswordRandomReqDomain();
        reqObj.setOid_partner("2019082100299004");
//        reqObj.setFlag_chnl("PC");
        reqObj.setFlag_chnl("ANDROID");
        reqObj.setPkg_name("test");
        reqObj.setApp_name("test");
        reqObj.setTimestamp(getTimeStamp());
        String content = JSON.toJSONString(reqObj);
//        String url = serverurl + "get-random.htm";
        String url = test_domainserverurl + "get-random";
        System.out.println(url);
        requestWithSign(url, content);
    }
}

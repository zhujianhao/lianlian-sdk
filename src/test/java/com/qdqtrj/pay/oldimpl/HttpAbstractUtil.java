package com.qdqtrj.pay.oldimpl;

import com.qdqtrj.pay.util.AccpPayHttpClient;
import com.qdqtrj.pay.util.SignatureUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @ClassName: AbstractTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author KENT ligr@yintong.com.cn
 * @date 2018年1月6日 上午11:54:44
 */
public class HttpAbstractUtil {
    //    public static final String TRADER_PRI_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOilN4tR7HpNYvSBra/DzebemoAiGtGeaxa+qebx/O2YAdUFPI+xTKTX2ETyqSzGfbxXpmSax7tXOdoa3uyaFnhKRGRvLdq1kTSTu7q5s6gTryxVH2m62Py8Pw0sKcuuV0CxtxkrxUzGQN+QSxf+TyNAv5rYi/ayvsDgWdB3cRqbAgMBAAECgYEAj02d/jqTcO6UQspSY484GLsL7luTq4Vqr5L4cyKiSvQ0RLQ6DsUG0g+Gz0muPb9ymf5fp17UIyjioN+ma5WquncHGm6ElIuRv2jYbGOnl9q2cMyNsAZCiSWfR++op+6UZbzpoNDiYzeKbNUz6L1fJjzCt52w/RbkDncJd2mVDRkCQQD/Uz3QnrWfCeWmBbsAZVoM57n01k7hyLWmDMYoKh8vnzKjrWScDkaQ6qGTbPVL3x0EBoxgb/smnT6/A5XyB9bvAkEA6UKhP1KLi/ImaLFUgLvEvmbUrpzY2I1+jgdsoj9Bm4a8K+KROsnNAIvRsKNgJPWd64uuQntUFPKkcyfBV1MXFQJBAJGs3Mf6xYVIEE75VgiTyx0x2VdoLvmDmqBzCVxBLCnvmuToOU8QlhJ4zFdhA1OWqOdzFQSw34rYjMRPN24wKuECQEqpYhVzpWkA9BxUjli6QUo0feT6HUqLV7O8WqBAIQ7X/IkLdzLa/vwqxM6GLLMHzylixz9OXGZsGAkn83GxDdUCQA9+pQOitY0WranUHeZFKWAHZszSjtbe6wDAdiKdXCfig0/rOdxAODCbQrQs7PYy1ed8DuVQlHPwRGtokVGHATU=";
//    public static final String TRADER_PRI_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDw/pmpStlt1CV31+azu/YEVGy3vpMArJMO1cxE1wOEH/+VVpT8Tm9ekpX5ZBOM8iJ4RsHoY1E71z73mzbWSSaSkvkP+6FsOoTENXCAvfQ1plejq47c+tU5ouQP+EJ2KlJthkUnH658iC0MPf6opJL8o6NKT7CDE9q4Zrt9S0skjQIDAQAB";
    public static final String TRADER_PRI_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPD+malK2W3UJXfX5rO79gRUbLe+kwCskw7VzETXA4Qf/5VWlPxOb16SlflkE4zyInhGwehjUTvXPvebNtZJJpKS+Q/7oWw6hMQ1cIC99DWmV6Orjtz61Tmi5A/4QnYqUm2GRScfrnyILQw9/qikkvyjo0pPsIMT2rhmu31LSySNAgMBAAECgYEAokaubeKq2lu6ByLohCqTFINM2cWH8zJBrAGnFMu74GIzlfnBRMwEDiiiuFX9HDGHqHns5HDMKIFeMxjfKhgD0exp3S06xpSbmkIbvWLM+xBl70/+SLG7wztZ4KtdKu7PR26xJht6zM/KDrovuRzFYNB6ZbyO3My9CJXaZS6GU/kCQQD+/wsf0M7Byp+sPzy3SEn8katFopVOz8oESBBuSNNXl1rgyWfgVXBUKRDAus8oa/Nhx2zWNqpuchrHerPp5McHAkEA8fFyidW4nMkL3x4ULQmbsZBqsNEXoKv3fDDvHWRljX0AElel+XaVuxrtpYiDxwqFSM0s92nCBj2ZXt4O+d2eywJAS5mFzMr1YZMXP9QHxjcSaGUvqBeJuLH2LMrIxEmnDuL6uIY928643NrH8rvvywYmRCkB5YiTgucldVq1mHSRZQJAYny8+WrsqbYVhQ/DesnsfQ2iwLN9AMTAC+gHjlluFXiK7OyM/c3OCcpebwHxUrbvpsEOyvBcMRomMr4GLqSOnQJAcDKoXpkYFGakejn6LQj57EBtMgfVNatTipBnQxPaHMGGO9V9SzedbkgNg0NBSzsNsauKnFOy+yFwFqf6oGHm0A==";
    public static final String YT_RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    public static final String TEST_OIDPARTNER = "201701120000283004";
    protected final static Log logger = LogFactory.getLog(HttpAbstractUtil.class);
    protected static final String SIGNATURE_TYPE = "Signature-Type";
    protected static final String SIGNATURE_DATA = "Signature-Data";
    public static String serverurl = "http://192.168.162.190:8099/accpapi/v1/acctmgr/";
    //    public static String test_domainserverurl = "https://accptest.lianlianpay.com/openapi/v1/acctmgr/";
//    public static String test_domainserverurl = "https://accptest.lianlianpay-inc.com/openapi/v1/";
    public static String test_domainserverurl = "https://accptest.lianlianpay-inc.com/openapi/v1/acctmgr/";
    public static String localurl = "http://localhost:8099/accpapi/v1/acctmgr/";

    /**
     * 发送POST请求
     */
    public static String doPostUrl(String myURL, String content, String correlationID) {
        URL url;
        try {
            url = new URL(myURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");// 提交模式
            //是否允许输入输出
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            conn.connect();
            conn.getOutputStream().write(content.getBytes(StandardCharsets.UTF_8));
            conn.getOutputStream().flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String lines = reader.readLine();
            reader.close();
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 发起交易请求
     *
     * @return
     */
    public static String requestWithSign(String url, String content) {
        HttpClient httpClient = AccpPayHttpClient.getInstance();
        System.out.println("请求报文:" + content);
        HttpPost post = new HttpPost(url);
        System.out.println("请求URL [" + url + "]");
        post.setHeader("Content-Type", "application/text;charset=UTF-8");
        try {
            String signatureData = SignatureUtil.getInstance().sign(TRADER_PRI_KEY, content);
            System.out.println("请求signatureData [" + signatureData + "]");
            post.addHeader(SIGNATURE_TYPE, "RSA");
            post.addHeader(SIGNATURE_DATA, signatureData);
            StringEntity formEntiry = new StringEntity(content, "UTF-8");
            // 设置请求参数
            post.setEntity(formEntiry);
            // 发起交易
            HttpResponse resp = httpClient.execute(post);
            // 响应分析
            HttpEntity entity = resp.getEntity();
            BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8));
            StringBuffer responseString = new StringBuffer();
            String result = br.readLine();
            while (result != null) {
                responseString.append(result);
                result = br.readLine();
            }
            // 直接获取返回的字符串
            String resJson = responseString.toString();
            System.out.println("返回报文:" + resJson);
            String resSignatureData = "";
            Header[] headers = resp.getAllHeaders();
            int i = 0;
            while (i < headers.length) {
                System.out.println(headers[i].getName() + ":  " + headers[i].getValue());
                if (SIGNATURE_DATA.equals(headers[i].getName())) {
                    resSignatureData = headers[i].getValue();
                }
                i++;

            }
            boolean checksign = SignatureUtil.getInstance().checksign(YT_RSA_PUBLIC, resJson, resSignatureData);
            System.out.println("验证签名结果:" + checksign);
            return resJson;
        } catch (Exception cte) {
            System.out.print(cte);
            return "";
        }
    }

    public static String getTimeStamp() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return df.format(date);
    }

    public void init(String name) {
        System.out.println("初始化设置线程参数");
//        ThreadUtil.setCorrelationID(UUID.randomUUID().toString());
//        ThreadUtil.setIP("127.0.0.1");
//        ThreadUtil.setTag(Thread.currentThread().getStackTrace()[2].getMethodName() + name);
    }
}

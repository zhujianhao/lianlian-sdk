package com.qdqtrj.pay.util;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * 线程安全的HttpCLient,单例模式，支持http、https协议
 */
public class AccpPayHttpClient {
    private static int TIME_OUT = 1000 * 30;
    private static HttpClient customHttpClient;

    private AccpPayHttpClient() {
    }

    /**
     * synchronized TODO 可能会影响性能 可替换为性能更高的自旋锁实现
     *
     * @return
     */
    public static synchronized HttpClient getInstance() {
        if (customHttpClient == null) {
            return httpClientInstance();
        }
        return customHttpClient;
    }

    /**
     * synchronized TODO 可能会影响性能 可替换为性能更高的自旋锁实现 timeout和单例实现不优雅，有时间重构
     *
     * @param reqTimeout
     * @return
     */
    public static synchronized HttpClient getInstance(Integer reqTimeout) {
        if (customHttpClient == null || reqTimeout == null) {
            return httpClientInstance();
        }
        if (AccpPayHttpClient.TIME_OUT != reqTimeout) {
            AccpPayHttpClient.TIME_OUT = reqTimeout;
            return httpClientInstance();
        }
        return customHttpClient;
    }

    private static HttpClient httpClientInstance() {

        KeyStore trustStore;
        SSLSocketFactory sf = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            sf = new MySSLSocketFactory(trustStore);
            sf
                    .setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        ConnManagerParams.setTimeout(params, TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
        HttpConnectionParams.setSoTimeout(params, TIME_OUT);
        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory
                .getSocketFactory(), 80));
        schReg.register(new Scheme("https", sf, 443));

        ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
                params, schReg);
        customHttpClient = new DefaultHttpClient(conMgr, params);
        return customHttpClient;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}

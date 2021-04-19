package com.qdqtrj.pay.https.request.impl;

import com.qdqtrj.pay.AccpPayConfig;
import com.qdqtrj.pay.https.request.AccpPayRequest;
import com.qdqtrj.pay.https.request.AccpResponseResult;

/**
 * post 请求实现
 * TODO 平台可能不在支持不建议使用
 * @author yinbin
 */
@Deprecated
public final class AccpPostRequestImpl implements AccpPayRequest {
    @Override
    public AccpResponseResult doRequest(AccpPayConfig accpPayConfig, String apiPath, String jsonData) {
        return null;
    }
}

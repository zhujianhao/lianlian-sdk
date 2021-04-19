#   

lianlianpay-accp-sdk

连连支付 - accp支付平台SDK

## 一、使用方法

https://github.com/felixyin/lianlianpay-accp-sdk

### 1.1 源码编译打包，安装到本地仓库

1. `git clone https://github.com/felixyin/lianlianpay-accp-sdk.git`
2. `mvn clean install -U -DskipTests`

### 1.2 项目集成

1. jdk1.8
2. maven

需要accp支付的项目pom.xml中引入sdk：

```xml

<dependency>
    <groupId>com.qdqtrj.pay</groupId>
    <artifactId>lianlianpay-accp-sdk</artifactId>
    <version>1.0.1-SNAPSHOT</version>
</dependency>
```

`mvn clean install -U -DskipTests`

### 1.3 命名规则

1. 类大都以Accp开头(dto除外)
    - AccpManagePayClientImpl
    - AccpTradePayClientImpl
    - AccpNotifyUtil：异步通知工具类
    - AccpNotifyCallback：请看最后例子
2. IAccp开头的是接口
    - IAccpManagePayClient：管理类接口
    - IAccpTradePayClient：交易类接口
3. 请求dto对象以Req开头
    - 在com.qdqtrj.pay.api.manage.dto.request 包中的是管理请求报文封装类型
    - 在com.qdqtrj.pay.api.trade.dto.request 包中的是交易请求报文封装类型
4. 返回dto对象以Res开头
    - 在com.qdqtrj.pay.api.manage.dto.response 包中的是管理响应报文封装类型
    - 在com.qdqtrj.pay.api.trade.dto.response 包中的是交易响应报文封装类型
5. 异步dto对象以Notify开头
    - 在com.qdqtrj.pay.api.manage.dto.callback 包中的是管理异步通知accp请求报文封装类型
    - 在com.qdqtrj.pay.api.trade.dto.callback 包中的是交易异步通知accp请求报文封装类型
6. 枚举以Enum结尾

## 二、文档

### 2.1 管理类API V1.4

doc/《ACCP产品商户接口说明书-账户管理类（API）V1.4-标准版.pdf》

### 2.2 交易类API V2.3

doc/《ACCP产品商户接口说明书-交易类（API）V2.3.pdf》

## 三、接口更新和重新生成

请参考Test类：GenerateApiAndBeanMain （文件中有注释和说明）

> 注意：如果accp提供更新api pdf文档，api更新较少，建议手动仿照之前api编写，不建议自动生成

## 四、API接口说明

### 4.1 管理类API接口

`IAccpManagePayClient accpManagePayClient = new AccpManagePayClientImpl();`

### 4.2 交易类API接口

`IAccpTradePayClient accpTradePayClient = new AccpTradePayClientImpl();`

### 4.3 demo举例：

```java
// 管理类API接口客户端
private IAccpManagePayClient accpManagePayClient;
// 支付配置对象
private AccpPayConfig accpPayConfig;

        // 初始化管理类接口实现对象
        accpManagePayClient=new AccpManagePayClientImpl();
        // accpTradePayClient = new AccpTradePayClientImpl(); // 交易类接口实现对象

        // ------------------- config start
        // 可以采用spring cloud config / nacos配合@Value注解初始化AccpPayConfig对象 
        accpPayConfig=new AccpPayConfig();
        // v1/xxx/xxx之前的domain url
        accpPayConfig.setPayDomainServerUrl("https://accptest.lianlianpay-inc.com/openapi/");
        // ca私钥
        accpPayConfig.setRsaPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPD+malK2W3UJXfX5rO79gRUbLe+kwCskw7VzETXA4Qf/5VWlPxOb16SlflkE4zyInhGwehjUTvXPvebNtZJJpKS+Q/7oWw6hMQ1cIC99DWmV6Orjtz61Tmi5A/4QnYqUm2GRScfrnyILQw9/qikkvyjo0pPsIMT2rhmu31LSySNAgMBAAECgYEAokaubeKq2lu6ByLohCqTFINM2cWH8zJBrAGnFMu74GIzlfnBRMwEDiiiuFX9HDGHqHns5HDMKIFeMxjfKhgD0exp3S06xpSbmkIbvWLM+xBl70/+SLG7wztZ4KtdKu7PR26xJht6zM/KDrovuRzFYNB6ZbyO3My9CJXaZS6GU/kCQQD+/wsf0M7Byp+sPzy3SEn8katFopVOz8oESBBuSNNXl1rgyWfgVXBUKRDAus8oa/Nhx2zWNqpuchrHerPp5McHAkEA8fFyidW4nMkL3x4ULQmbsZBqsNEXoKv3fDDvHWRljX0AElel+XaVuxrtpYiDxwqFSM0s92nCBj2ZXt4O+d2eywJAS5mFzMr1YZMXP9QHxjcSaGUvqBeJuLH2LMrIxEmnDuL6uIY928643NrH8rvvywYmRCkB5YiTgucldVq1mHSRZQJAYny8+WrsqbYVhQ/DesnsfQ2iwLN9AMTAC+gHjlluFXiK7OyM/c3OCcpebwHxUrbvpsEOyvBcMRomMr4GLqSOnQJAcDKoXpkYFGakejn6LQj57EBtMgfVNatTipBnQxPaHMGGO9V9SzedbkgNg0NBSzsNsauKnFOy+yFwFqf6oGHm0A==");
        // ca公钥
        accpPayConfig.setRsaPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB");
        // ------------------- config end

        // 初始化和设置请求报文对象，会转化为json，并ca签名加密
        ReqGetRandom req=new ReqGetRandom();
        req.setOid_partner("2019082100299004");
        req.setFlag_chnl("ANDROID");
        req.setPkg_name("test");
        req.setApp_name("test");
        DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date=new Date();
        String timestamp=df.format(date);
        req.setTimestamp(timestamp);

        // 发起对accp支付平台getRandom接口api请求，返回值自动签名验证和解析json到bean，如果签名或解析错误，会throw AccpPayException异常
        ResGetRandom random=this.accpManagePayClient.getRandom(accpPayConfig,req);

        System.out.println(random);
        System.out.println(random.getRet_code());
        assert ReturnCodeEnum.SUCCESS.code().equals(random.getRet_code());

```

### 4.4 回调测试环境

#### 4.4.1 测试步骤

0. `cd project目录`
1. 解压tomcat开头的压缩包
2. `mvn clean install -U -DskipTests`
3. 运行tomcat：`./target/bin/webapp`
4. 浏览器访问：http://localhost:8080/notifyUrlXxx
5. postman配置，并send
    - url : https://qlytestpay.qly58.shop/notifyCancelApplyServlet (可改为你本机地址)
    - headers
        - Signature-Type: RSA
        - Signature-Data:
          s/9IPb+okoOnzfJJsGxmwI+k6e+V/iWrXrqzkU65ZfPP7ic8MSFMILEKLtu/SuJE8oP+O2hkQkPhG2P1pTo/HIUkHB4MUdAtCNS1wP29PCcJnPGrSDz7zVTf3d1gTb8nJEbvlKMUyLu8d487gN9PBmG/RK0bkUCUG+T4C/sOf8I=
    - body
        - raw: {"accp_txno":"aaaaaaaaaaaaa","oid_partner":"ooooooooooooooo","result":"SUCCESS","txn_seqno":"
          tttttttttttttt","user_id":"uuuuuuuuuuuuuuuuuuuu"}

或者linux/macos下运行命令：

```
curl --location --request POST 'https://qlytestpay.qly58.shop/notifyCancelApplyServlet' \
--header 'Signature-Type: RSA' \
--header 'Signature-Data: s/9IPb+okoOnzfJJsGxmwI+k6e+V/iWrXrqzkU65ZfPP7ic8MSFMILEKLtu/SuJE8oP+O2hkQkPhG2P1pTo/HIUkHB4MUdAtCNS1wP29PCcJnPGrSDz7zVTf3d1gTb8nJEbvlKMUyLu8d487gN9PBmG/RK0bkUCUG+T4C/sOf8I=' \
--header 'Content-Type: text/plain' \
--data-raw '{"accp_txno":"aaaaaaaaaaaaa","oid_partner":"ooooooooooooooo","result":"SUCCESS","txn_seqno":"tttttttttttttt","user_id":"uuuuuuuuuuuuuuuuuuuu"}'
```

或者java（需导入OkHttp包）：

```java
OkHttpClient client=new OkHttpClient().newBuilder()
        .build();
        MediaType mediaType=MediaType.parse("text/plain");
        RequestBody body=RequestBody.create(mediaType,"{\"accp_txno\":\"aaaaaaaaaaaaa\",\"oid_partner\":\"ooooooooooooooo\",\"result\":\"SUCCESS\",\"txn_seqno\":\"tttttttttttttt\",\"user_id\":\"uuuuuuuuuuuuuuuuuuuu\"}");
        Request request=new Request.Builder()
        .url("https://qlytestpay.qly58.shop/notifyCancelApplyServlet")
        .method("POST",body)
        .addHeader("Signature-Type","RSA")
        .addHeader("Signature-Data","s/9IPb+okoOnzfJJsGxmwI+k6e+V/iWrXrqzkU65ZfPP7ic8MSFMILEKLtu/SuJE8oP+O2hkQkPhG2P1pTo/HIUkHB4MUdAtCNS1wP29PCcJnPGrSDz7zVTf3d1gTb8nJEbvlKMUyLu8d487gN9PBmG/RK0bkUCUG+T4C/sOf8I=")
        .addHeader("Content-Type","text/plain")
        .build();
        Response response=client.newCall(request).execute();
```

> postman 输出 Success字符即成功

#### 4.4.2 回调工具类使用举例：

```java
String returnStr=""; // 默认为空串，表示：回调处理失败
        try{
        returnStr=AccpNotifyUtil.doNotify(accpPayConfig,request,NotifyCancelApply.class,
        new AccpNotifyCallback<NotifyCancelApply>(){
@Override
protected boolean businessCode(NotifyCancelApply notifyBean){
        System.out.println(notifyBean);
        return true;
        }
        });
        }catch(Exception e){
        // 注意： 必须要try catch，因为无论如何都要给我们提供给accp支付平台回调url的调用方（也就是accp平台）返回消息
        }
```

> 注意：入参依赖HttpServletReqest，可以对接spring和普通java web项目(HttpServletRequest)

## 五、测试商户号

测试商户号：2020088888888（测试商户号需连连支付提供）

加签私钥：xxx （需连连支付提供）

测试环境接口地址将文档中地址域名换成https://accptest.lianlianpay-inc.com/openapi/

如个人开户接口生产环境：https://accpapi.lianlianpay.com/v1/acctmgr/openacct-apply-enterprise

测试环境地址为：https://accptest.lianlianpay-inc.com/openapi/v1/acctmgr/openacct-apply-enterprise

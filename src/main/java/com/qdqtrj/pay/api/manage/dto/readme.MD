# dto说明

1. 不同支付接口底层请求逻辑和处理方式相同
2. 不同支付接口传递参数和返回数据以及回调数据不同
3. 每个接口最多封装三种dto类：
 - request目录
     - 命名规则：Req+请求path改驼峰dto
     - 说明：发送accp请求的参数对象,将通过json toString后，签名加密后，传输到accp平台
 - response目录
     - 命名规则：Res+请求path改驼峰dto
     - 说明：accp返回数据验证签名成功后json parse的对象
 - callback目录
    - 说明：异步通知回调数据dto

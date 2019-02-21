package com.jk.config;

public class AlipayConfig {

    /*沙箱环境  买家账户登录付款

    买家账号 retlqk4299@sandbox.com

    登录密码 111111

    支付密码 111111

    * */





    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    //*应用id
    public static String app_id = "2016092500592485";//*

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    //*商户私钥
    public static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2yRuyFCOg1bOS5PocRvaNiIyMmy0W+wDxLFu5MVmwrR7YQKMNtJoB+ZbiOx7L5i4rdBgADbNLQinaMk4iysjIhq8X4iMrOFO2CLMKmx9XVO1oyudrvC18zLM0IuwsQEohYhnURlrWbBZRL7EvtyxaJX8UtXfqTxtolo901u2uYYarhB84er+qyJnDtYnYnmhDUNrT+8aicgahKIIJnNFXPTHpbXIoazVHfmP2bPVHm2bCaZMe7gP3u5oc0HMXD/yBO6UwGU3xUds05e252TzYl0/IT+GSY6lm3dq7sRnLpOHpNfQlW/ENAtKICotUYkXp2euKBgHC0zhNk6lu5FbvAgMBAAECggEAV07oc7865XAuPlQxQ6CB1EkNGXxlpTxvzsMpbOQtuz52JUV6nOlPRvI5KAalRy/Dje3+KMhig+gupZKxz9yc22u55uaVdeeJ1MGDA+XkqopefFevAr7320zLrHOh6+Eph5icTdDtQs6OOmlVcT1FainO8c1cYgc3SFXiYCTpkwkiyVj0MBaewr3xY9BxJ1S7NLq+YiutZFIzyXxVztI3BGF/sa5zF9d0NpF9r/fxLr3IYZMS5d3iqLJ2UhgbShY1EUZysWJSPy7OaYKvgYL8neJmZVgtvnLPrldktRGoX+rcYaqCf720ZF9TPz+N5wAiz86dVBMq0B1wBtnVGCW3QQKBgQDwL81XIwbDprqu6EdY5kCXz9L33bMftTSAfHaa3mPRTSWBuYJAjwC8dDlMYlzwyjEQa8KnGfedMl3lU8G5mNPbh1rT44MFvpjJ3Sy3RpVLO6T3npTqc4HSq+Vld6omuNSsSzm1xVE2QTaCIHUCjoXDpxwQ40VDo2+1QMXPz0+DEwKBgQDC0dht22ZiyL4iD0u89CZyGWvN68ydHQCdRd0Fws60nkVzctyQvPwzfj0kIK0F8KI3M9GbR59A99SnNKAuYs933Ku6JAyaOeksXBkMi5UVZG3ksY9eTckwi/Bi2Gt1xpGyA7oh5dSGklOL4sCr2fZWCQbjuSH4Yzry0qC9zWt8NQKBgCZFx7ep2isVB0xVsQDGd+Z49EoQ5rkXu8z5iEC3TTqNy3s3Xz0ATIK7FmJIjjzESzstoK/V4HIJE5M2XHlBlAi4Mc3vw/IHY/tOphByS9nYIDpg56PQUhCK2ZvojJFtBF6MAh8n2QAHNjNYDq0gnsoFd+BtBp13jpZYQu0RQL9HAoGBAIDmm07Elc/Shoq+mBwjZrSjwUJ0O+PQZrGoof7H0ECNX+JtIybZA/2GDyoyPIjrmEjyDkOxddtknt0q4rkOQ7tI1I7Kf1Qj8PWa0jAMws1ur49bNELvMKjgTmL4UtGQWqHv+V2oVZ/cfU7W7yhFhMmUG2zc928DKOO1HQm4Ot/pAoGBAK/HdgmjMwmiDfUgFfTRh57q5PyJjZiUWPe/DvbzSvVd7z+xNUh0R0t8ESHBIKEppwmhv9F19C06F7mDSmUwoYDT1xwM2xR+1/xmGktjdDJbeDd64e+7TN9gHLsBY+So7Ki8tC2tkYhtLeFyTyYuSOs09JFwQ697TjRUHXDA/yqu";

    //*服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8085/pay/notifyUrl";
    //*页面跳转同步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8085/pay/returnUrl";

    //*开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    //支付宝网关
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    //*支付宝公钥
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6M4ZpAIMEnWAY9t4Tfe8EV2H9Bbgb9d+VIJFPXH26v7DWlZtR+MUJiHtQtz4kTyIjg1wGKb/0JomcobNXXKIi3sfEIkNEQTy9qW5dR+LQpFCB8mcJk7jWMRl3hMQrVAy3CIaZ3NKb/oFpCoiaU3hYn9CyKQLrh7iqytpbGtc8+upjXTORnFMnrcJEYpYveqm/cDIlDz8KmWKUbb09UXWvMY8JRXUCvVFx4akPxHpT0DYIBeAxgM+XV1OReyI2tttI5I7ZCvLChz8TtreHJrqWt8qkA7BqRdRYyRe40Wo1iueoCUBW41VkMS7DlqKkGf1vbZuo4FjAJyzVRf0X3sVZwIDAQAB";

    public static String signtype = "RSA2";



}

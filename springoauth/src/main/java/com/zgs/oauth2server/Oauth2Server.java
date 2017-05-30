package com.zgs.oauth2server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shmily on 2017/5/30.
 */
@Controller
@RequestMapping("/oauth2")
public class Oauth2Server {
    /**
     * 注册APP
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response){
        return "";
    }
    /**
     * 授权码请求
     * response_type：必选项。该值必须设置为(code|授权码)。
       client_id：必选项。客户端 ID。
       redirect_uri：必选项。用于用户代理重定向。
       scope：可选项。访问请求的范围。
       req-demo
       /oauth2/authorize?response_type=code&client_id=s6BhdRkqt3&redirect_uri=https://client.example.com/cb
     */
    @RequestMapping("/authorize")
    public String authorize(HttpServletRequest request, HttpServletResponse response){
      return "";
    }

    /**
     *获取Token
     grant_type：必选项。该值必须设置为
                 authorization_code授权码|client_credentials客户端凭证|password 用户密码|refresh_token刷新token
     client_id：必选项。客户端 ID。
     client_secret：可选项。密码，用于与授权服务器进行身份验证。（client_credentials模式必填）
     code：可选项。从服务器收到的授权码。(authorization_code模式必填)
     redirect_uri：必选项。在步骤 (A) 中发送的完全一样。
     req-demo
     authorization_code模式
     grant_type=authorization_code&code=SplxlOBeZQQYbYS6WxSbIA&client_id=c342
     &redirect_uri=https://client.example.com
     */
    @RequestMapping("/token")
    public String token(HttpServletRequest request, HttpServletResponse response){
//        返回数据DEMO
//        {
//            "access_token":"2YotnFZFEjr1zCsicMWpAA",
//                "token_type":"Bearer",
//                "expires_in":3600,
//                "refresh_token":"tGzv3JOkF0XG5Qx2TlKWIA",
//                "example_parameter":"example_value"
//        }
        return "";
    }
}

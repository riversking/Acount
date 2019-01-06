package com.rivers.user.api.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author riversking
 */
@FeignClient("OAUTH-SERVER")
public interface OauthClientFeign {


    /**
     * 获取TOKEN
     * @param authorization  authorization
     * @param username username
     * @param password password
     * @param grantType grantType
     * @return
     */
    @PostMapping("/oauth/token")
    JSONObject getAccessToken(@RequestHeader("Authorization") String authorization,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("grant_type") String grantType);

}
package com.rivers.user.api.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author riversking
 */
@FeignClient(name = "USER-SERVER")
public interface UserClientFeign {


    /**
     * 用户查询
     *
     * @param from     from
     * @param username username
     * @return JSONObject
     */
    @PostMapping(value = "/user/info")
    JSONObject userInfo(@RequestHeader("from") String from, @RequestBody String username);
}

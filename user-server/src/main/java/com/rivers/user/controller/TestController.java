package com.rivers.user.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("FILE-SERVER")
public interface TestController {

    @PostMapping("/file/test")
    String test(@RequestHeader("FROM") String hear);
}

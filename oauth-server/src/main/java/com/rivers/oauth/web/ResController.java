package com.rivers.oauth.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author riverskingking
 * @date 2018/9/16
 */
@RestController
public class ResController {
    /**
     * 任何人都需要授权后才能访问
     * @param value
     * @return
     */
    @GetMapping("/test/{value}")
    public String test(@PathVariable String value){
        //只是为了下断点查看授权信息而已
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return value;
    }

    /**
     * 开放资源，任何人都可以访问
     * @param value
     * @return
     */
    @GetMapping("/open")
    public String publi(@RequestParam String value){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return value;
    }

    /**
     * 拥有权限res1或者scope2的人才能访问
     * 权限验证一般细化到具体资源，下面的#oauth2.hasScope不建议使用，每个scope也是有对应的资源列表的，因此在clientDetailsService里声明好客户端scope对应的authorities即可
     * @param value
     * @return
     */
    @GetMapping("/res1/{value}")
    @PreAuthorize("hasAuthority('res1') or  #oauth2.hasScope('scope2')")
    public String res1(@PathVariable String value){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return value;
    }



    /**
     * 拥有权限res2的人才能访问
     * @param value
     * @return
     */
    @GetMapping("/res2/{value}")
    @PreAuthorize("hasAuthority('res2') ")
    public String res2(@PathVariable String value){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return value;
    }

    /**
     * 拥有权限res3的人才能访问
     * @param value
     * @return
     */
    @GetMapping("/res3/{value}")
    @PreAuthorize("hasAuthority('res3')")
    public String res3(@PathVariable String value){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return value;
    }
}

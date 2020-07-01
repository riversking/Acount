package com.rivers.file.controller;

import com.rivers.core.view.ResponseVo;
import com.rivers.file.client.UserClientFeign;
import com.rivers.file.service.UploadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author riversking
 */
@RestController
@RequestMapping("file")
@Log4j2
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UserClientFeign userClientFeign;


    @PostMapping("/upload")
    @ResponseBody
    public ResponseVo upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseVo.ok(uploadService.uploadFile(file));
    }

    @PostMapping("/test")
    @ResponseBody
    public ResponseVo test() {
        return ResponseVo.ok(userClientFeign.userInfo("admin").get("data"));
    }


}

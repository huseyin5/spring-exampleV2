package com.example.gridfs.api;

import com.example.gridfs.service.FileUploudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("uploud")
public class FileUploudApi {

    @Autowired
    private FileUploudService fileUploudService;

    @PostMapping
    public void fileUploud(@RequestParam MultipartFile file) throws Exception {
        fileUploudService.uploudFile(file);
    }
}

package com.example.shortcoursebms.controllers.restcontrollers;


import com.example.shortcoursebms.services.impl.FileUploadService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
public class FileUploadRestController {

    private FileUploadService fileUploadService;

    public FileUploadRestController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/multiple")
    public List<String> upload(@ApiParam("file") @RequestParam("file") MultipartFile[] file) {

        List<MultipartFile> files = Arrays.asList(file);

        return this.fileUploadService.upload(files, "");

    }

    @PostMapping("")
    public String upload(@ApiParam("file") MultipartFile file) {
        return this.fileUploadService.upload(file, "");
    }


}

package com.example.shortcoursebms.controllers.restcontrollers;


import com.example.shortcoursebms.services.impl.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
public class FileUploadRestController {

    private FileUploadService fileUploadService;

    public FileUploadRestController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }


    @PostMapping("")
    public List<String> upload(List<MultipartFile> file) {

        return this.fileUploadService.upload(file, "");
    }


}

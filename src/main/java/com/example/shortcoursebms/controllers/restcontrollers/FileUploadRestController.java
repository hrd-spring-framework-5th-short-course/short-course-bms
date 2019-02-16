package com.example.shortcoursebms.controllers.restcontrollers;


import com.example.shortcoursebms.services.impl.FileUploadService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

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
    public Map<String, Object> upload(@ApiParam("file") MultipartFile file) {

        Map<String , Object> response = new HashMap<>();
        String filename = this.fileUploadService.upload(file,"");
        response.put("filename", filename);
        return response;
    }


}

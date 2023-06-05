package com.martinps.controller;

import com.martinps.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileController {
    @Autowired
    private IFileService iFileService;

    @GetMapping("/file")
    public ResponseEntity<Resource> get(@RequestParam("n") String file){
        return iFileService.get(file);
    }

}

package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.service.impl.FileServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
@Tag(name = "File", description = "File Management APIs")
public class FileController {
    private final FileServiceImpl fileService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }
        try {
            fileService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading the file: " + e.getMessage());
        }
    }
}

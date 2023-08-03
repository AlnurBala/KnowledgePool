package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        Path filePath = Paths.get("uploads/" + file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Error while copying the file: {}", e.getMessage());
            throw e;
        }
    }
}

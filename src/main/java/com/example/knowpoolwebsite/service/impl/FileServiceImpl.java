package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.entity.File;
import com.example.knowpoolwebsite.repository.FileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl {
    private final FileRepository fileRepository;

    private String formatFileSize(long fileSize) {
        if (fileSize >= 1024 * 1024) {
            return String.format("%.2f MB", (double) fileSize / (1024 * 1024));
        } else {
            return String.format("%.2f KB", (double) fileSize / 1024);
        }
    }

    @Transactional
    public void uploadFile(MultipartFile file) throws IOException {
        File fileEntity = new File();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setFileContent(Base64.getEncoder().encodeToString(file.getBytes()));
        fileEntity.setFileSize(formatFileSize(file.getSize())); // Format and set the file size
        fileEntity.setUploadDate(LocalDateTime.now());
        fileRepository.save(fileEntity);
    }
}
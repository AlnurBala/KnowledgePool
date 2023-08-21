package com.matrix.knowpoolwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "files", schema = "project")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_type", nullable = false)
    private String fileType;
    @Column(name = "file_content", nullable = false, columnDefinition = "TEXT")
    private String fileContent;

    @Column(name = "file_size", nullable = false)
    private String fileSize; // Store formatted file size as a string

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;


}

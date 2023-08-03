package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}

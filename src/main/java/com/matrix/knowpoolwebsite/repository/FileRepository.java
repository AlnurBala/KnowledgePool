package com.matrix.knowpoolwebsite.repository;

import com.matrix.knowpoolwebsite.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}

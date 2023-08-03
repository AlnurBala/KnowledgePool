package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.EnrollmentRequest;
import com.example.knowpoolwebsite.dto.Response.EnrollmentResponse;
import com.example.knowpoolwebsite.entity.Enrollment;
import com.example.knowpoolwebsite.mapper.EnrollmentMapper;
import com.example.knowpoolwebsite.repository.EnrollmentRepository;
import com.example.knowpoolwebsite.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentResponse> getAllEnrollments() {
        var enrollmentEntity = enrollmentRepository.findAll();
        return enrollmentMapper.toDTOs(enrollmentEntity);
    }
    @Override
    public EnrollmentResponse updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest) {
        var newEnrollment = enrollmentRepository.findById(id).orElse(new Enrollment());
        enrollmentMapper.mapUpdateRequestToEntity(newEnrollment, enrollmentRequest);
        enrollmentRepository.save(newEnrollment);
        return enrollmentMapper.toDTO(newEnrollment);
    }

    @Override
    public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) {
        var enrollmentEntity = enrollmentMapper.fromDTO(enrollmentRequest);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);
        return enrollmentMapper.toDTO(enrollmentEntity);
    }

    @Override
    public void deleteEnrollment(Integer id) {
        enrollmentRepository.deleteById(id);
    }
}

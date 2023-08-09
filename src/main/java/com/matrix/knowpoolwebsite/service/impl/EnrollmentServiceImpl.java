package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.EnrollmentRequest;
import com.matrix.knowpoolwebsite.dto.response.EnrollmentResponseDto;
import com.matrix.knowpoolwebsite.entity.Enrollment;
import com.matrix.knowpoolwebsite.mapper.EnrollmentMapper;
import com.matrix.knowpoolwebsite.repository.EnrollmentRepository;
import com.matrix.knowpoolwebsite.service.EnrollmentService;
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
    public List<EnrollmentResponseDto> getAllEnrollments() {
        var enrollmentEntity = enrollmentRepository.findAll();
        return enrollmentMapper.toDTOs(enrollmentEntity);
    }
    @Override
    public EnrollmentResponseDto updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest) {
        var newEnrollment = enrollmentRepository.findById(id).orElse(new Enrollment());
        enrollmentMapper.mapUpdateRequestToEntity(newEnrollment, enrollmentRequest);
        enrollmentRepository.save(newEnrollment);
        return enrollmentMapper.toDTO(newEnrollment);
    }

    @Override
    public EnrollmentResponseDto createEnrollment(EnrollmentRequest enrollmentRequest) {
        var enrollmentEntity = enrollmentMapper.fromDTO(enrollmentRequest);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);
        return enrollmentMapper.toDTO(enrollmentEntity);
    }

    @Override
    public void deleteEnrollment(Integer id) {
        enrollmentRepository.deleteById(id);
    }
}

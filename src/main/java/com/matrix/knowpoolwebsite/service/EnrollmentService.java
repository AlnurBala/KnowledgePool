package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.EnrollmentRequest;
import com.matrix.knowpoolwebsite.dto.response.EnrollmentResponseDto;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponseDto> getAllEnrollments();

    EnrollmentResponseDto createEnrollment(EnrollmentRequest enrollmentRequest);
    EnrollmentResponseDto updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest);

    void deleteEnrollment(Integer id);
}

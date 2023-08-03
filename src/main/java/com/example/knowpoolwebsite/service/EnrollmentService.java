package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.EnrollmentRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.EnrollmentResponse;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponse> getAllEnrollments();

    EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest);
    EnrollmentResponse updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest);

    void deleteEnrollment(Integer id);
}

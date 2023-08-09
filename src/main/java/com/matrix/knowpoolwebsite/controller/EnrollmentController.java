package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.EnrollmentRequest;
import com.matrix.knowpoolwebsite.dto.response.EnrollmentResponseDto;
import com.matrix.knowpoolwebsite.service.EnrollmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "Enrollment",description = "Enrollment Management APIs")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResponseDto> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping
    public EnrollmentResponseDto createEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        return enrollmentService.createEnrollment(enrollmentRequest);
    }
    @PutMapping("/{id}")
    public EnrollmentResponseDto updateEnrollment(@PathVariable Integer id, @RequestBody EnrollmentRequest enrollmentRequest) {
        return enrollmentService.updateEnrollment(id, enrollmentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnrollmentById(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}

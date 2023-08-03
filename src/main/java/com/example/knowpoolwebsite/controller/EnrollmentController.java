package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.EnrollmentRequest;
import com.example.knowpoolwebsite.dto.Response.EnrollmentResponse;
import com.example.knowpoolwebsite.service.EnrollmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
@Tag(name = "Enrollment",description = "Enrollment Management APIs")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping
    public EnrollmentResponse createEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        return enrollmentService.createEnrollment(enrollmentRequest);
    }
    @PutMapping("/{id}")
    public EnrollmentResponse updateEnrollment(@PathVariable Integer id, @RequestBody EnrollmentRequest enrollmentRequest) {
        return enrollmentService.updateEnrollment(id, enrollmentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnrollmentById(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}

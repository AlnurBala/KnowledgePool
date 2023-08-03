package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.InstructorRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.InstructorResponse;

import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getAllInstructors();

    InstructorResponse createInstructor(InstructorRequest instructorRequest);
    InstructorResponse updateInstructor(Integer id, InstructorRequest instructorRequest);

    void deleteInstructor(Integer id);
}

package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.InstructorRequest;
import com.matrix.knowpoolwebsite.dto.response.InstructorResponseDto;

import java.util.List;

public interface InstructorService {
    List<InstructorResponseDto> getAllInstructors();

    InstructorResponseDto createInstructor(InstructorRequest instructorRequest);

    InstructorResponseDto updateInstructor(Integer id, InstructorRequest instructorRequest);

    void deleteInstructor(Integer id);
}

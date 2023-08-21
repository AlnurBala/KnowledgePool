package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.InstructorRequest;
import com.matrix.knowpoolwebsite.dto.response.InstructorResponseDto;
import com.matrix.knowpoolwebsite.service.InstructorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "Instructor", description = "Instructor Management APIs")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponseDto> getAllInstructors() {

        return instructorService.getAllInstructors();
    }

    @PostMapping
    public InstructorResponseDto createInstructor(@RequestBody @Valid InstructorRequest instructorRequest) {
        return instructorService.createInstructor(instructorRequest);
    }

    @PutMapping("/{id}")
    public InstructorResponseDto updateInstructor(@PathVariable Integer id, @RequestBody InstructorRequest instructorRequest) {
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstructorById(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
    }
}

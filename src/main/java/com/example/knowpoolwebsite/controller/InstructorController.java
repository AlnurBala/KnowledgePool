package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.InstructorRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.InstructorResponse;
import com.example.knowpoolwebsite.service.InstructorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
@Tag(name = "Instructor",description = "Instructor Management APIs")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponse> getAllInstructors() {

        return instructorService.getAllInstructors();
    }

    @PostMapping
    public InstructorResponse createInstructor(@RequestBody InstructorRequest instructorRequest) {
        return instructorService.createInstructor(instructorRequest);
    }
    @PutMapping("/{id}")
    public InstructorResponse updateInstructor(@PathVariable Integer id,@RequestBody InstructorRequest instructorRequest){
        return instructorService.updateInstructor(id,instructorRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstructorById(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
    }
}

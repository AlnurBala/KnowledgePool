package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.InstructorRequest;
import com.example.knowpoolwebsite.dto.Response.InstructorResponse;
import com.example.knowpoolwebsite.entity.Instructor;
import com.example.knowpoolwebsite.mapper.InstructorMapper;
import com.example.knowpoolwebsite.repository.InstructorRepository;
import com.example.knowpoolwebsite.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Override
    public List<InstructorResponse> getAllInstructors() {
        var instructorEntity = instructorRepository.findAll();
        return instructorMapper.toDTOs(instructorEntity);
    }

    @Override
    public InstructorResponse createInstructor(InstructorRequest instructorRequest) {
        var instructorEntity = instructorMapper.fromDTO(instructorRequest);
        instructorEntity = instructorRepository.save(instructorEntity);
        return instructorMapper.toDTO(instructorEntity);
    }
    @Override
    public InstructorResponse updateInstructor(Integer id, InstructorRequest instructorRequest) {
        var newInstructor = instructorRepository.findById(id).orElse(new Instructor());
        instructorMapper.mapUpdateRequestToEntity(newInstructor, instructorRequest);
        instructorRepository.save(newInstructor);
        return instructorMapper.toDTO(newInstructor);
    }


    @Override
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteById(id);
    }
}

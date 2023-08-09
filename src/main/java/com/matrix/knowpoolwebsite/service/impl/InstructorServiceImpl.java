package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.InstructorRequest;
import com.matrix.knowpoolwebsite.dto.response.InstructorResponseDto;
import com.matrix.knowpoolwebsite.entity.Instructor;
import com.matrix.knowpoolwebsite.mapper.InstructorMapper;
import com.matrix.knowpoolwebsite.repository.InstructorRepository;
import com.matrix.knowpoolwebsite.service.InstructorService;
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
    public List<InstructorResponseDto> getAllInstructors() {
        var instructorEntity = instructorRepository.findAll();
        return instructorMapper.toDTOs(instructorEntity);
    }

    @Override
    public InstructorResponseDto createInstructor(InstructorRequest instructorRequest) {
        var instructorEntity = instructorMapper.fromDTO(instructorRequest);
        instructorEntity = instructorRepository.save(instructorEntity);
        return instructorMapper.toDTO(instructorEntity);
    }
    @Override
    public InstructorResponseDto updateInstructor(Integer id, InstructorRequest instructorRequest) {
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

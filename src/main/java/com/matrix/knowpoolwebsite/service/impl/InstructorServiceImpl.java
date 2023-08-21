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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Override
    public List<InstructorResponseDto> getAllInstructors() {
        log.info("Getting all instructors");
        var instructorEntity = instructorRepository.findAll();
        return instructorMapper.toDTOs(instructorEntity);
    }

    @Override
    public InstructorResponseDto createInstructor(InstructorRequest instructorRequest) {
        log.info("Creating new instructor: {}", instructorRequest);
        var instructorEntity = instructorMapper.fromDTO(instructorRequest);
        instructorEntity = instructorRepository.save(instructorEntity);
        return instructorMapper.toDTO(instructorEntity);
    }

    @Override
    public InstructorResponseDto updateInstructor(Integer id, InstructorRequest instructorRequest) {
        log.info("Updating instructor with ID {}: {}", id, instructorRequest);
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);
        if (!instructorOptional.isPresent()) {
            log.error("Instructor with ID {} not found for update", id);
            return null;
        }
        Instructor newInstructor = instructorOptional.get();
        instructorMapper.mapUpdateRequestToEntity(newInstructor, instructorRequest);
        newInstructor = instructorRepository.save(newInstructor);
        return instructorMapper.toDTO(newInstructor);
    }

    @Override
    public void deleteInstructor(Integer id) {
        log.info("Deleting instructor with ID {}", id);
        instructorRepository.deleteById(id);
    }
}

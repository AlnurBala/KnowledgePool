package com.example.knowpoolwebsite.dto.Response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorResponse {
    private Integer instructorId;
    private String name;
    private String bio;
    private List<CourseResponse> courses;
}

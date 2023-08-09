package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorResponseDto {
    private Integer instructorId;
    private String name;
    private String bio;
    private List<CourseResponse> courses;
}

package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import com.matrix.knowpoolwebsite.dto.UserResponse;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponseDto {
    private Integer enrollmentId;
    private Date enrollmentDate;
    private Integer progress;
    private CourseResponse course;
    private UserResponse user;
}

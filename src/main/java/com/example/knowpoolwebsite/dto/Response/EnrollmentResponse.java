package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseeResponse;
import com.example.knowpoolwebsite.dto.UserrResponse;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponse {
    private Integer enrollmentId;
    private Date enrollmentDate;
    private Integer progress;
    private CourseeResponse course;
    private UserrResponse user;

}

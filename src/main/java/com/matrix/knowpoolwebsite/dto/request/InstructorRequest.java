package com.matrix.knowpoolwebsite.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorRequest {
    private Integer instructorId;
    private String name;
    private String bio;
}

package com.example.knowpoolwebsite.dto.Request;

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

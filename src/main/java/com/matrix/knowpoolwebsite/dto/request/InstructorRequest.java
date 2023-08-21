package com.matrix.knowpoolwebsite.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorRequest {
    private Integer instructorId;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Bio is required")
    private String bio;
}


package com.matrix.knowpoolwebsite.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {
    private Integer categoryId;
    @NotBlank(message = "Name is required")
    private String name;
}

package com.example.knowpoolwebsite.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {
    private Integer categoryId;
    private String name;
}

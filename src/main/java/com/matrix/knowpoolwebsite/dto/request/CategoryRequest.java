package com.matrix.knowpoolwebsite.dto.request;

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

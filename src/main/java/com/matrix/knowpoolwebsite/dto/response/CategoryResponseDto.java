package com.matrix.knowpoolwebsite.dto.response;

import com.matrix.knowpoolwebsite.dto.CourseResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {
    private Integer categoryId;
    private String name;
    private List<CourseResponse> courses;
}

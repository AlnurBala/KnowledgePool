package com.example.knowpoolwebsite.dto.Response;

import com.example.knowpoolwebsite.dto.CourseeResponse;
import com.example.knowpoolwebsite.dto.EnrollmenttResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Integer categoryId;
    private String name;
    private List<CourseeResponse> courses;
}

package com.example.knowpoolwebsite.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseeResponse {
    private Integer courseId;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private String status;
}

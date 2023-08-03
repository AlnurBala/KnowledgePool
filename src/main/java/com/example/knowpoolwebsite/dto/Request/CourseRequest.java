package com.example.knowpoolwebsite.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {
    private Integer courseId;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private String status;
}

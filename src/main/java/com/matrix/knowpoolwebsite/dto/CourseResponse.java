package com.matrix.knowpoolwebsite.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Integer courseId;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private String status;
    private Date uploadDate;
}

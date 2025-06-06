package com.matrix.knowpoolwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id")
    private Integer enrollmentId;
    @Column(name = "enrollment_date")
    private Date enrollmentDate;
    @Column(name = "progress")
    private Integer progress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}

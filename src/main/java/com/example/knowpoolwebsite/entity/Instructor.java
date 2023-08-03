package com.example.knowpoolwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "instructors", schema = "project")
public class Instructor {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "instructor")
    List<Course> courses;
    @Id
    @Column(name = "instructor_id")
    private Integer instructorId;
    @Column(name = "name")
    private String name;
    @Column(name = "bio")
    private String bio;


}

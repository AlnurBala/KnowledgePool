package com.example.knowpoolwebsite.schedule;

import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.service.CourseScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseSchedule {
    private final CourseScheduleService courseScheduleService;
    @SchedulerLock(name = "checkTime")
    @Scheduled(fixedDelay = 100000)
    public void checkCustomerStatus() {
        System.out.println("schedule start");
        var courses = courseScheduleService.getCourseByStatus();
        for (Course course:courses) {
            courseScheduleService.updateCourseStatus(course);
        }
        System.out.println("schedule END");
    }

}

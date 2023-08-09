package com.matrix.knowpoolwebsite.schedule;

import com.matrix.knowpoolwebsite.entity.Course;
import com.matrix.knowpoolwebsite.service.CourseScheduleService;
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
    public void checkCourseStatus() {
        System.out.println("schedule start");
        var courses = courseScheduleService.getCourseByStatus();
        for (Course course:courses) {
            courseScheduleService.updateCourseStatus(course);
        }
        System.out.println("schedule END");
    }

}

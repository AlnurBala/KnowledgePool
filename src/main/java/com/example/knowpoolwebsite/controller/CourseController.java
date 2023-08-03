package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Tag(name = "Course", description = "Course Management APIs")
@Slf4j
public class CourseController {
    private final CourseService courseService;

    /**
     * Retrieves all courses with pagination support.
     *
     * @param pageable The pagination information.
     * @return A page of CourseResponse containing course details.
     */
    @Operation(
            summary = "Retrieve a Course",
            description = "Get a Course object. The response is Course object with page parameters, title, description and published status.",
            tags = {"courses", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Course.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public Page<CourseResponse> getAllCourses(Pageable pageable) {
        return courseService.getAllCourses(pageable);
    }

    /**
     * Retrieves all courses with sorting applied based on the provided sortProperty.
     *
     * @param pageNumber   The page number.
     * @param pageSize     The page size.
     * @param sortProperty The property to sort the courses by.
     * @return A page of CourseResponse containing sorted course details.
     */
    @GetMapping("/sort/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<CourseResponse> getAllCoursesBySorting(@PathVariable Integer pageNumber,
                                                       @PathVariable Integer pageSize,
                                                       @PathVariable String sortProperty) {
        log.info("getAllCoursesBySorting called with pageNumber={}, pageSize={}, sortProperty={}",
                pageNumber, pageSize, sortProperty);
        return courseService.getAllCoursesBySorting(pageNumber, pageSize, sortProperty);
    }

    /**
     * Retrieves courses whose names start with the given prefix.
     *
     * @param prefix The prefix to match course names.
     * @return A list of CourseResponse containing matched course details.
     */
    @GetMapping("/criteria/{prefix}")
    public List<CourseResponse> getCoursesByNameStartingWith(@PathVariable String prefix) {
        return courseService.getCoursesByNameStartingWith(prefix);
    }

    /**
     * Retrieves filtered courses based on the provided duration range.
     *
     * @param minDuration The minimum duration of courses to include.
     * @param maxDuration The maximum duration of courses to include.
     * @param pageable    The pagination information.
     * @return A page of CourseResponse containing filtered course details.
     */
    @GetMapping("/duration")
    public Page<CourseResponse> getFilteredCoursesByDuration(
            @RequestParam(required = false) Integer minDuration,
            @RequestParam(required = false) Integer maxDuration,
            Pageable pageable
    ) {
        return courseService.getFilteredCoursesByDuration(minDuration, maxDuration, pageable);
    }

    /**
     * Creates a new course based on the provided CourseRequest.
     *
     * @param courseRequest The CourseRequest object containing course details.
     * @return A CourseResponse containing the details of the created course.
     */
    @PostMapping
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    /**
     * Updates an existing course based on the provided CourseRequest and ID.
     *
     * @param id           The ID of the course to be updated.
     * @param courseRequest The CourseRequest object containing updated course details.
     * @return A CourseResponse containing the updated course details.
     */
    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id The ID of the course to be deleted.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}


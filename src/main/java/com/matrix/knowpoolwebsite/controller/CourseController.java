package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.CourseRequest;
import com.matrix.knowpoolwebsite.dto.response.CourseResponseDto;
import com.matrix.knowpoolwebsite.entity.Course;
import com.matrix.knowpoolwebsite.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
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
    public Page<CourseResponseDto> getAllCourses(Pageable pageable) {
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
    public Page<CourseResponseDto> getAllCoursesBySorting(@PathVariable Integer pageNumber,
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
    public Page<CourseResponseDto> getCoursesByNameStartingWith(@PathVariable String prefix,
                                                                @RequestParam(defaultValue = "0") Integer pageNumber,
                                                                @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return courseService.getCoursesByNameStartingWith(prefix, pageable);
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
    public Page<CourseResponseDto> getFilteredCoursesByDuration(
            @RequestParam(required = false) Integer minDuration,
            @RequestParam(required = false) Integer maxDuration,
            Pageable pageable
    ) {
        return courseService.getFilteredCoursesByDuration(minDuration, maxDuration, pageable);
    }
    @GetMapping("/sort/date")
    public Page<CourseResponseDto> getAllCoursesByUploadDateSorting(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return courseService.getAllCoursesByUploadDateSorting(pageNumber, pageSize);
    }
    /**
     * Creates a new course based on the provided CourseRequest.
     *
     * @param courseRequest The CourseRequest object containing course details.
     * @return A CourseResponse containing the details of the created course.
     */
    @PostMapping
    public CourseResponseDto createCourse(@RequestBody CourseRequest courseRequest) {
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
    public CourseResponseDto updateCourse(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
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


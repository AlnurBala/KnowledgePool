package com.example.knowpoolwebsite.mapper;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.UserRequest;
import com.example.knowpoolwebsite.dto.Response.UserResponse;
import com.example.knowpoolwebsite.entity.Course;
import com.example.knowpoolwebsite.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface UserMapper {
    User fromDTO(UserRequest userRequest);

    UserResponse toDTO(User user);

    List<UserResponse> toDTOs(List<User> users);
    User mapUpdateRequestToEntity(@MappingTarget User user, UserRequest userRequest);
}

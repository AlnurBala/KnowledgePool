package com.matrix.knowpoolwebsite.mapper;

import com.matrix.knowpoolwebsite.dto.request.UserRequest;
import com.matrix.knowpoolwebsite.dto.response.UserResponseDto;
import com.matrix.knowpoolwebsite.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface UserMapper {
    User fromDTO(UserRequest userRequest);

    UserResponseDto toDTO(User user);

    List<UserResponseDto> toDTOs(List<User> users);

    User mapUpdateRequestToEntity(@MappingTarget User user, UserRequest userRequest);
}

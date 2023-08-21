package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.UserRequest;
import com.matrix.knowpoolwebsite.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto createUser(UserRequest userRequest);

    UserResponseDto updateUser(Integer id, UserRequest userRequest);

    void deleteUser(Integer id);
}

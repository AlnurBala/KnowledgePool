package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.UserRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(Integer id, UserRequest userRequest);

    void deleteUser(Integer id);
}

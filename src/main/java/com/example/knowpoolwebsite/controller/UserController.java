package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.UserRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.UserResponse;
import com.example.knowpoolwebsite.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User",description = "User Management APIs")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


}

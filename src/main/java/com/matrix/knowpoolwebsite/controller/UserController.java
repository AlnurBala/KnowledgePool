package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.UserRequest;
import com.matrix.knowpoolwebsite.dto.response.UserResponseDto;
import com.matrix.knowpoolwebsite.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "User",description = "User Management APIs")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


}

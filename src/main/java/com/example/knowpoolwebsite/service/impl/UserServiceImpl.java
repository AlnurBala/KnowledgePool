package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.UserRequest;
import com.example.knowpoolwebsite.dto.Response.UserResponse;
import com.example.knowpoolwebsite.entity.User;
import com.example.knowpoolwebsite.mapper.UserMapper;
import com.example.knowpoolwebsite.repository.UserRepository;
import com.example.knowpoolwebsite.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        var userEntity = userRepository.findAll();
        return userMapper.toDTOs(userEntity);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        var userEntity = userMapper.fromDTO(userRequest);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest userRequest) {
        var newUser=userRepository.findById(id).orElse(new User());
        userMapper.mapUpdateRequestToEntity(newUser,userRequest);
        userRepository.save(newUser);
        return userMapper.toDTO(newUser);
    }

    @Override
    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }
}

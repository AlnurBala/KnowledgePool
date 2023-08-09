package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.UserRequest;
import com.matrix.knowpoolwebsite.dto.response.UserResponseDto;
import com.matrix.knowpoolwebsite.entity.User;
import com.matrix.knowpoolwebsite.mapper.UserMapper;
import com.matrix.knowpoolwebsite.repository.UserRepository;
import com.matrix.knowpoolwebsite.service.UserService;
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
    public List<UserResponseDto> getAllUsers() {
        var userEntity = userRepository.findAll();
        return userMapper.toDTOs(userEntity);
    }

    @Override
    public UserResponseDto createUser(UserRequest userRequest) {
        var userEntity = userMapper.fromDTO(userRequest);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserResponseDto updateUser(Integer id, UserRequest userRequest) {
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

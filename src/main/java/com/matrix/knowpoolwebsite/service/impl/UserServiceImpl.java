package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.UserRequest;
import com.matrix.knowpoolwebsite.dto.response.UserResponseDto;
import com.matrix.knowpoolwebsite.entity.User;
import com.matrix.knowpoolwebsite.enumeration.Role;
import com.matrix.knowpoolwebsite.mapper.UserMapper;
import com.matrix.knowpoolwebsite.repository.UserRepository;
import com.matrix.knowpoolwebsite.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        log.debug("Fetching all users");
        var userEntity = userRepository.findAll();
        return userMapper.toDTOs(userEntity);
    }

    @Override
    public UserResponseDto createUser(UserRequest userRequest) {
        log.info("Creating user: {}", userRequest);
        if (userRequest.getRole() == null) {
            userRequest.setRole("USER");
        }
        var userEntity = userMapper.fromDTO(userRequest);
        userEntity = userRepository.save(userEntity);
        log.info("User created: {}", userEntity);
        return userMapper.toDTO(userEntity);
    }

    @Override
    public UserResponseDto updateUser(Integer id, UserRequest userRequest) {
        log.debug("Updating user with ID {}: {}", id, userRequest);
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            log.error("User with ID {} not found for update", id);
            return null;
        }
        User newUser = userOptional.get();
        userMapper.mapUpdateRequestToEntity(newUser, userRequest);
        newUser = userRepository.save(newUser);
        log.info("User updated: {}", newUser);
        return userMapper.toDTO(newUser);
    }

    @Override
    public void deleteUser(Integer id) {
        log.warn("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
        log.info("User deleted with ID: {}", id);
    }
}

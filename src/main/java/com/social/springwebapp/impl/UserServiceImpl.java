package com.social.springwebapp.impl;

import com.social.springwebapp.entities.User;
import com.social.springwebapp.exceptions.EmailAlreadyUsedException;
import com.social.springwebapp.mapper.UserMapper;
import com.social.springwebapp.repository.UserRepository;
import com.social.springwebapp.services.UserService;
import com.social.springwebapp.services.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link User}.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        userRepository.findOneByEmail(userDTO.getEmail()).ifPresent(existingUser -> {
            throw new EmailAlreadyUsedException(userDTO.getEmail());
        });
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDTO> searchUser() {
        return null;
    }
}

package com.social.springwebapp.services.impl;

import com.social.springwebapp.zdao.entities.User;
import com.social.springwebapp.exceptions.EmailAlreadyUsedException;
import com.social.springwebapp.zdao.repository.UserRepository;
import com.social.springwebapp.services.UserService;
import com.social.springwebapp.services.dto.UserDTO;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User save(UserDTO userDTO) {
        userRepository.findOneByEmail(userDTO.getEmail()).ifPresent(existingUser -> {
            throw new EmailAlreadyUsedException(userDTO.getEmail());
        });
        log.debug("Request to save User : {}", userDTO);
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User update(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            return Optional.empty();
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @Override
    public List<UserDTO> searchUser() {
        return null;
    }
}

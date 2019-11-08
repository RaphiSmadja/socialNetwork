package com.social.springwebapp;

import com.social.springwebapp.services.dto.UserDTO;
import com.social.springwebapp.zdao.entities.User;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserMapper implements EntityMapper<UserDTO, User> {
    @Override
    public User toEntity(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO toDto(User entity) {
        return null;
    }

    @Override
    public Collection<User> toEntity(Collection<UserDTO> dtoList) {
        return null;
    }

    @Override
    public Collection<UserDTO> toDto(Collection<User> entityList) {
        return null;
    }
}

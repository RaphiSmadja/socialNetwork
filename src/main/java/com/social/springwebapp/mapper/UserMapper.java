package com.social.springwebapp.mapper;

import com.social.springwebapp.entities.User;
import com.social.springwebapp.services.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity {@link User} and its DTO {@link UserDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User>{
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}

package com.social.springwebapp.services.mapper;

import com.social.springwebapp.zdao.entities.User;
import com.social.springwebapp.services.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link User} and its DTO {@link UserDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User>{
}

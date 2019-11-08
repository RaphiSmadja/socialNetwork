package com.social.springwebapp.services;

import com.social.springwebapp.services.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Save a user.
     *
     * @param userDTO the entity to save.
     * @return the persisted entity.
     */
    UserDTO save(UserDTO userDTO);

    /**
     * Get all the users.
     *
     * @return the list of entities.
     */
    List<UserDTO> findAll();


    /**
     * Get the "id" user.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserDTO> findOne(Long id);

    /**
     * Delete the "id" user.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    /**
     * Get all the selected offers for actual account.
     *
     * @return the list of available entities.
     */
    List<UserDTO> searchUser();
}

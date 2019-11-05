package com.social.springwebapp.ressources;

import com.social.springwebapp.entities.User;
import com.social.springwebapp.exceptions.UserNotFoundException;
import com.social.springwebapp.repository.UserRepository;
import com.social.springwebapp.services.UserService;
import com.social.springwebapp.services.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRessource {

    private final UserRepository userRepository;

    private String applicationName;
    private final UserService userService;

    public UserRessource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable Long id) {
        Optional<User> student = userRepository.findById(id);

        if (student.isEmpty())
            throw new UserNotFoundException(""+id);

        return student.get();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userRequestDTO) throws URISyntaxException {
        return new ResponseEntity<>(userService.save(userRequestDTO), HttpStatus.CREATED);
    }
}

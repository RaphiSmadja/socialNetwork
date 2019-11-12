package com.social.springwebapp.ressources;

import com.social.springwebapp.zdao.entities.User;
import com.social.springwebapp.services.UserService;
import com.social.springwebapp.services.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRessource {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRessource(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getOneUser(@PathVariable(value = "id") Long id) {
        Optional<User> user = userService.findOne(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userRequestDTO) {
        return new ResponseEntity<>(userService.save(userRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDTO userRequestDTO) {
        Optional<User> userToUpdate = userService.findOne(id);
        if (userToUpdate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userToUpdate.get().setFirstname(userRequestDTO.getFirstname());
        userToUpdate.get().setLastname(userRequestDTO.getLastname());
        userToUpdate.get().setEmail(userRequestDTO.getEmail());
        userToUpdate.get().setPassword(userRequestDTO.getPassword());
        userToUpdate.get().setCity(userRequestDTO.getCity());
        userToUpdate.get().setPostalcode(userRequestDTO.getPostalcode());
        userToUpdate.get().setAddress(userRequestDTO.getAddress());
        UserDTO userDTO = modelMapper.map(userToUpdate.get(), UserDTO.class);
        return new ResponseEntity<>(userService.update(userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
        Optional<User> userToUpdate = userService.findOne(id);
        if (userToUpdate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

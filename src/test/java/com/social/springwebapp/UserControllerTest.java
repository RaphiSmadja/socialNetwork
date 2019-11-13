package com.social.springwebapp;

import com.social.springwebapp.services.dto.UserDTO;
import com.social.springwebapp.services.impl.UserServiceImpl;
import com.social.springwebapp.zdao.entities.User;
import com.social.springwebapp.zdao.repository.UserRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    UserDTO userDTO;
    User user;
    UserServiceImpl userService;

    @Before
    public void setup() {
        userDTO = new UserDTO();
        userDTO.setFirstname("Raphael");
        userDTO.setLastname("Smadja");
        userDTO.setEmail("raphael.smadja@soat.fr");
        userDTO.setPassword("azerty");
        userDTO.setCity("Paris");
        userDTO.setPostalcode(75012);
        userDTO.setAddress("12 avenue general breton");
        userDTO.setId(1L);

        user = new User();
        user.setFirstname("Raphael");
        user.setLastname("Smadja");
        user.setEmail("raphael.smadja@soat.fr");
        user.setPassword("azerty");
        user.setCity("Paris");
        user.setPostalcode(75012);
        user.setAddress("12 avenue general breton");
        user.setId(1L);

        userService = new UserServiceImpl(userRepository, modelMapper);
    }

    @Ignore
    @Test
    public void should_save_and_return_saved_object() throws Exception{
        //Given

        //When
        User actual = userService.save(userDTO);

        //Then
        verify(userRepository, times(1)).save(user);
        assertThat(actual).isNotNull();
        assertThat(actual.getAddress()).isEqualTo(user.getAddress());
    }
}

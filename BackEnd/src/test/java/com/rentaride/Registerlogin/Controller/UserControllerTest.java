package com.rentaride.Registerlogin.Controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rentaride.Registerlogin.Dto.User;
import com.rentaride.Registerlogin.Repo.UserRepository;
import com.rentaride.Registerlogin.execption.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userController.getAllUsers();

        assertEquals(2, result.size());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        when(userRepository.save(user)).thenReturn(user);

        User result = userController.createUser(user);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<User> responseEntity = userController.getUserById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

//    @Test
//    public void testUpdateUser() {
//        User user = new User();
//        user.setId(1L);
//        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//
//        User userDetails = new User();
//        userDetails.setFullname("John Doe");
//
//        ResponseEntity<User> responseEntity = userController.updateUser(1L, userDetails);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("John Doe", responseEntity.getBody().getFullname());
//    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<?> responseEntity = userController.deleteEmployee(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetUserById_WithInvalidId_ShouldThrowException() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            userController.getUserById(1L);
        });
    }

    @Test
    public void testUpdateUser_WithInvalidId_ShouldThrowException() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            userController.updateUser(1L, new User());
        });
    }

    @Test
    public void testDeleteUser_WithInvalidId_ShouldThrowException() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            userController.deleteEmployee(1L);
        });
    }
}

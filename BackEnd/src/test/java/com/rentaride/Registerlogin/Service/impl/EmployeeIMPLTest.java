package com.rentaride.Registerlogin.Service.impl;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rentaride.Registerlogin.Dto.EmployeeDTO;
import com.rentaride.Registerlogin.Dto.LoginDTO;
import com.rentaride.Registerlogin.Entity.Employee;
import com.rentaride.Registerlogin.Repo.EmployeeRepo;
import com.rentaride.Registerlogin.Response.LoginResponse;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeIMPLTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private EmployeeIMPL employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeid((int)1L);
        employeeDTO.setEmployeename("John Doe");
        employeeDTO.setEmail("john@example.com");
        employeeDTO.setPassword("password");

        Employee employee = new Employee(employeeDTO.getEmployeeid(), employeeDTO.getEmployeename(), employeeDTO.getEmail(), "encodedPassword");
        when(passwordEncoder.encode(employeeDTO.getPassword())).thenReturn("encodedPassword");
        when(employeeRepo.save(any(Employee.class))).thenReturn(employee);

        String result = employeeService.addEmployee(employeeDTO);

        assertEquals("John Doe", result);
        verify(employeeRepo, times(1)).save(any(Employee.class));
    }

    @Test
    public void testLoginEmployee_Success() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("john@example.com");
        loginDTO.setPassword("password");

        Employee employee = new Employee(1L, "John Doe", "john@example.com", "encodedPassword");
        when(employeeRepo.findByEmail("john@example.com")).thenReturn(employee);
        when(passwordEncoder.matches("password", "encodedPassword")).thenReturn(true);
        when(employeeRepo.findOneByEmailAndPassword("john@example.com", "encodedPassword")).thenReturn(Optional.of(employee));

        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

        assertTrue(loginResponse.isSuccess());
        assertEquals("Login Success", loginResponse.getMessage());
    }

    @Test
    public void testLoginEmployee_PasswordMismatch() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("john@example.com");
        loginDTO.setPassword("wrongPassword");

        Employee employee = new Employee(1L, "John Doe", "john@example.com", "encodedPassword");
        when(employeeRepo.findByEmail("john@example.com")).thenReturn(employee);
        when(passwordEncoder.matches("wrongPassword", "encodedPassword")).thenReturn(false);

        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

        assertFalse(loginResponse.isSuccess());
        assertEquals("password Not Match", loginResponse.getMessage());
    }

    @Test
    public void testLoginEmployee_EmailNotFound() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("nonexistent@example.com");
        loginDTO.setPassword("password");

        when(employeeRepo.findByEmail("nonexistent@example.com")).thenReturn(null);

        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

        assertFalse(loginResponse.isSuccess());
        assertEquals("Email not exits", loginResponse.getMessage());
    }
}

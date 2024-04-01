package com.rentaride.Registerlogin.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentaride.Registerlogin.Dto.User;
import com.rentaride.Registerlogin.Repo.UserRepository;
import com.rentaride.Registerlogin.execption.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
@Slf4j
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// get all user
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	// create employee rest api
	@PostMapping("/registerUser")
	public User createUser(@RequestBody User user) {
		// log.info("registering new request...");
		user.setBookingId(UUID.randomUUID().toString().substring(0,10));
		return userRepository.save(user);
		// log.info("registration successfull");
	}



	// get employee by id rest api
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(user);
	}

	// update employee rest api

	@PutMapping("/userWith/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		Optional<User> opUser = userRepository.findById(id);
		// log.info("updating Loan record...");
		if (!opUser.isPresent()) {
			throw new ResourceNotFoundException("user not exist with id :" + id);
		}
		User userObj = opUser.get();
		userObj.setId(userDetails.getId());
		userObj.setFullname(userDetails.getFullname());
		userObj.setPhonenumber(userDetails.getPhonenumber());
		userObj.setAddress(userDetails.getAddress());
		userObj.setDLnumber(userDetails.getDLnumber());
		userObj.setTotalDays(userDetails.getTotalDays());
		userObj.setCarType(userDetails.getCarType());
//		userObj.setBookingID(userDetails.getBookingID());
		
		if(userDetails.isStatus()) {
			userObj.approve();
		}
		else {
			userObj.reject();
		}

		User updatedUser = userRepository.save(userObj);
		// log.info("user updated successfully");
		return ResponseEntity.ok(updatedUser);
	}

	// delete employee rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}

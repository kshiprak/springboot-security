package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/CRUD")

public class EntryController {
	
	
	
	private  final IUserService userService;
	
	/*
	 * @Autowired public void setUserService(IUserService userService) {
	 * this.userService = userService; }
	 */

	@DeleteMapping ("/delete/{id}")
public void DeleteUser(@PathVariable int id) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
		
}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<?> GetAllUsers() {
		return new ResponseEntity<>(userService.GetAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/add-user")
public ResponseEntity<?> AddUser(@RequestBody Characteristics user) {
		userService.AddUser(user);
		return new ResponseEntity<String>("User added successfully", HttpStatus.CREATED);
}
	
	
}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class UserService implements IUserService {

	
	
	private IUser userRepository;

	@Autowired
	public void setUserRepository(IUser userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void DeleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<Characteristics> GetAllUsers() {
		 return userRepository.findAll();
		//return null;
	}

	@Override
	public Characteristics GetUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddUser(Characteristics user) {
		userRepository.save(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateUser(Characteristics user) {
		 userRepository.save(user);
		// TODO Auto-generated method stub
		
	}
	
	
	


	
}

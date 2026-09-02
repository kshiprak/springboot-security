package com.example.demo;

import java.util.List;

public interface IUserService {
	
	public void DeleteUser(int id);
	List<Characteristics> GetAllUsers();
	Characteristics GetUserById(int id);
	public void AddUser(Characteristics user);
	public void UpdateUser(Characteristics user);
	
	

}

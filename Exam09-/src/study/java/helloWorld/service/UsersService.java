package study.java.helloWorld.service;

import java.util.List;

import study.java.helloWorld.model.Users;

public interface UsersService {

	public Users join(Users params) throws NullPointerException, Exception;

	public Users login(Users params) throws NullPointerException, Exception;
	
	public Users getUserInfo(Users params) throws NullPointerException, Exception;
	
	public Users editUserInfo(Users params) throws NullPointerException, Exception;
	
	public List<Users> getUserList() throws NullPointerException, Exception;
	
	public void out(Users params) throws NullPointerException, Exception;



}

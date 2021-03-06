package service;

import java.util.List;
import entity.User;

public interface UserService {

	public List<User> getUserList();
	
	public int addUser(String email, String password, String fullname, String phone, String address, int role);
	
	public int delUserById(int id);
	
	public User findUserById(int id);
	
	public int updateUser(int id, String email, String password, String fullname, String phone, String address, int role);

	public int editAccount(int id, String email, String fullname, String phone, String address, String password);

	public List<User> getUserIsMember();
}

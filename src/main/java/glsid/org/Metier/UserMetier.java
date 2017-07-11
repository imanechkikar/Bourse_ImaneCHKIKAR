package glsid.org.Metier;

import java.util.List;

import glsid.org.Entities.User;;

public interface UserMetier {

    public User findById(long id);
	
    public User findByName(String name);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(long id);

	public List<User> findAllUsers(); 
	
	public void deleteAllUsers();
	
	public boolean isUserExist(User user);
}

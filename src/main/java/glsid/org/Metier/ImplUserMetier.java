package glsid.org.Metier;

import java.util.List;

import glsid.org.Entities.User;
import glsid.org.DAO.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplUserMetier implements UserMetier {
	
	
	@Autowired
	UserJpaRepository userJpaRepository ;

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userJpaRepository.findOne(id);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userJpaRepository.findByName(name);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userJpaRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userJpaRepository.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userJpaRepository.delete(id);	
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userJpaRepository.findAll();
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userJpaRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return userJpaRepository.exists(user.getId());
	}

	
}

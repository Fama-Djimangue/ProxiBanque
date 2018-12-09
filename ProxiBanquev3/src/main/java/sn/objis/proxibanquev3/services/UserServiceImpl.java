package sn.objis.proxibanquev3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.dao.UserRepository;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {		
		userRepository.save(user);		
	}

	@Override
	public Employe empConnecter(String username) {
	return userRepository.empConnecter(username);
	}


}

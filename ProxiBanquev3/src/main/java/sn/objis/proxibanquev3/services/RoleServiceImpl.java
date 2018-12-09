package sn.objis.proxibanquev3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.dao.RolesRepository;
import sn.objis.proxibanquev3.entities.Role;



@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RolesRepository roleRepository;
	
	@Override
	public void createRole(Role role) {		
		roleRepository.save(role);		
	}

}

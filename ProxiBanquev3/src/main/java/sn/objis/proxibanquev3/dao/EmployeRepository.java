package sn.objis.proxibanquev3.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	public Employe findByEmailEmployer(String email);
	
	public Employe findByuser(User user);
	
	


}

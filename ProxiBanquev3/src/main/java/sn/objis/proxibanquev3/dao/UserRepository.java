package sn.objis.proxibanquev3.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;



public interface UserRepository extends JpaRepository<User, String> {
    
	@Query("select e from Employe e where e.user.username=:x")
	public Employe empConnecter(@Param("x")String username);
}
package sn.objis.proxibanquev3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.dao.EmployeRepository;
import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;



@Service
@Transactional
public class EmployeServiceImpl implements IEmployeService{
	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	@Override
	public Employe createConseiller(Employe conseiller) {
		return employeRepository.save(conseiller);
	}

	@Override
	public List<Employe> findConseiller() {
		return employeRepository.findAll();
	}

	@Override
	public Employe findByEmail(String email) {
	return employeRepository.findByEmailEmployer(email);
	}

	@Override
	public Employe createGerent(Employe gerent) {
		return employeRepository.save(gerent);
		
	}

	@Override
	public Employe findEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return employeRepository.findOne(codeEmp);
	}

	@Override
	public Employe findByuser(User user) {		
		return employeRepository.findByuser(user);
	}

	@Override
	public Employe editeremp(Long id) {
		Employe employe = employeRepository.getOne(id);
		return employe;
	}

	@Override
	public Employe update(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 employeRepository.delete(id);
	}

	
	

}

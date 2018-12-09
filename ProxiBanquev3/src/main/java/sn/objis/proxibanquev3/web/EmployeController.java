package sn.objis.proxibanquev3.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.CompteCourant;
import sn.objis.proxibanquev3.entities.CompteEpargne;
import sn.objis.proxibanquev3.entities.Conseiller;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.Role;
import sn.objis.proxibanquev3.entities.User;
import sn.objis.proxibanquev3.services.IEmployeService;
import sn.objis.proxibanquev3.services.IRoleService;
import sn.objis.proxibanquev3.services.IUserService;

@Controller
@SessionAttributes({ "prenom", "nom", "roles", "idEmploye" })
public class EmployeController {

	@Autowired
	private IEmployeService employeService;

	@Autowired
	private IUserService userservice;

	@Autowired
	private IRoleService roleservice;

	@RequestMapping("/consulteremploye")
	public String consulter(HttpServletRequest request, Model model) {
		String confirme = request.getParameter("save");
		String mod = request.getParameter("modif");
		List<Employe> listeEmp = employeService.findConseiller();
		model.addAttribute("conf", confirme);
		model.addAttribute("mod", mod);
		model.addAttribute("liste", listeEmp);
		return "employes";
	}

	@RequestMapping(value = "/saveconseiller", method = RequestMethod.POST)
	public String save(Model model, String nomEmployer, String prenomEmployer, String emailEmployer, String telEmployer,
			String username, String password) {
		try {
			// Création Role
			// Création instance de role
			Role role = new Role("Conseiller", "Conseiller");
			List<Role> listerole = new ArrayList<>();
			listerole.add(role);
			roleservice.createRole(role);

			// Créarion User
			User user = new User(username, password, true);
			user.getRoles().add(role);
			userservice.createUser(user);

			// Création gérent : ici on fixe le gérent = 1
			Employe emp = new Employe(1L);
			// Création employe
			Employe employe = new Conseiller(nomEmployer, prenomEmployer, emailEmployer, telEmployer, user, emp);
			employeService.createConseiller(employe);
			List<Employe> listeEmp = employeService.findConseiller();
			model.addAttribute("liste", listeEmp);
		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "redirect:/consulteremploye?save=" + true;
	}

	@RequestMapping("/editeremp")
	public String editer(HttpServletRequest request, Model model, Long idemp, String optradio, String agence) {
		Employe employe = employeService.editeremp(idemp);
		Long idEmp = Long.parseLong(request.getParameter("idemp"));
		model.addAttribute("employe", employe);
		model.addAttribute("codeEmployer", idEmp);
		// Liste des clients de l'employer connecté
		List<Employe> listeemp = employeService.findConseiller();
		model.addAttribute("liste", listeemp);
		return "employes";
	}

	@RequestMapping(value = "/updateemploye", method = RequestMethod.POST)
	public String update(Model model, Long codeEmployer, String nomEmployer, String prenomEmployer,
			String emailEmployer, String telEmployer, String optradio, Long agence, String username, String password) {
		try {
			// Création Role
			// Création instance de role
			Role role = new Role("Conseiller", "Conseiller");
			List<Role> listerole = new ArrayList<>();
			listerole.add(role);
			roleservice.createRole(role);

			// Créarion User
			User user = new User(username, password, true);
			user.getRoles().add(role);
			userservice.createUser(user);

			// Création gérent : ici on fixe le gérent = 1
			Employe emp = new Employe(1L);
			// Création employe
			Employe employe1 = new Conseiller(codeEmployer, nomEmployer, prenomEmployer, emailEmployer, telEmployer,
					user, emp);
			employeService.update(employe1);

		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "redirect:/consulteremploye?modif=" + true;
	}

	@RequestMapping("/deleteemp")
	public String delete(HttpServletRequest request, Model model, Long idemp) {
		Long idEmp = Long.parseLong(request.getParameter("idemp"));
		employeService.delete(idEmp);
		// Liste des clients de l'employer connecté
		List<Employe> listeemp = employeService.findConseiller();
		model.addAttribute("liste", listeemp);
		return "employes";
	}

}
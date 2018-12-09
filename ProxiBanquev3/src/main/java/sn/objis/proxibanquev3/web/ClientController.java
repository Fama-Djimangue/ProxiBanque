package sn.objis.proxibanquev3.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.CompteCourant;
import sn.objis.proxibanquev3.entities.CompteEpargne;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.services.IClientService;
import sn.objis.proxibanquev3.services.ICompteService;
import sn.objis.proxibanquev3.services.IEmployeService;
import sn.objis.proxibanquev3.services.IUserService;

@Controller
@SessionAttributes({ "prenom", "nom", "roles", "idEmploye" })
public class ClientController {

	public Employe emp;

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	@Autowired
	private IClientService clientService;

	@Autowired
	private ICompteService compteService;

	@Autowired
	private IEmployeService employeService;

	@Autowired
	private IUserService userService;

	@RequestMapping("/clients")
	public String client() {
		return "clients";
	}

	@RequestMapping(value = "/saveclient", method = RequestMethod.POST)
	public String save(Model model, String nomClient, String professionClient, String adresseClient, String emailClient,
			String codeCompte, String typeCourant, String typeEpargne) {
		try {
			// Employe employe = employeService.findEmploye(1L);
			Client client1 = new Client(nomClient, professionClient, adresseClient, emailClient, emp);

			Compte cpt = new Compte();
			Compte cptCc = new CompteCourant(10000, 1000);
			Compte cptEp = new CompteEpargne(10000, 2.5);

			if (typeEpargne != null && typeCourant == null) {
				// testCreate = true;
				// Creation du client
				clientService.create(client1);

				// Creation du compte epargne du client
				compteService.addCompte(cptEp, client1, emp);

			} else if (typeEpargne == null && typeCourant != null) {
				// testCreate = true;
				// Creation du client
				clientService.create(client1);

				// Creation du compte courant du client
				compteService.addCompte(cptCc, client1, emp);
			}

			else if (typeEpargne != null && typeCourant != null) {

				// Creation du client
				clientService.create(client1);

				// Creation du compte epargne du client
				compteService.addCompte(cptEp, client1, emp);
				// Creation du compte courant du client
				compteService.addCompte(cptCc, client1, emp);
			}

		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "redirect:/consulterclient?save=" + true;
	}

	@RequestMapping("/consulterclient")
	public String consulter(HttpServletRequest request, Model model) {
		String confirme = request.getParameter("save");
		String mod = request.getParameter("modif");
		List<Client> listeclient = clientService.findByEmploye(emp);
		model.addAttribute("conf", confirme);
		model.addAttribute("mod", mod);
		model.addAttribute("liste", listeclient);
		return "clients";
	}

	@RequestMapping("/editer")
	public String editer(HttpServletRequest request, Model model, Long idclient, String nomClient,
			String professionClient, String adresseClient, String emailClient) {
		Client client = clientService.editer(idclient);
		Long idClient = Long.parseLong(request.getParameter("idclient"));
		model.addAttribute("client", client);
		model.addAttribute("codeClient", idClient);
		model.addAttribute("modif", false);
		// Liste des comptes du client
		List<Compte> listecpte = compteService.findByClient(client);

		int itemCount = listecpte.size();
		if (itemCount == 2) {
			model.addAttribute("deuxcpte", listecpte);
		}

		if (itemCount == 1) {
			model.addAttribute("cpteduclient", listecpte);

			// RECUP NUMERO COMPTE
			for (int i = 0; i < listecpte.size(); i++) {
				String numCompte = listecpte.get(i).getNumeroCompte();
				Compte cp = compteService.findByNumeroCompte(numCompte);
				if (cp.getClass().getSimpleName().equals("CompteCourant")) {
					model.addAttribute("cpteC", cp.getClass().getSimpleName());

				}
				if (cp.getClass().getSimpleName().equals("CompteEpargne")) {
					model.addAttribute("cpteE", cp.getClass().getSimpleName());
				}
			}

		}
		// Liste des clients de l'employer connecté
		List<Client> listeclient = clientService.findByEmploye(emp);
		model.addAttribute("liste", listeclient);
		return "clients";
	}

	@RequestMapping(value = "/updateclient", method = RequestMethod.POST)
	public String update(Model model, long codeClient, String nomClient, String emailClient, String adresseClient,
			String professionClient, String typeCourant, String typeEpargne) {

		try {
			Client client1 = new Client(codeClient, nomClient, professionClient, adresseClient, emailClient, emp);
			clientService.update(client1);

			Compte cpt = new Compte();
			Compte cptCc = new CompteCourant(10000, 1000);
			Compte cptEp = new CompteEpargne(10000, 2.5);

			if (typeEpargne != null) {
				compteService.addCompte(cptEp, client1, emp);
			}

			if (typeCourant != null) {
				compteService.addCompte(cptCc, client1, emp);
			}

		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "redirect:/consulterclient?modif=" + true;
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getLoggedUser(Model model, HttpServletRequest httpservletRequest) {
		HttpSession session = httpservletRequest.getSession();
		SecurityContext securitycontext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securitycontext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securitycontext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
			model.addAttribute("roles", ga.getAuthority());
		}
		model.addAttribute("userconnecte", username);
		emp = userService.empConnecter(username);

		model.addAttribute("idEmploye", emp.getCodeEmployer());
		model.addAttribute("prenom", emp.getPrenomEmployer());
		model.addAttribute("nom", emp.getNomEmployer());

		// Liste des clients de l'employer connecté
		List<Client> listeclient = clientService.findByEmploye(emp);
		model.addAttribute("liste", listeclient);
		return "clients";
	}
}

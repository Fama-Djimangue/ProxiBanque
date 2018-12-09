package sn.objis.proxibanquev3.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.services.IClientService;
import sn.objis.proxibanquev3.services.ICompteService;

import sn.objis.proxibanquev3.services.IOperationsService;


@Controller
@SessionAttributes({ "prenom", "nom", "roles", "idEmploye" })
public class CompteController {

	@Autowired
	private ICompteService compteService;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IOperationsService operationsService;

	@Autowired
	private ClientController client;

	@RequestMapping("/comptes")
	public String agence() {
		return "comptes";
	}

	@RequestMapping(value = "/listecompte")
	public String save(HttpServletRequest request, Model model) {
		long idclient = Long.parseLong(request.getParameter("idclient"));

		Client clientRecup = clientService.findClient(idclient);
		List<Compte> listecompte = compteService.findByClient(clientRecup);
		model.addAttribute("client", clientRecup);
		model.addAttribute("nomClient", clientRecup.getNomClient());
		model.addAttribute("liste", listecompte);
		try {

		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "comptes";
	}

	@RequestMapping("/infocompte")
	public String infoCompte(HttpServletRequest request, Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		String codeCompte = request.getParameter("codeCompte");
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = compteService.findByNumeroCompte(codeCompte);
	    	model.addAttribute("listeOperation", cp.getListeOperations());
			model.addAttribute("compte", cp);
						

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "infocompte";
	}

	
	@RequestMapping("/consultercompte")
	public String consulter(Model model, String codeCompte) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = compteService.findByNumeroCompte(codeCompte);
			if (cp == null) throw new RuntimeException("Ce compte n'existe pas !!!");
			model.addAttribute("listeOperation", cp.getListeOperations());
			model.addAttribute("compte", cp);		
			
		} catch (Exception e) {
			model.addAttribute("error", e);
		}
		return "consultercompte";
	}

	
}

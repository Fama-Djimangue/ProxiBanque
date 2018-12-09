package sn.objis.proxibanquev3.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.Operations;
import sn.objis.proxibanquev3.services.ICompteService;
import sn.objis.proxibanquev3.services.IEmployeService;
import sn.objis.proxibanquev3.services.IOperationsService;
import sn.objis.proxibanquev3.services.ThreadCompteDepot;
import sn.objis.proxibanquev3.services.ThreadCompteRetrait;
import sn.objis.proxibanquev3.services.ThreadCompteVirement;

@Controller
@SessionAttributes({ "prenom", "nom", "roles", "idEmploye" })
public class OperationController {

	@Autowired
	private ICompteService compteservice;

	@Autowired
	private IEmployeService employeService;

	@Autowired
	private ClientController client;

	@Autowired
	private IOperationsService operationsService;

	// @Autowired
	private ThreadCompteDepot tcd;
	// @Autowired
	private ThreadCompteRetrait tcr;

	// @Autowired
	private ThreadCompteVirement tcv;

	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}

	@RequestMapping(value = "/saveoperation", method = RequestMethod.POST)
	public String save(Model model, String codeCompte, String typeOperation, double montant, String codeCompte2) {
		Compte cpt2 = compteservice.findByNumeroCompte(codeCompte2);
		Compte cpt = compteservice.findByNumeroCompte(codeCompte);
		Operations operation = new Operations(typeOperation, montant);
		operation.setEmploye(client.emp);
		try {
			if (typeOperation.equals("Versement")) {
				operation.getListeComptes().add(cpt);
				cpt.getListeOperations().add(operation);
				operationsService.crediter(cpt, montant);
				operationsService.createOperation(operation);
				
			} else if (typeOperation.equals("Retrait")) {
				operation.getListeComptes().add(cpt);
				cpt.getListeOperations().add(operation);
				operationsService.debiter(cpt, montant);
				operationsService.createOperation(operation);
			}
			if (typeOperation.equals("Virement")) {
				operation.getListeComptes().add(cpt);
				operation.getListeComptes().add(cpt2);
				cpt.getListeOperations().add(operation);
				cpt2.getListeOperations().add(operation);
				operationsService.virementComptACompte(cpt, cpt2, montant);
				operationsService.createOperation(operation);

			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consultercompte?codeCompte=" + codeCompte + "&error=" + e.getMessage();
		}

		return "redirect:/consultercompte?codeCompte=" + codeCompte;
	}
}

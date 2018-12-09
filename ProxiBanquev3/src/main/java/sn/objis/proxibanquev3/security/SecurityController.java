package sn.objis.proxibanquev3.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping(value="/login")
	public String login() {		
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {		
		return "login";
	}
	
	@RequestMapping(value="/")
	public String home() {		
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/403")
	public String accesdined() {		
		return "403";
	}

}

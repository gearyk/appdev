package ie.cit.appdev.web;


import ie.cit.appdev.service.AccountService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AccountsController {
	
	private AccountService accService;
	
	@Autowired
	public AccountsController(AccountService accService) {
		//super();
		this.accService = accService;
	}

	
	@RequestMapping("all")
	public String getAllAccounts(Model model){
		model.addAttribute("allaccounts", accService.getAllAccounts());
		return "allaccounts";
		}
	
//	@RequestMapping(value="/",method=RequestMethod.POST)
//	public String createAccount(@RequestParam String firstname, @RequestParam String lastname){
//			accService.createNewAccount(firstname, lastname);
//			return "redirect:all";
//			}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String createAccount(@RequestParam String firstname, @RequestParam String lastname, 
			@RequestParam String username, @RequestParam String password  ){
			accService.createNewAccount(firstname, lastname, username, password);
			return "redirect:all";
			}

	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable String id){
		String uname=accService.getAccountUsername(id);
		accService.deleteAccount(id,uname);
		return "redirect:all";
	}
	
	

}

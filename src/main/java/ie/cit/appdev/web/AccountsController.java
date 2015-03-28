package ie.cit.appdev.web;



import java.util.HashMap;
import java.util.List;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.domain.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccountsController {
	
	@Autowired
	private AccountRespository accRepo;
	
	
	//returns the model and logical name of the view 
	@RequestMapping("all")
	public ModelAndView getAllAccounts(){
		List<Account> allAccounts=accRepo.getAllAccounts();
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("allaccounts", allAccounts);
		return new ModelAndView("allaccounts",model);
		
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String createAccount(@RequestParam String firstname, @RequestParam String lastname){
			Account acc=new Account();
			acc.setFirstname(firstname);
			acc.setLastname(lastname);
			accRepo.addAccount(acc);
			return "redirect:all";
			
		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable String id){
		accRepo.deleteAccount(id);
		return "redirect:all";
	}

}

package ie.cit.appdev.web;



import java.util.HashMap;
import java.util.List;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.domain.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccountsController {
	
	@Autowired
	private AccountRespository accRepo;
	
	
	//returns the model and logical name of the view 
	@RequestMapping("all")
	public ModelAndView getAllAccounts(){
		List<Account> allAccounts=accRepo.getAllAccounts();
		//this map represents the model
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("allaccounts", allAccounts);
		return new ModelAndView("allaccounts",model);
		
	}

}

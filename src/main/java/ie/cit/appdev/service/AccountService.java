package ie.cit.appdev.service;


import java.util.List;

import ie.cit.appdev.domain.Account;

public interface AccountService {
	
	List<Account> getAllAccounts();
	Account createNewAccount(String firstname, String Surname);
	void deleteAccount(String id);
		
	
}

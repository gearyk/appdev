package ie.cit.appdev.service;


import java.util.List;

import ie.cit.appdev.domain.Account;

public interface AccountService {
	
	List<Account> getAllAccounts();
	//Account createNewAccount(String firstname, String Surname);
	Account createNewAccount(String firstname, String Surname, String username, String password);
	void deleteAccount(String id);
	Account getByID(String id);
	
}

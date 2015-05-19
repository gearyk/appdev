package ie.cit.appdev.service;


import java.util.List;

import ie.cit.appdev.domain.Account;

public interface AccountService {
	
	List<Account> getAllAccounts();
	Account createNewAccount(String firstname, String Surname, String username, String password);
	void deleteAccount(String id, String username, String auth);
	Account getByID(String id);
	Account getByUsername(String username);
	void updateLeaderBoard(Account acc, String score);
	String getAccountPassword(String id);
	String getAccountUsername(String id);
	
}

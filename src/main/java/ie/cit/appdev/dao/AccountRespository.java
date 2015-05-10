package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;

import java.util.List;

public interface AccountRespository {
	
	void addAccount(Account newAccount);
	List<Account> getAllAccounts();
	void deleteAccount(String id);
	Account findById(String id);
	void updateLeaderBoard(Account Account, String score);
	Account findByUsername(String username);

}

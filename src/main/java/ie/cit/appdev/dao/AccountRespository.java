package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;

import java.util.List;

public interface AccountRespository {

	void addAccount(Account newAccount);
	List<Account> getAllAccounts();
	void deleteAccount(String id, String username);
	Account findById(String id);
	void updateLeaderBoard(Account Account, String score);
	Account findByUsername(String username);
	String getUsername(String id);
	String getPassword(String id);
	boolean isAdmin(String id);

}

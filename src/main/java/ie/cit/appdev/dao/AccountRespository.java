package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;

import java.util.List;

public interface AccountRespository {
	
	void addAccount(Account newAccount);
	List<Account> getAllAccounts();

}

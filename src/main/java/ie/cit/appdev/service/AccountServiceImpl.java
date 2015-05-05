package ie.cit.appdev.service;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.dao.AccountRespository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@Transactional
public class AccountServiceImpl implements AccountService{

	AccountRespository repo;

	@Autowired
	public AccountServiceImpl(AccountRespository repo) {
		super();
		this.repo = repo;
	}
	
	
	public Account createNewAccount(String firstname, String surname) {
		Account acc=new Account();
		acc.setFirstname(firstname);
		acc.setLastname(surname);
		repo.addAccount(acc);
		return acc;
	}


	public List<Account> getAllAccounts() {
		return repo.getAllAccounts();
	}


	public void deleteAccount(String id) {
		repo.deleteAccount(id);
		
	}

}

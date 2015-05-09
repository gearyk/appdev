package ie.cit.appdev.service;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.dao.AccountRespository;

//import org.mindrot.jbcrypt.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	
	
//	public Account createNewAccount(String firstname, String surname) {
//		Account acc=new Account();
//		acc.setFirstname(firstname);
//		acc.setLastname(surname);
//		repo.addAccount(acc);
//		return acc;
//	}

	public Account createNewAccount(String firstname, String surname, String username, String password) {
		Account acc=new Account();
		acc.setFirstname(firstname);
		acc.setLastname(surname);
		acc.setUsername(username);
		//hash the password
		String hashedPassword = passwordEncoder.encode(password);
		acc.setPassword(hashedPassword);
		repo.addAccount(acc);
		return acc;
	}

	public List<Account> getAllAccounts() {
		return repo.getAllAccounts();
	}


	public void deleteAccount(String id) {
		repo.deleteAccount(id);
		
	}


	public Account getByID(String id) {
		return repo.findById(id);
	}

}

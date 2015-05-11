package ie.cit.appdev.service;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.dao.AccountRespository;





import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


	public void deleteAccount(String id, String username) {
		//only admin users can perform a delete
		Account acc;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    acc=repo.findByUsername(name);
		if(repo.isAdmin(acc.getId()))
		{
		repo.deleteAccount(id,username);
		}
		
		
	}


	public Account getByID(String id) {
		return repo.findById(id);
	}

	public void updateLeaderBoard(Account acc, String score) {
		Account currentAcc=acc;
		String sessionScore=score;
		repo.updateLeaderBoard(currentAcc, sessionScore);
		
	}

	public Account getByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	public String getAccountPassword(String id){
		return repo.getPassword(id);
	}
	
	public String getAccountUsername(String id){
		return repo.getUsername(id);
	}
	
	public boolean isUserAdmin(String id){
		return repo.isAdmin(id);
	}

}

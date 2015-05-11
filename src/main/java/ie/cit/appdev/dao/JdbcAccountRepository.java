package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;







import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JdbcAccountRepository implements AccountRespository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAccountRepository(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	//This is a user account create - no admin access
	public void addAccount(Account newAccount) {
		jdbcTemplate.update("Insert into accounts(id,firstname,lastname) values (?,?,?)", 
				newAccount.getId(),newAccount.getFirstname(),newAccount.getLastname());
		jdbcTemplate.update("Insert into users(username,password,enabled,id) values (?,?,?,?)", 
				newAccount.getUsername(),newAccount.getPassword(),true,newAccount.getId());
		jdbcTemplate.update("insert into authorities(username,authority) values (?,?)", 
				newAccount.getUsername(),"ROLE_USER");
		
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return jdbcTemplate.query("select id, firstname, lastname from accounts", new AccountRowMapper());
	}

	public void deleteAccount(String id, String username) {
		jdbcTemplate.update("Delete from accounts where id=?",id);
		jdbcTemplate.update("Delete from authorities where username=?",username);
		jdbcTemplate.update("Delete from users where id=?",id);
		
	}
	
	@SuppressWarnings("unchecked")
	public Account findById(String id) {
		return jdbcTemplate.queryForObject(
				"select id, firstname, lastname from accounts where id=?",
				new AccountRowMapper(), id);
	}
	
	@SuppressWarnings("unchecked")
	public Account findByUsername(String username) {
		return jdbcTemplate.queryForObject
				("select id, firstname, lastname from accounts where id in "
						+ "( select id from users where username=?)",new AccountRowMapper(), username);
		
	}

	public void updateLeaderBoard(Account Account, String score) {
		jdbcTemplate.update("Insert into highscore(id,firstname,lastname,score) values (?,?,?,?)", 
				Account.getId(),Account.getFirstname(),Account.getLastname(),score);
		
	}
	
	
	public String getUsername(String id){
		return (String)jdbcTemplate.queryForObject("select username from users where id in ( select id from accounts where id=?)", new Object[]{id},String.class);
	
	}
	
	public String getPassword(String id){
		
		return (String)jdbcTemplate.queryForObject("select password from users where id in ( select id from accounts where id=?)", new Object[]{id},String.class);
	
	}

	

}



package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcAccountRepository implements AccountRespository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAccountRepository(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account newAccount) {
		jdbcTemplate.update("Insert into accounts(id,firstname,lastname) values (?,?,?)", 
				newAccount.getId(),newAccount.getFirstname(),newAccount.getLastname());
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return jdbcTemplate.query("select id, firstname, lastname from accounts", new AccountRowMapper());
	}

	public void deleteAccount(String id) {
		jdbcTemplate.update("Delete from accounts where id=?",id);
		
	}
	
	@SuppressWarnings("unchecked")
	public Account findById(String id) {
		return jdbcTemplate.queryForObject(
				"select id, firstname, lastname from accounts where id=?",
				new AccountRowMapper(), id);
	}

}



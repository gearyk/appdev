package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public List<Account> getAllAccounts() {
		return jdbcTemplate.query("select id, firstname, lastname from accounts", new AccountRowMapper());
	}

}


class AccountRowMapper implements RowMapper{

	public Account mapRow(ResultSet rs, int row) throws SQLException {
		
		String id=rs.getString("id");
		String firstname=rs.getString("firstname");
		String lastname=rs.getString("lastname");
		Account acc=new Account();
		acc.setId(id);
		acc.setFirstname(firstname);
		acc.setLastname(lastname);
		return acc;
	}
	
}
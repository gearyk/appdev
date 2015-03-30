package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
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

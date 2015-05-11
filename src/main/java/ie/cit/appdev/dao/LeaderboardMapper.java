package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Leaderboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LeaderboardMapper implements RowMapper<Leaderboard> {

public Leaderboard mapRow(ResultSet rs, int row) throws SQLException {
		
		String first=rs.getString("firstname");
		String last=rs.getString("lastname");
		String score=rs.getString("score");
		Leaderboard lb=new Leaderboard();
		lb.setFirstname(first);
		lb.setLastname(last);
		lb.setScore(score);
		return lb;
	}
	
	
}

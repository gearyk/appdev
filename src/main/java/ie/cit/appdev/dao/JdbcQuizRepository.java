package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Account;
import ie.cit.appdev.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcQuizRepository implements QuizRepository {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcQuizRepository(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	public List<Question> getQuestions() {
		return jdbcTemplate.query("select id, question, answer, wrong1, wrong2, wrong3 from quizquestions order by random() limit 5;", new QuizRowMapper());
		
	}


	public List<Question> getAnswer(String id) {
		
		return jdbcTemplate.query("select * from quizquestions where id=?",new QuizRowMapper(),id);
		
	}

}
class QuizRowMapper implements RowMapper{

	public Question mapRow(ResultSet rs, int row) throws SQLException {
		
		String id=rs.getString("id");
		String question=rs.getString("question");
		String answer=rs.getString("answer");
		String wrong1=rs.getString("wrong1");
		String wrong2=rs.getString("wrong2");
		String wrong3=rs.getString("wrong3");
		Question quizQ=new Question();
		quizQ.setId(id);
		quizQ.setQuestion(question);
		quizQ.setAnswer(answer);
		quizQ.setWrong1(wrong1);
		quizQ.setWrong2(wrong2);
		quizQ.setWrong3(wrong3);
		return quizQ;
	}
	

	
}
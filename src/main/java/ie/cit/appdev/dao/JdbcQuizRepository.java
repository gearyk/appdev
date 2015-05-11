package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Leaderboard;
import ie.cit.appdev.domain.Question;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcQuizRepository implements QuizRepository {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcQuizRepository(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Question> getRandomQuestions() {
		return jdbcTemplate.query("select id, question, answer, wrong1, wrong2, wrong3 from quizquestions order by random() limit 10;", new QuizRowMapper());
		
	}


	@SuppressWarnings("unchecked")
	public List<Question> getAnswer(String id) {
		
		return jdbcTemplate.query("select * from quizquestions where id=?",new QuizRowMapper(),id);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Leaderboard> getHighscores() {
		return jdbcTemplate.query("select firstname,lastname,score from highscore order by score::int DESC limit 10",new LeaderboardMapper());
		
	}
	
	

}

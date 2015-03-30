package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Question;




import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcSessionRepository implements SessionRepository{

	private JdbcTemplate jdbcTemplate;
	private Question question;

	@Autowired
	public JdbcSessionRepository(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	//This method sets the questions for the current quiz session by updating the quizsession repository 
	public void setQuiz(List<Question> questionsInSession) {
		jdbcTemplate.execute("delete from quizsession");
		Iterator<Question> it=questionsInSession.iterator();
		while(it.hasNext()){
			question=it.next();
			updateWithSessionQuestion(question);
		}

	}

	//This method Updates the Quizsession table with one question
	public void updateWithSessionQuestion(Question quizSessionQuestion) {
		jdbcTemplate.update("insert into quizsession(id,question,answer,wrong1,wrong2,wrong3,result)values(?,?,?,?,?,?,null)",
				quizSessionQuestion.getId(),quizSessionQuestion.getQuestion(),quizSessionQuestion.getAnswer(),quizSessionQuestion.getWrong1(),
				quizSessionQuestion.getWrong2(),quizSessionQuestion.getWrong3());

	}

	//This method Gets the questions from the quizsession table
	@SuppressWarnings("unchecked")
	public List<Question> getQuizQuestions() {
		return jdbcTemplate.query("select id, question, answer, wrong1, wrong2, wrong3 from quizsession order by id", new QuizRowMapper());

	}

	//This method Updates the Quizsession table row result with correct or incorrect. This is used to calculate the final score
	public void updateAnswerResult(String attempt, String correctAnswer, String id) {
		if (attempt.equals(correctAnswer)){
			jdbcTemplate.update("update quizsession set result ='correct' where id=?",id);
		}
		else{
			jdbcTemplate.update("update quizsession set result ='incorrect' where id=?",id);	
		}

	}

	//Count the correct answers
	public String getScore() {

		return Integer.toString(jdbcTemplate.queryForInt("select count (result) from quizsession where result = 'correct'"));
	}



}


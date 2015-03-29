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

	public void setQuiz(List<Question> questionsInSession) {
		System.out.println("inside");
		jdbcTemplate.execute("delete from quizsession");
		System.out.println("inside 1");
		Iterator<Question> it=questionsInSession.iterator();
		while(it.hasNext()){
			question=it.next();
			updateWithSessionQuestion(question);
		}

	}

	//Update the Quizsession table with one question
	public void updateWithSessionQuestion(Question quizSessionQuestion) {
		jdbcTemplate.update("insert into quizsession(id,question,answer,wrong1,wrong2,wrong3,result)values(?,?,?,?,?,?,null)",
				quizSessionQuestion.getId(),quizSessionQuestion.getQuestion(),quizSessionQuestion.getAnswer(),quizSessionQuestion.getWrong1(),
				quizSessionQuestion.getWrong2(),quizSessionQuestion.getWrong3());

	}

	//Get the questions from the quizsession table
	@SuppressWarnings("unchecked")
	public List<Question> getQuizQuestions() {
		return jdbcTemplate.query("select id, question, answer, wrong1, wrong2, wrong3 from quizsession order by id", new QuizRowMapper());

	}

	//Update the Quizsession table row result with correct or incorrect
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


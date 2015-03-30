package ie.cit.appdev.dao;

import ie.cit.appdev.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
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
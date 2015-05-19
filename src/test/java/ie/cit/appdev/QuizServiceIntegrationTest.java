package ie.cit.appdev;

import java.util.List;

import ie.cit.appdev.domain.Leaderboard;
import ie.cit.appdev.domain.Question;
import ie.cit.appdev.service.QuizService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class QuizServiceIntegrationTest {
	
	@Autowired
	QuizService qs;
	List<Question> getQuiz;
	List<Question> getRandom;
	List<Leaderboard> getLeaderboard;
	
	
	@Test @Transactional
	public void testGetQuestions(){
		getQuiz =qs.getQuizQuestions();
		Assert.assertTrue("Verify the list contains 10 questions", getQuiz.size()==10);
	}
	
	@Test @Transactional
	public void testSetQuiz(){
		getRandom =qs.setQuiz();
		Assert.assertTrue("Verify the random list contains 10 questions", getRandom.size()==10);
	}
	
	@Test @Transactional
	//This test assumes that we have some data in the leaderboard
	public void testGetHighscore(){
		getLeaderboard =qs.getHighscores();
		Assert.assertNotNull("A table is returned", getLeaderboard);
	}
	
	@Test @Transactional
	public void testGetScore(){
		String score =qs.getScore();
		Assert.assertNotNull(score);
	}
	
	@Test @Transactional
	public void testUpdateAnswerResult(){
		qs.updateAnswerResult("attempt", "answer", "ID123");
	}

}

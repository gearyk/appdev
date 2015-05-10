package ie.cit.appdev.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


import static org.mockito.Mockito.verify;
import ie.cit.appdev.domain.Account;
import ie.cit.appdev.service.AccountService;
import ie.cit.appdev.service.QuizService;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;


public class QuizControllerTest {


	private QuizController tested;

	private ExtendedModelMap model;
	private QuizService quizService;
	private AccountService accountService;
	private Account test;
	

	@Before
	public void setup(){
		quizService=mock(QuizService.class);
		accountService=mock(AccountService.class);
		tested=new QuizController(quizService,accountService);
	}

		
	@Test
	public void testGetQuestions() {
		model = new ExtendedModelMap();
		//mav=tested.getQuestions();
		String all=tested.getQuestions(model);
		//assertThat(mav.getModel(),notNullValue());
		assertThat(all,notNullValue());
		assertThat("questions", CoreMatchers.equalTo(all));
		verify(quizService).getQuizQuestions();
	}
	
	@Test
	public void testSetQuestions(){
		model = new ExtendedModelMap();
		String questions=tested.setQuestions(model);
		assertThat(questions,notNullValue());
		assertThat("questions", CoreMatchers.equalTo(questions));
		verify(quizService).setQuiz();
		
	}
	
	@Test
	public void testAnswer() {
	tested.answer("3", "attempt", "answer");
	verify(quizService).updateAnswerResult("attempt", "answer", "3");
	}
	
	@Test
	public void testGetScore() {
		model = new ExtendedModelMap();
		String score=tested.getScore("myUsername",model);
		test=accountService.getByUsername("myUsername");
		assertThat("score", CoreMatchers.equalTo(score));
		assertThat(score,notNullValue());
		//verify(accountService).getByUsername("myUsername");
		verify(accountService).updateLeaderBoard(test, quizService.getScore());
	}

}

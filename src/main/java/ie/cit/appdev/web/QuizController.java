package ie.cit.appdev.web;


import java.util.HashMap;
import java.util.List;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.dao.QuizRepository;
import ie.cit.appdev.dao.SessionRepository;
import ie.cit.appdev.domain.Question;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@Autowired
	private QuizRepository quizRepo;
	@Autowired
	private SessionRepository thisSession;
	
	@Autowired
	public QuizController(QuizRepository quizRepo, SessionRepository thisSession) {
		super();
		this.quizRepo = quizRepo;
		this.thisSession=thisSession;
	}


	@RequestMapping("quiz")
	public ModelAndView getQuestions(){
		List<Question> sessionQuestions=thisSession.getQuizQuestions();
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("questions", sessionQuestions);
		return new ModelAndView("questions",model);
	}

	@RequestMapping("setquiz")
	public ModelAndView setQuestions(){
		List<Question> quizQuestions=quizRepo.getRandomQuestions();
		thisSession.setQuiz(quizQuestions);
		List<Question> sessionQuestions=thisSession.getQuizQuestions();
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("questions", sessionQuestions);
		return new ModelAndView("questions",model);
		//return "redirect:/accounts/quiz";
	}

	@RequestMapping(value="/quiz/{myId}/{attemptAnswer}/{answer}", method=RequestMethod.GET)
	public String answer(@PathVariable String myId, @PathVariable String attemptAnswer,@PathVariable String answer){
		thisSession.updateAnswerResult(attemptAnswer,answer, myId);
		return "redirect:/accounts/quiz";
	}

	@RequestMapping("score")
	public ModelAndView getScore(){
		String result= thisSession.getScore();
		HashMap<String, String> model=new HashMap<String, String>();
		model.put("score", result);
		return new ModelAndView("score",model);
	}

}

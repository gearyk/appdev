package ie.cit.appdev.web;


import ie.cit.appdev.domain.Account;
import ie.cit.appdev.service.AccountService;
import ie.cit.appdev.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private AccountService accountService;
	
	
	@Autowired
	public QuizController(QuizService quizService, AccountService accountService) {
		this.quizService = quizService;
		this.accountService=accountService;
		
	}

	
	@RequestMapping("quiz")
	public String getQuestions(Model model){
		model.addAttribute("questions", quizService.getQuizQuestions());
		return "questions";
	}
	
	@RequestMapping("setquiz")
	public String setQuestions(Model model){
		model.addAttribute("questions", quizService.setQuiz());
		return "questions";
		//return "redirect:/accounts/quiz";
	}
	

	@RequestMapping(value="/quiz/{myId}/{attemptAnswer}/{answer}", method=RequestMethod.GET)
	public String answer(@PathVariable String myId, @PathVariable String attemptAnswer,@PathVariable String answer){
		quizService.updateAnswerResult(attemptAnswer,answer, myId);
		return "redirect:/accounts/quiz";
	}


	@RequestMapping(value="/quiz/{username}", method=RequestMethod.GET)
	public String getScore(@PathVariable String username, Model model){
		Account test=accountService.getByUsername(username);
		accountService.updateLeaderBoard(test, quizService.getScore());
		model.addAttribute("score", quizService.getScore());
		model.addAttribute("leaderboard",quizService.getHighscores());
		return "score";
	}
	
//	@RequestMapping(value="/quiz/{username}", method=RequestMethod.GET)
//	public String logout(@PathVariable String username, Model model){
//		return "/login?logout";
//		
//	}

}

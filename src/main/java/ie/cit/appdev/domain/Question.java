package ie.cit.appdev.domain;

public class Question {
	
	String id;
	String question;
	String answer;
	String wrong1;
	String wrong2;
	String wrong3;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getWrong1() {
		return wrong1;
	}
	public void setWrong1(String wrong1) {
		this.wrong1 = wrong1;
	}
	public String getWrong2() {
		return wrong2;
	}
	public void setWrong2(String wrong2) {
		this.wrong2 = wrong2;
	}
	public String getWrong3() {
		return wrong3;
	}
	public void setWrong3(String wrong3) {
		this.wrong3 = wrong3;
	}

}

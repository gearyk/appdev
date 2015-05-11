package ie.cit.appdev.domain;

public class Leaderboard {
	
	String firstname;
	String lastname;
	String score;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Leaderboard [firstname=" + firstname + ", lastname=" + lastname
				+ ", score=" + score + "]";
	}
	


}

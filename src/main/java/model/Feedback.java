package model;

public class Feedback {
	private int feedbackId;
	private String userName;
	private String email;
	private String subject;
	private String feedbackDescription;

	// Constructor
	
	public Feedback(String userName, String email, String subject, String feedbackDescription) {
		this.userName = userName;
		this.subject = subject;
		this.email = email;
		this.feedbackDescription = feedbackDescription;
	}

	
	public Feedback(int feedbackId, String userName, String email, String subject, String feedbackDescription) {
		super();
		this.feedbackId = feedbackId;
		this.userName = userName;
		this.email = email;
		this.subject = subject;
		this.feedbackDescription = feedbackDescription;
	}

	public Feedback() {
		super();
	}


	// Getters and setters
	public int getFeedbackId() {
		return feedbackId;
	}
	
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getUserName() {
		return userName;
	}

		public void setUserName(String user_Name) {
		this.userName = user_Name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}
}

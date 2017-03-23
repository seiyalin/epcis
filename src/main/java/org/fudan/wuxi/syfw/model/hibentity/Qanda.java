package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;

/**
 * Qanda entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Qanda implements java.io.Serializable {

	// Constructors

	/** default constructor */
	/*public Qanda() {
	}

	*//** minimal constructor *//*
	public Qanda(Complaint complaint, String answer, String question) {
		super(complaint, answer, question);
	}

	*//** full constructor *//*
	public Qanda(Complaint complaint, String answer, Timestamp answerTime,
			String question) {
		super(complaint, answer, answerTime, question);
	}*/

	// Fields

		private Integer questionId;
		private Complaint complaint;
		private String answer;
		private Timestamp answerTime;
		private String question;

		// Constructors

		/** default constructor */
		public Qanda() {
		}

		/** minimal constructor */
		public Qanda(Complaint complaint, String answer, String question) {
			this.complaint = complaint;
			this.answer = answer;
			this.question = question;
		}

		/** full constructor */
		public Qanda(Complaint complaint, String answer,
				Timestamp answerTime, String question) {
			this.complaint = complaint;
			this.answer = answer;
			this.answerTime = answerTime;
			this.question = question;
		}

		// Property accessors

		public Integer getQuestionId() {
			return this.questionId;
		}

		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}

		public Complaint getComplaint() {
			return this.complaint;
		}

		public void setComplaint(Complaint complaint) {
			this.complaint = complaint;
		}

		public String getAnswer() {
			return this.answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public Timestamp getAnswerTime() {
			return this.answerTime;
		}

		public void setAnswerTime(Timestamp answerTime) {
			this.answerTime = answerTime;
		}

		public String getQuestion() {
			return this.question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}
	
}

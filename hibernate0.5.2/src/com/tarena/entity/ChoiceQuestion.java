package com.tarena.entity;

public class ChoiceQuestion extends Question{

	private String options;
    
	private String answerOptions;

	public String getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(String answerOptions) {
		this.answerOptions = answerOptions;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
}

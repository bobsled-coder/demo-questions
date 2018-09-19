package com.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmbedQuestionViewAnswerDTO {

	private UUID viewUUID;
	private List<Long> answers = new ArrayList<>();
	
	public UUID getViewUUID() {
		return viewUUID;
	}
	public void setViewUUID(UUID viewUUID) {
		this.viewUUID = viewUUID;
	}
	public List<Long> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Long> answers) {
		this.answers = answers;
	}
	
	
}

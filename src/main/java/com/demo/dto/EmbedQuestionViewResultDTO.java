package com.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.demo.model.Question;
import com.demo.model.QuestionPrediction;

public class EmbedQuestionViewResultDTO {

	private UUID viewUUID;
	private List<Result> answer = new ArrayList<>();

	public UUID getViewUUID() {
		return viewUUID;
	}

	public void setViewUUID(UUID viewUUID) {
		this.viewUUID = viewUUID;
	}

	public List<Result> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Result> answer) {
		this.answer = answer;
	}

	public void setQuestion(Question question) {
		for (QuestionPrediction prediction : question.getPredictions()) {
			if (prediction.isAnswer()) {
				answer.add(new Result(prediction.getColumnName(), prediction.getRowName()));
			}
		}
	}

	private class Result {
		private String columnName;
		private String rowName;

		public Result(String columnName, String rowName) {
			this.columnName = columnName;
			this.rowName = rowName;
		}

		public String getColumnName() {
			return columnName;
		}


		public String getRowName() {
			return rowName;
		}

	}
}

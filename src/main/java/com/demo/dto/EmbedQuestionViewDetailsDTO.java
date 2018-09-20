package com.demo.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import com.demo.model.QuestionPrediction;
import com.demo.model.ViewQuestion;

public class EmbedQuestionViewDetailsDTO {

	private UUID viewUUID;
	private SortedSet<Header> headers = new TreeSet<>();
	private LinkedHashMap<String, Row> rows = new LinkedHashMap<>();
	private Integer maxResponses = 0;
	private Integer minResponses = 0;

	public UUID getViewUUID() {
		return viewUUID;
	}

	public SortedSet<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(SortedSet<Header> headers) {
		this.headers = headers;
	}

	public Collection<Row> getRows() {
		return rows.values();
	}

	public Integer getMaxResponses() {
		return maxResponses;
	}

	public Integer getMinResponses() {
		return minResponses;
	}

	public void setViewQuestion(ViewQuestion viewQuestion) {
		viewUUID = viewQuestion.getQuestionViewUUID();
		
		for (QuestionPrediction prediction : viewQuestion.getQuestion().getPredictions()) {
			if (prediction != null && prediction.getColumnName() != null) {
				headers.add(new Header(prediction.getColumnName(), prediction.getColumnOrder()));
			}

			if (rows.containsKey(prediction.getRowName())) {
				final Row row = rows.get(prediction.getRowName());
				row.addPrediction(prediction.getQuestionPredictionId());
			} else {
				Row row = new Row(prediction.getRowName(), prediction.getQuestionPredictionId());
				rows.put(prediction.getRowName(), row);
			}
		}
		this.maxResponses = viewQuestion.getQuestion().getMaxNumPredictions();
		this.minResponses = viewQuestion.getQuestion().getMinNumPredictions();
	}

	private class Header implements Comparable<Header>{
		private String name;
		private Long order;

		public Header(String name, Long order) {
			this.name = name;
			this.order = order;
		}

		public String getName() {
			return name;
		}

		public Long getOrder() {
			return order;
		}

		@Override
		public int compareTo(Header o) {
			if ( this.order == o.order ) {
				return 0;
			} else if ( this.order < o.order ) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	private class Row {
		
		private String label;
		private List<Long> predictions = new ArrayList<>();
		
		public Row(String rowName, Long questionPredictionId) {
			this.label = rowName;
			predictions.add(questionPredictionId);
		}

		public String getLabel() {
			return label;
		}

		public List<Long> getPredictions() {
			return predictions;
		}
		
		public void addPrediction( Long questionPredictionId ) {
			predictions.add(questionPredictionId);
		}
	}

}

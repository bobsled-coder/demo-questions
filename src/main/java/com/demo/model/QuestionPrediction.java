package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "question_predictions")
@EntityListeners(AuditingEntityListener.class)
public class QuestionPrediction  implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "questionPredictionGen", table = "sequenceGen", pkColumnName = "KeyGen", valueColumnName = "ValueGen", pkColumnValue = "questionPredictionId", initialValue = 1000000, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "questionPredictionGen")
	@Column(name = "question_prediction_id")
	private Long questionPredictionId;
	
	@Column(name = "question_id")
	private Long questionId;
	private String columnName;
	
	@NotBlank
	@Length(min = 0, max = 250)
	private String rowName;
	private Long columnOrder;
	private Long rowOrder;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isAnswer;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isDeleted;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getQuestionPredictionId() {
		return questionPredictionId;
	}

	public void setQuestionPredictionId(Long questionPredictionId) {
		this.questionPredictionId = questionPredictionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public Long getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(Long columnOrder) {
		this.columnOrder = columnOrder;
	}

	public Long getRowOrder() {
		return rowOrder;
	}

	public void setRowOrder(Long rowOrder) {
		this.rowOrder = rowOrder;
	}
	
	public boolean isAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	
	@JsonIgnore
	public boolean isDeleted() {
		return isDeleted;
	}
	@JsonIgnore
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getCreatedAt() {
		return createdAt;
	}
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
}

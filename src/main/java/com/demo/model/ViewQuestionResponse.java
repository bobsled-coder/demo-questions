package com.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "view_question_response")
@EntityListeners(AuditingEntityListener.class)
public class ViewQuestionResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "question_view_response_uuid")
	private UUID questionViewResponseUUID;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="question_view_uuid",referencedColumnName="question_view_uuid")
	private ViewQuestion questionView;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="question_prediction_id",referencedColumnName="question_prediction_id")
	private QuestionPrediction questionPrediction;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public ViewQuestion getQuestionView() {
		return questionView;
	}

	public void setQuestionView(ViewQuestion questionView) {
		this.questionView = questionView;
	}

	public QuestionPrediction getQuestionPrediction() {
		return questionPrediction;
	}

	public void setQuestionPrediction(QuestionPrediction questionPrediction) {
		this.questionPrediction = questionPrediction;
	}

	public UUID getQuestionViewResponseUUID() {
		return questionViewResponseUUID;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
}

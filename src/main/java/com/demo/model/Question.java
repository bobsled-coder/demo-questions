package com.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "Questions")
@NamedQuery(name = "Person.findUserQuestionsNotAnswered", 
			query = "SELECT q FROM Question q WHERE LOWER(p.lastName) = LOWER(?1)")
@EntityListeners(AuditingEntityListener.class)
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "questionGen", table = "sequenceGen", pkColumnName = "KeyGen", valueColumnName = "ValueGen", pkColumnValue = "questionId", initialValue = 1000000, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "questionGen")
	@Column(name = "question_id")
	private Long questionId;

	@NotBlank
	@Length(min = 0, max = 250)
	private String question;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isDeleted;

	@OneToMany(mappedBy = "questionId", cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@OrderBy("rowOrder ASC, columnOrder ASC")
	private List<QuestionPrediction> predictions = new ArrayList<>();

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getQuestionId() {
		return questionId;
	}

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getCreatedAt() {
		return createdAt;
	}

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@JsonIgnore
	public boolean isDeleted() {
		return isDeleted;
	}

	@JsonIgnore
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<QuestionPrediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<QuestionPrediction> predictions) {
		this.predictions = predictions;
	}

	
}

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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "view_question")
@EntityListeners(AuditingEntityListener.class)
public class ViewQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "question_view_uuid")
	private UUID questionViewUUID;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="question_id",referencedColumnName="question_id")
	private Question question;

	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="site_uuid",referencedColumnName="site_uuid")
	private Site site;

	@Column(nullable = false, name="embed_uuid")
	private UUID embedUUID;

	@Column(nullable = false, name="user_uuid")
	private UUID userUUID;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public UUID getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(UUID userUUID) {
		this.userUUID = userUUID;
	}

	public UUID getEmbedUUID() {
		return embedUUID;
	}

	public void setEmbedUUID(UUID embedUUID) {
		this.embedUUID = embedUUID;
	}


	public UUID getQuestionViewUUID() {
		return questionViewUUID;
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

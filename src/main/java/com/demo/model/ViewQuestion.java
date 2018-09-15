package com.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "view_question")
@EntityListeners(AuditingEntityListener.class)
public class ViewQuestion {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "question_view_uuid")
	
	private UUID questionViewUUID;

	@Column(name = "question_id")
	private Long questionId;

	@Column(nullable = false, name="site_uuid")
	//@ColumnTransformer(read = "uuid_from_bin(site_UUID)", write = "uuid_to_bin(?)")
	private UUID siteUUID;

	@Column(nullable = false, name="embed_uuid")
	//@ColumnTransformer(read = "uuid_from_bin(embed_UUID)", write = "uuid_to_bin(?)")
	private UUID embedUUID;

	@Column(nullable = false, name="user_uuid")
	//@ColumnTransformer(read = "uuid_from_bin(user_UUID)", write = "uuid_to_bin(?)")
	private UUID userUUID;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public UUID getSiteUUID() {
		return siteUUID;
	}

	public void setSiteUUID(UUID siteUUID) {
		this.siteUUID = siteUUID;
	}

	public UUID getEmbedUUID() {
		return embedUUID;
	}

	public void setEmbedUUID(UUID embedUUID) {
		this.embedUUID = embedUUID;
	}

	public UUID getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(UUID userUUID) {
		this.userUUID = userUUID;
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

package com.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Sites")
@EntityListeners(AuditingEntityListener.class)
public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "siteGen", table = "sequenceGen", pkColumnName = "KeyGen", valueColumnName = "ValueGen", pkColumnValue = "siteId", initialValue = 1000000, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "siteGen")
	@Column(name = "site_id")
	private Long siteId;
	
	@Column(nullable = false, name="site_uuid")
	//@ColumnTransformer(read = "uuid_from_bin(site_UUID)", write = "uuid_to_bin(?)")
	private UUID siteUUID;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public UUID getSiteUUID() {
		return siteUUID;
	}

	public void setSiteUUID(UUID siteUUID) {
		this.siteUUID = siteUUID;
	}

	public Long getSiteId() {
		return siteId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
}

package com.demo.dto;

import java.util.UUID;

public class EmbedQuestionViewRequestDTO {
	private UUID embedUUID;
	private UUID userUUID;
	private UUID siteUUID;
	
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
	public UUID getSiteUUID() {
		return siteUUID;
	}
	public void setSiteUUID(UUID siteUUID) {
		this.siteUUID = siteUUID;
	}
	
	
}

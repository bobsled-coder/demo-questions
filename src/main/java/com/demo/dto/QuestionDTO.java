package com.demo.dto;

public class QuestionDTO {
	private final long id;
    private final String content;

    public QuestionDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

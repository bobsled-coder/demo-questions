package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.ViewQuestionResponse;

public interface EmbedViewResultsRepository  extends JpaRepository<ViewQuestionResponse, Long> {

}

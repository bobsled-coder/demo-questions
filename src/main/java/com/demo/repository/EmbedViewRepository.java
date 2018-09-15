package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.ViewQuestion;

public interface EmbedViewRepository extends JpaRepository<ViewQuestion, Long> {

}

package com.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.ViewQuestion;

public interface EmbedViewRepository extends JpaRepository<ViewQuestion, Long> {

	@Query(value = "SELECT v.* FROM view_question v WHERE v.question_view_uuid = ?1", nativeQuery = true)
	ViewQuestion findByUUID(UUID questionId);

}

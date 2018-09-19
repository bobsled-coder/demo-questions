package com.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	
	@Query(value = "SELECT q.* FROM questions	q LEFT JOIN view_question v ON v.question_id = q.question_id AND v.site_uuid = ?1 AND v.user_uuid = ?2 WHERE v.question_view_UUID IS NULL", nativeQuery = true)
	public List<Question> findNextUserQuestion(UUID siteUUID, UUID userUUID);
	
	
	@Query(value = "SELECT q.* FROM questions q WHERE q.site_id = ?1", nativeQuery = true)
	public List<Question> findSiteQuestions(Long siteId);
	

}

package com.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	/**
	 * Finds person by using the last name as a search criteria.
	 * 
	 * @param lastName
	 * @return A list of persons whose last name is an exact match with the given
	 *         last name. If no persons is found, this method returns null.
	 */
	public List<Question> findUserQuestionsNotAnswered(UUID userUUID);

}

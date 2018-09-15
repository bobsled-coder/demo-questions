package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.QuestionDTO;
import com.demo.model.Question;
import com.demo.repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {
	 
	@Autowired
    QuestionRepository questionRepository;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Question createQuestion(@Valid @RequestBody Question incomingQuestion) {
		return questionRepository.save(incomingQuestion);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Question> updateQuestion(@Valid @RequestBody Question incomingQuestion) {
		
		ResponseEntity<Question> question = fetchQuestion(incomingQuestion.getQuestionId());
		if ( question.getStatusCode() != HttpStatus.NOT_FOUND) {
			return new ResponseEntity<Question>(questionRepository.save(incomingQuestion), HttpStatus.OK);
		}
		return question; 
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Question> deleteQuestion(@PathVariable(value = "id") Long questionId) {
		
		ResponseEntity<Question> question = fetchQuestion(questionId);
		if ( question.getStatusCode() != HttpStatus.NOT_FOUND) {
			Question toDelete = question.getBody();
			toDelete.setDeleted(true);
			return new ResponseEntity<Question>(questionRepository.save(toDelete), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long questionId) {
		return fetchQuestion(questionId);
	}
	
	private ResponseEntity<Question> fetchQuestion( Long questionId ) {
		final Question ret = questionRepository.findById(questionId).orElse(null);
		if ( ret==null||ret.isDeleted()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		} else {
			return new ResponseEntity<Question>(ret, HttpStatus.OK);
		}
	}
}

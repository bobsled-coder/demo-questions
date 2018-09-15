package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Question;
import com.demo.model.ViewQuestion;
import com.demo.model.ViewQuestionResults;
import com.demo.repository.EmbedViewRepository;
import com.demo.repository.QuestionRepository;

@RestController
@RequestMapping("/embedview")
public class EmbeddedViewController {
	
	@Autowired
	EmbedViewRepository embeddedViewRepository;
	
	@Autowired
    QuestionRepository questionRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ViewQuestion createView(@Valid @RequestBody ViewQuestion a) {
		
//		ViewQuestion a = new ViewQuestion();
//		a.setEmbedUUID(UUID.randomUUID());
//		a.setSiteUUID(UUID.randomUUID());
//		a.setUserUUID(UUID.randomUUID());
//		a.setQuestionId(1L);
		return embeddedViewRepository.save(a) ;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{viewId}/result/")
	@ResponseBody
	public ViewQuestionResults createViewResult(@Valid @RequestBody ViewQuestionResults incomingQuestion) {
		return null ;
	}
	
	@GetMapping("/{viewId}/result/summary")
	@ResponseBody
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long questionId) {
		return null ;
	}

}

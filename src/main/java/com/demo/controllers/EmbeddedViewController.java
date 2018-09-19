package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.EmbedQuestionViewAnswerDTO;
import com.demo.dto.EmbedQuestionViewDetailsDTO;
import com.demo.dto.EmbedQuestionViewRequestDTO;
import com.demo.dto.EmbedQuestionViewResultDTO;
import com.demo.model.Question;
import com.demo.model.QuestionPrediction;
import com.demo.model.Site;
import com.demo.model.ViewQuestion;
import com.demo.model.ViewQuestionResponse;
import com.demo.repository.EmbedViewRepository;
import com.demo.repository.EmbedViewResultsRepository;
import com.demo.repository.QuestionPredictionRepository;
import com.demo.repository.QuestionRepository;
import com.demo.repository.SiteRepository;

@RestController
@RequestMapping("/embedview")
public class EmbeddedViewController {

	@Autowired
	EmbedViewRepository embeddedViewRepository;
	
	@Autowired
	EmbedViewResultsRepository embeddedViewResultRepository;

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	QuestionPredictionRepository questionPredictionRepository;

	@Autowired
	SiteRepository siteRepository;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EmbedQuestionViewDetailsDTO> createView(
			@Valid @RequestBody EmbedQuestionViewRequestDTO requestedView) {
		// Lookup the Site, if the Site does not exist reject hte request.
		if ( requestedView.getSiteUUID() == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		Site foundSite = siteRepository.findByUuid(requestedView.getSiteUUID());
		if (foundSite == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// With Site and User lookup the Questions that are available.
		List<Question> questions = questionRepository.findNextUserQuestion(requestedView.getSiteUUID(),
				requestedView.getUserUUID());

		if (questions != null && questions.size() <= 0) {
			questions = questionRepository.findSiteQuestions(foundSite.getSiteId());
		}
		
		final Question selectedQuestion = randomQuestion(questions);
		

		// Assign a Question to this view
		final ViewQuestion newView = new ViewQuestion();
		newView.setEmbedUUID(requestedView.getEmbedUUID());
		newView.setUserUUID(requestedView.getUserUUID());
		newView.setSite(foundSite);
		newView.setQuestion(selectedQuestion);
		ViewQuestion question = embeddedViewRepository.save(newView);

		// Lets build a DTO that represents what we want to return (Minimize the amount
		// returned, and format for easy processing)
		// This allows us to hide away some of the complexity of the DB.
		EmbedQuestionViewDetailsDTO details = new EmbedQuestionViewDetailsDTO();
		details.setViewUUID(UUID.randomUUID());
		details.setViewQuestion(question);

		return new ResponseEntity<EmbedQuestionViewDetailsDTO>(details, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/{viewId}/result/")
	@ResponseBody
	public ResponseEntity<EmbedQuestionViewResultDTO> createViewResult(@Valid @RequestBody EmbedQuestionViewAnswerDTO answer, @PathVariable(value = "viewId") UUID questionId) {
		
		// Validate the view exists in the DB and retrieve the view.
		final ViewQuestion vQuestion = embeddedViewRepository.findByUUID(questionId);
		if ( vQuestion == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// validate number of responses fit in min and max of question
		if (!(answer.getAnswers().size() > vQuestion.getQuestion().getMinNumPredictions() && answer.getAnswers().size() < vQuestion.getQuestion().getMaxNumPredictions())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// validate responses are matched to the question.
		List<ViewQuestionResponse> newResponses = new ArrayList<>();
		for ( Long guess : answer.getAnswers()) {
			final Optional<QuestionPrediction> prediction = questionPredictionRepository.findById(guess);
			if ( !prediction.isPresent() ) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			
			final ViewQuestionResponse newResponse = new ViewQuestionResponse();
			newResponse.setQuestionPrediction(prediction.get());
			newResponse.setQuestionView(vQuestion);	
			
			newResponses.add(newResponse);
		}
		
		// Batch Save
		if (newResponses.size() > 0) {
			embeddedViewResultRepository.saveAll(newResponses);
		}
		
		// Send back the correct result 
		EmbedQuestionViewResultDTO result = new EmbedQuestionViewResultDTO();
		result.setViewUUID(questionId);
		result.setQuestion(vQuestion.getQuestion());
		
		return new ResponseEntity<EmbedQuestionViewResultDTO>(result, HttpStatus.OK);
	}

	private Question randomQuestion(List<Question> questions) {
		Random rand = new Random();
		int randIndex = rand.nextInt(questions.size());
		return questions.get(randIndex);
	}
}

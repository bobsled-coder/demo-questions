package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.repository.QuestionRepository;

@Component
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
    QuestionRepository questionRepository;
}

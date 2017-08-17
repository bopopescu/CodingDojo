package com.sushma.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.sushma.DojoOverflow.repositories.AnswerRepository;
import com.sushma.DojoOverflow.repositories.QuestionRepository;
import com.sushma.DojoOverflow.repositories.TagRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	
	public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
	}
}

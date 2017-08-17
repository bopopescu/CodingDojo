package com.sushma.DojoOverflow.services;

import com.sushma.DojoOverflow.repositories.AnswerRepository;
import com.sushma.DojoOverflow.repositories.QuestionRepository;
import com.sushma.DojoOverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	
	public TagService(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
	}

}

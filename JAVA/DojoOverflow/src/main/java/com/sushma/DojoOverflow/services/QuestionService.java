package com.sushma.DojoOverflow.services;

import com.sushma.DojoOverflow.models.QuestionsModel;
import com.sushma.DojoOverflow.models.Tags;
import com.sushma.DojoOverflow.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	
	public QuestionService(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
	}
	public void addQuestion(QuestionsModel question) {
		questionRepository.save(question);
		
	}
	public void addTagToQuestion(Long questionid, String tag) {
		// TODO Auto-generated method stub
		QuestionsModel question = questionRepository.findOne(questionid);
		
		if(tagRepository.findTagByName(tag) == null) {
			Tags gettag = new Tags(tag);
			tagRepository.save(gettag);
		}
		Tags thattag = tagRepository.findTagByName(tag);
		question.getTags().add(thattag);
		questionRepository.save(question);
		
	}

}

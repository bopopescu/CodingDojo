package com.sushma.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.DojoOverflow.models.QuestionsModel;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionsModel, Long>{

}

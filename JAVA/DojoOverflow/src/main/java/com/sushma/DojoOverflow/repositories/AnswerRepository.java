package com.sushma.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sushma.DojoOverflow.models.Answers;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answers, Long>{

}

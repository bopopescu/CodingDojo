package com.sushma.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;


import com.sushma.DojoOverflow.models.Tags;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tags, Long>{
	Tags findTagByName(String tag);
}

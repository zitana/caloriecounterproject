package com.greenfoxacademy.calorie.repository;

import com.greenfoxacademy.calorie.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long>{

}

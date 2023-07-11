package com.cricket.cricket.repository;

import org.springframework.data.repository.CrudRepository;
import com.cricket.cricket.model.Cricket;

public interface CricketRepository extends CrudRepository<Cricket, Long> {

}
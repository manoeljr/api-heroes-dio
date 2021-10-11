package com.digitalinnovationone.heroesapi.repository;

import com.digitalinnovationone.heroesapi.document.Heroes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends ReactiveMongoRepository<Heroes, String> {

}

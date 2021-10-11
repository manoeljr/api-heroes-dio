package com.digitalinnovationone.heroesapi.service;

import com.digitalinnovationone.heroesapi.document.Heroes;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;


public interface HeroesService {
    public Flux<Heroes> findAll();
    public Mono<Heroes> findByIdHero(String id);
    public Mono<Heroes> save(Heroes heroes);
    public Mono<Boolean> deleteByIdHero(String id);
}

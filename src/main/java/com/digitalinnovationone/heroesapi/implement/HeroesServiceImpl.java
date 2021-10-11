package com.digitalinnovationone.heroesapi.implement;

import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.repository.HeroesRepository;
import com.digitalinnovationone.heroesapi.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesServiceImpl implements HeroesService {

    @Autowired
    private HeroesRepository heroesRepository;

    @Override
    public Flux<Heroes> findAll() {
        return this.heroesRepository.findAll();
    }

    @Override
    public Mono<Heroes> findByIdHero(String id) {
        return this.heroesRepository.findById(id);
    }

    @Override
    public Mono<Heroes> save(Heroes heroes) {
        return this.heroesRepository.save(heroes);
    }

    @Override
    public Mono<Boolean> deleteByIdHero(String id) {
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }

}

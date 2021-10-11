package com.digitalinnovationone.heroesapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.repository.HeroesRepository;
import com.digitalinnovationone.heroesapi.service.HeroesService;

@Slf4j
@RestController
@RequestMapping("/heroes")
public class HeroesController {

    private HeroesService heroesService;
    private HeroesRepository heroesRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
        this.heroesService = heroesService;
    }

    @GetMapping
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes");
        return heroesService.findAll();
    }

    @GetMapping("/id")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new hero was created");
        return heroesService.save(heroes);
    }

    @DeleteMapping("/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public Mono<HttpStatus> deleteByIdHero(@PathVariable String id) {
        heroesService.deleteByIdHero(id);
        log.info("deleting a hero with id {}", id);
        return Mono.just(HttpStatus.CONTINUE);
    }

}
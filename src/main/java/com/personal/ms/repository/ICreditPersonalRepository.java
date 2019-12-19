package com.personal.ms.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.personal.ms.model.EntityCreditPersonal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICreditPersonalRepository extends ReactiveMongoRepository<EntityCreditPersonal,String> {

	Mono<EntityCreditPersonal> findByNumCredi(String numCredi);

	@Query("{'customer.dniH':?0}")
	Flux<EntityCreditPersonal> findByNumDoc(String numDoc);
}

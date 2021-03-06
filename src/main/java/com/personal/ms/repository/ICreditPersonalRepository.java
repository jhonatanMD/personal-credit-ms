package com.personal.ms.repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
	
	@Query("{'customer.dniH': {$in:[ ?0 ]} , 'status':?1}")
	Flux<EntityCreditPersonal> findByNumDocList(List<String> numDoc , String status);
	
	Flux<EntityCreditPersonal> findByBankAndDateOpenBetween(String bank,Date dt1 ,Date dt2) throws ParseException;
}

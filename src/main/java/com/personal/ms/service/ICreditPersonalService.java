package com.personal.ms.service;

import com.personal.ms.model.EntityCreditPersonal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditPersonalService {

	Flux<EntityCreditPersonal> allCreditPersonal();
	Mono<EntityCreditPersonal> saveCreditPersonal(final EntityCreditPersonal creditPersonal);
	Mono<EntityCreditPersonal> updCreditPersonal(final EntityCreditPersonal creditPersonal);
	Mono<Void> dltCreditPersonal(final String id);
	Mono<EntityCreditPersonal> CreditPersonalNumCredi(final String numCredi);
	Flux<EntityCreditPersonal> CreditPersonalNumDoc(final String numDoc);
	Mono<EntityCreditPersonal> transacationCreditPersonal(final String numCredi,String tipo,Double cash);
	
}

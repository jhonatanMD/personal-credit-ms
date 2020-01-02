package com.personal.ms.service;

import java.text.ParseException;
import java.util.List;

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
	Flux<EntityCreditPersonal> CreditPersonalNumDocList(List<String> numDoc,String status);
	Flux<EntityCreditPersonal> findByBankAndDateOpenBetween(String bank,String dt1 ,String dt2) throws ParseException;
}

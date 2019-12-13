package com.personal.ms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.ms.model.EntityCreditPersonal;
import com.personal.ms.repository.ICreditPersonalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreditPersonalServiceImpl  implements ICreditPersonalService{

	@Autowired
	ICreditPersonalRepository repository;
	@Override
	public Flux<EntityCreditPersonal> allCreditPersonal() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityCreditPersonal> saveCreditPersonal(EntityCreditPersonal creditPersonal) {
		// TODO Auto-generated method stub
		return repository.save(creditPersonal);
	}

	@Override
	public Mono<EntityCreditPersonal> updCreditPersonal(EntityCreditPersonal creditPersonal) {
		// TODO Auto-generated method stub
		return repository.save(creditPersonal);
	}

	@Override
	public Mono<Void> dltCreditPersonal(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<EntityCreditPersonal> CreditPersonalDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDniCli(dni);
	}

}

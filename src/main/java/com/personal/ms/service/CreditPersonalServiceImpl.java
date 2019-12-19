package com.personal.ms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.ms.model.EntityCreditPersonal;
import com.personal.ms.model.EntityTransaction;
import com.personal.ms.repository.ICreditPersonalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditPersonalServiceImpl  implements ICreditPersonalService{

	@Autowired
	ICreditPersonalRepository repository;
	EntityTransaction transaction;
	List<EntityTransaction> listTransaction;
	Date dt = new Date();
	
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
	public Mono<EntityCreditPersonal> CreditPersonalNumCredi(String numCredi) {
		// TODO Auto-generated method stub
		return repository.findByNumCredi(numCredi);
	}

	@Override
	public Mono<EntityCreditPersonal> transacationCreditPersonal(String numCredi, String tipo, Double cash) {
		
		return repository.findByNumCredi(numCredi)
				.flatMap(p ->{
					transaction = new EntityTransaction();
					transaction.setCashA(p.getCash());
					if(tipo.equals("c") && p.getCash() >= cash) {
						p.setCash(p.getCash() - cash);
					}else if (tipo.equals("p") && p.getCashPay() >= (p.getCash() + cash) ){
						p.setCash( p.getCash() + cash);
					}
					transaction.setType(tipo);
					 transaction.setCashO(cash);
					 transaction.setCashT(p.getCash());
					 transaction.setDateTra(dt);
					listTransaction = new ArrayList<>();
					p.getTransactions().forEach(transac-> {
						listTransaction.add(transac);
					});
					listTransaction.add(transaction);
					p.setTransactions(listTransaction);
			return repository.save(p);
			});

	}

	@Override
	public Flux<EntityCreditPersonal> CreditPersonalNumDoc(String numDoc) {
		// TODO Auto-generated method stub
		return repository.findByNumDoc(numDoc);
	}

}

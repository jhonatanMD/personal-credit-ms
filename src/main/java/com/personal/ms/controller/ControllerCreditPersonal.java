package com.personal.ms.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.ms.model.EntityCreditPersonal;
import com.personal.ms.service.ICreditPersonalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class ControllerCreditPersonal {
	
	@Autowired
	ICreditPersonalService imple;
	
	@GetMapping("/getCreditPersonal")
	Flux<EntityCreditPersonal> getCreditPersonal(){
		return imple.allCreditPersonal();
	}
	
	@GetMapping("/getCreditPersonalDates/{dt1}/{dt2}/{bank}")
	Flux<EntityCreditPersonal> getCreditPersonalDates(@PathVariable("dt1") String dt1
			,@PathVariable("dt2") String dt2,@PathVariable("bank") String bank) throws ParseException{	
		return imple.findByBankAndDateOpenBetween(bank, dt1, dt2);
	}
	
	@GetMapping("/getCreditPersonalNumDoc/{numDoc}")
	Flux<EntityCreditPersonal> getCreditPersonalNumDoc(@PathVariable("numDoc") String numDoc){
		return imple.CreditPersonalNumDoc(numDoc);
	}
	
	@GetMapping("/getCreditPersonalNumCred/{numCred}")
	Mono<EntityCreditPersonal> getCreditPersonal(String numCred){
		return imple.CreditPersonalNumCredi(numCred);
	}

	@PostMapping("/postCreditPersonal")
	Mono<EntityCreditPersonal> postCreditPersonal(@RequestBody EntityCreditPersonal creditPersonal){
		return imple.saveCreditPersonal(creditPersonal);
	}
	
	@PutMapping("/postCreditPersonal")
	Mono<EntityCreditPersonal> updCreditPersonal(@RequestBody EntityCreditPersonal creditPersonal){
		return imple.updCreditPersonal(creditPersonal);
	}
	
	@DeleteMapping("/dltCreditPersonal/{id}")
	Mono<Void> dltCreditPersonal(@PathVariable("id") String id){
		return imple.dltCreditPersonal(id);
	}
	
	@PostMapping("/updTransancionesCreditPersonal/{numCred}/{tipo}/{cash}")
	public Mono<EntityCreditPersonal> updTransancionesCreditPersonal(@PathVariable("numCred") String numCred 
			,@PathVariable("tipo") String tipo ,@PathVariable("cash")  Double cash){
			return imple.transacationCreditPersonal(numCred, tipo, cash);
	}
	
	@PostMapping("/creditPersonalByNumDocList/{status}")
	public Flux<EntityCreditPersonal> creditCardByNumDocList(@RequestBody List<String> numDoc
			,@PathVariable("status") String status){
		return imple.CreditPersonalNumDocList(numDoc,status);
		
	}
}


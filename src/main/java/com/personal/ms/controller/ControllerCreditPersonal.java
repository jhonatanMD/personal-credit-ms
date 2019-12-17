package com.personal.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/updTransancionesCreditPersonal/{numCred}/{tipo}/{cash}")
	public Mono<EntityCreditPersonal> updTransancionesCreditPersonal(@PathVariable("numCred") String numCred 
			,@PathVariable("tipo") String tipo ,@PathVariable("cash")  Double cash){
			return imple.transacationCreditPersonal(numCred, tipo, cash);
	}
}


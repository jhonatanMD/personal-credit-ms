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
import com.personal.ms.service.CreditPersonalServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class ControllerCreditPersonal {
	
	@Autowired
	CreditPersonalServiceImpl imple;
	@GetMapping("/getCreditPersonal")
	Flux<EntityCreditPersonal> getCreditPersonal(){
		return imple.allCreditPersonal();
	}
	
	@GetMapping("/getCreditPersonal/dni")
	Mono<EntityCreditPersonal> getCreditPersonal(String dni){
		return imple.CreditPersonalDni(dni);
	}

	@PostMapping("/postCreditPersonal")
	Mono<EntityCreditPersonal> postCreditPersonal(@RequestBody EntityCreditPersonal creditPersonal){
		return imple.saveCreditPersonal(creditPersonal);
	}
	
	@PutMapping("/postCreditPersonal")
	Mono<EntityCreditPersonal> updCreditPersonal(@RequestBody EntityCreditPersonal creditPersonal){
		return imple.updCreditPersonal(creditPersonal);
	}
	
	@PostMapping("/updTransancionesCreditPersonal/{dni}/{tipo}/{cash}")
	public Mono<EntityCreditPersonal> updTransancionesCreditPersonal(@PathVariable("dni") String dni 
			,@PathVariable("tipo") String tipo ,@PathVariable("cash")  Double cash){
			return imple.CreditPersonalDni(dni)
					.flatMap(p ->{
						if(tipo.equals("r") && p.getCash() >= cash) {
							p.setCash(p.getCash() - cash);
						}else if (tipo.equals("d")){
							p.setCash( p.getCash() + cash);
						}
				return imple.updCreditPersonal(p);
				});

	}
}


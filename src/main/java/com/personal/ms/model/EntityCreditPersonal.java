package com.personal.ms.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CreditPersonal")
public class EntityCreditPersonal {
	
	@Id
	private String codCur;
	
	private String numCredi;
	
	private Double cash;
	
	private Double cashPay;
	
	private HeadLineEntity  customer;
	
	private List<EntityTransaction> transactions;


	public String getCodCur() {
		return codCur;
	}

	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}

	

	public String getNumCredi() {
		return numCredi;
	}

	public void setNumCredi(String numCredi) {
		this.numCredi = numCredi;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}
		
	public Double getCashPay() {
		return cashPay;
	}

	public void setCashPay(Double cashPay) {
		this.cashPay = cashPay;
	}

	public HeadLineEntity getCustomer() {
		return customer;
	}

	public void setCustomer(HeadLineEntity customer) {
		this.customer = customer;
	}

	public List<EntityTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EntityTransaction> transactions) {
		this.transactions = transactions;
	}


}

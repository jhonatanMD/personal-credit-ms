package com.personal.ms.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "CreditPersonal")
public class EntityCreditPersonal {
	
	@Id
	private String codCur;
	
	private String numCredi;
	
	private Double cash;
	
	private Double cashPay;
	
	private HeadLineEntity  customer;
	
	private String bank;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@NotNull
	private Date dateOpen;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date dateCredit;
	
	private List<EntityTransaction> transactions;

	private String status;
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
	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}

	public Date getDateCredit() {
		return dateCredit;
	}

	public void setDateCredit(Date dateCredit) {
		this.dateCredit = dateCredit;
	}

	public List<EntityTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<EntityTransaction> transactions) {
		this.transactions = transactions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}

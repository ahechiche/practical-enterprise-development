package com.itbuzzpress.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import com.itbuzzpress.exception.InsufficientFundsException;
 

@Stateful
@Remote(Account.class)
public class AccountEJB implements Account {

    long money;
 
    
	@Override
	public long getMoney() {
		return money;

	}
    @Asynchronous
    public Future<String> createAccount(long amount)  
	{
		this.money= amount;
		return new AsyncResult<String>("OK");
	}


	@Override
	public void deposit(long amount)  
	{
		 
			this.money+= amount;
			 
		System.out.println("Money deposit. total is "+money);
	}
 
	 
	@Override
	public void withdraw(long amount) throws InsufficientFundsException {
		
		long newAmount = money - amount;
		if (newAmount < 0) {
			throw new InsufficientFundsException("Unsufficient funds for account! ");
		}
		
		money = newAmount;	 
		System.out.println("Money withdrawal. total is "+money);

	}
}

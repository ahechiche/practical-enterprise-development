 
package com.itbuzzpress.ejb.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itbuzzpress.ejb.Account;
import com.itbuzzpress.ejb.Calculator;
import com.itbuzzpress.exception.InsufficientFundsException;
 

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {
		Account account = lookupAccountEJB();
		Calculator calculator = lookupCalculatorEJB();
		System.out.println("Create Account with 1000$ ");

		account.createAccount(1000l);
		System.out.println("Deposit 250$ ");
		account.deposit(250);

		try {
			System.out.println("Withdraw 500$ ");
			account.withdraw(500);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long money = account.getMoney();
		System.out.println("Money left " + money);
		float totalMoney = calculator.calculateInterest(money);
		System.out.println("Money plus interests " + totalMoney);

	}

	private static Account lookupAccountEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                 "org.wildfly.naming.client.WildFlyInitialContextFactory");
		final Context context = new InitialContext(jndiProperties);

		return (Account) context
				.lookup("ejb:/thorntail-ejb-server-timer-1.0/AccountEJB!com.itbuzzpress.ejb.Account?stateful");
	}

	private static Calculator lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
                jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                 "org.wildfly.naming.client.WildFlyInitialContextFactory");
		final Context context = new InitialContext(jndiProperties);

		return (Calculator) context
				.lookup("ejb:/thorntail-ejb-server-timer-1.0/CalculatorEJB!com.itbuzzpress.ejb.Calculator");
	}
}

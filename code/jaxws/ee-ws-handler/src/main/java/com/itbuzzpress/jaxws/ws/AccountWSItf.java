package com.itbuzzpress.jaxws.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface AccountWSItf {
	@WebMethod
	public void newAccount( String name);

	@WebMethod
	public void withdraw(String name, long amount) throws RuntimeException;

	@WebMethod
	public void deposit(String name, long amount);

	@WebMethod
	public Account findAccountByName(String name);
}

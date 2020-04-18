package controller;

import model.Account;

public class LoginController {
	
	
	public Account validateLogin(String email, String pwd) {
		Account returnedAcc = new Account();
		if(!email.isEmpty() && !pwd.isEmpty()) {
			Account account = new Account();
			account.setEmail(email);
			account.setPassword(pwd);
			returnedAcc = account.doLogin();
		}
		return returnedAcc;
	}

}

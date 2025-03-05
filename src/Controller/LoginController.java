package Controller;

import Dao.IAccountCreationDao;
import Service.LoginService;

public class LoginController {
	private LoginService loginService;
	public LoginController(LoginService loginService){
		this.loginService = loginService;
	}
	
	public boolean login(long cardNumber, int pin) {
		 return loginService.login(cardNumber, pin);
	 }

}

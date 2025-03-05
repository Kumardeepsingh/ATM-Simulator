package Service;

import Dao.ILoginDao;

public class LoginService {
	private ILoginDao loginDao;
	
	public LoginService(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public boolean login(long cardNumber, int pin) {
    	return loginDao.login(cardNumber, pin);
    }
	 

}

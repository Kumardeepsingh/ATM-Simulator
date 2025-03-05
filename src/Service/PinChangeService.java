package Service;

import Dao.IAccountPinDao;
import Model.Account;

public class PinChangeService {
	
	IAccountPinDao accountPinDao;
	
	public PinChangeService(IAccountPinDao accountPinDao){
		this.accountPinDao = accountPinDao;
	}
	
	public void changePinNumber(Account account) {
		accountPinDao.changePinNumber(account);
	}

}

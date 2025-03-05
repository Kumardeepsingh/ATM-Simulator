package Service;
import Dao.IAccountCreationDao;
import Dao.IAccountBalanceDao;
import Dao.IAccountQueryDao;
import Model.Account;

public class AccountService {
    
    private IAccountCreationDao accountCreationDao;
    private IAccountBalanceDao accountBalanceDao;
    private IAccountQueryDao accountQueryDao;

    public AccountService(IAccountCreationDao accountCreationDao, IAccountBalanceDao accountBalanceDao, IAccountQueryDao accountQueryDao) {
        this.accountCreationDao = accountCreationDao;
        this.accountBalanceDao = accountBalanceDao;
        this.accountQueryDao = accountQueryDao;
    }

    public void createAccount(Account account) {
        accountCreationDao.save(account);
    }

    public void updateBalance(Account account) {
        accountBalanceDao.updateBalance(account);
    }

    public Account getAccountByCardNumber(Account account,long cardNumber) {
        return accountQueryDao.getAccountByCardNumber(account, cardNumber);
    }

    

    public int getAccountIDByCustomerID(Account account) {
        return accountQueryDao.getAccountIDByCustomerID(account);
    }
}

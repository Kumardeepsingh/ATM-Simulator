package View;

import Controller.*;
import Dao.*;
import Service.*;


public class MainApp {

	public static void main(String[] args) {
		
		DatabaseConnection databaseConnection =  Conn.getInstance();
		
		ICustomerDao customerDao = new CustomerDao(databaseConnection);
		IAccountCreationDao accountCreationDao = new AccountDao(databaseConnection);
        IAccountBalanceDao accountBalanceDao = new AccountDao(databaseConnection);
        IAccountQueryDao accountQueryDao = new AccountDao(databaseConnection);
        ILoginDao loginDao = new LoginDao(databaseConnection);
        ITransactionCreationDao transactionDao = new TransactionDao(databaseConnection);
        ITransactionBalanceDao transactionBalanceDao = new TransactionBalanceDao(databaseConnection);
        IAccountPinDao accountPinDao = new AccountDao(databaseConnection);
        ITransactionQueryDao transactionQueryDao = new TransactionQueryDao(databaseConnection);

        
        AccountService accountService = new AccountService(accountCreationDao, accountBalanceDao, accountQueryDao);
        LoginService loginService = new LoginService(loginDao);
        TransactionService transactionService = new TransactionService(transactionDao, transactionBalanceDao, transactionQueryDao);
        PinChangeService pinChangeService = new PinChangeService(accountPinDao);


       
        CustomerController customerController = new CustomerController(customerDao);
        AccountController accountController = new AccountController(accountService, pinChangeService, transactionService);
        LoginController loginController = new LoginController(loginService);
        TransactionController transactionController = new TransactionController(transactionService);
        
        NavigationManager navigationManager =  new NavigationManager(accountController, loginController, customerController, transactionController);
        
        navigationManager.navigateToLoginView(navigationManager);
		
		

	}

}

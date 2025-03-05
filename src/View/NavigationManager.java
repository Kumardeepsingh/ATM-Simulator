package View;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;

public class NavigationManager {
	
	AccountController accountController;
	LoginController loginController;
	CustomerController customerController;
	TransactionController transactionController;
	
	public NavigationManager(AccountController accountController, LoginController loginController, CustomerController customerController, TransactionController transactionController) {
		this.transactionController = transactionController;
		this.customerController = customerController;
		this.accountController = accountController;
		this.loginController = loginController;
	}
	
	public void navigateToLoginView(NavigationManager navigationManager) {
		new Login(accountController, loginController, navigationManager);
	}
	
	public void navigateToSignUpView(NavigationManager navigationManager) {
		new SignUp(customerController,navigationManager);
	}

	public void navigateToSignUpTwoView(NavigationManager navigationManager) {
		new SignUpTwo(customerController,navigationManager);
	
}

	public void navigateToSignUpThreeView(NavigationManager navigationManager) {
		new SignUpThree(customerController, accountController, navigationManager);
	
}
	public void navigateToTransactionView(NavigationManager navigationManager) {
		new TransactionView(navigationManager);
}

	public void navigateToDepositView(NavigationManager navigationManager) {
		new DepositView(accountController,transactionController,navigationManager);
	
}

	public void navigateToWithdrawlTwoView(NavigationManager navigationManager) {
		new WithdrawlView(accountController,transactionController,navigationManager);
}

	public void navigateToFastCashView(NavigationManager navigationManager) {
		new FastCashView(accountController,transactionController,navigationManager);
}

	public void navigateToCheckBalanceView(NavigationManager navigationManager) {
		new CheckBalanceView(accountController,navigationManager);
}

	public void navigateToMiniStatementView(NavigationManager navigationManager) {
		new MiniStatementView(accountController,navigationManager);
	
}

	public void navigateToPinChangeView(NavigationManager navigationManager) {
		new PinChangeView(accountController,navigationManager);
}



}

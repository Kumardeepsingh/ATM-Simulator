ATM Simulator

Project Description:
The ATM Simulator is a Java-based application that simulates basic ATM functionalities, allowing users to perform transactions like withdrawals, deposits, balance checks, fast cash, and more. It follows the MVC (Model-View-Controller) design pattern and adheres to SOLID principles for a clean and maintainable code structure. The system interacts with a MySQL database to securely store customer information, transaction histories, and account details.

Features:
Login and Sign-Up: Users can log in to their accounts or sign up for a new account. The sign-up process involves entering customer and account details.
Deposit and Withdrawal: Users can deposit money or withdraw funds, with validations in place for transaction limits.
Fast Cash: A quick withdrawal option with predefined amounts.
Balance Check: Users can view their current account balance.
Mini Statement: Displays a short transaction history of the account.
PIN Change: Users can change their account PIN for security purposes.
Database Integration: All customer and transaction data are securely stored and retrieved from a MySQL database.

Technology Stack:
Programming Language: Java (Java Swing for the GUI)
Database: MySQL
Design Pattern: MVC (Model-View-Controller)
Tools: Eclipse IDE, MySQL Workbench
Operating System: Windows 10

Installation:

Clone the repository from GitHub.

Install Java and MySQL.

Set up the MySQL database using the provided schema.

MySQL Connector JAR: Download the MySQL Connector/J online

In Eclipse, right-click your project, go to Build Path > Configure Build Path > Libraries.

Click Add External JARs and select the MySQL Connector JAR file.

JCalendar JAR: Download the JCalendar JAR file online.

Similarly, go to Build Path > Configure Build Path > Libraries, click Add External JARs, and select the JCalendar JAR file.

Configure the database connection in the ConnectionUtil class.

Run the project using Eclipse or any compatible IDE.

How to Use:
Login: Enter your card number and PIN to log in.
Transaction Menu: After logging in, you can choose to:
Deposit money
Withdraw funds
Use the Fast Cash option
Check your account balance
View a mini statement of recent transactions
Change your PIN
Sign-Up: If you don't have an account, you can sign up by entering customer information and account details.

Structure:
Model: Handles data management (e.g., customer information, transactions).
View: Contains the GUI for user interaction (e.g., login screen, transaction menus).
Controller: Manages the communication between the model and the view.

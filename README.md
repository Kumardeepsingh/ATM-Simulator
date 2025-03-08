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

Screenshots:
![Capture](https://github.com/user-attachments/assets/33e24cd4-d700-477f-8be6-03f549d6ef58)
![2](https://github.com/user-attachments/assets/bbde7e56-7b6c-4aca-8a86-e6424ef01f4c)
![3](https://github.com/user-attachments/assets/b5af7e62-0d9b-46f9-aa7d-bfd7ee911185)
![4](https://github.com/user-attachments/assets/54cfc1e6-b58d-4bfb-a59a-07c5864fbab8)
![5](https://github.com/user-attachments/assets/104ab670-2b14-43dd-9d42-c11ce7d361e7)
![6](https://github.com/user-attachments/assets/72c1dda5-f32b-4be0-85b7-31945ec6d6b2)
![7](https://github.com/user-attachments/assets/e2c90249-e52c-4a5b-882f-0b0eab72798b)
![8](https://github.com/user-attachments/assets/dbbc1766-c3b5-49e1-8d21-9f676ed4119c)
![9](https://github.com/user-attachments/assets/cb6d7e60-0e4c-410d-a725-566e3b41180e)
![10](https://github.com/user-attachments/assets/04e14194-e432-42f0-aa19-87d1590a235c)
![11](https://github.com/user-attachments/assets/08b69359-ec3e-4c67-a1ec-1781bf0d64c8)

SQL File

create database bankmanagementsystem;

use bankmanagementsystem;


CREATE TABLE Customer (
customer_id INT(4) AUTO_INCREMENT,
first_name VARCHAR(100),
last_name VARCHAR(100),
dob Date,
gender VARCHAR(100),
email VARCHAR(100),
marital_status VARCHAR(100),
address VARCHAR(100),
postal_code VARCHAR(100),
phone_number BIGINT(10),
id_type VARCHAR(100),
id_number VARCHAR(100),
sin BIGINT(9),
employment_status VARCHAR(100),
job_title VARCHAR(100),
income_range VARCHAR(100),
PRIMARY KEY (customer_id)
) AUTO_INCREMENT = 1000;

CREATE TABLE Account(
account_id int(4) AUTO_INCREMENT,
account_type VARCHAR(20),
card_number BIGINT(16),
pin_number BIGINT(4),
balance DOUBLE,
customer_id INT,
PRIMARY KEY (account_id),
FOREIGN KEY (customer_id) REFERENCES Customer (customer_ID)
) Auto_INCREMENT = 2000;



CREATE TABLE Transaction(
transaction_id int(4) AUTO_INCREMENT,
transaction_type VARCHAR(20),
amount DOUBLE,
transaction_date Date,
account_id INT,
PRIMARY KEY (transaction_id),
FOREIGN KEY (account_id) REFERENCES Account (account_ID)
) Auto_INCREMENT = 3000;









# 🏧 ATM Simulator

**ATM Simulator** is a Java-based desktop application that simulates essential banking functions such as withdrawals, deposits, balance checks, and more. It follows the MVC (Model-View-Controller) architecture and adheres to SOLID principles for clean, maintainable code. The system uses a MySQL database to store user data, transactions, and account details securely.

---

## 🚀 Features

- 🔐 **Login and Sign-Up**: Authenticate with card number and PIN, or register as a new user with personal and account details.
- 💰 **Deposit and Withdrawal**: Safely deposit or withdraw funds with validations.
- ⚡ **Fast Cash**: One-click withdrawals using predefined amounts.
- 💳 **Balance Check**: View your current account balance.
- 🧾 **Mini Statement**: Display a short transaction history.
- 🔄 **PIN Change**: Update account PIN securely.
- 🗃️ **Database Integration**: All records are stored in a MySQL database.

---

## 🛠️ Technology Stack

- **Language**: Java
- **GUI**: Java Swing
- **Database**: MySQL
- **Design Pattern**: MVC
- **IDE**: Eclipse
- **Platform**: Windows 10

---

## ⚙️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK)
- Eclipse IDE
- MySQL Server & MySQL Workbench

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/YourUsername/ATMSimulator.git
   ```

2. **Setup the MySQL Database**
   - Open MySQL Workbench
   - Run the SQL schema provided below

3. **Add Dependencies**
   - **MySQL Connector JAR**
     - Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
     - In Eclipse: Right-click the project → Build Path → Configure Build Path → Add External JARs
   - **JCalendar JAR** (if used)
     - Download and add using the same method above

4. **Configure Database Connection**
   - Update DB credentials in `ConnectionUtil` or equivalent utility class

5. **Run the Project**
   - Launch from Eclipse using the main class

---

## 💻 How to Use

- **Login**: Enter your card number and PIN.
- **Sign-Up**: Create a new account by entering personal and banking details.
- **Transaction Options**:
  - Deposit
  - Withdraw
  - Fast Cash
  - Balance Check
  - Mini Statement
  - Change PIN

---

## 🧱 Project Structure

- **Model**: Manages data and database logic (e.g., Customer, Account, Transaction).
- **View**: Swing-based GUI interfaces for login, transactions, etc.
- **Controller**: Bridges GUI events with model actions and database operations.

---

## 🖼️ Screenshots

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

---

## 🗃️ SQL Schema

```sql
CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

CREATE TABLE Customer (
    customer_id INT(4) AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    dob DATE,
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

CREATE TABLE Account (
    account_id INT(4) AUTO_INCREMENT,
    account_type VARCHAR(20),
    card_number BIGINT(16),
    pin_number BIGINT(4),
    balance DOUBLE,
    customer_id INT,
    PRIMARY KEY (account_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
) AUTO_INCREMENT = 2000;

CREATE TABLE Transaction (
    transaction_id INT(4) AUTO_INCREMENT,
    transaction_type VARCHAR(20),
    amount DOUBLE,
    transaction_date DATE,
    account_id INT,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
) AUTO_INCREMENT = 3000;
```

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

> “Simulating real-world banking operations in a secure and user-friendly way.”

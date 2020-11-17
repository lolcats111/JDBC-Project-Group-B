SAVEPOINT makeTables;


drop table TRANSACTIONS;
drop table BANK_ACCOUNTS;
drop table CLERKS;
drop table CUSTOMERS;


/* Customers */

CREATE TABLE CUSTOMERS(
	id NUMBER PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	gender CHAR(1) NOT NULL,
	email VARCHAR(100),
	phone VARCHAR(15),
	address VARCHAR(200), 
	CONSTRAINT ck_GENDER
		CHECK (gender in ('M','F','O'))
);

/* Login Details for Bank Clerks */

CREATE TABLE CLERKS(
	username VARCHAR(30) PRIMARY KEY,
	password_hash RAW(16)
);


/* Accounts */

CREATE TABLE BANK_ACCOUNTS(
	acc_id NUMBER PRIMARY KEY,
	customer_id NUMBER NOT NULL REFERENCES CUSTOMERS(id),
	balance NUMBER DEFAULT 0,
	acc_type VARCHAR(10) NOT NULL,
	CONSTRAINT ck_BANK_TYPE
		CHECK (acc_type in ('REGULAR','CREDIT'))
);

/* Transactions */

CREATE TABLE TRANSACTIONS(
	txn_id NUMBER PRIMARY KEY,
	acc_id NUMBER NOT NULL REFERENCES BANK_ACCOUNTS(acc_id),
	ts DATE NOT NULL,
	txn_type VARCHAR(10) NOT NULL,
	amount NUMBER NOT NULL,
	CONSTRAINT ck_TXN_TYPE
		CHECK (txn_type in ('REGULAR','CREDIT','OVERDRAFT'))
);

ROLLBACK TO makeTables;
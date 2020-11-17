SAVEPOINT makeTables;


drop table TRANSACTIONS;
drop table BANK_ACCOUNTS;
drop table CREDENTIALS;
drop table CUSTOMERS;


/* Customers */

CREATE TABLE CUSTOMERS(
	id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	gender VARCHAR(1) NOT NULL,
	email VARCHAR(100),
	phone VARCHAR(15),
	address VARCHAR(200)
);

/* Login Details */

CREATE TABLE CREDENTIALS(
	id VARCHAR(30) PRIMARY KEY REFERENCES CUSTOMERS(id),
	password_hash RAW(16)
);


/* Accounts */

CREATE TABLE BANK_ACCOUNTS(
	acc_id VARCHAR(30) PRIMARY KEY,
	customer_id VARCHAR(30) NOT NULL REFERENCES CUSTOMERS(id),
	balance NUMBER DEFAULT 0,
	acc_type VARCHAR(10) NOT NULL,
	CONSTRAINT ck_BANK_TYPE
		CHECK (acc_type in ('REGULAR','CREDIT'))
);

/* Transactions */

CREATE TABLE TRANSACTIONS(
	acc_id VARCHAR(30) NOT NULL REFERENCES BANK_ACCOUNTS(acc_id),
	customer_id VARCHAR(30) NOT NULL REFERENCES CUSTOMERS(id),
	ts DATE NOT NULL,
	txn_type VARCHAR(10) NOT NULL,
	amount NUMBER NOT NULL,
	CONSTRAINT ck_TXN_TYPE
		CHECK (txn_type in ('REGULAR','CREDIT','OVERDRAFT'))
);

ROLLBACK TO makeTables;
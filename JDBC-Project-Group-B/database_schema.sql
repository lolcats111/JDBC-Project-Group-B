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
/* id Auto Increment */
CREATE SEQUENCE cust_id_seq START WITH 1;
/* Must run the following as "One Statement"*/
CREATE OR REPLACE TRIGGER cust_id_trig
  BEFORE INSERT ON CUSTOMERS
  FOR EACH ROW
BEGIN
  SELECT cust_id_seq.nextval
  INTO :new.id
  FROM dual;
END;


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
	acc_type VARCHAR(10) DEFAULT 'REGULAR',
	CONSTRAINT ck_BANK_TYPE
		CHECK (acc_type in ('REGULAR','CREDIT'))
);

/* acc_id Auto Increment */
CREATE SEQUENCE acc_id_seq START WITH 1;
/* Must run the following as "One Statement"*/
CREATE OR REPLACE TRIGGER acc_id_trig
  BEFORE INSERT ON BANK_ACCOUNTS
  FOR EACH ROW
BEGIN
  SELECT acc_id_seq.nextval
  INTO :new.acc_id
  FROM dual;
END;



/* Transactions */
CREATE TABLE TRANSACTIONS(
	txn_id NUMBER PRIMARY KEY,
	acc_id NUMBER NOT NULL REFERENCES BANK_ACCOUNTS(acc_id),
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	txn_type VARCHAR(10) DEFAULT 'REGULAR',
	amount NUMBER NOT NULL,
	CONSTRAINT ck_TXN_TYPE
		CHECK (txn_type in ('REGULAR','CREDIT','OVERDRAFT'))
);

/* Txn Auto Increment */
CREATE SEQUENCE txn_id_seq START WITH 1;
/* Must run the following as "One Statement"*/
CREATE OR REPLACE TRIGGER txn_id_trig
  BEFORE INSERT ON TRANSACTIONS
  FOR EACH ROW
BEGIN
  SELECT txn_id_seq.nextval
  INTO :new.txn_id
  FROM dual;
END;



/* Test */
insert into CUSTOMERS(name, gender) values('mark', 'M');
insert into BANK_ACCOUNTS(customer_id) values(1);
insert into TRANSACTIONS(acc_id,amount) values (1,333);
select * from TRANSACTIONS;
select * from BANK_ACCOUNTS;
select * from CUSTOMERS;


ROLLBACK TO makeTables;
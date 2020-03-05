DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT (
  account_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY START WITH 1111111 PRIMARY KEY,
  account_type NUMBER,
  balance NUMBER(12,5),
  overdraft_protection NUMBER(6),
  active NUMBER(1)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_OWNERSHIP');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_OWNERSHIP CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_OWNERSHIP (
  ownership_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  owner NUMBER,
  account NUMBER,
  date_added DATE
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_REQUEST');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_REQUEST CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_REQUEST (
  acc_request_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  account_type NUMBER,
  date_of_request DATE
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_REQUEST_USERS');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_REQUEST_USERS CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_REQUEST_USERS (
  acc_request_user NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  person NUMBER,
  acc_request NUMBER
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_TRANSACTION');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_TRANSACTION CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_TRANSACTION (
  transaction_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  amount NUMBER(12,2),
  account NUMBER,
  status NUMBER,
  transaction_type NUMBER,
  notes VARCHAR(500),
  related_transaction NUMBER
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_TRANSACTION_STATUS');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_TRANSACTION_STATUS CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_TRANSACTION_STATUS (
  trans_status_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_TRANSACTION_TYPE');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_TRANSACTION_TYPE CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_TRANSACTION_TYPE (
  trans_type_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_TYPE');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_TYPE CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_TYPE (
  account_type_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100),
  min_balance NUMBER(7),
  Interest NUMBER(6,5)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ADDRESS');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ADDRESS CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ADDRESS (
  address_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  address VARCHAR(100)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ASSOCIATED_PEOPLE');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ASSOCIATED_PEOPLE CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ASSOCIATED_PEOPLE (
  first_person NUMBER,
  second_person NUMBER
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('CITY');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE CITY CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE CITY (
  city_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  city VARCHAR(200),
  state VARCHAR(2),
  zip NUMBER(5)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('EMAIL');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE EMAIL CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE EMAIL (
  email_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  person NUMBER
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERSON');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERSON CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PERSON (
  person_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  social_sec_num VARCHAR(9),
  standing NUMBER,
  password VARCHAR2(1000),
  city NUMBER,
  address NUMBER,
  username VARCHAR(100) UNIQUE,
  active NUMBER(1)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERSON_STANDING');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERSON_STANDING CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PERSON_STANDING (
  standing_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERSON_STANDING_LABEL');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERSON_STANDING_LABEL CASCADE CONSTRAINTS';
   END IF;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERMISSION_RANK');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERMISSION_RANK CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PERMISSION_RANK (
  person NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label NUMBER
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERMISSION_RANK_LABEL');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERMISSION_RANK_LABEL CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PERMISSION_RANK_LABEL (
  permission_label_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100)
);

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PHONE_NUMBER');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PHONE_NUMBER CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PHONE_NUMBER (
  phone_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  phone_number VARCHAR(20),
  person NUMBER
);

ALTER TABLE ACCOUNT 
  ADD CONSTRAINT ac_account_type
    FOREIGN KEY (ACCOUNT_TYPE)
    REFERENCES ACCOUNT_TYPE (account_type_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_OWNERSHIP 
  ADD CONSTRAINT ao_owner
    FOREIGN KEY (owner)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_OWNERSHIP 
  ADD CONSTRAINT ao_account
    FOREIGN KEY (account)
    REFERENCES ACCOUNT (account_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_REQUEST 
  ADD CONSTRAINT ar_account_type
    FOREIGN KEY (ACCOUNT_TYPE)
    REFERENCES ACCOUNT_TYPE (account_type_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_REQUEST_USERS
  ADD CONSTRAINT ar_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_REQUEST_USERS
  ADD CONSTRAINT ar_account_request
    FOREIGN KEY (acc_request)
    REFERENCES ACCOUNT_REQUEST (acc_request_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_TRANSACTION
  ADD CONSTRAINT at_account
    FOREIGN KEY (account)
    REFERENCES ACCOUNT (account_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_TRANSACTION
  ADD CONSTRAINT at_status
    FOREIGN KEY (status)
    REFERENCES ACCOUNT_TRANSACTION_STATUS (trans_status_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_TRANSACTION
  ADD CONSTRAINT at_type
    FOREIGN KEY (transaction_type)
    REFERENCES ACCOUNT_TRANSACTION_TYPE (trans_type_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_TRANSACTION
  ADD CONSTRAINT at_related
    FOREIGN KEY (related_transaction)
    REFERENCES ACCOUNT_TRANSACTION (transaction_id)
    ON DELETE SET NULL
;
ALTER TABLE ASSOCIATED_PEOPLE
  ADD CONSTRAINT ap_first
    FOREIGN KEY (first_person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ASSOCIATED_PEOPLE
  ADD CONSTRAINT ap_second
    FOREIGN KEY (second_person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE EMAIL
  ADD CONSTRAINT em_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE PERSON
  ADD CONSTRAINT pe_standing
    FOREIGN KEY (standing)
    REFERENCES PERSON_STANDING (standing_id)
    ON DELETE SET NULL
;
ALTER TABLE PERSON
  ADD CONSTRAINT pe_city
    FOREIGN KEY (city)
    REFERENCES CITY (city_id)
    ON DELETE SET NULL
;
ALTER TABLE PERSON
  ADD CONSTRAINT pe_address
    FOREIGN KEY (address)
    REFERENCES ADDRESS (address_id)
    ON DELETE SET NULL
;
ALTER TABLE PERMISSION_RANK
  ADD CONSTRAINT pr_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE PERMISSION_RANK
  ADD CONSTRAINT pr_label
    FOREIGN KEY (label)
    REFERENCES PERMISSION_RANK_LABEL (permission_label_id)
    ON DELETE SET NULL
;
ALTER TABLE PHONE_NUMBER
  ADD CONSTRAINT pn_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;

INSERT INTO PERMISSION_RANK_LABEL (label) VALUES ('Customer');
INSERT INTO PERMISSION_RANK_LABEL (label) VALUES ('Employee');
INSERT INTO PERMISSION_RANK_LABEL (label) VALUES ('Admin');
INSERT INTO PERSON_STANDING (label) VALUES ('Delinquent -3');
INSERT INTO PERSON_STANDING (label) VALUES ('Disresected -2');
INSERT INTO PERSON_STANDING (label) VALUES ('Untrustworthy -1');
INSERT INTO PERSON_STANDING (label) VALUES ('Unknown 0');
INSERT INTO PERSON_STANDING (label) VALUES ('Trustworthy 1');
INSERT INTO PERSON_STANDING (label) VALUES ('Respected 2');
INSERT INTO PERSON_STANDING (label) VALUES ('Honored 3');
INSERT INTO ACCOUNT_TYPE (label,min_balance,interest) VALUES ('Checking',0,0.0005);
INSERT INTO ACCOUNT_TYPE (label,min_balance,interest) VALUES ('Savings',300,0.0015);
INSERT INTO ACCOUNT_TYPE (label,min_balance,interest) VALUES ('High Yield Savings',50000,0.0105);
INSERT INTO ACCOUNT_TYPE (label,min_balance,interest) VALUES ('Credit',-5000,0.0);
SELECT * FROM PERMISSION_RANK_LABEL;
SELECT * FROM PERSON_STANDING;
SELECT * FROM ACCOUNT_TYPE;
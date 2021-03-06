SET AUTO OFF;
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

CREATE OR REPLACE PROCEDURE create_account(
  acc_id OUT NUMBER, 
  acc_type IN NUMBER,
  acc_balance IN NUMBER,
  acc_overdraft NUMBER,
  acc_active NUMBER
)
IS
BEGIN
  INSERT INTO ACCOUNT(account_type, balance, overdraft_protection, active) 
    VALUES (acc_type, acc_balance, acc_overdraft, acc_active)
    RETURNING account_id 
      INTO acc_id;
  COMMIT;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_OWNERSHIP_JT');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_OWNERSHIP_JT CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_OWNERSHIP_JT (
  ownership_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  owner NUMBER,
  account NUMBER,
  date_added DATE
);

CREATE OR REPLACE PROCEDURE create_account_ownership_jt(
  acc_own_id OUT NUMBER, 
  acc_own_account IN NUMBER,
  acc_own_owner IN NUMBER,
  acc_own_date_added DATE
)
IS
BEGIN
  SELECT MIN(ownership_id) INTO acc_own_id FROM ACCOUNT_OWNERSHIP_JT 
    WHERE ACCOUNT_OWNERSHIP_JT.owner = acc_own_owner 
      AND ACCOUNT_OWNERSHIP_JT.account = acc_own_account;
  IF acc_own_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(acc_own_id);
  ELSE
    INSERT INTO ACCOUNT_OWNERSHIP_JT(owner, account, date_added) 
      VALUES (acc_own_owner, acc_own_account, acc_own_date_added)
      RETURNING ownership_id 
        INTO acc_own_id;
  END IF;
  COMMIT;
END;
/

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

CREATE OR REPLACE PROCEDURE create_account_request(
  acc_request_id OUT NUMBER, 
  acc_request_type IN NUMBER,
  acc_request_date IN OUT DATE
)
IS
BEGIN
  INSERT INTO ACCOUNT_REQUEST(account_type, date_of_request) 
    VALUES (acc_request_type, acc_request_date)
    RETURNING acc_request_id 
      INTO acc_request_id;
  COMMIT;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ACCOUNT_REQUEST_USERS_JT');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ACCOUNT_REQUEST_USERS_JT CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ACCOUNT_REQUEST_USERS_JT (
  person NUMBER,
  acc_request NUMBER
);

CREATE OR REPLACE PROCEDURE create_account_req_users_jt(
  per_id IN NUMBER,
  acc_req_id IN NUMBER,
  tmp_var OUT NUMBER
)
IS
BEGIN
  SELECT MIN(person) INTO tmp_var FROM ACCOUNT_REQUEST_USERS_JT
    WHERE ACCOUNT_REQUEST_USERS_JT.person = per_id AND ACCOUNT_REQUEST_USERS_JT.acc_request = acc_req_id;
  IF tmp_var > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(tmp_var);
  ELSE
    INSERT INTO ACCOUNT_REQUEST_USERS_JT(person, acc_request) 
      VALUES (per_id, acc_req_id);
    COMMIT;
  END IF;
END;
/

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
  notes VARCHAR2(500),
  related_transaction NUMBER,
  transaction_date DATE
);

CREATE OR REPLACE PROCEDURE create_acc_tran(
  tran_id OUT NUMBER, tran_amount IN NUMBER, tran_acc IN NUMBER,
  tran_status IN NUMBER, tran_type IN NUMBER, tran_notes IN VARCHAR2,
  tran_related IN NUMBER, tran_date IN DATE
)
IS
BEGIN
  INSERT INTO ACCOUNT_TRANSACTION(amount, account, status, transaction_type, notes, related_transaction, transaction_date) 
    VALUES (tran_amount, tran_acc, tran_status, tran_type, tran_notes, tran_related, tran_date)
    RETURNING transaction_id 
      INTO tran_id;
  COMMIT;
END;
/

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

CREATE OR REPLACE PROCEDURE create_acc_tran_status(
  tran_id OUT NUMBER, new_label IN VARCHAR2
)
IS
BEGIN
  SELECT MIN (trans_status_id) INTO tran_id FROM ACCOUNT_TRANSACTION_STATUS WHERE ACCOUNT_TRANSACTION_STATUS.label = new_label;
  IF tran_id > 0
  THEN
    DBMS_OUTPUT.PUT_LINE(tran_id);
  ELSE
    INSERT INTO ACCOUNT_TRANSACTION_STATUS(label) 
      VALUES (new_label)
      RETURNING trans_status_id 
        INTO tran_id;
    COMMIT;
  END IF;
END;
/

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

CREATE OR REPLACE PROCEDURE create_acc_tran_type(
  tran_id OUT NUMBER, new_label IN VARCHAR2
)
IS
BEGIN
  SELECT MIN(trans_type_id) INTO tran_id FROM ACCOUNT_TRANSACTION_TYPE WHERE ACCOUNT_TRANSACTION_TYPE.label = new_label;
  if tran_id >0
  THEN
    DBMS_OUTPUT.PUT_LINE(tran_id);
  ELSE
    INSERT INTO ACCOUNT_TRANSACTION_TYPE(label) 
      VALUES (new_label)
      RETURNING trans_type_id 
        INTO tran_id;
    COMMIT;
  END IF;
END;
/

CREATE OR REPLACE PROCEDURE create_deposit(
  acc_id IN NUMBER, val IN NUMBER
)
IS
BEGIN
  INSERT INTO ACCOUNT_TRANSACTION(amount,account,status,transaction_type,transaction_date)
    VALUES (val
      ,acc_id
      ,(SELECT MIN(trans_status_id) FROM ADMIN.ACCOUNT_TRANSACTION_STATUS WHERE ADMIN.ACCOUNT_TRANSACTION_STATUS.label = 'Approved')
      ,(SELECT MIN(trans_type_id) FROM ADMIN.ACCOUNT_TRANSACTION_TYPE WHERE ADMIN.ACCOUNT_TRANSACTION_TYPE.label = 'Deposit')
      , CURRENT_TIMESTAMP
      );
  UPDATE ACCOUNT SET balance = (SELECT MIN(balance) FROM ACCOUNT WHERE account_id = acc_id) + val WHERE account_id = acc_id;
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE create_withdraw(
  acc_id IN NUMBER, val IN NUMBER
)
IS
BEGIN
  INSERT INTO ACCOUNT_TRANSACTION(amount,account,status,transaction_type,transaction_date)
    VALUES (val
      ,acc_id
      ,(SELECT MIN(trans_status_id) FROM ADMIN.ACCOUNT_TRANSACTION_STATUS WHERE ADMIN.ACCOUNT_TRANSACTION_STATUS.label = 'Approved')
      ,(SELECT MIN(trans_type_id) FROM ADMIN.ACCOUNT_TRANSACTION_TYPE WHERE ADMIN.ACCOUNT_TRANSACTION_TYPE.label = 'Withdraw')
      , CURRENT_TIMESTAMP
      );
  UPDATE ACCOUNT SET balance = (SELECT MIN(balance) FROM ACCOUNT WHERE account_id = acc_id) - val WHERE account_id = acc_id;
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE create_transfer(
  acc_in_id IN NUMBER, acc_out_id IN NUMBER, val IN NUMBER
)
IS
BEGIN
  INSERT INTO ACCOUNT_TRANSACTION(amount,account,status,transaction_type,transaction_date)
    VALUES (val
      ,acc_in_id
      ,(SELECT MIN(trans_status_id) FROM ADMIN.ACCOUNT_TRANSACTION_STATUS WHERE ADMIN.ACCOUNT_TRANSACTION_STATUS.label = 'Approved')
      ,(SELECT MIN(trans_type_id) FROM ADMIN.ACCOUNT_TRANSACTION_TYPE WHERE ADMIN.ACCOUNT_TRANSACTION_TYPE.label = 'Transfer in')
      , CURRENT_TIMESTAMP
      );
  UPDATE ACCOUNT SET balance = (SELECT MIN(balance) FROM ACCOUNT WHERE account_id = acc_in_id) - val WHERE account_id = acc_in_id;
  INSERT INTO ACCOUNT_TRANSACTION(amount,account,status,transaction_type,transaction_date)
    VALUES (val
      ,acc_out_id
      ,(SELECT MIN(trans_status_id) FROM ADMIN.ACCOUNT_TRANSACTION_STATUS WHERE ADMIN.ACCOUNT_TRANSACTION_STATUS.label = 'Approved')
      ,(SELECT MIN(trans_type_id) FROM ADMIN.ACCOUNT_TRANSACTION_TYPE WHERE ADMIN.ACCOUNT_TRANSACTION_TYPE.label = 'Transfer out')
      , CURRENT_TIMESTAMP
      );
  UPDATE ACCOUNT SET balance = (SELECT MIN(balance) FROM ACCOUNT WHERE account_id = acc_out_id) + val WHERE account_id = acc_out_id;
  COMMIT;
END;
/

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
  interest NUMBER(6,5)
);

CREATE OR REPLACE PROCEDURE create_account_type(
  acc_type_id OUT NUMBER, new_label IN VARCHAR2, new_min_balance IN NUMBER, 
  new_interest IN NUMBER
)
IS
BEGIN
  SELECT MIN(account_type_id) INTO acc_type_id FROM ACCOUNT_TYPE WHERE ACCOUNT_TYPE.label = new_label 
  AND ACCOUNT_TYPE.min_balance = new_min_balance AND ACCOUNT_TYPE.interest = new_interest;
  if acc_type_id > 0
  THEN
    DBMS_OUTPUT.PUT_LINE(acc_type_id);
  ELSE
    INSERT INTO ACCOUNT_TYPE(label, min_balance, interest) 
      VALUES (new_label, new_min_balance, new_interest)
      RETURNING account_type_id 
        INTO acc_type_id;
    COMMIT;
  END IF;
END;
/

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
  address_label VARCHAR(100)
);

CREATE OR REPLACE PROCEDURE create_address(
  add_id IN OUT NUMBER, add_label IN VARCHAR2
)
IS
BEGIN
  SELECT MIN(address_id) INTO add_id FROM ADDRESS WHERE ADDRESS.address_label = add_label;
  IF add_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(add_id);
  ELSE
    INSERT INTO ADDRESS(address_label) 
      VALUES (add_label)
      RETURNING address_id 
        INTO add_id;
    COMMIT;
  END IF;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('ASSOCIATED_PEOPLE_JT');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE ASSOCIATED_PEOPLE_JT CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE ASSOCIATED_PEOPLE_JT (
  first_person NUMBER,
  second_person NUMBER
);

CREATE OR REPLACE PROCEDURE create_associated_people_jt(
  fir_person IN NUMBER, sec_person IN NUMBER, tmp_val OUT NUMBER
)
IS
BEGIN
  SELECT MIN(first_person) INTO tmp_val FROM ASSOCIATED_PEOPLE_JT 
    WHERE ASSOCIATED_PEOPLE_JT.first_person = fir_person 
    AND ASSOCIATED_PEOPLE_JT.second_person = sec_person;
  IF tmp_val > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(tmp_val);
  ELSE
    INSERT INTO ASSOCIATED_PEOPLE_JT(first_person, second_person) 
      VALUES (fir_person, sec_person);
    COMMIT;
  END IF;
END;
/

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
  city VARCHAR2(200),
  state VARCHAR2(2),
  zip NUMBER(5)
);

CREATE OR REPLACE PROCEDURE create_city(
  cit_id IN OUT NUMBER, cit_label IN VARCHAR2, cit_state IN VARCHAR2, cit_zip IN NUMBER
)
IS
BEGIN
  SELECT MIN(city_id) INTO cit_id FROM CITY WHERE CITY.city = cit_label 
  AND CITY.state = cit_state AND CITY.zip = cit_zip;
  IF cit_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(cit_id);
  ELSE
    INSERT INTO CITY(city, state, zip) 
      VALUES (cit_label, cit_state, cit_zip)
      RETURNING city_id 
        INTO cit_id;
    COMMIT;
  END IF;
END;
/

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

CREATE OR REPLACE PROCEDURE create_email(
  em_id IN OUT NUMBER, em_email IN VARCHAR2, em_person IN NUMBER
)
IS
BEGIN
  SELECT MIN(email_id) INTO em_id FROM EMAIL WHERE EMAIL.email = em_email 
  AND EMAIL.person = em_person;
  IF em_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(em_id);
  ELSE
    INSERT INTO EMAIL(email, person) 
      VALUES (em_email, em_person)
      RETURNING email_id 
        INTO em_id;
    COMMIT;
  END IF;
END;
/

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
  first_name VARCHAR2(100),
  last_name VARCHAR2(100),
  social_sec_num VARCHAR2(9),
  standing NUMBER,
  password VARCHAR2(1000),
  city NUMBER,
  address NUMBER,
  username VARCHAR2(100) UNIQUE
);

CREATE OR REPLACE PROCEDURE create_person(
  per_id IN OUT NUMBER, per_password IN VARCHAR2, per_username IN VARCHAR2
)
IS
BEGIN
  INSERT INTO PERSON(password, username) 
    VALUES (per_password, per_username)
    RETURNING person_id 
      INTO per_id;
  COMMIT;
END;
/

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

CREATE OR REPLACE PROCEDURE create_standing(
  stand_id IN OUT NUMBER, stand_label IN VARCHAR2
)
IS
BEGIN
  SELECT MIN(standing_id) INTO stand_id FROM PERSON_STANDING WHERE PERSON_STANDING.label = stand_label;
  IF stand_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(stand_id);
  ELSE
    INSERT INTO PERSON_STANDING(label) 
      VALUES (stand_label)
      RETURNING standing_id 
        INTO stand_id;
    COMMIT;
  END IF;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM user_tables WHERE table_name = upper('PERMISSION_RANK_JT');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP TABLE PERMISSION_RANK_JT CASCADE CONSTRAINTS';
   END IF;
END;
/

CREATE TABLE PERMISSION_RANK_JT (
  person NUMBER,
  permission_rank_label_id NUMBER
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
  permission_rank_label_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  label VARCHAR(100)
);

CREATE OR REPLACE PROCEDURE create_rank(
  rank_id IN OUT NUMBER, rank_label IN VARCHAR2
)
IS
BEGIN
  SELECT MIN(permission_rank_label_id) INTO rank_id FROM PERMISSION_RANK_LABEL WHERE PERMISSION_RANK_LABEL.label = rank_label;
  IF rank_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(rank_id);
  ELSE
    INSERT INTO PERMISSION_RANK_LABEL(label) 
      VALUES (rank_label)
      RETURNING permission_rank_label_id 
        INTO rank_id;
    COMMIT;
  END IF;
END;
/

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
  phone_num VARCHAR(20),
  person NUMBER
);

CREATE OR REPLACE PROCEDURE create_phone(
  phon_id IN OUT NUMBER, phone_numb IN VARCHAR2, phone_person IN NUMBER
)
IS
BEGIN
  SELECT MIN(phone_id) INTO phon_id FROM PHONE_NUMBER WHERE PHONE_NUMBER.phone_num = phone_numb AND PHONE_NUMBER.person = phone_person;
  IF phon_id > 0
  THEN
   DBMS_OUTPUT.PUT_LINE(phon_id);
  ELSE
    INSERT INTO PHONE_NUMBER(phone_num, person) 
      VALUES (phone_numb, phone_person)
      RETURNING phone_id 
        INTO phon_id;
    COMMIT;
  END IF;
END;
/

ALTER TABLE ACCOUNT 
  ADD CONSTRAINT ac_account_type
    FOREIGN KEY (ACCOUNT_TYPE)
    REFERENCES ACCOUNT_TYPE (account_type_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT
  ADD CONSTRAINT ac_check_bool
    CHECK (active <= 1 AND active >= 0)
;
ALTER TABLE ACCOUNT_OWNERSHIP_JT 
  ADD CONSTRAINT ao_owner
    FOREIGN KEY (owner)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_OWNERSHIP_JT 
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
ALTER TABLE ACCOUNT_REQUEST_USERS_JT
  ADD CONSTRAINT ar_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ACCOUNT_REQUEST_USERS_JT
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
ALTER TABLE ASSOCIATED_PEOPLE_JT
  ADD CONSTRAINT ap_first
    FOREIGN KEY (first_person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE ASSOCIATED_PEOPLE_JT
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
--ALTER TABLE PERSON
--  ADD CONSTRAINT pe_standing
--    FOREIGN KEY (standing)
--    REFERENCES PERSON_STANDING (standing_id)
--    ON DELETE SET NULL
--;
--ALTER TABLE PERSON
--  ADD CONSTRAINT pe_city
--    FOREIGN KEY (city)
--    REFERENCES CITY (city_id)
--    ON DELETE SET NULL
--;
--ALTER TABLE PERSON
--  ADD CONSTRAINT pe_address
--    FOREIGN KEY (address)
--    REFERENCES ADDRESS (address_id)
--    ON DELETE SET NULL
--;
ALTER TABLE PERMISSION_RANK_JT
  ADD CONSTRAINT pr_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;
ALTER TABLE PERMISSION_RANK_JT
  ADD CONSTRAINT pr_label
    FOREIGN KEY (permission_rank_label_id)
    REFERENCES PERMISSION_RANK_LABEL (permission_rank_label_id)
    ON DELETE SET NULL
;
ALTER TABLE PHONE_NUMBER
  ADD CONSTRAINT pn_person
    FOREIGN KEY (person)
    REFERENCES PERSON (person_id)
    ON DELETE SET NULL
;

DECLARE
  c int;
BEGIN
  create_rank(c,'Customer');
  create_rank(c,'Employee');
  create_rank(c,'Admin');
  create_standing(c,'Black List -5');
  create_standing(c,'Delinquent -3');
  create_standing(c,'Disrespectful -2');
  create_standing(c,'Untrustworthy -1');
  create_standing(c,'Unknown 0');
  create_standing(c,'Trustworthy 1');
  create_standing(c,'Respected 2');
  create_standing(c,'Honored 3');
  create_acc_tran_type(c,'Deposit');
  create_acc_tran_type(c,'Transfer in');
  create_acc_tran_type(c,'Transfer out');
  create_acc_tran_type(c,'Withdraw');
  create_acc_tran_status(c,'Pending');
  create_acc_tran_status(c,'Disputed');
  create_acc_tran_status(c,'Approved');
  create_acc_tran_status(c,'Rejected');
  create_account_type(c,'Checking',0,0.0005);
  create_account_type(c,'Savings',300,0.0015);
  create_account_type(c,'High Yield Savings',50000,0.0105);
  create_account_type(c,'Credit',-5000,0.0);
  COMMIT;
END;
/

DECLARE
   c int;
BEGIN
   SELECT count(*) INTO c FROM dba_users WHERE username  = upper('bank_connection');
   IF c = 1 then
      EXECUTE IMMEDIATE 'DROP USER bank_connection CASCADE';
   END IF;
END;
/
CREATE USER bank_connection IDENTIFIED BY a2v5iIl9vTqbTrziqB581Bt5iB0iqz;
GRANT CREATE SESSION TO bank_connection;
GRANT CREATE PROCEDURE TO bank_connection;
GRANT EXECUTE ON create_account TO bank_connection;
GRANT EXECUTE ON create_account_ownership_jt TO bank_connection;
GRANT EXECUTE ON create_account_request TO bank_connection;
GRANT EXECUTE ON create_acc_tran TO bank_connection;
GRANT EXECUTE ON create_acc_tran_status TO bank_connection;
GRANT EXECUTE ON create_acc_tran_type TO bank_connection;
GRANT EXECUTE ON create_account_type TO bank_connection;
GRANT EXECUTE ON create_account_req_users_jt TO bank_connection;
GRANT EXECUTE ON create_address TO bank_connection;
GRANT EXECUTE ON create_associated_people_jt TO bank_connection;
GRANT EXECUTE ON create_city TO bank_connection;
GRANT EXECUTE ON create_deposit TO bank_connection;
GRANT EXECUTE ON create_withdraw TO bank_connection;
GRANT EXECUTE ON create_transfer TO bank_connection;
GRANT EXECUTE ON create_email TO bank_connection;
GRANT EXECUTE ON create_person TO bank_connection;
GRANT EXECUTE ON create_standing TO bank_connection;
GRANT EXECUTE ON create_rank TO bank_connection;
GRANT EXECUTE ON create_phone TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_employees_jt TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_ownership_jt TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_request TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_request_users_jt TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_transaction TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_transaction_status TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_transaction_type TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.account_type TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.address TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.associated_people_jt TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.city TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.email TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.permission_rank_jt TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.permission_rank_label TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.person TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.person_standing TO bank_connection;
GRANT INSERT, SELECT, UPDATE, DELETE ON admin.phone_number TO bank_connection;
COMMIT;
--SELECT * FROM ACCOUNT;
--SELECT * FROM ACCOUNT WHERE account_id = (SELECT MAX(account_id) FROM ACCOUNT);
--SELECT MAX(account_id) FROM ACCOUNT;
--SELECT * FROM PERMISSION_RANK_LABEL;
--SELECT * FROM ACCOUNT;
--SELECT * FROM ACCOUNT_REQUEST_USERS_JT;
--SELECT * FROM ACCOUNT_TYPE;
--SELECT * FROM ACCOUNT_OWNERSHIP_JT;
--SELECT * FROM ASSOCIATED_PEOPLE_JT;
--DELETE FROM ASSOCIATED_PEOPLE_JT;
--SELECT * FROM PERMISSION_RANK_JT;
--SELECT * FROM PERSON;
--call create_withdraw(1111113,1500);
--SELECT * FROM ADMIN.PERMISSION_RANK_JT 
--  INNER JOIN ADMIN.PERMISSION_RANK_LABEL 
--  ON ADMIN.PERMISSION_RANK_JT.permission_rank_label_id = 
--  ADMIN.PERMISSION_RANK_LABEL.permission_rank_label_id 
--  WHERE ADMIN.PERMISSION_RANK_JT.person = 46;
--SELECT * FROM PERSON_STANDING;
--SELECT * FROM ACCOUNT_TYPE;
--SELECT second_person FROM ADMIN.ASSOCIATED_PEOPLE_JT WHERE first_person = 1;
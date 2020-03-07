DECLARE
  c int;
BEGIN
  create_address(c,'3080 Dutch Hollow Rd');
  create_address(c,'1600 Pennslavania Ave.');
  create_address(c,'100 Main Street');
  create_address(c,'300 East');
  create_address(c,'3080 Dutch Hollow Rd');
  create_address(c,'1600 Pennslavania Ave.');
  create_address(c,'100 Main Street');
  create_address(c,'300 East');
  create_address(c,'3080 Dutch Hollow Rd');
  create_address(c,'1600 Pennslavania Ave.');
  create_address(c,'100 Main Street');
  create_address(c,'300 East');
  create_acc_tran_status(c,'Approved');
  create_acc_tran_status(c,'Approved');
  create_acc_tran_status(c,'Approved');
  COMMIT;
END;
/
SELECT * FROM ADDRESS;
SELECT * FROM ACCOUNT_TRANSACTION_STATUS;



--
--Procedures
--
CREATE OR REPLACE PROCEDURE insert_into_person(
  emp_id OUT NUMBER, 
  emp_first IN VARCHAR2,
  emp_last IN VARCHAR2,
  emp_email VARCHAR2,
  emp_salary NUMBER,
  emp_title VARCHAR2
)
IS
BEGIN
  INSERT INTO EMPLOYEES(first_name, last_name, email, salary, title) 
    VALUES (emp_first, emp_last, emp_email, emp_salary, emp_title)
    RETURNING employee_id 
      INTO emp_id;
END;
/

CREATE OR REPLACE PROCEDURE insert_into_account(
  account_id OUT NUMBER, 
  account_owner IN NUMBER
)
IS
BEGIN
  INSERT INTO tmp_account(owner) 
    VALUES (account_owner)
    RETURNING id 
      INTO account_id;
END;
/

CREATE OR REPLACE PROCEDURE transfer_funds(
  source_id IN NUMBER, 
  target_id IN NUMBER, 
  amount IN NUMBER
)
IS
  source_balance NUMBER;
  target_balance NUMBER;
BEGIN
  SELECT (balance - amount) INTO source_balance FROM tmp_account
    WHERE tmp_account.id = source_id;
--  source_balance := source_balance - amount;
  SELECT (balance + amount) INTO target_balance FROM tmp_account
    WHERE tmp_account.id = target_id;
--  target_balance := target_balance + amount;
  UPDATE tmp_account SET balance = source_balance WHERE tmp_account.id = source_id;
  UPDATE tmp_account SET balance = target_balance WHERE tmp_account.id = target_id;
  COMMIT;
END;
/
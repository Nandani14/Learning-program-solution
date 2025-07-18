-- Run these if not already done
ALTER TABLE Loans ADD IsPaid CHAR(1);
ALTER TABLE Customers ADD CustomerStatus VARCHAR2(20);
-- Trigger to update customer status when a loan is marked as paid

CREATE OR REPLACE TRIGGER trg_update_status_on_payment
AFTER UPDATE OF IsPaid ON Loans
FOR EACH ROW
WHEN (NEW.IsPaid = 'Y')
BEGIN
    UPDATE Customers
    SET CustomerStatus = 'Cleared'
    WHERE CustomerID = :NEW.CustomerID;

    DBMS_OUTPUT.PUT_LINE('Customer status set to Cleared.');
END;
/
-- Mark a loan as paid (this should trigger the update)
UPDATE Loans
SET IsPaid = 'Y'
WHERE LoanID = 6001;


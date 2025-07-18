-- This trigger blocks any loan insert or update with amount > ₹1,00,000

CREATE OR REPLACE TRIGGER trg_prevent_large_loans
BEFORE INSERT OR UPDATE ON Loans
FOR EACH ROW
BEGIN
    IF :NEW.Amount > 100000 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Loan amount cannot exceed ₹1,00,000.');
    END IF;
END;
/
-- Try inserting a large loan (this should fail)
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (6002, 102, 150000, 9.0, SYSDATE + 180);


CREATE TABLE Loan_Log (
    LogID        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    LoanID       NUMBER,
    Action       VARCHAR2(20),
    LoggedAt     DATE
);
-- This trigger logs every loan insertion into the Loan_Log table

CREATE OR REPLACE TRIGGER trg_log_loan_insert
AFTER INSERT ON Loans
FOR EACH ROW
BEGIN
    INSERT INTO Loan_Log (LoanID, Action, LoggedAt)
    VALUES (:NEW.LoanID, 'INSERT', SYSDATE);
END;
/
-- Insert a loan to test the trigger
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (6001, 101, 15000, 7.5, SYSDATE + 365);


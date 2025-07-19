-- This script increases interest rate for overdue loans using a cursor

DECLARE
    CURSOR overdue_loans IS
        SELECT LoanID, InterestRate
        FROM Loans
        WHERE DueDate < SYSDATE;

    -- Temp variables
    v_LoanID       Loans.LoanID%TYPE;
    v_InterestRate Loans.InterestRate%TYPE;

BEGIN
    OPEN overdue_loans;

    LOOP
        FETCH overdue_loans INTO v_LoanID, v_InterestRate;
        EXIT WHEN overdue_loans%NOTFOUND;

        -- Increase interest rate by 0.5%
        UPDATE Loans
        SET InterestRate = v_InterestRate + 0.5
        WHERE LoanID = v_LoanID;

        DBMS_OUTPUT.PUT_LINE('Updated interest rate for Loan ID: ' || v_LoanID);
    END LOOP;

    CLOSE overdue_loans;
END;
/


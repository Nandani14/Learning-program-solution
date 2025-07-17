-- This block inserts a loan and handles invalid (zero or negative) amounts.

DECLARE
    v_LoanID     NUMBER := 5001;
    v_CustomerID NUMBER := 101;
    v_Amount     NUMBER := -5000;  -- Try changing this to 0 or positive
    v_Rate       NUMBER := 8.5;
    v_DueDate    DATE   := SYSDATE + 365;

BEGIN
    -- ✅ Check if the amount is valid
    IF v_Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Loan amount must be greater than zero.');
    END IF;

    -- ✅ If valid, insert the loan
    INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
    VALUES (v_LoanID, v_CustomerID, v_Amount, v_Rate, v_DueDate);

    DBMS_OUTPUT.PUT_LINE('Loan added successfully.');

-- ✅ Exception Handling
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


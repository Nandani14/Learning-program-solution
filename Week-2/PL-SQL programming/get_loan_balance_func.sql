CREATE OR REPLACE FUNCTION GetLoanBalance(p_LoanID IN NUMBER)
RETURN NUMBER
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Loans
    WHERE LoanID = p_LoanID;

    RETURN v_Balance;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Loan not found.');
        RETURN NULL;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        RETURN NULL;
END;
/


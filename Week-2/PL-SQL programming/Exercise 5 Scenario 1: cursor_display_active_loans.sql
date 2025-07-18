-- Cursor to loop through customers with unpaid loans
DECLARE
    CURSOR active_loans_cursor IS
        SELECT c.CustomerID, c.Name, l.LoanID, l.Amount
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.IsPaid = 'N';

    -- Temporary variables to hold each row's data
    v_CustomerID Customers.CustomerID%TYPE;
    v_Name       Customers.Name%TYPE;
    v_LoanID     Loans.LoanID%TYPE;
    v_Amount     Loans.Amount%TYPE;

BEGIN
    OPEN active_loans_cursor;

    LOOP
        FETCH active_loans_cursor INTO v_CustomerID, v_Name, v_LoanID, v_Amount;
        EXIT WHEN active_loans_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_Name || 
            ' | Loan ID: ' || v_LoanID || 
            ' | Amount: ₹' || v_Amount
        );
    END LOOP;

    CLOSE active_loans_cursor;
END;
/


-- This block prints total loan amount for each customer using a cursor

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Name
        FROM Customers;

    -- Variables to hold customer info and total
    v_CustomerID Customers.CustomerID%TYPE;
    v_Name       Customers.Name%TYPE;
    v_TotalLoan  NUMBER;

BEGIN
    FOR cust IN customer_cursor LOOP
        -- Calculate total loan amount for this customer
        SELECT NVL(SUM(Amount), 0)
        INTO v_TotalLoan
        FROM Loans
        WHERE CustomerID = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || cust.Name || 
            ' | Total Loan Amount: ₹' || v_TotalLoan
        );
    END LOOP;
END;
/


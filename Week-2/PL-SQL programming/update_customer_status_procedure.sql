-- This procedure checks the loan balance of each customer.
-- If the balance is less than 5000, it marks the customer as 'Good'.
-- Otherwise, it marks them as 'Review'.

CREATE OR REPLACE PROCEDURE UpdateCustomerStatus IS

    -- Cursor to fetch customer IDs and their loan balances
    CURSOR customer_loans IS
        SELECT Customers.CustomerID, Loans.Balance
        FROM Customers
        JOIN Loans ON Customers.CustomerID = Loans.CustomerID;

BEGIN
    -- Loop through each customer and check their loan balance
    FOR cust IN customer_loans LOOP
        IF cust.Balance < 5000 THEN
            UPDATE Customers
            SET CustomerStatus = 'Good'
            WHERE CustomerID = cust.CustomerID;
        ELSE
            UPDATE Customers
            SET CustomerStatus = 'Review'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Customer statuses have been updated.');
END;
/

-- 🧪 Example usage of the procedure:
BEGIN
    UpdateCustomerStatus;
END;
/


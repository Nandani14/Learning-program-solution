BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/


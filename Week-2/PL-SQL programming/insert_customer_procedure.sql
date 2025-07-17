CREATE OR REPLACE PROCEDURE InsertCustomer(
    p_Name     IN VARCHAR2,
    p_DOB      IN DATE,
    p_Balance  IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance)
    VALUES (Customers_seq.NEXTVAL, p_Name, p_DOB, p_Balance);

    DBMS_OUTPUT.PUT_LINE('New customer added: ' || p_Name);
END;
/


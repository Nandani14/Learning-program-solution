-- Assumption:
-- Make sure the Email column is unique to prevent duplicate entries.
-- This block creates a unique index on the Email column (only run once).
BEGIN
    EXECUTE IMMEDIATE 'CREATE UNIQUE INDEX idx_email_unique ON Customers(Email)';
    DBMS_OUTPUT.PUT_LINE('Unique index created on Email column.');
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE = -955 THEN
            DBMS_OUTPUT.PUT_LINE('Index already exists. Continuing...');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Unexpected error while creating index: ' || SQLERRM);
        END IF;
END;
/
---- try inserting a customer with a duplicate email
BEGIN
    INSERT INTO Customers (CustomerID, Name, Email, DOB, Balance)
    VALUES (
        Customers_seq.NEXTVAL,
        'Shikha',
        'shikha@example.com',
        TO_DATE('2001-04-05', 'YYYY-MM-DD'),
        9000
    );

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

--  Handle duplicate email error
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: This email is already registered.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Some other error occurred: ' || SQLERRM);
END;
/


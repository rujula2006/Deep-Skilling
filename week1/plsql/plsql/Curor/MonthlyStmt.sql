SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name,
               t.TransactionID,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
        ON c.CustomerID = a.CustomerID
        JOIN Transactions t
        ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) =
              EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) =
              EXTRACT(YEAR FROM SYSDATE);

    v_name Customers.Name%TYPE;
    v_transactionid Transactions.TransactionID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
        INTO v_name, v_transactionid, v_amount, v_type;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_name ||
            ', Transaction ID: ' || v_transactionid ||
            ', Amount: ' || v_amount ||
            ', Type: ' || v_type
        );
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;

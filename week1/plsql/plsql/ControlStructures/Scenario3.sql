SET SERVEROUTPUT ON;

DECLARE
    CURSOR c1 IS
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Customers c, Loans l
        WHERE c.CustomerID = l.CustomerID
        AND l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c1 LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID '
            || rec.LoanID
            || ' for customer '
            || rec.Name
            || ' is due on '
            || rec.EndDate
        );
    END LOOP;
END;

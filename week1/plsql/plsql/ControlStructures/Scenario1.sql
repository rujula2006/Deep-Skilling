DECLARE
    CURSOR c1 IS
        SELECT c.CustomerID, c.DOB
        FROM Customers c;

    v_age NUMBER;
BEGIN
    FOR rec IN c1 LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;

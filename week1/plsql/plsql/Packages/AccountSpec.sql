CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid NUMBER,
        p_customerid NUMBER,
        p_accounttype VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountid NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerid NUMBER
    ) RETURN NUMBER;

END AccountOperations;

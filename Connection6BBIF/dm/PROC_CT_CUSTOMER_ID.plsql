Create or Replace Procedure Proc_CT_Customer IS V_CNT NUMBER;
BEGIN
            Select count(*) INTO V_CNT
            from ALL_TABLES
            WHERE OWNER = 'DEMO' AND
            TABLE_NAME = 'CUSTOMER'; 
            
          
            IF V_CNT = 0 THEN 
                EXECUTE IMMEDIATE  'CREATE TABLE CUSTOMER
                (
Customer_ID INTEGER,
EMAIL Varchar(45),
FirstName Varchar(40),
LastName Varchar(40),
Gender Varchar(20),
Birthdate DATE,
Credits Decimal(4.0)
)';
COMMIT;
END IF;


SELECT COUNT(*) INTO V_CNT
FROM ALL_SEQUENCES
WHERE SEQUENCE_OWNER = 'DEMO' AND SEQUENCE_NAME = 'SEQ_CUSTOMER_ID';
IF V_CNT = 0 THEN EXECUTE IMMEDIATE 
'Create SEQUENCE SEQ_CUSTOMER_ID 
START WITH 10000
INCREMENT BY 1 
CACHE 50';
COMMIT;
END IF;
End Proc_CT_Customer;
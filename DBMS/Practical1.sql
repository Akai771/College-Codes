-- Practical 1
-- Partitioning: Range, List, Hash Partitioning

-- Range Partitioning: divides a table into partitions based on a range of values for a specified column.
CREATE TABLE Transaction1 (cust_id number(5), trans_id number(5), trans_date Date, trans_amount number(10))
PARTITION BY RANGE(cust_id) (
	PARTITION p1 VALUES LESS THAN (103),
	PARTITION p2 VALUES LESS THAN (105),
	PARTITION p3 VALUES LESS THAN (MAXVALUE)
); -- creates 3 partitions based on cust_id ranges

INSERT INTO Transaction1 VALUES (101, 1, TO_DATE('2023-10-21', 'YYYY-MM-DD'), 1000); -- goes to p1
INSERT INTO Transaction1 VALUES (104, 2, TO_DATE('2023-10-22', 'YYYY-MM-DD'), 2000); -- goes to p2
INSERT INTO Transaction1 VALUES (106, 3, TO_DATE('2023-10-23', 'YYYY-MM-DD'), 3000); -- goes to p3

-- List Partitioning: divides a table into partitions based on a list of values for a specified column.
CREATE TABLE Transaction2 (cust_id number(5), trans_id number(5), trans_date Date, trans_amount number(10))
PARTITION BY LIST(cust_id) (
	PARTITION p1 VALUES (101, 102),
	PARTITION p2 VALUES (103, 104),
	PARTITION p3 VALUES (105, 106)
); -- creates 3 partitions based on cust_id values

INSERT INTO Transaction2 VALUES (101, 4, TO_DATE('2023-10-21', 'YYYY-MM-DD'), 1500); -- goes to p1
INSERT INTO Transaction2 VALUES (103, 5, TO_DATE('2023-10-22', 'YYYY-MM-DD'), 2500); -- goes to p2
INSERT INTO Transaction2 VALUES (105, 6, TO_DATE('2023-10-23', 'YYYY-MM-DD'), 3500); -- goes to p3
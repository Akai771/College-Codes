-- Practical 2

-- Hash Partitioning: distributes data across a predefined number of partitions based on a hash function applied to a specified column.
CREATE TABLE Transaction (cust_id number(5), trans_id number(5), trans_date Date, trans_amount number(10))
PARTITION BY HASH(cust_id)(
	PARTITION p1,
	PARTITION p2,
	PARTITION p3
); -- creates 3 partitions based on hash value of cust_id

INSERT INTO Transaction VALUES (101, 10, TO_DATE('2023-10-22', 'YYYY-MM-DD'), 2000); -- goes to p1
INSERT INTO Transaction VALUES (101, 11, TO_DATE('2023-10-23', 'YYYY-MM-DD'), 3000); -- goes to p2
INSERT INTO Transaction VALUES (102, 12, TO_DATE('2023-10-24', 'YYYY-MM-DD'), 4000); -- goes to p3


-- Analytical Queries: Ranking functions, Rollup(), Lag() functions
create table employee2 ( eno number(5), ename varchar2(15), job varchar2(15), sal number(8), depname varchar2(15));

insert into employee2 values (101, 'seema', 'account', 30000, 'finance');
insert into employee2 values (102, 'neha', 'account', 35000, 'finance');
insert into employee2 values (104, 'reema', 'teacher', 45000, 'academic');
insert into employee2 values (105, 'rhea', 'developer', 45000, 'development');
insert into employee2 values (106, 'jaya', 'clerk', 42000, 'admin');

-- Row_number(), Rank(), Dense_Rank(): to assign a unique number to each row in the result set of a query based on the order specified in the over() clause
select eno, job, sal, row_number() over(order by sal) from employee2; -- gives unique number to each row
select eno, job, sal, row_number() over(order by sal) RANK from employee2; -- gives unique number to each row
select eno, job, sal, rank() over(order by sal) RANK from employee2; -- gives same rank to same salary but leaves gap in ranking
select eno, job, sal, dense_rank() over(order by sal) RANK from employee2; -- gives same rank to same salary but does not leaves gap in ranking
select eno, job, sal, dense_rank() over(partition by job order by sal) RANK from employee2; -- gives same rank to same salary in each job but does not leaves gap in ranking
select eno, job, sal, dense_rank() over(partition by job order by sal desc) RANK from employee2; -- gives same rank to same salary in each job but does not leaves gap in ranking
select eno, job, sal, dense_rank() over(order by sal desc) RANK from employee2; -- gives same rank to same salary but does not leaves gap in ranking


-- Rollup(): hierarchical grouping of data in multiple levels of aggregation in a single query without using multiple group by queries
create table frid( empId number(5), ename varchar2(15), depname varchar2(15), salary number(10), gender varchar2(8));

insert into  frid values(1011, 'seema', 'development', 35000, 'female');
insert into  frid values(1012, 'reema', 'development', 45000, 'female');
insert into  frid values(1023, 'neha', 'quality control', 40000, 'female');
insert into  frid values(1024, 'rahul', 'quality control', 42000, 'male');
insert into  frid values(1035, 'vedant', 'support', 25000, 'male');
insert into  frid values(1035, 'kshitij', 'support', 35000, 'male');

select sum(salary) from frid; -- total salary
select depname, sum(salary) from frid group by depname; -- total salary by department
select depname, sum(salary) from frid group by rollup(depname); -- total salary by department with grand total
select depname, gender, sum(salary) from frid group by rollup(depname, gender); -- total salary by department and gender with grand total

-- lag() : access data from previous row in the same result set without using self join
select ename, salary, lag(salary) over(order by salary desc) as prev_sal from frid; -- previous salary
select ename, salary, lag(salary,1) over(order by salary desc) as prev_sal from frid; -- previous salary
select ename, salary, lag(salary,2) over(order by salary desc) as prev_sal from frid; -- salary before previous salary
select ename, salary, lag(salary,1,0) over(order by salary desc) as prev_sal from frid; -- previous salary with default value 0

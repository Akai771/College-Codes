-- Practical 2

-- Hash Partitioning
CREATE TABLE Transaction(cust_id number(5), trans_id number(5), trans_date Date, trans_amount number(10))
PARTITION BY HASH(cust_id)(
	PARTITION p1,
	PARTITION p2,
	PARTITION p3
);

INSERT INTO Transaction VALUES (101, 11, TO_DATE('2023-10-23', 'YYYY-MM-DD'), 3000);
INSERT INTO Transaction VALUES (102, 12, TO_DATE('2023-10-24', 'YYYY-MM-DD'), 4000);


-- Analytical Queries
create table employee ( eno number(5), ename varchar2(15), job varchar2(15), sal number(8), depname varchar2(15));

insert into employee values (101, 'seema', 'account', 30000, 'finance');
insert into employee values (102, 'neha', 'account', 35000, 'finance');
insert into employee values (104, 'reema', 'teacher', 45000, 'academic');
insert into employee values (105, 'rhea', 'developer', 45000, 'development');
insert into employee values (106, 'jaya', 'clerk', 42000, 'admin');

select eno, job, sal, row_number() over(order by sal) from employee;
select eno, job, sal, row_number() over(order by sal) RANK from employee;
select eno, job, sal, rank() over(order by sal) RANK from employee;
select eno, job, sal, dense_rank() over(order by sal) RANK from employee;
select eno, job, sal, dense_rank() over(partition by job order by sal) RANK from employee;
select eno, job, sal, dense_rank() over(partition by job order by sal desc) RANK from employee;
select eno, job, sal, dense_rank() over(order by sal desc) RANK from employee;


-- Rollup():
create table frid( empId number(5), ename varchar2(15), depname varchar2(15), salary number(10), gender varchar2(8));

insert into  frid values(1011, 'seema', 'development', 35000, 'female');
insert into  frid values(1012, 'reema', 'development', 45000, 'female');
insert into  frid values(1023, 'neha', 'quality control', 40000, 'female');
insert into  frid values(1024, 'rahul', 'quality control', 42000, 'male');
insert into  frid values(1035, 'vedant', 'support', 25000, 'male');
insert into  frid values(1035, 'kshitij', 'support', 35000, 'male');

select sum(salary) from frid;
select depname, sum(salary) from frid group by depname;
select depname, sum(salary) from frid group by rollup(depname);
select depname, gender, sum(salary) from frid group by rollup(depname, gender);

-- lag()
select ename, salary, lag(salary) over(order by salary desc) as prev_sal from frid;
select ename, salary, lag(salary,1) over(order by salary desc) as prev_sal from frid;
select ename, salary, lag(salary,2) over(order by salary desc) as prev_sal from frid;
select ename, salary, lag(salary,1,0) over(order by salary desc) as prev_sal from frid;

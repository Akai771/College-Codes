-- Practical 3

create table employee1(empid number(8), empname varchar2(5),dept_name varchar2(15),salary number(10),gender varchar2(10));

insert into employee1 values(101,'reema','testing',45000,'female'); 
insert into employee1 values(102,'seema','testing',46000,'female'); 
insert into employee1 values(103,'heema','support',38000,'female'); 
insert into employee1 values(104,'tom','support',30000,'male'); 
insert into employee1 values(105,'eva','develop',40000,'female'); 
insert into employee1 values(106,'rohit','develop',20000,'male'); 

-- lag() : access data from previous row in the same result set without using self join
select empname, dept_name, salary, lag(salary) over(order by salary) from employee1; -- previous salary
select empname, dept_name, salary, lag(salary) over(order by salary) as prev_sal from employee1; -- previous salary
select empname, salary, lag(salary,1) over(order by salary) as prev_sal from employee1; -- previous salary
select empname, salary, lag(salary,1) over(order by salary desc) as prev_sal from employee1; -- previous salary in descending order
select empname, salary, lag(salary,1,0) over(order by salary) as prev_sal from employee1; -- previous salary with default value 0
select empname, salary, lag(salary,2,0) over(order by salary) as prev_sal from employee1; -- salary before previous salary with default value 0 
select empname,dept_name, salary, lag(salary,1,0) over(partition by dept_name order by salary) as prev_sal from employee1; -- previous salary in each department with default value 0

-- lead(): access data from next row in the same result set without using self join 
select empname, salary, lead(salary) over(order by salary) from employee1; -- next salary
select empname, salary, lead(salary,1,0) over(order by salary) from employee1; -- next salary with default value 0
select empname, salary, lead(salary,1,0) over(order by salary) as next_sal from employee1; -- next salary with default value 0
select empname,dept_name ,salary, lead(salary) over(order by salary) as next_sal from employee1; -- next salary
select empname,dept_name ,salary, lead(salary,1,0) over(order by salary) as next_sal from employee1; -- next salary with default value 0

-- first value(): access first value in the ordered set without using self join
select empname,salary,first_value(empname) over (order by salary) from employee1; -- lowest salary employee
select empname,salary,first_value(empname) over (order by salary) as lowest_sal_emp from employee1; -- lowest salary employee
select empname,dept_name,salary,first_value(empname) over (partition by dept_name order by salary) as lowest_sal_emp from employee1; -- lowest salary employee in each department

-- last value(): access last value in the ordered set without using self join
select empname,salary,last_value(empname) over (order by salary) as lowest_sal_emp from employee1; -- highest salary employee
select empname,dept_name,salary,last_value(empname) over (partition by dept_name order by salary) as lowest_sal_emp from employee1; -- highest salary employee in each department

-- inserting clause(): to define the window frame for the analytic function 
select empname,dept_name,salary,last_value(empname) over (order by salary rows between unbounded preceding and current row) as lowest_sal_emp from employee1; -- lowest salary employee
select empname,dept_name,salary,last_value(empname) over (order by salary rows between unbounded preceding and unbounded following) as lowest_sal_emp from employee1; -- highest salary employee 

-- keep(dense_rank first/last order by): to get the first/last value of a column based on the order specified in the order by clause
select empid,empname,dept_name,salary,min(salary) keep(dense_rank first order by salary) over(partition by dept_name) as lowest from employee1; -- lowest salary in each department
select empid,empname,dept_name,salary,min(salary) keep(dense_rank last order by salary) over(partition by dept_name) as highest from employee1; -- highest salary in each department
select empid,empname,dept_name,salary,min(salary) keep(dense_rank first order by salary) over(partition by dept_name) as lowest, max(salary) keep(dense_rank last order by salary) over(partition by dept_name) as highest from employee1; -- lowest and highest salary in each department

-- NTILE(): distributes the rows in an ordered partition into a specified number of approximately equal groups, or tiles.
select empname, salary, NTILE(2) over(order by salary) from employee1; -- divides the rows into 2 groups
select empname, salary, NTILE(2) over(order by salary) "RANK" from employee1; -- divides the rows into 2 groups
select empname, salary, NTILE(3) over(order by salary) "RANK" from employee1; -- divides the rows into 3 groups
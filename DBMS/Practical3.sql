-- Practical 4

create table employee1(empid number(8), empname varchar2(5),dept_name varchar2(15),salary number(10),gender varchar2(10));

insert into employee1 values(101,'reema','testing',45000,'female'); 
insert into employee1 values(102,'seema','testing',46000,'female'); 
insert into employee1 values(103,'heema','support',38000,'female'); 
insert into employee1 values(104,'tom','support',30000,'male'); 
insert into employee1 values(105,'eva','develop',40000,'female'); 
insert into employee1 values(106,'rohit','develop',20000,'male'); 

-- lag()
select empname, dept_name, salary, lag(salary) over(order by salary) from employee1;
select empname, dept_name, salary, lag(salary) over(order by salary) as prev_sal from employee1;
select empname, salary, lag(salary,1) over(order by salary) as prev_sal from employee1;
select empname, salary, lag(salary,1) over(order by salary desc) as prev_sal from employee1;
select empname, salary, lag(salary,1,0) over(order by salary) as prev_sal from employee1;
select empname, salary, lag(salary,2,0) over(order by salary) as prev_sal from employee1;
select empname,dept_name, salary, lag(salary,1,0) over(partition by dept_name order by salary) as prev_sal from employee1;

-- lead()
select empname, salary, lead(salary) over(order by salary) from employee1;
select empname, salary, lead(salary,1,0) over(order by salary) from employee1;
select empname, salary, lead(salary,1,0) over(order by salary) as next_sal from employee1;
select empname,dept_name ,salary, lead(salary) over(order by salary) as next_sal from employee1;
select empname,dept_name ,salary, lead(salary,1,0) over(order by salary) as next_sal from employee1;

-- first value()
select empname,salary,first_value(empname) over (order by salary) from employee1;
select empname,salary,first_value(empname) over (order by salary) as lowest_sal_emp from employee1;
select empname,dept_name,salary,first_value(empname) over (partition by dept_name order by salary) as lowest_sal_emp from employee1;

-- last value()
select empname,salary,last_value(empname) over (order by salary) as lowest_sal_emp from employee1;
select empname,dept_name,salary,last_value(empname) over (partition by dept_name order by salary) as lowest_sal_emp from employee1;

-- inserting clause()
select empname,dept_name,salary,last_value(empname) over (order by salary rows between unbounded preceding and current row) as lowest_sal_emp from employee1;
select empname,dept_name,salary,last_value(empname) over (order by salary rows between unbounded preceding and unbounded following) as lowest_sal_emp from employee1;
select empid,empname,dept_name,salary,min(salary) keep(dense_rank first order by salary) over(partition by dept_name) as lowest from employee1;
select empid,empname,dept_name,salary,min(salary) keep(dense_rank first order by salary) over(partition by dept_name) as lowest,max(salary) keep(dense_rank last order by salary) over(partition by dept_name) as highest from employee1;

-- NTILE()
select empname, salary, NTILE(2) over(order by salary) from employee1;
select empname, salary, NTILE(2) over(order by salary) "RANK" from employee1;
select empname, salary, NTILE(3) over(order by salary) "RANK" from employee1;
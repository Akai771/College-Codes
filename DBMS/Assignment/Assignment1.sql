Q1] Prepare following two vectors for following data:
A) # Values of salary in $
45, 89, 64.78, 39, 45, 92, 28, 57, 85
B) # Values of experience
4, 7, 2, 9, 10, 12, 5, 8, 11, 5
# Values of age
33, 43, 42, 29, 35, 30, 40, 41, 51, 47

Implement and analyze Multiple Regression Through graphical methods

Query:
> dataf<-data.frame(salary<-c(45, 89, 64, 78, 39, 45, 92, 28, 57, 85), 
experience<-c(4, 7, 2, 9, 10, 12, 5, 8, 11, 5), 
age<-c(33, 43, 42, 29, 35, 30, 40, 41, 51, 47))

>dataf
>plot(dataf$salary,dataf$age)
>plot(dataf$experience,dataf$age)
>plot(dataf)


Q2] 1) Create type Address with fields (street, city and pincode)
2) Create type Name with fields (Fname, Mname and Lname)
3) Create table Student with its 2 fields std_id, std_name, phone_no, along with the ADT address and Name
4) Insert 8 records in student table
5) Display the list of students who are staying in the Mumbai city.
6) Display Fname and Lname of all students.

Query:
> create type AddressOl as object(street varchar2(20), city varchar2(20), pincode number);
Output: Type created.

> create type NameOl as object(Fname varchar2(20), Mname varchar2(20), Lname varchar2(20));
Output: Type created.

> create table StudentOl(std_id number, std_name NameOl, phone_no number, std_address AddressOl);
Output: Table created.

> insert into StudentOl values(1, NameOl('Amit', 'Kumar', 'Shah'), 9876543210, AddressOl('MG Road', 'Mumbai', 400001));
Output: 1 row created.

> insert into StudentOl values(2, NameOl('Ravi', 'Singh', 'Yadav'), 8765432109, AddressOl('Brigade Road', 'Bangalore', 560001));
Output: 1 row created.

> insert into StudentOl values(3, NameOl('Sonal', 'Patel', 'Desai'), 7654321098, AddressOl('Linking Road', 'Mumbai', 400002));
Output: 1 row created.

> insert into StudentOl values(4, NameOl('Neha', 'Gupta', 'Sharma'), 6543210987, AddressOl('Park Street', 'Kolkata', 700001));
Output: 1 row created.

> insert into StudentOl values(5, NameOl('Aakash', 'Raj', 'Mehta'), 5432109876, AddressOl('MG Road', 'Mumbai', 400003));
Output: 1 row created.

> insert into StudentOl values(6, NameOl('Priya', 'Kaur', 'Singh'), 4321098765, AddressOl('Connaught Place', 'Delhi', 110001));
Output: 1 row created.

> insert into StudentOl values(7, NameOl('Vikram', 'Chopra', 'Malhotra'), 3210987654, AddressOl('Marine Drive', 'Mumbai', 400004));
Output: 1 row created.

> insert into StudentOl values(8, NameOl('Anjali', 'Verma', 'Joshi'), 2109876543, AddressOl('MG Road', 'Pune', 411001));
Output: 1 row created.

> select * from StudentOl where std_address.city='Mumbai';
Output:
STD_ID  STD_NAME(FNAME,MNAME,LNAME)        PHONE_NO   STD_ADDRESS(STREET,CITY, PINCODE)
1       Amit,Kumar,Shah                     9876543210 MG Road,Mumbai,400001
3       Sonal,Patel,Desai                   7654321098 Linking Road,Mumbai,400002
5       Aakash,Raj,Mehta                    5432109876 MG Road,Mumbai,400003
7       Vikram,Chopra,Malhotra              3210987654 Marine Drive,Mumbai,400004

> select std_name.Fname, std_name.Lname from StudentOl;
Output:
FNAME      LNAME
Amit       Shah
Ravi       Yadav
Sonal      Desai
Neha       Sharma
Aakash     Mehta
Priya      Singh
Vikram     Malhotra
Anjali     Joshi

Q3]	
1.	Create table “Sales” with attributes sid, pid, salesamt, profit and location by partitioning using list partition on location.
2.	Create 3 partition on location 
3.	Display the total profit of the location “Mumbai”. Merge any two partitions.
4.	Split the merged partition

Query:
> create table SalesOl(sid number, pid number, salesamt number, profit number, location varchar2(20))
partition by list(location)(
partition p_Mumbai values('Mumbai'),
partition p_Bangalore values('Bangalore'),
partition p_Delhi values('Delhi'));

Output: Table created.

> insert into SalesOl values(1, 101, 5000, 500, 'Mumbai');
Output: 1 row created.

> insert into SalesOl values(2, 102, 7000, 700, 'Bangalore');
Output: 1 row created.

> insert into SalesOl values(3, 103, 6000, 600, 'Delhi');
Output: 1 row created.

> insert into SalesOl values(4, 104, 8000, 800, 'Mumbai');
Output: 1 row created.

> insert into SalesOl values(5, 105, 9000, 900, 'Bangalore');
Output: 1 row created.

> insert into SalesOl values(6, 106, 4000, 400, 'Delhi');
Output: 1 row created.

> select sum(profit) as Total_Profit from SalesOl where location='Mumbai';
Output:
TOTAL_PROFIT
1300

> alter table SalesOl merge partition p_Bangalore and partition p_Delhi into partition p_BangDelhi;
Output: Table altered.

> alter table SalesOl split partition p_BangDelhi into
(partition p_Bangalore values('Bangalore'),
 partition p_Delhi values('Delhi'));
Output: Table altered.

Q4]	
1. Create a folder name “RPractical” in your home directory /C:drive.
2. Set the working directory to this folder.
3. Create a vector with the values(“B”, “AB”, “O”, “A”, “B”, “O”, “A”, “AB”, “O”, “A”)
4. Convert the above vector into factor type.
5. Check and display the created factor.

Query:
> dir.create("C:/RPractical")
> setwd("C:/RPractical")
> getwd()
Output: [1] "C:/RPractical"

> bld_grp<-c("B", "AB", "O", "A", "B", "O", "A", "AB", "O", "A")
> bld_factor<-factor(bld_grp)
> bld_factor
Output:
[1] B   AB  O   A   B   O   A   AB  O   A
Levels: A AB B O

Q5]	
Create the Customer table with attributes Cust_no, Cust_name, Salary, Commission, DOB, Dep_no (10,20,30)
1.	Insert 10 records.
2.	Demonstrate Roll_Up, Cube, First, Last, Lead and Lag functions.

> create table CustomerOl(Cust_no number, Cust_name varchar2(20), Salary number, Commission number, DOB date, Dep_no number);
Output: Table created.

> insert into CustomerOl values(1, 'Amit', 50000, 5000, to_date('1990-01-01', 'YYYY-MM-DD'), 10);
Output: 1 row created.

> insert into CustomerOl values(2, 'Ravi', 60000, 6000, to_date('1989-02-02', 'YYYY-MM-DD'), 20);
Output: 1 row created.

> insert into CustomerOl values(3, 'Sonal', 55000, 5500, to_date('1991-03-03', 'YYYY-MM-DD'), 30);
Output: 1 row created.

> insert into CustomerOl values(4, 'Neha', 70000, 7000, to_date('1988-04-04', 'YYYY-MM-DD'), 10);
Output: 1 row created.

> insert into CustomerOl values(5, 'Aakash', 65000, 6500, to_date('1992-05-05', 'YYYY-MM-DD'), 20);
Output: 1 row created.

> insert into CustomerOl values(6, 'Priya', 72000, 7200, to_date('1987-06-06', 'YYYY-MM-DD'), 30);
Output: 1 row created.

> insert into CustomerOl values(7, 'Vikram', 48000, 4800, to_date('1993-07-07', 'YYYY-MM-DD'), 10);
Output: 1 row created.

> insert into CustomerOl values(8, 'Anjali', 53000, 5300, to_date('1994-08-08', 'YYYY-MM-DD'), 20);
Output: 1 row created.

> insert into CustomerOl values(9, 'Rahul', 59000, 5900, to_date('1990-09-09', 'YYYY-MM-DD'), 30);
Output: 1 row created.

> insert into CustomerOl values(10, 'Sneha', 61000, 6100, to_date('1989-10-10', 'YYYY-MM-DD'), 10);
Output: 1 row created.

> select Dep_no, sum(Salary) as Total_Salary from CustomerOl group by Dep_no with rollup;
Output:
DEP_NO  TOTAL_SALARY
10      181000
20      178000
30      174000
NULL    533000

> select Dep_no, sum(Salary) as Total_Salary from CustomerOl group by Dep_no with cube;
Output:
DEP_NO  TOTAL_SALARY
10      181000
20      178000
30      174000
NULL    533000

> select Cust_no, Cust_name, Salary,
first_value(Salary) over (order by Cust_no) as First_Salary,
last_value(Salary) over (order by Cust_no
rows between unbounded preceding and unbounded following) as Last_Salary
from CustomerOl;
Output:
CUST_NO CUST_NAME SALARY FIRST_SALARY LAST_SALARY
1       Amit      50000  50000        72000
2       Ravi      60000  50000        72000
3       Sonal     55000  50000        72000
4       Neha      70000  50000        72000
5       Aakash    65000  50000        72000
6       Priya     72000  50000        72000
7       Vikram    48000  50000        72000
8       Anjali    53000  50000        72000
9       Rahul     59000  50000        72000
10      Sneha     61000  50000        72000

> select Cust_no, Cust_name, Salary,
lead(Salary, 1) over (order by Cust_no) as Next_Salary,
lag(Salary, 1) over (order by Cust_no) as Previous_Salary
from CustomerOl;
Output:
CUST_NO CUST_NAME SALARY NEXT_SALARY PREVIOUS_SALARY
1       Amit      50000  60000        NULL
2       Ravi      60000  55000        50000
3       Sonal     55000  70000        60000
4       Neha      70000  65000        55000
5       Aakash    65000  72000        70000
6       Priya     72000  48000        65000
7       Vikram    48000  53000        72000
8       Anjali    53000  59000        48000
9       Rahul     59000  61000        53000
10      Sneha     61000  NULL         59000


Q6]	
1.	Create a folder named “RStudio_Practical” in your home directory /C:drive.
2.	Set the working directory to this folder.
3.	Create a vector with the values (4,5,6, NA,7,8, NA,9,10).
4.	Impute the mean and median in above vector.
5.	Display above created mean and median. 

Query:
> dir.create("C:/RStudio_Practical")
> setwd("C:/RStudio_Practical")
> getwd()
Output: [1] "C:/RStudio_Practical"

> vec<-c(4,5,6, NA,7,8, NA,9,10)
> mean_vec<-mean(vec, na.rm=TRUE)
> median_vec<-median(vec, na.rm=TRUE)
> mean_vec
Output: [1] 7
> median_vec
Output: [1] 7

Q7]
Create table Weather (wid, place, month, year, avg_temp) . Using Analytical Functions:
1.	Display rankwise hottest to coolest month placewise.
2.	Find the hottest and coolest month in every year.
3.	Find the second highest hottest month in every place.
4.	Display monthwise temperature using rollup function
5.	Display monthwise temperature using Cube function

Query:
> create table WeatherOl(wid number, place varchar2(20), month varchar2(20), year number, avg_temp number);
Output: Table created.

> insert into WeatherOl values(1, 'Mumbai', 'January', 2020, 25);
Output: 1 row created.
> insert into WeatherOl values(2, 'Mumbai', 'February', 2020, 27);
Output: 1 row created.
> insert into WeatherOl values(3, 'Mumbai', 'March', 2020, 30);
Output: 1 row created.
> insert into WeatherOl values(4, 'Delhi', 'January', 2020, 15);
Output: 1 row created.
> insert into WeatherOl values(5, 'Delhi', 'February', 2020, 20);
Output: 1 row created.
> insert into WeatherOl values(6, 'Delhi', 'March', 2020, 25);
Output: 1 row created.

> select place, month, avg_temp,
rank() over (partition by place order by avg_temp desc) as Temp_Rank from WeatherOl;
Output:
PLACE   MONTH     AVG_TEMP TEMP_RANK
Mumbai  March     30       1
Mumbai  February  27       2
Mumbai  January   25       3
Delhi   March     25       1
Delhi   February  20       2
Delhi   January   15       3

> select year, month, avg_temp,
first_value(month) over (partition by year order by avg_temp desc) as Hottest_Month,
last_value(month) over (partition by year order by avg_temp desc
rows between unbounded preceding and unbounded following) as Coolest_Month from WeatherOl;
Output:
YEAR MONTH     AVG_TEMP Hottest_Month Coolest_Month
2020 March     30       March          January
2020 February  27       March          January
2020 January   25       March          January
2020 March     25       March          January
2020 February  20       March          January
2020 January   15       March          January

> select place, month, avg_temp, dense_rank() over (partition by place order by avg_temp desc) as Temp_Rank from WeatherOl where Temp_Rank=2;
Output:
PLACE   MONTH     AVG_TEMP TEMP_RANK
Mumbai  February  27       2
Delhi   February  20       2

> select month, sum(avg_temp) as Total_Temp from WeatherOl group by month with rollup;
Output:
MONTH     TOTAL_TEMP
January   40
February  47
March     55
NULL      142

> select month, sum(avg_temp) as Total_Temp from WeatherOl group by month with cube;
Output:
MONTH     TOTAL_TEMP
January   40
February  47
March     55
NULL      142

Q8]
1.	Create table sales with fields store_id, store_name, location, month, amount.
2.	Insert 10 records.
3.	Display the highest sale of every month using Rank function.
4.	Display the highest sale of every store using Rank function

Query:
> create table SalesOl2(store_id number, store_name varchar2(20), location varchar2(20), month varchar2(20), amount number);
Output: Table created.

> insert into SalesOl2 values(1, 'StoreA', 'Mumbai', 'January', 5000);
Output: 1 row created.
> insert into SalesOl2 values(2, 'StoreB', 'Delhi', 'January', 6000);
Output: 1 row created.
> insert into SalesOl2 values(3, 'StoreA', 'Mumbai', 'February', 7000);
Output: 1 row created.
> insert into SalesOl2 values(4, 'StoreB', 'Delhi', 'February', 8000);
Output: 1 row created.
> insert into SalesOl2 values(5, 'StoreA', 'Mumbai', 'March', 9000);
Output: 1 row created.
> insert into SalesOl2 values(6, 'StoreB', 'Delhi', 'March', 10000);
Output: 1 row created.
> insert into SalesOl2 values(7, 'StoreA', 'Mumbai', 'April', 11000);
Output: 1 row created.
> insert into SalesOl2 values(8, 'StoreB', 'Delhi', 'April', 12000);
Output: 1 row created.
> insert into SalesOl2 values(9, 'StoreA', 'Mumbai', 'May', 13000);
Output: 1 row created.
> insert into SalesOl2 values(10, 'StoreB', 'Delhi', 'May', 14000);
Output: 1 row created.

> select month, store_name, amount, rank() over (partition by month order by amount desc) as Amount_Rank from SalesOl2;
Output:
MONTH    STORE_NAME AMOUNT AMOUNT_RANK
January StoreB     6000   1
January StoreA     5000   2
February StoreB    8000   1
February StoreA    7000   2
March    StoreB     10000  1
March    StoreA     9000   2
April    StoreB     12000  1
April    StoreA     11000  2
May      StoreB     14000  1
May      StoreA     13000  2

> select store_name, month, amount, rank() over (partition by store_name order by amount desc) as Amount_Rank from SalesOl2;
Output:
STORE_NAME MONTH    AMOUNT AMOUNT_RANK
StoreA     May      13000  1
StoreA     April    11000  2
StoreA     March    9000   3
StoreA     February 7000   4
StoreA     January  5000   5
StoreB     May      14000  1
StoreB     April    12000  2
StoreB     March    10000  3
StoreB     February 8000   4
StoreB     January  6000   5







-- ORDBMS

-- create object type 'Name' with attributes 'FName' and 'LName' of a person using the table 'Person2'.
create type name as object(FName varchar(10), LName varchar(10));                   -- creating object type Name
create table Person2(PName Name);                                                   -- creating table with object type
insert into Person2 values(Name('Alice', 'Smith'));                                 -- inserting values
select * from person2;                                                              -- display all records
desc Person2;                                                                       -- describe table
select p.PName.FName from Person2 p;                                                -- display First name
select p.PName.FName, p.PName.LName from Person2 p;                                 -- display First name and Last name



-- create object type 'Adress' with attributes 'street' and 'city' of a person using the table 'People'.
-- Also display the Person 'Name' and 'DOB' using 'Nam' and 'Date' Object type.
create type Address2 as object(Street varchar(10), City varchar(10));                                                       -- creating object type Address2
create table People2(PLName Name, Addr Address2, DOB Date);                                                                 -- creating table with object types
insert into People2 Values( Name('John', 'Doe'), Address2('Chakala', 'Mumbai'), to_date('03-06-1998', 'dd-mm-yyyy'));       -- inserting values
desc people2;                                                                                                               -- describe table
select p.PLName.FName, p.PLName.LName from People2 p;                                                                       -- Display FName and LName
select p.addr.street, p.addr.city from people2 p;                                                                           -- Display street and city



-- Calculating square of a number using type.
create type Demoo as object(ID number, member function get_square return number); / -- 1. create type
create or replace type body Demoo is                                                -- 2. create type body
  member function get_square return number is                                               -- define member function
  begin                                                                                     -- function logic
  return ID * ID;                                                                           -- return square of ID
  end;
  end;
  /

create table demo_tbl(col Demoo);                                                   -- 3. create table
insert into demo_tbl values(Demoo(4));                                              -- 4. insert values in table
select v.Col.get_square() from demo_tbl v;                                          -- 5. display square of a number 

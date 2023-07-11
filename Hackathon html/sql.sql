create database complaint;
use complaint;
create table complaint(
Id Int primary key,
Name varchar(300),
mobile int(10000)

);
insert into complaint values(1,'sandhya',9390);

select * from complaint;
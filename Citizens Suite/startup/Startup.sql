SET SQL_SAFE_UPDATES = 0;
drop database if exists test;
create database test;
use test;
drop table if exists users;
drop table if exists venue;
drop table if exists group_events;
drop table if exists shows;
drop table if exists bookings;
drop table if exists companies;
drop table if exists jobs;
drop table if exists applications;
drop table if exists censor_applications;
drop table if exists city_applications;
drop table if exists credit_applications;
drop table if exists my_purchases;
drop table if exists course_applications;
drop table if exists company_jobs;
drop table if exists my_applications;
drop table if exists university_applications;
drop table if exists company_applications;
drop table if exists event_bookings;
create table users(
user_id integer auto_increment,
firstname varchar(50),
lastname varchar(50),
username varchar(50),
email varchar(50),
passwordFld varchar(100),
verify_code integer,
can_login varchar(2) default "0",
role varchar(20),
balance double,
lat double,
lon double,
address varchar(200),
primary key(user_id)
);

create table venues(  
venue_id integer auto_increment,
name varchar(100),
owner varchar(50),
location varchar(20),
lat double,
lon double,
primary key(venue_id)
);
create table group_events(
group_events_id integer auto_increment,
name varchar(100),
venue_id integer,
primary key(group_events_id)
);
create table shows(
show_id integer auto_increment,
show_time varchar(15),
group_events_id integer,
no_of_tickets integer default 50,
primary key(show_id)
);
create table bookings(
booking_id integer auto_increment,
user_id integer,
enterprize varchar(15),
lat double,
lon double,
primary key(booking_id)
);
 
 create table event_bookings(
booking_code integer auto_increment,
username varchar(30),
venue varchar(30),
event varchar(30),
tickets integer,
event_date date,
primary key(booking_code));
 
create table companies(
company_id integer auto_increment,
name varchar(30),
primary key(company_id)
);
create table jobs(
job_id integer auto_increment,
name varchar(20),
description varchar(200),
company_id integer,
primary key(job_id)
);
create table applications(
application_id integer auto_increment,
username varchar(20),
company_name varchar(20),
job_name varchar(30),
applied_date varchar(30),
status varchar(20),
comments varchar(200),
primary key(application_id)
);
create table censor_applications(
application_id integer auto_increment,
event_name varchar(100),
venue varchar(20),
organizer varchar(30),
sponsor varchar(30),
app_status varchar(20),
event_status varchar(20),
applied_date date,
url varchar(100),
asignee varchar(30),
primary key(application_id)
);
 
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role,balance) values("vijay","kalki","vijay","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"User","120.25");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","SysAdmin","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"SystemAdmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","gadmin","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"gadmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","censoradmin1","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"censoradmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","censoradmin2","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"censoradmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","eventcreator","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"eventcreator");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","citycomm","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"citycomm");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","ccadmin","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"ccadmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","compadmin","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"compadmin");
insert into users(firstname,lastname,username,email,passwordFld,verify_code,can_login,role) values("vijay","kalki","venuecreator","poosarla.s@northeastern.edu","XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=",123456,1,"venuecreator");

update users set username = 'Username' where user_id = 1;
update users set can_login = 1 where user_id = 1;
insert into venues(name,location,owner,lat,lon) values('YMCA','Boston','Lions Club',42.3410701,-71.0882683);
insert into venues(name,location,owner,lat,lon) values('EXP','New York','Mancity',42.3410701,-71.0882683);
insert into group_events(name,venue_id) values('How not become a software developer',1);
insert into group_events(name,venue_id) values('Find Your Passion',1);
insert into group_events(name,venue_id) values('Resume Building',1);
insert into group_events(name,venue_id) values('How to Network',2);
insert into group_events(name,venue_id) values('Goodness and Well Being',2);
insert into shows(show_time,group_events_id) values("11:00 AM",1);
insert into shows(show_time,group_events_id) values("11:15 AM",1);
insert into shows(show_time,group_events_id) values("11:30 AM",1);
insert into shows(show_time,group_events_id) values("02:00 PM",2);
insert into shows(show_time,group_events_id) values("02:15 PM",2);
insert into bookings(user_id,enterprize,lat,lon) values (1,"events",42.3410701,-71.0882683);
insert into bookings(user_id,enterprize,lat,lon) values (1,"events",42.3432429,-71.0979135);
insert into censor_applications(venue,event_name,organizer,sponsor,app_status,event_status,applied_date,url,asignee) values ("YMCA","Stand up comedy by Kenny","Kenny sebastian","youtube","Active","Pending","2022-12-08","https://www.youtube.com/watch?v=TcMBFSGVi1c","N/A");
 
 
 
 
 
create table city_applications(
application_id integer auto_increment,
name varchar(30),
type varchar(30),
owner varchar(30),
location varchar(30),
lat double,
lon double,
asignee varchar(30),
application_status varchar(30),
primary key(application_id)
);
create table credit_applications(
request_id integer auto_increment,
username varchar(20),
cardnumber varchar(20),
amount double,
alimit double,
status varchar(20),
primary key(request_id));
 
create table credit_cards(
card_id integer auto_increment,
cardnumber varchar(20),
pin integer,
alimit double,
primary key(card_id));
insert into credit_cards(cardnumber,pin,alimit) values ("1234567891234567",1245,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234567891234568",5478,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234567891234557",8577,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234567891224567",2788,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234564591234567",4785,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234567091234567",1414,500.00);
insert into credit_cards(cardnumber,pin,alimit) values ("1234567893334567",8574,500.00);
create table my_purchases(
transaction_id integer auto_increment,
username varchar(20),
t_type varchar(20),
amount double,
balance double,
enterprise varchar(30),
lat double,
lon double,
primary key(transaction_id));
 
 
 
create table course_applications(
application_id integer auto_increment,
coursename varchar(20),
university varchar(50),
professor varchar(30),
coursedesc varchar(200),
app_status varchar(20),
applied_date date,
asignee varchar(30),
dayofweek varchar(30),
primary key(application_id));
 
create table company_jobs(
job_id integer auto_increment,
company varchar(30),
role varchar(30),
roledesc varchar(200),
app_status varchar(20),
asignee varchar(30),
applied_date date,
applied_by varchar(30),
primary key(job_id));
 

create table my_applications(
application_id integer auto_increment,
username varchar(30),
enterprise varchar(30),
lat double,
lon double,
message varchar(30),
primary key(application_id));

create table university_applications(
uni_apply_id integer auto_increment,
university varchar(30),
username varchar(30),
course varchar(30),
status varchar(30),
primary key(uni_apply_id)
);

create table company_applications(
comp_apply_id integer auto_increment,
company varchar(30),
username varchar(30),
role varchar(30),
status varchar(30),
primary key(comp_apply_id)
);


 
select * from course_applications;
select * from applications;
 
select * from users;
select * from group_events;
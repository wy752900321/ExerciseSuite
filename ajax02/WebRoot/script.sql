create table t_account(
id int primary key auto_increment,
accountNo varchar(20) unique,
balance double);

insert into t_account(accountNo,balance) 
values('6225881003192000',1000);
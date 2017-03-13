create table t_account(
	id bigint primary key auto_increment,
	accountNo varchar(20) unique,
	balance double
);

insert into t_account(accountNo,balance) 
								values('666666',1000);
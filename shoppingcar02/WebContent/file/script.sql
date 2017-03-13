create table t_computer(
	id bigint primary key auto_increment,
	model varchar(20),
	pic varchar(50),
	prodInfo varchar(255),
	price double);
	
	insert into t_computer(model,pic,prodInfo,price) 
	values('x200','x200.jpg','good',1000);
	insert into t_computer(model,pic,prodInfo,price) 
	values('x500','x500.jpg','good',2000);
	insert into t_computer(model,pic,prodInfo,price) 
	values('x600','x600.jpg','good',3000);
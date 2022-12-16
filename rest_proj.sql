select * from food;
desc food;

insert into food values(1,true,'Packaged Water 1Litre',1,20,1);
insert into food values(2,false,'Pav Bhaji',15,90,2);
insert into food values(3,true,'Jain Pav Bhaji',18,110,1);
insert into food values(4,true,'Extra Pav',5,40,1);
insert into food values(5,true,'Idli Sambar',5,40,2);
insert into food values(6,true,'Butter Dosa',10,45,3);
insert into food values(7,false,'Masala Dosa',12,55,5);


select * from food where food_price <=100;

select * from orders;

insert into orders values(1,1,'2022-12-14',1,20,true);
insert into orders values(2,3,'2022-12-14',2,90,true);
insert into orders values(5,2,'2022-12-02',2,55,false);
insert into orders values(3,4,'2022-12-15',2,45,false);


select * from customer;
desc customer;
insert into customer values(1,'john@gmail.com',false,'john',9898989898,1);
insert into customer values(2,'ishaan@gmail.com',true,'ishaan',8989898989,1);
insert into customer values(3,'shagun@gmail.com',false,'shagun',9797979797,1);
insert into customer values(4,'parshva@gmail.com',true,'parshva',7979797979,1);

delete from customer where customerid='4'

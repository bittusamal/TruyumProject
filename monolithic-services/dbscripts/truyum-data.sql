-- Include table data insertion, updation, deletion and select scripts


insert into truyum.menu_item 
    values(1, 'Sandwich', 99.00, 'Yes', '2017-03-15', 'Main Course', 'Yes','https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60'),
    (2, 'Burger', 129.00, 'Yes', '2017-12-23', 'Main Course', 'No','https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
    (3, 'Pizza', 149.00, 'Yes', '2018-08-21', 'Main Course', 'No','https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60'),
    (4, 'French Fries', 57.00, 'No', '2017-07-02', 'Starters', 'Yes','https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60'),
    (5, 'Choclate Brownie', 32.00, 'Yes', '2022-11-02', 'Dessert', 'Yes','https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60');
    
select * from truyum.menu_item;
delete from truyum.menu_item ;
    
select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery
    from truyum.menu_item 
    where me_date_of_launch = NOW() 
    or me_date_of_launch < NOW() 
    and me_active = 'Yes';


select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery
    from truyum.menu_item 
    where me_id = 1;
    
update truyum.menu_item 
    set me_name = 'Hot Dog', me_price = 99.00, me_active = 'Yes', me_date_of_launch = '2017-03-15', me_category = 'Main Course', me_free_delivery = 'Yes' 
    where me_id = 1;


insert into truyum.user 
    values(1, 'First'),(2, 'Second');
    


delete from truyum.cart ;
DROP TABLE truyum.cart;
select * from truyum.user_role ;

insert into truyum.user values (1,'admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','admin','admin' );
insert into truyum.user values (2,'user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'user','user');

insert into truyum.role values (1,'ADMIN');
insert into truyum.role values (2,'USER');

insert into truyum.user_role values (1,1,1);
insert into truyum.user_role values (2,2,2);

insert into truyum.cart 
    values(1, 1, 1),(2, 1, 3),(3, 1, 5);
select * from truyum.cart ;
    
    
select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery 
    from truyum.menu_item 
    inner join truyum.cart 
    on me_id = ct_pr_id 
    where ct_us_id = 1;
    
select sum(me_price) 
    as Total 
    from truyum.menu_item 
    inner join truyum.cart 
    on me_id = ct_pr_id 
    where ct_us_id = 1;


delete from truyum.cart 
    where ct_us_id = 2
    and ct_pr_id = 3;
    
select * from truyum.cart;

select * from truyum.menu_item ;
delete from truyum.menu_item ;

select * from user;

delete from user where us_id = 3;

delete from user;

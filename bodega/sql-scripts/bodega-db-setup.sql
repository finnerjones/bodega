-- Create database
create database bodega;

-- Create user
create user 'bodega'@'localhost' identified by 'bodega';
-- grants
grant all on bodega.* to 'bodega'@'localhost';

-- tables
 drop table bodega.product;
 drop table bodega.product_type;
 drop table bodega.restaurant;
 drop table bodega.taste_journal;
 drop table bodega.years;


-- years_id is NUMERIC because INT AUTO_INCREMENT 
-- will not allow me make a foreign key to years_id from product
 create table bodega.years(
 	years_id NUMERIC not null,
 	years_yyyy NUMERIC(4) not null,
 	primary key (years_id)
 );
 
 
create table bodega.product_type(
	product_type_id NUMERIC not null, 
	product_type_code VARCHAR(30) not null,
	product_type_description VARCHAR(128),
	primary key (product_type_id)
);

create table bodega.product(
	product_id INT not null AUTO_INCREMENT,
	product_name VARCHAR(128) not null,
	product_type NUMERIC not null,
	product_country VARCHAR(128),
	product_description VARCHAR(256),
	product_year NUMERIC not null,
	product_grapes VARCHAR(128),
	product_price NUMERIC(10,2),
	product_celler VARCHAR(256),
	product_denom_origen VARCHAR(256),
	product_vender VARCHAR(128),
	product_alcohol NUMERIC(4,2),
	product_date_purchased DATE,
	product_date_opened DATE,
	product_date_inserted DATE,
	product_date_last_modified TIMESTAMP DEFAULT NOW(),
	product_comments VARCHAR(1024),
	primary key (product_id),
  index product_type_idx (product_type),
  index product_years_idx (product_year),
  foreign key (product_type) references bodega.product_type(product_type_id),
  foreign key (product_year) references bodega.years(years_id)
);
	
	
create table bodega.restaurant(
	restaurant_id INT not null AUTO_INCREMENT,
	restaurant_name VARCHAR(256),
	restaurant_address VARCHAR(256),
	restaurant_phone VARCHAR(128),
	restaurant_rating NUMERIC,
	restaurant_food VARCHAR(256),
	restaurant_price NUMERIC(10,2),
	restaurant_comments VARCHAR(512),
	restaurant_date_inserted DATE,
	restaurant_date_modified TIMESTAMP DEFAULT NOW(),
	primary key (restaurant_id)
);	
	
create table bodega.taste_journal(
	taste_journal_id INT not null AUTO_INCREMENT,
	taste_journal_date_of_taste DATE,
	taste_journal_product_id NUMERIC,
	taste_journal_product_name VARCHAR(256) not null,
	taste_journal_product_type NUMERIC not null,
	taste_journal_celler VARCHAR(256),
	taste_journal_product_year NUMERIC,
	taste_journal_product_origen VARCHAR(256),
	taste_journal_product_grapes VARCHAR(256),
	taste_journal_presentation VARCHAR(256),
	taste_journal_aspect VARCHAR(128),
	taste_journal_aroma VARCHAR(128),
	taste_journal_taste VARCHAR(128),
	taste_journal_score NUMERIC,
	taste_journal_quality VARCHAR(128),
	taste_journal_price NUMERIC(10,2),
	taste_journal_inserted DATE,
	taste_journal_last_modified TIMESTAMP DEFAULT NOW(),
	primary key (taste_journal_id)
);
	

-- initial data

-- BODEGA.YEARS
insert into bodega.years (years_id, years_yyyy) values (1988,'1988');
insert into bodega.years (years_id, years_yyyy) values (1989,'1989');
insert into bodega.years (years_id, years_yyyy) values (1990,'1990');
insert into bodega.years (years_id, years_yyyy) values (1991,'1991');
insert into bodega.years (years_id, years_yyyy) values (1992,'1992');
insert into bodega.years (years_id, years_yyyy) values (1993,'1993');
insert into bodega.years (years_id, years_yyyy) values (1994,'1994');
insert into bodega.years (years_id, years_yyyy) values (1995,'1995');
insert into bodega.years (years_id, years_yyyy) values (1996,'1996');
insert into bodega.years (years_id, years_yyyy) values (1997,'1997');
insert into bodega.years (years_id, years_yyyy) values (1998,'1998');
insert into bodega.years (years_id, years_yyyy) values (1999,'1999');
insert into bodega.years (years_id, years_yyyy) values (2000,'2000');
insert into bodega.years (years_id, years_yyyy) values (2001,'2001');
insert into bodega.years (years_id, years_yyyy) values (2002,'2002');
insert into bodega.years (years_id, years_yyyy) values (2003,'2003');
insert into bodega.years (years_id, years_yyyy) values (2004,'2004');
insert into bodega.years (years_id, years_yyyy) values (2005,'2005');
insert into bodega.years (years_id, years_yyyy) values (2006,'2006');
insert into bodega.years (years_id, years_yyyy) values (2007,'2007');
insert into bodega.years (years_id, years_yyyy) values (2008,'2008');
insert into bodega.years (years_id, years_yyyy) values (2009,'2009');
insert into bodega.years (years_id, years_yyyy) values (2010,'2010');
insert into bodega.years (years_id, years_yyyy) values (2011,'2011');
insert into bodega.years (years_id, years_yyyy) values (2012,'2012');
insert into bodega.years (years_id, years_yyyy) values (2013,'2013');


-- BODEGA.BDG_TYPE
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (1, 'red_wine', 'Red Wine');
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (2, 'white_wine', 'White Wine');
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (3, 'rose_wine', 'Rose Wine');
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (4, 'cava', 'Cava');
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (5, 'champagne', 'Champagne');
insert into bodega.product_type (product_type_id, product_type_code, product_type_description) values (6, 'moscatel', 'Moscatel');

-- BODEGA.BDG_PRODUCT
insert into bodega.product (product_id, product_name, product_description, product_type, product_country, product_year, product_date_inserted) values (1, 'Scala Dei', 'Red wine from Priorat', 1, 'Spain', '2005', now());
insert into bodega.product (product_id, product_name, product_description, product_type, product_country, product_year, product_vender, product_price, product_celler, product_alcohol, product_date_inserted) values (2, 'Auzelles', 'Nice wine', 2, 'Spain', '2010', 'Vinacoteca, El Clot', 8.00, 'Cosers del Segre, Lleida', 12.5, now());
insert into bodega.product (product_id, product_name, product_description, product_type, product_country, product_year, product_vender, product_price, product_celler, product_alcohol, product_date_inserted) values (3, 'Heretat Navas', 'Nice wine', 2, 'Spain', '2010', 'Montsant', 8.00, 'Montsant', 12.5, now());
insert into bodega.product (product_id, product_name, product_type, product_country, product_description, product_year, product_grapes, product_price, product_celler, product_alcohol, product_date_purchased, product_date_opened, product_date_inserted, product_date_last_modified, product_comments) values (4,'Jean Leon', 1, 'Spain, Cataluyna', 'Reserva', '2004', 'Cabernet Sauvignon', 25.00, 'Jean Leon S.L', 13.5, '2012-05-06', '2012-07-22', '2012-07-22', now(), 'D.O Penedes : viña de Le Havre. Viña no tratada con insecticidas ni herbicidas.');

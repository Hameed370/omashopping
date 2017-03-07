CREATE TABLE category
(

id identity,
name varchar(30),
description varchar(255),
image_url varchar(50),
is_active boolean;
constraint pk_category primary key(id)


)



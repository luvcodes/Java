CREATE TABLE `order1` (
    id INT NOT NULL,
    `name` VARCHAR(64) NOT NULL DEFAULT '',
    person VARCHAR(32) NOT NULL DEFAULT '',
    quantity INT NOT NULL
);
create table `order2` (
    id INT NOT NULL PRIMARY KEY, -- 创建主键方式方式二
    `name` VARCHAR(64) NOT NULL DEFAULT '',
    person VARCHAR(32) NOT NULL DEFAULT '',
    quantity INT NOT NULL
);
CREATE TABLE `order3` (
    id INT NOT NULL,
    `name` VARCHAR(64) NOT NULL DEFAULT '',
    person VARCHAR(32) NOT NULL DEFAULT '',
    quantity INT NOT NULL
);
-- 创建主键方式一
alter table `order1` add PRIMARY KEY (id);
-- 创建主键方式三
alter table `order3` add index id_index(id);

show indexes from order1;
show index from order2;
show index from order3;



create table menu1 (
	id int not null,
    `name` varchar(64) not null default '',
    chef varchar(64) not null default '',
    identity char(17) not null,
	price decimal(10,2) not null
);
alter table menu1 add primary key (id);
-- 添加unique索引方式一
create unique index identity_index on menu1 (identity);

create table menu2(
	id int not null,
    `name` varchar(64) not null default '',
    chef varchar(64) not null default '',
    identity char(17) not null,
	price decimal(10,2) not null
);

alter table menu2 add primary key (id);
-- 添加unique索引方式二
alter table menu2 add unique index identity_index (identity);

show indexes from menu1;
show index from menu2;



create table sportman (
	id INT not null,
    `name` varchar(64) not null default '',
    specialise varchar(64) not null default ''
);
alter table sportman add primary key (id);
-- 第一种方式添加普通索引
create index name_index on sportman (`name`);
show indexes from sportman;


create table sportman2 (
	id INT not null,
    `name` varchar(64) not null default '',
    specialise varchar(64) not null default ''
);
alter table sportman2 add primary key (id);
alter table sportman2 add index name_index (`name`);
SHOW indexes from sportman2;
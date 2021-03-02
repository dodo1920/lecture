create table test.tbl_board
(
no int not null auto_increment,
title varchar(100) not null,
content text null,
writer varchar(50) not null,
regdate timestamp not null default now(),
viewcnt int default 0,
primary key(no)
);

select * from test.tbl_board;

insert into test.tbl_board(title, content, writer)
(select title, content, writer from test.tbl_board);

select * from test.tbl_board order by no desc limit 10, 10;

select count(*) from test.tbl_board;

select count(*) from test.tbl_board where title like '%1%';

use test;
create table tbl_reply
(
no int not null auto_increment,
bno int not null default 0,
replytext varchar(500) not null,
replyer varchar(50) not null,
regdate timestamp default now(),
updatedate timestamp default now(),
primary key(no)
);

alter table tbl_reply
add constraint fk_board
foreign key(bno) references tb_board(no);



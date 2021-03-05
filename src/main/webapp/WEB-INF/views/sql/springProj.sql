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

SELECT * FROM test.tbl_reply;

use test;
-- 회원 테이블 생성
create table tbl_user
(
uid varchar(50) not null,
upw varchar(50) not null,
uname varchar(100),
upoint int(11),
primary key(uid)
);

create table tbl_message
(
mid int(11) not null auto_increment,
targetId varchar(50),
sender varchar(50),
message varchar(100),
openDate timestamp,
sendDate timestamp,
primary key(mid)
);

alter table tbl_message
add constraint fk_targetId
foreign key(targetId) references tbl_user(uid);

alter table tbl_message
add constraint fk_sender
foreign key(sender) references tbl_user(uid);

select distinct writer from tbl_board;

insert into tbl_user(uid, upw, uname) 
values('dodo1920', '1234', 'do');

insert into tbl_user(uid, upw, uname) 
values('1234', '1234', 'mago');

insert into tbl_user(uid, upw, uname) 
values('abc', '1234', 'iron man');

insert into tbl_user(uid, upw, uname) 
values('ggggggg', '1234', 'superman');

insert into tbl_user(uid, upw, uname) 
values('아이디', '1234', 'vatman');

insert into tbl_user(uid, upw, uname) 
values('aaa', '1234', 'captin America');

insert into tbl_user(uid, upw, uname) 
values('bbb', '1234', 'Herk');

insert into tbl_user(uid, upw, uname) 
values('ccc', '1234', 'thor');

select distinct replyer from tbl_reply;

insert into tbl_user(uid, upw, uname) 
values('bbbbb', '1234', 'black widow');

insert into tbl_user(uid, upw, uname) 
values('testest', '1234', 'vision');

alter table tbl_board
add constraint fk_writer
foreign key(writer) references tbl_user(uid);

alter table tbl_reply
add constraint fk_reply_replyer
foreign key(replyer) references tbl_user(uid);

select * from tbl_user;
select * from tbl_message;

alter table tbl_user
add upoint int default 0;

update tbl_user set upoint = upoint + 10 where uid = 'bbb';

alter table test.tbl_board
add column replyCnt int;tbl_board

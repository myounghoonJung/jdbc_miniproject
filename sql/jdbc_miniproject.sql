
-- jdbc_miniproject

-- table 생성

create table tbl_book(
    bookno varchar2(30) constraint pk_book_bookno primary key,
    booktitle varchar2(60) not null,
    author varchar2(60) not null,
    publisher varchar2(30) not null,
    genre varchar2(30) not null,
    borrowdate date,
    returndate date,
    status char(1) default 'N' check (status in ('B','N')),
    borrowuserid varchar2(30)
);

create table tbl_book_del(
    bookno varchar2(30) constraint pk_book_del_bookno primary key,
    booktitle varchar2(60),
    author varchar2(60),
    publisher varchar2(30),
    genre varchar2(30),
    deldate date default sysdate
);

create table tbl_user(
    userid varchar2(30) constraint pk_user_userid primary key,
    userpw varchar2(30) not null,
    username varchar2(20) not null,
    gender char(1) check (gender in ('M','F')) not null,
    age number not null,
    phone varchar2(13) not null,
    borrowpresentcount number default 0,
    borrowhistorycount number default 0,
    enrolldate date default sysdate
);

create table tbl_user_quit(
    userid varchar2(30) constraint pk_user_quit_userid primary key,
    userpw varchar2(30),
    username varchar2(20),
    gender char(1) check (gender in ('M','F')),
    age number,
    phone varchar2(13),
    borrowhistorycount number,
    enrolldate date,
    quitdate date default sysdate
);


create table tbl_borrow_log as
select 1 logno, sysdate logdate, tbl_book.*
from tbl_book;

alter table tbl_borrow_log add constraint pk_borrow_log_logno primary key(logno);
alter table tbl_borrow_log add constraint fk_borrow_log_bookno foreign key(bookno) references tbl_book(bookno) on delete set null;
alter table tbl_borrow_log add constraint fk_borrow_log_borrowuserid foreign key(borrowuserid) references tbl_user(userid) on delete set null;
alter table tbl_borrow_log modify logdate default sysdate;

-- sequence 생성

create sequence seq_borrow_log;

-- trigger 생성

create or replace trigger trg_book_del
    after
    delete on tbl_book
    for each row
begin
    insert into tbl_book_del (bookno,booktitle,author,publisher,genre) values (:old.bookno,:old.booktitle,:old.author,:old.publisher,:old.genre);
end;
/

create or replace trigger trg_user_quit
    after
    delete on tbl_user
    for each row
begin
    insert into tbl_user_quit (userid,userpw,username,gender,age,phone,borrowhistorycount,enrolldate) 
    values (:old.userid,:old.userpw,:old.username,:old.gender,:old.age,:old.phone,:old.borrowhistorycount,:old.enrolldate);
end;
/

create or replace trigger trg_borrow_log
    after
    update of status on tbl_book
    for each row
begin
    insert into tbl_borrow_log (logno,bookno,booktitle,author,publisher,genre,borrowdate,returndate,status,borrowuserid)
    values (seq_borrow_log.nextval,:new.bookno,:new.booktitle,:new.author,:new.publisher,:new.genre,:new.borrowdate,:new.returndate
            ,:new.status,:old.borrowuserid);
end;
/



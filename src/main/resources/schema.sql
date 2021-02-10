--
create table genres(id number generated by default as identity primary key,
                    name varchar2(255 char) not null);

create table authors(id number generated by default as identity primary key,
                     first_name varchar2(255 char) not null,
                     second_name varchar2(255 char) not null);

create table books(id number generated by default as identity primary key,
                   name varchar2(255 char) not null,
                   id_author number references authors(id),
                   id_genre number references genres(id));

create sequence book_seq start with 1;
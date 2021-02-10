--
insert into authors(id, first_name, second_name) values (1, 'Neil', 'Gaiman');
insert into authors(id, first_name, second_name) values (2, 'Terry' ,'Pratchett');
insert into authors(id, first_name, second_name) values (3, 'Lisa', 'Lutz');
insert into authors(id, first_name, second_name) values (4, 'David', 'Hayward');
insert into authors(id, first_name, second_name) values (5, 'Jodi', 'Picoult');
insert into authors(id, first_name, second_name) values (6, 'Samantha', 'Leer');


insert into genres(id, name) values (1, 'biography');
insert into genres(id, name) values (2, 'fable');
insert into genres(id, name) values (3, 'realistic');
insert into genres(id, name) values (4, 'fiction');
insert into genres(id, name) values (5, 'poetry');
insert into genres(id, name) values (6, 'science fiction');
insert into genres(id, name) values (7, 'drama');
insert into genres(id, name) values (8, 'fantasy');
insert into genres(id, name) values (9, 'mystery');


insert into books(id, name, id_author, id_genre) values (book_seq.nextval, 'Good Omens', 1, 7);
insert into books(id, name, id_author, id_genre) values (book_seq.nextval, 'Heads You Lose', 4, 9);
insert into books(id, name, id_author, id_genre) values (book_seq.nextval, 'Between the Lines', 6, 1);
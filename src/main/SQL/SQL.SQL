DROP DATABASE IF EXISTS prac;
Create DATABASE prac;
Use prac;

CREATE TABLE TodoItem (
    id int AUTO_INCREMENT Primary Key,
    item varchar(254),
    `time` varchar(64),
    `priority` varchar(5)
);

CREATE TABLE User (
    username varchar(255) Primary Key,
    `password` varchar(64)
);

Insert Into TodoItem (item, `time`, `priority`) Values ('Demo', '12 Nov 2000', 'High');
Insert Into User (username, `password`) Values ("Manvir", "Heer");

Select * from TodoItem;
Select * from User;
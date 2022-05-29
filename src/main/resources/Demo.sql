================================================================UC1=================================================

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| payroll_services   |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> create database AddressBookService;
Query OK, 1 row affected (0.02 sec)

mysql> use AddressBookService;
Database changed


mysql> select database();
+--------------------+
| database()         |
+--------------------+
| AddressBookService |
+--------------------+
1 row in set (0.00 sec)


================================================ UC2 ===================================================================

mysql> CREATE TABLE addressbook (
    ->      fName varchar(50) NOT NULL,
    ->      lName varchar(50) NOT NULL,
    ->      address varchar(100) NOT NULL,
    ->      city varchar(20) NOT NULL ,
    ->      state varchar(30) NOT NULL,
    ->      zip varchar(10) NOT NULL,
    ->      phoneNO varchar(20) NOT NULL,
    ->      email varchar(50) NOT NULL
    ->      );
Query OK, 0 rows affected (0.04 sec)


mysql> desc addressbook;
+---------+--------------+------+-----+---------+-------+
| Field   | Type         | Null | Key | Default | Extra |
+---------+--------------+------+-----+---------+-------+
| fName   | varchar(50)  | NO   |     | NULL    |       |
| lName   | varchar(50)  | NO   |     | NULL    |       |
| address | varchar(100) | NO   |     | NULL    |       |
| city    | varchar(20)  | NO   |     | NULL    |       |
| state   | varchar(30)  | NO   |     | NULL    |       |
| zip     | varchar(10)  | NO   |     | NULL    |       |
| phoneNO | varchar(20)  | NO   |     | NULL    |       |
| email   | varchar(50)  | NO   |     | NULL    |       |
+---------+--------------+------+-----+---------+-------+
8 rows in set (0.01 sec)


================================================ UC3 ===================================================================


mysql> INSERT INTO addressbook  VALUES
   ('Ashish','Mashal','sbRoad','Pune','MH','4160011','8380805787','ashish@gmail.com'),
   ('Vicky','Jo','ABC','Pune','MH','4160011','1234567890','vicky@gmail.com'),
   ('Vikas','Mashal','citizen park','Solapur','MH','413004','1234567890','vikas@gmail.com');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from addressbook;
+--------+--------+--------------+---------+-------+---------+------------+------------------+
| fName  | lName  | address      | city    | state | zip     | phoneNO    | email            |
+--------+--------+--------------+---------+-------+---------+------------+------------------+
| Ashish | Mashal | sbRoad       | Pune    | MH    | 4160011 | 8380805787 | ashish@gmail.com |
| Vicky  | Jo     | ABC          | Pune    | MH    | 4160011 | 1234567890 | vicky@gmail.com  |
| Vikas  | Mashal | citizen park | Solapur | MH    | 413004  | 1234567890 | vikas@gmail.com  |
+--------+--------+--------------+---------+-------+---------+------------+------------------+
3 rows in set (0.00 sec)


================================================ UC4 ===================================================================


mysql> select * from addressbook where fName = 'Ashish';
+--------+--------+---------+------+-------+---------+------------+------------------+
| fName  | lName  | address | city | state | zip     | phoneNO    | email            |
+--------+--------+---------+------+-------+---------+------------+------------------+
| Ashish | Mashal | sbRoad  | Pune | MH    | 4160011 | 8380805787 | ashish@gmail.com |
+--------+--------+---------+------+-------+---------+------------+------------------+
1 row in set (0.00 sec)

mysql> update addressbook SET city = 'Banglore' where fName = 'Ashish';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from addressbook where fName='Ashish';
+--------+--------+---------+----------+-------+---------+------------+------------------+
| fName  | lName  | address | city     | state | zip     | phoneNO    | email            |
+--------+--------+---------+----------+-------+---------+------------+------------------+
| Ashish | Mashal | sbRoad  | Banglore | MH    | 4160011 | 8380805787 | ashish@gmail.com |
+--------+--------+---------+----------+-------+---------+------------+------------------+
1 row in set (0.00 sec)


================================================ UC5 ===================================================================


mysql> DELETE  FROM addressbook where fName='Vikas';
Query OK, 1 row affected (0.01 sec)

mysql> select * from addressbook;
+--------+--------+---------+----------+-------+---------+------------+------------------+
| fName  | lName  | address | city     | state | zip     | phoneNO    | email            |
+--------+--------+---------+----------+-------+---------+------------+------------------+
| Ashish | Mashal | sbRoad  | Banglore | MH    | 4160011 | 8380805787 | ashish@gmail.com |
| Vicky  | Jo     | ABC     | Pune     | MH    | 4160011 | 1234567890 | vicky@gmail.com  |
+--------+--------+---------+----------+-------+---------+------------+------------------+
2 rows in set (0.00 sec)


================================================ UC6 ===================================================================


mysql> select * from addressbook where city='Banglore' AND State ='KA';
+--------+--------+---------+----------+-------+---------+------------+------------------+
| fName  | lName  | address | city     | state | zip     | phoneNO    | email            |
+--------+--------+---------+----------+-------+---------+------------+------------------+
| Ashish | Mashal | sbRoad  | Banglore | KA    | 4160011 | 8380805787 | ashish@gmail.com |
+--------+--------+---------+----------+-------+---------+------------+------------------+
1 row in set (0.00 sec)


================================================ UC7 ===================================================================

mysql> select COUNT(city)  CountOfCity ,COUNT(state) CountOfState from addressbook;
+-------------+--------------+
| CountOfCity | CountOfState |
+-------------+--------------+
|           2 |            2 |
+-------------+--------------+
1 row in set (0.00 sec)



================================================ UC8 ===================================================================

mysql> select fName from addressbook ORDER BY city ASC;
+--------+
| fName  |
+--------+
| Ashish |
| Vicky  |
+--------+
2 rows in set (0.00 sec)


================================================ UC9 ==================================================================

mysql> ALTER TABLE addressbook ADD type varchar(150) NOT NULL AFTER lName;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> ALTER TABLE addressbook ADD name varchar(20) NOT NULL AFTER type;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> INSERT INTO addressbook
 VALUES
 ('Shubham','Kande','Friends','TCS','street 1','taxes','CA','123456','1234567890','shubham@gmail.com'),
 ('vikas','mashal','Family','WIPRO','citizen park','solapur','MH','123456','1234567890','vikas@gmail.com'),
 ('mahesh','kumar','Profession','AMAZON','street  2','taxes','CA','123456','1234567890','mahesh@gmail.com');
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from addressbook;
+---------+--------+------------+--------+--------------+----------+-------+---------+------------+-------------------+
| fName   | lName  | type       | name   | address      | city     | state | zip     | phoneNO    | email             |
+---------+--------+------------+--------+--------------+----------+-------+---------+------------+-------------------+
| Ashish  | Mashal |            |        | sbRoad       | Banglore | KA    | 4160011 | 8380805787 | ashish@gmail.com  |
| Vicky   | Jo     |            |        | ABC          | Pune     | MH    | 4160011 | 1234567890 | vicky@gmail.com   |
| Shubham | Kande  | Friends    | TCS    | street 1     | taxes    | CA    | 123456  | 1234567890 | shubham@gmail.com |
| vikas   | mashal | Family     | WIPRO  | citizen park | solapur  | MH    | 123456  | 1234567890 | vikas@gmail.com   |
| mahesh  | kumar  | Profession | AMAZON | street  2    | taxes    | CA    | 123456  | 1234567890 | mahesh@gmail.com  |
+---------+--------+------------+--------+--------------+----------+-------+---------+------------+-------------------+
5 rows in set (0.00 sec)


================================================ UC10 ==================================================================
mysql> SELECT COUNT(fName) AS contacts_count_by_type FROM addressbook WHERE type = 'Profession';
+------------------------+
| contacts_count_by_type |
+------------------------+
|                      1 |
+------------------------+
1 row in set (0.00 sec)



================================================ UC11 ==================================================================

mysql> INSERT INTO addressbook
VALUES('shikar','dhavan','Friends','TCS','random_address','delhi','delhi','123456','1234567890','shikar@gmail.com'),
('srikar','msk','Family','WIPRO','random_address','solapur','MH','123456','1234567890','srikar@gmail.com');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0






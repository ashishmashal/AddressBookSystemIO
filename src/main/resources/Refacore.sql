mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| AddressBookService |
| AddressBookSystem  |
| information_schema |
| mysql              |
| payroll_services   |
| performance_schema |
| sys                |
+--------------------+
7 rows in set (0.00 sec)


mysql> USE AddressBookSystem;
Database changed
mysql> select database();
+-------------------+
| database()        |
+-------------------+
| AddressBookSystem |
+-------------------+
1 row in set (0.00 sec)


mysql> CREATE TABLE IF NOT EXISTS `AddressBookSystem`.`addressbook` (
    ->   `add_id` INT NOT NULL AUTO_INCREMENT,
    ->   PRIMARY KEY (`add_id`));
Query OK, 0 rows affected (0.03 sec)

mysql> show tables;
+-----------------------------+
| Tables_in_AddressBookSystem |
+-----------------------------+
| addressbook                 |
+-----------------------------+
1 row in set (0.00 sec)

mysql> desc addressbook;
+--------+------+------+-----+---------+----------------+
| Field  | Type | Null | Key | Default | Extra          |
+--------+------+------+-----+---------+----------------+
| add_id | int  | NO   | PRI | NULL    | auto_increment |
+--------+------+------+-----+---------+----------------+
1 row in set (0.01 sec)


mysql> CREATE TABLE IF NOT EXISTS `AddressBookSystem`.`person` (
    ->   `p_id` INT NOT NULL AUTO_INCREMENT,
    ->   `fName` VARCHAR(50) NOT NULL,
    ->   `lName` VARCHAR(50) NOT NULL,
    ->   `phoneno` VARCHAR(50) NOT NULL,
    ->   `address` VARCHAR(50) NOT NULL ,
    ->   `city` VARCHAR(45) NOT NULL,
    ->   `state` VARCHAR(45) NOT NULL,
    ->   `zipcode` VARCHAR(45) NOT NULL,
    ->   `add_id` INT NULL,
    ->   PRIMARY KEY (`p_id`),
    ->   INDEX `add_id_idx` (`add_id` ASC) VISIBLE,
    ->   CONSTRAINT `add_id`
    ->     FOREIGN KEY (`add_id`)
    ->     REFERENCES `AddressBookSystem`.`addressbook` (`add_id`)
    ->     ON DELETE NO ACTION
    ->     ON UPDATE NO ACTION);
Query OK, 0 rows affected (0.05 sec)

mysql> show tables;
+-----------------------------+
| Tables_in_AddressBookSystem |
+-----------------------------+
| addressbook                 |
| person                      |
+-----------------------------+
2 rows in set (0.01 sec)


mysql> desc person;
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| p_id    | int         | NO   | PRI | NULL    | auto_increment |
| fName   | varchar(50) | NO   |     | NULL    |                |
| lName   | varchar(50) | NO   |     | NULL    |                |
| phoneno | varchar(50) | NO   |     | NULL    |                |
| address | varchar(50) | NO   |     | NULL    |                |
| city    | varchar(45) | NO   |     | NULL    |                |
| state   | varchar(45) | NO   |     | NULL    |                |
| zipcode | varchar(45) | NO   |     | NULL    |                |
| add_id  | int         | YES  | MUL | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
9 rows in set (0.00 sec)


mysql> CREATE TABLE IF NOT EXISTS `AddressBookSystem`.`type` (
    ->   `type_id` INT NOT NULL,
    ->   `type` VARCHAR(255) NOT NULL,
    ->   `p_id` INT NULL,
    ->   PRIMARY KEY (`type_id`),
    ->   INDEX `p_id_idx` (`p_id` ASC) VISIBLE,
    ->   CONSTRAINT `p_id`
    ->     FOREIGN KEY (`p_id`)
    ->     REFERENCES `AddressBookSystem`.`person` (`p_id`)
    ->     ON DELETE NO ACTION
    ->     ON UPDATE NO ACTION);
Query OK, 0 rows affected (0.06 sec)

mysql> show tables;
+-----------------------------+
| Tables_in_AddressBookSystem |
+-----------------------------+
| addressbook                 |
| person                      |
| type                        |
+-----------------------------+
3 rows in set (0.01 sec)


mysql> CREATE TABLE IF NOT EXISTS `AddressBookSystem`.`name` (
    ->   `name_id` INT NOT NULL AUTO_INCREMENT,
    ->   `name` VARCHAR(255) NOT NULL,
    ->   `add_id` INT NULL,
    ->   PRIMARY KEY (`name_id`),
    ->   INDEX `add_id_idx` (`add_id` ASC) VISIBLE,
    ->   CONSTRAINT ``
    ->     FOREIGN KEY (`add_id`)
    ->     REFERENCES `AddressBookSystem`.`addressbook` (`add_id`)
    ->     ON DELETE NO ACTION
    ->     ON UPDATE NO ACTION);
Query OK, 0 rows affected (0.06 sec)


mysql> show tables;
+-----------------------------+
| Tables_in_AddressBookSystem |
+-----------------------------+
| addressbook                 |
| name                        |
| person                      |
| type                        |
+-----------------------------+
4 rows in set (0.00 sec)


mysql> CREATE TABLE IF NOT EXISTS `AddressBookSystem`.`phoneNo` (   `phoneno_id` INT NOT NULL AUTO_INCREMENT,   `phoneno` VARCHAR(255) NOT NULL,   `p_id` INT NULL,   PRIMARY KEY (`phoneno_id`),   INDEX `p_id_idx` (`p_id` ASC) VISIBLE,   CONSTRAINT `person_id`     FOREIGN KEY (`p_id`)     REFERENCES `AddressBookSystem`.`person` (`p_id`)
    ON DELETE NO ACTION     ON UPDATE NO ACTION);
Query OK, 0 rows affected (0.07 sec)

mysql> show tables;
+-----------------------------+
| Tables_in_AddressBookSystem |
+-----------------------------+
| addressbook                 |
| name                        |
| person                      |
| phoneNo                     |
| type                        |
+-----------------------------+
5 rows in set (0.01 sec)

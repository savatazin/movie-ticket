## Create Database
```
mysql> create database movieticket character set utf8 collate utf8_general_ci;
Query OK, 1 row affected (0.00 sec)

mysql> grant all on movieticket.* to movie@'%' identified by 'movie';
Query OK, 0 rows affected, 1 warning (0.04 sec)

mysql> grant all on movieticket.* to movie@'localhost' identified by 'movie';
Query OK, 0 rows affected, 1 warning (0.00 sec)

```

## Run Project
1. mvn clean
2. mvn clean install
3. Go to the target folder
4. java -jar demo-0.0.1-SNAPSHOT.ja

- http://localhost:8080/registration
- http://localhost:8080/login

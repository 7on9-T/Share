MySQL笔记
=
>[]为可选项 { | }表示二选一，MySQL对大小写不敏感

创建数据库
-
```sql
CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] 数据库名 [ [DEFAULT] CHARACTER SET 字符集名 | [DEFAULT] COLLATE 校对规则名 ]
```
查看字符集和他们的默认校对规则
-
```sql
SHOW CHARACTER SET;
```
指定数据库
-
```sql
USE 数据库名
```
修改数据库
-
```sql
ALTER  {DATABASE | SCHEMA} [数据库名] [ [DEFAULT] CHARACTER SET 字符集名 | [DEFAULT] COLLATE 校对规则名 ]
```
用户必须有对数据库进行修改的权限

删除数据库
-
```sql
DROP DATABASE [IF EXISTS] 数据库名
```
显示数据库
-
```sql
SHOW DATABASES
```
创建表
-
```sql
CREATE TABLE [IF NOT EXISTS] 表名 (列名 数据类型 [NOT NULL | NULL] [DEFAULT 列默认值] ... ) ENGINE = 存储引擎
```
查看存储引擎
-
```sql
SHOW ENGINES;
```
# 实战
### 1.创建一个名为"Bookstore"的数据库  
```sql
CREATE DATABASE Bookstore;
```
### 2.创建一个名为"Bookstore"的数据库,采用字符集gb2312和校对规则gb2312_chinese_ci  
```sql
CREATE DATABASE Bookstore DEFAULT CHARACTER SET gb2312 COLLATE gb2312_chinese_ci;
```
### 3.修改数据库"Bookstore"的默认字符集为"utf8mb4"、校对规则为"utf8mb4_0900_ai_ci"
```sql
ALTER DATABASE Bookstore DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_0900_ai_ci;
```
### 4.在Bookstore数据库中创建图书目录表"book"
```sql
USE Bookstore;
CREATE TABLE book(图书编号 char(10) NOT NULL PRIMARY KEY,图书类别 varchar(20) NOT NULL DEFAULT '计算机')
```
>MySQL支持所有标准SQL数据类型，包括严格数值数据类型（integer、smallint、decimal和numeric）
和近似数值数据类型（float、real和double precision）。关键词int是integer的同义词，关键词dec是decimal的同义词

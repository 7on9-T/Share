MySQL笔记
=
<b>先了解一下数据库的范式理论</b>  

第一范式
-
Example.   
这是学生的基本信息  
|学号|姓名|性别|年龄|入学日期|所学专业|
|----|---|-----|---|-------|--------|
|0001|王小芳|女|18|2003年9月|计算机网络|
|0002|林志强|男|17|2003年9月|计算机软件|
|0003|张长生|男|19|2003年9月|会计电算化|

这是不满足第一范式的学生情况表
|学号|姓名|性别|年龄|地址|
|----|---|-----|---|----|
|0001|王小芳|女|18|深圳市罗湖区解放路2号，邮编518001|
|0002|林志强|男|17|深圳市福田区福华路122号，邮编518033|
|0003|张长生|男|19|深圳市宝安区人民路23号，邮编518038|

这是满足第一范式的学生情况表
|学号|姓名|性别|年龄|地址|邮编
|----|---|-----|---|--------------------|---|
|0001|王小芳|女|18|深圳市罗湖区解放路2号|518001|
|0002|林志强|男|17|深圳市福田区福华路122号|518033|
|0003|张长生|男|19|深圳市宝安区人民路23号|518038|

第二范式
-
Example.   
这是选课关系表
|学号|姓名|年龄|课程名称|成绩|学分|
|----|---|---|-------|----|----|
|010101|张三|18|计算机基础|80|2|
|010102|王小芳|18|数据库基础|85|2|
|010101|张三|18|英语|75|3|
|010102|王小芳|18|高级程序语言设计|85|3|

1.这张表含有重复（冗余）数据  
2.若调整了某门课程的学分，则表中的所有的学分值都需要更新  
3.若开设新的课程，但暂时无人选修，学号无法写入数据库  
4.若学生毕业，应删除记录，但课程和学分信息会被一同删除  

修改后的表：  
由选课关系表拆分的学生表
|学号|姓名|年龄|
|----|---|---|
|010101|张三|18|
|010102|王小芳|18|
|010101|张三|18|
|010102|王小芳|18|

由选课关系拆分的课程表
|课程名称|学分|
|---|---|
|计算机基础|2|
|英语|3|

由选课关系表拆分的成绩表
|学号|课程名称|成绩|
|----|-------|----|
|010101|计算机基础|80|
|010102|数据库基础|85|
|010101|英语|75|
|010102|高级程序语言设计|85|

MySQL命令
-
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
修改表结构
-
```sql

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
CREATE TABLE book
(图书编号 CHAR(10) NOT NULL PRIMARY KEY,
图书类别 VARCHAR(20) NOT NULL DEFAULT '计算机',
书名 VARCHAR(40) NOT NULL,
作者 char(10) NOT NULL,
出版社 VARCHAR(20) NOT NULL,
出版时间 DATE NOT NULL,
单价 FLOAT (5,2) NOT NULL,
数量 int(5),
折扣 FLOAT(3,2),
封面图片 BLOB
)ENGINE=INNODB;
```
>MySQL支持所有标准SQL数据类型，包括严格数值数据类型（integer、smallint、decimal和numeric）
和近似数值数据类型（float、real和double precision）。关键词int是integer的同义词，关键词dec是decimal的同义词

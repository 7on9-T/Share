# PHP程序设计

语法基础
-
php脚本以```<?php```开头，以```?>```结尾。   
php脚本可放置于文档中的任何位置，文件扩展名为```.php```  
php语句以分号结尾。 

1.php
```php
<?php echo'单行php代码' ?>

<?php
echo'多行';
echo'php';
echo'代码';
?>
```
 

2.php
```php
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <style>
        body{
            background-color: green;
        }
    </style>
    <?php
    echo "hello World";
    echo "hello World";
    //提示：html、css、js可以写在php文件里运行，但php不能写在html、css、js文件里。
    ?>
</body>
</html>
```
PHP echo 和 print 语句
-
```php
<?php
//echo可以输出多个字符串,以英文逗号连接
echo "hello World";
echo "hello", "World";

//print只能输出一个字符串
print "你干嘛哎呦";
//下面语句会报错Parse error: syntax error, unexpected ',' in %PATH% on line xx
//print "你干嘛哎呦","你好烦"；

//有无括号均可使用
echo ("hello World");
print ("你干嘛哎呦");

//print 返回值为1
$a = print "wow";
echo $a;
?>
```
PHP 注释
-
```php
<?php
//这是单行注释

#这也是单行注释

/*
多行
注释
*/
?>
```
PHP 变量
-
```php
<?php
//变量命名规则：
//变量以$为开头，
//变量名必须以字母或者下划线为开头，不能有空格，
//变量名只能包含数字字母下划线，
//变量名对大小写敏感。
$a=1;
$b=2;
//php中的“=”不是等于，是赋值。
$c=$a+$b;
echo $c;
?>
```
PHP 大小写敏感
-
```php
<?php
//用户定义的函数，类和关键字都对大小写不敏感。
//尽量别这么写。
ECHO "hello World";
EcHo "hello World";
PRint "你干嘛哎呦";
//但是所有变量都对大小写敏感
$color="World";
echo "Hello". $color;
echo "Hello". $COLOR;
?>
```
PHP 空白符
-
```php
<?php
//回车换行不影响正常执行
echo
'h
e
l
l
o'
;
/*
注

释
*/
?>
```
命令行的使用
-
Windows：添加php到环境变量  
在cmd输入php -v 应得到类似于这样的的提示
```
C:\Windows\System32\php -v
PHP 7.3.4 (cli) (built: Apr  2 2019 21:57:22) ( NTS MSVC15 (Visual C++ 2017) x64 )
Copyright (c) 1997-2018 The PHP Group
Zend Engine v3.3.4, Copyright (c) 1998-2018 Zend Technologies
```
获取用户输入的内容
-
```php
<?php
$input=readline("请输入内容：");
echo "输入的是" . $input;
?>
```
```php
<?php
echo "请输入内容：";
$input1 = fgets(STDIN);
echo "输入的内容：" . $input1;
?>
```
PHP 数据类型
-
PHP 支持以下几种数据类型:

    String（字符串）
    Integer（整型）
    Float（浮点型）
    Boolean（布尔型）
    Array（数组）
    Object（对象）
    NULL（空值）
    Resource（资源类型）

使用```var_dump()```会返回变量的数据类型和值，一般开发调试使用  
使用```echo gettype($a)```只获取数据类型

### String（字符串）
字符串可以是引号内的任意文本，可以使用单引号或者双引号  
```php
<?php
$a = 20;
//双引号可直接放入变量，直接把变量的值显示出来
echo "a的值是:$a";//a的值是:20
echo 'a的值是:$a';//a的值是:$a
?>
```
### Integer（整型）

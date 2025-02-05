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

### String(字符串)
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
要求：
必须有至少一个数字  
不包含逗号空格  
不能有小数点  
整数正负均可  
可用三种格式规定整数：十进制、十六进制（0x）或八进制（0）  
```php
<?php
$a=777;//正数
$b=-888;//负数
$c=0x7b;//十六进制
$d=011;//八进制
?>
```
### Float（浮点型）
小数点或者指数形式的数字  
要求：  
必须有至少一个数字  
不包含逗号空格  
正负均可  
其中e或E被称为阶码标志，e或E后面的有符号整数被称为阶码。阶码代表10的阶码次方。
例如：
-1.56E+12；
2.87e-3；
-8e1.0；错

浮点型常量可以省略正号，可以没有小数点或指数部分。
例如：
2E5；
19.28；
但是不能同时没有二者。
例如：
19；错

浮点型常量可以省略小数或者整数部分，但不能同时省略。
例如：
e3；错
注意：e前后的实数和整数不能省略。
-80.0e;错

注意：浮点型常量有阶码的小数点前面只能有一位非0的数字。
例如：
1.81e7;//对
18.1e6;//错
```php
<?php
$f0= 10.6655;
$f1= -549.146;
$f2= -1.5716E+12;
$f3= 2.1287e-31; 
?>
```
### Boolean（布尔型）
```php
<?php
$b1=true;
$b2=false;
?>
```
### Array（数组）
在一个变量存储多个值
```php
<?php
$os=array("Linux","Windows","macOS");
$_os=["Linux","Windows","macOS"];
var_dump($os);
var_dump($_os);
?>
```
### Object（对象）
在PHP中，对象是一个抽象概念，它是一组属性和方法的集合。对象可以被创建、使用和销毁。对象是通过类来创建的，类是用来描述对象的属性和方法的模板。对象可以被赋值给变量，也可以作为函数的参数和返回值。
```php
<?php    
class Person{
    public $name;
    public $age;
    public function __construct($name,$age){
        $this->name=$name;
        $this->age=$age;
    }
    public function sayHello(){
        echo "Hello, my name is ".$this->name." and I am ".$this->age." years old.";
    }
}
$person1=new Person("John",25);
$person1->sayHello();
?>
```
### NULL（空值）
NULL表示变量无值，NULL是数据类型NULL唯一可能的值  
提示：可以通过设置变量值为NULL来清空变量数据
```php
<?php
$xx = "Hello World!";
var_dump( $xx );
$xx = null;
var_dump( $xx );
?>
```
### Resource（资源类型）
在PHP中，资源（resource）是一种特殊的变量，它保存了对某个外部资源的引用。这些资源通常是通过与数据库、文件系统、图形库等交互的函数或方法创建的。资源不能直接转换为其他数据类型，也不能直接进行运算或比较。

PHP中常见的资源类型包括：

数据库连接：通过 mysqli_connect 或 PDO 等函数创建的数据库连接资源。
文件句柄：通过 fopen 函数打开文件时返回的文件句柄资源。
图像处理：通过 imagecreate 等GD库函数创建的图像资源。
CURL会话：通过 curl_init 函数初始化的CURL会话资源。
套接字：通过 socket_create 函数创建的套接字资源。
日期时间：通过 date_create 函数创建的日期时间资源。
XML解析器：通过 xml_parser_create 函数创建的XML解析器资源。
资源通常需要显式地释放，以避免内存泄漏或其他资源管理问题。释放资源的函数通常以 close、free 或 destroy 结尾，例如 fclose 用于关闭文件句柄，mysqli_close 用于关闭数据库连接，xml_parser_free 用于释放XML解析器资源等。

以下是一些资源操作的示例：
// 打开文件
$fileHandle = fopen("example.txt", "r");

// 读取文件内容
$content = fread($fileHandle, 1024);

// 关闭文件
fclose($fileHandle);

// 创建数据库连接
$connection = mysqli_connect("localhost", "user", "password", "database");

// 查询数据库
$result = mysqli_query($connection, "SELECT * FROM table");

// 处理结果集
while ($row = mysqli_fetch_assoc($result)) {
    // 处理每一行数据
}

// 关闭数据库连接
mysqli_close($connection);

// 使用GD库创建图像
$image = imagecreate(200, 200);

// 释放图像资源
imagedestroy($image);

在这些示例中，$fileHandle 和 $connection 是资源类型的变量，使用完后需要通过相应的函数来释放它们。
### 运算符
PHP支持以下运算符：

算术运算符：+、-、*、/、%、**
赋值运算符：=、+=、-=、*=、/=、%=、**=
比较运算符：==、!=、<>、<、>、<=、>=
逻辑运算符：&&、||、!
位运算符：&、|、^、~、<<、>>
字符串运算符：.、.=、.（点）、[]、[]=
其他运算符：isset()、unset()、empty()、eval()、include()、require()、print()、echo()、isset()、unset()、empty()、die()、exit()、@、list()、compact()、func_get_arg()、func_get_args()、func_num_args()、call_user_func()、call_user_func_array()、isset()、unset()、empty()、eval()、include()、require()、print()、echo()、isset()、unset()、empty()、die()、exit()、@、list()、compact()、func_get_arg()、func_get_args()、func_num_args()、call_user_func()、call_user_func_array()、isset()、unset()、empty()、eval()、include()、require()、print()、echo()、isset()、unset()、
### 控制结构
PHP支持以下控制结构：

条件语句：if、elseif、else
循环语句：for、foreach、while
跳转语句：break、continue、goto

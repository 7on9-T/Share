# PHP程序设计

语法基础
-
php脚本以```<?php```开头，以```?>```结尾。   
php脚本可放置于文档中的任何位置，文件扩展名为```.php```  
php语句以分号结尾。 

```php
<?php echo'单行php代码' ?>

<?php
echo'多行';
echo'php';
echo'代码';
?>
```
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
暂时空着
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
暂时空着

实战：blog编写
-

blog.php
```html
<?php
$title = "江易北's blog";
?>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo "$title"; ?></title>
</head>

<body>
    <div class="bar">
        <a href="#home">Home</a>
        <a href="#about">About</a>
        <a href="#posts">Blog</a>
        <a href="#contact">Contact Me</a>
    </div>
    <div class="container">
        <h1 class="title">Welcome my blog.</h1>

        <!-- 第一种写法：直接使用html编写 -->
        <div class="text-area">
            <span class="create-day">2024.09.08</span>
            我来到了长春汽车职业技术大学。
        </div>

        <!-- 第二种写法：使用php变量，然后带到html中 -->
        <?php
        $date = "2024.09.12";
        $content = "在学长的推荐下，我进入了网络安全社团。";
        ?>
        <div class="text-area">
            <span class="create-day"><?php echo "$date"; ?></span>
            <?php echo "$content"; ?>
        </div>

        <!-- 第三种写法：仍然使用php变量，不过使用php将html代码块包裹起来,并使用分隔符 -->
        <?php
        $date = "2024.09.17";
        $content = "那是第一次TA向我表白。";
        echo '
        <div class="text-area">
            <span class="create-day">' . $date . '</span>
            ' . $content . '
        </div>
        '; ?>

        <!-- 第四种写法：仍然使用php变量，不过使用php将html代码块包裹起来,并使用php定界符 -->
        <?php
        $date = "2024.09.17";
        $content = "那是第一次TA向我表白。";
        echo <<<EOF
        <div class="text-area">
            <span class="create-day"> $date </span>
            $content 
        </div>
EOF;
        ?>

        <!-- 第五种写法：仍然使用php变量，不过使用php将html代码块包裹起来,并使用转义符号 -->
        <?php
        $date = "2024.12.04";
        $content = "我被确诊为中度抑郁，没机会了，一切都结束了。";
        echo "
        <div class=\"text-area\">
            <span class=\"create-day\">$date</span>
            $content
        </div>
        "; ?>
    </div>
</body>

</html>
```

PHP EOF定界符(heredoc)
-
以```<<<FOF```开始标记开始，以```EOF```结束标记结束  
结束标记必须顶头写，独自占一行，不能有缩进和空格，末尾要有分号  

```EOF```可以用任意其他字符代替，开始标记和结束标记相同即可，比如常用大写的```EOT```、```EOD```、```EOF```来表示，但是不局限于那几个，也可以用```JSON```、```HTML```等，只要保证开始标记和结束标记不在正文中出现即可。  

位于开始标记和结束标记之间的变量可以被正常解析，但是函数则不可以，在```heredoc```中，变量不需要用连接符```.```或```,```来拼接  

当内容需要内嵌引号（单引号或双引号）时，不需要加转义符，本身对单引号转义。
```php
<?php
// 1.可以在变量中使用EOF定界符，同时EOF定界符也可以引用变量。
$best = "php";
$a = <<<EOF
$best 是世界上最好的语言!
EOF;
echo $a;

//2.在定界符中，html标签会被解析
echo <<<EOF
<b>php是世界上最好的语言!</b>
EOF;

//3.在界定符里，不管单引号和双引号，都不影响转义符的转移效果
echo <<<EOF
"在定界符中双引号依旧被保留，双引号内也会保留转义符的转义效果，比如table:\t和换行:\n下一行"
'单引号也是哦，也会保留转义符的转义效果，比如table:\t和换行:\n下一行'
EOF;
?>
```
PHP EOF定界符(nowdoc)
-
```php
//注意看，与heredoc不同的是，nowdoc的变量和转义符均不会被执行，定界符由单引号包裹
<?php
$best = "php";
$a = <<<'EOF'
$best 是世界上最好的语言!
EOF;
echo $a;
echo <<<'EOF'
"在定界符中双引号依旧被保留，双引号内也会保留转义符的转义效果，比如table:\t和换行:\n下一行"
'单引号也是哦，也会保留转义符的转义效果，比如table:\t和换行:\n下一行'
EOF;
?>
```
PHP 模板字符串
-
```php
$name = 'wyw566487';
echo "Hello,{$name}";
//等同于
echo "Hello,$name";
//引用数组中的变量
$arr = ["name" => "wyw"];
//[]中也可以用双引号
echo "Hello,{$arr['name']}";
echo "Hello,{$arr["name"]}";
```

PHP printf()和sprintf()
-
```php
<?php
$name='wyw';
$school='长汽大学';
//printf是直接输出,不返回任何值
printf("我是%s，毕业于%s",$name,$school);
//printf不输出,但有返回值
$test = sprintf("我是%s，毕业于%s",$name,$school);
var_dump($test);
?>
```
PHP 算数运算符
-
```php
<?php
//加、减、乘、除  +-*/
echo 53 + 55;//108
echo 715 - 167;//548
echo 12 * 87;//1044
echo 102 / 12;//8.5
//取余 %
echo 100 % 14;//2
$a = -19;
//取相反数 -x
echo -$a;//19
echo '<hr>';
//除法取整 php7引入
//float 会提示丢失精度
echo intdiv(10,3);
//按二进制位进行"取反运算" ~x
?>
```
以下表格内容来自<https://www.runoob.com/php/php-operators.html>

PHP 赋值运算符
-
|运算符|等同于|意义|
|-|-|-|
|x = y|x = y|赋值|
|x += y|x = x + y|加|
|x -= y|x = x - y|减|
|x *= y|x = x * y|乘|
|x /= y|x = x / y|除|
|x %= y|x = x % y|取余|
|x .= y|x = x . y|连接字符串|

PHP 递增递减运算符
-
|运算符|名称|描述|
|-|-|-|
|++ x|预递增|x+1,然后返回x|
|x ++|后递增|返回x,然后x+1|
|-- x|预递减|x-1,然后返回x|
|x --|后递减|返回x,然后x-1|

PHP 比较运算符
-
|运算符	|名称	|描述	|实例|
|-|-|-|-|
|x == y|等于|如果 x 等于 y，则返回 true|5==8 返回 false|
|x === y|绝对等于|如果 x 等于 y，且它们类型相同，则返回 true|5==="5" 返回 false|
|x != y|不等于|	如果 x 不等于 y，则返回 true|5!=8 返回 true|
|x <> y|不等于|	如果 x 不等于 y，则返回 true|5<>8 返回 true|
|x !== y|不绝对等于|如果 x 不等于 y，或它们类型不相同，则返回 true|5!=="5" 返回 true|
|x > y|大于|如果 x 大于 y，则返回 true|5>8 返回 false|
|x < y|小于|如果 x 小于 y，则返回 true|5<8 返回 true|
|x >= y|大于等于|如果 x 大于或者等于 y，则返回 true|5>=8 返回 false|
|x <= y|小于等于|如果 x 小于或者等于 y，则返回 true|5<=8 返回 true|

PHP 逻辑运算符
-
|运算符|	名称	|描述	|实例|
|-|-|-|-|
|x && y	|与|如果 x 和 y 都为 true，则返回 true	|x=6y=3(x < 10 && y > 1) 返回 true|
|x and y|与|如果 x 和 y 都为 true，则返回 true|	x=6y=3(x < 10 and y > 1) 返回 true|
|x(双竖线)y|或|如果 x 和 y 至少有一个为 true，则返回 true|	x=6y=3(x==5(双竖线)y==5) 返回 false|
|x or y	|或|如果 x 和 y 至少有一个为 true，则返回 true|	x=6y=3(x==6 or y==5) 返回 true|
|x xor y|异或|如果 x 和 y 有且仅有一个为 true，则返回 true（一真一假）|x=6y=3(x==6 xor y==3) 返回 false|
|! x|非|如果 x 不为 true，则返回 true|	x=6,y=3!(x==y) 返回 true|

省流：与，两个都是true才行。或，有一个为true就行。异或，一true一false才行。非，反过来不为true，则true。

也许你发现了and和&&，or和||的功能一样  
但是它们还是有区别的  
主要体现在优先级:  
&& 运算符的优先级比and运算符高  
在一个表达式中，&&运算符会先被执行，然后才是and运算符。
```php
<?php
$bool1 = true && false;
$bool2 = false && true;
$bool3 = true and false;
$bool4 = false and true;
var_dump($bool1);//false
var_dump($bool2);//false
var_dump($bool3);//true
var_dump($boola = true and false);//false
var_dump($bool4);//false
var_dump($boolb = true and false);//false
?>
```
同样的，在一个表达式中，||运算符会先被执行，然后才是or运算符。
```php
<?php
$bool1 = true || false;
$bool2 = false || true;
$bool3 = true or false;
$bool4 = false or true;
var_dump($bool1);//true
var_dump($bool2);//true
var_dump($bool3);//true
var_dump($boola = true or false);//true
var_dump($bool4);//false
var_dump($boolb = false or true);//true
?>
```
and和or有阻断效果
```php
<?php
//or的话,如果前面是true,后面就不在执行了
//提示：在布尔语境中，非零值被视为 true，0视为false
//var_dump 函数的返回值为 null
$result1 = 1 or var_dump('执行语句');//前面为true，不再继续执行，无输出。
var_dump($result1);//1
$result2 = 0 or var_dump('执行语句');//前面为false，所以继续计算，string(12) "执行语句"
var_dump($result2);//0
$result5 = (1 or var_dump('执行语句'));//前面为true，不再继续执行，无输出，这句话等价于 true or (NULL)false
var_dump($result5);//满足至少一个为true，输出true
$result6 = (0 or var_dump('执行语句'));//前面为false，所以继续计算，string(12) "执行语句"，这句话等价于 false or (NULL)false
var_dump($result6);//不满足至少一个为true，输出false
//$result5 = (1 or var_dump('执行语句'));等价于$result5 = 1 || var_dump('执行语句');
?>
```
```php
<?php
//and的话，如果前面是false，后面就不再执行了
//提示：在布尔语境中，非零值被视为 true，0视为false
//var_dump 函数的返回值为 null
$result1 = 1 and var_dump('执行语句');//前面为true，所以继续计算，string(12) "执行语句"
var_dump($result1);//1
$result2 = 0 and var_dump('执行语句');//前面为false，不再继续执行，无输出。
var_dump($result2);//0
$result5 = (1 and var_dump('执行语句'));//前面为true，所以继续计算，string(12) "执行语句"，这句话等价于 true and (NULL)false
var_dump($result5);//不满足两个为true，false
$result6 = (0 and var_dump('执行语句'));//前面为false，不再继续执行，无输出，这句话等价于 false and (NULL)false
var_dump($result6);//不满足两个为true，false
?>
//$result5 = (1 and var_dump('执行语句'));等价于$result5 = 1 && var_dump('执行语句');
```
PHP 条件语句
-
if语句
仅当指定条件成立时执行代码
```php
if (条件)
{
    条件成立时执行的代码;
}
```
if...else...语句
在条件成立时执行一块代码，条件不成立时执行另一块代码
```php
if (条件)
{
    条件成立时执行的代码;
}
else
{
    条件不成立时执行的代码;
}

```
if...elseif...else语句
```php
if (条件)
{
    if条件成立时执行的代码;
}
elseif (条件)
{
    elseif条件成立时执行的代码;
}
elseif (条件)
{
    elseif条件成立时执行的代码;
}
else
{
    条件不成立时执行的代码;
}
```
switch
-
注意：break很重要。不要漏掉
```php
<?php
switch (n) {
    case 1:
        //如果n=1，此处代码将执行;
        break;
    case 2:
        //如果n=1，此处代码将执行;
        break;
    default:
        //如果n即不等于1也不等于2，此处代码将执行;
}
?>
```
什么时候适合用switch？
适合条件比较多，并且条件单一固定值匹配时用

循环
-
### for循环
用于预先知道脚本需要运行
```php
for (初始值;条件;增量) { 
    要执行的代码(叫循环体);
}
```
参数：
初始值：主要是初始化一个变量值，用于设置一个计数器（但可以是任何循环的开始被执行一次的代码）
条件：循环执行的限制条件。如果为TRUE，则循环继续。如果为FALSE，则循环结束.
增量：主要用于递增计数器（但可以是任何在循环的结束被执行的代码）。

注释：
上面的初始值和增量参数可为空，或者有多个表达式（用逗号分隔）。
```php
for ($i = 1, $j = 0; $i <= 5; ) {
    echo "数字为" . $i . $j . PHP_EOL;
    $i++;
}
```

### while循环
只要指定的条件成立，则循环执行代码块，直到指定的条件不成立
```php
while(条件)
{
    要执行的代码;
}
```
注意避免死循环
```php
<?php
$i = 1;
while ($i <= 5) {
    echo "the number is" . $i . "<br>";
    $i++;
}
?>
```
while可以改成for循环
```php
<?php
for ($i = 1; $i <= 5; $i++) {
    echo "the number is" . $i . "<br>";
}
?>
```

### do...while循环
语句会至少执行一次代码，然后检查条件，就会重复进行循环
```php
do
{
    要执行的代码;
}
while(条件);
```
```php
$i = 1;
do {
    $i++;
    echo "the number is" . $i . "<br>";
}
while ($i <= 5);
```
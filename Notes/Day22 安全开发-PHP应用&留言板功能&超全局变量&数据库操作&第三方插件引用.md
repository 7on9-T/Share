Day22 安全开发-PHP应用&留言板功能&超全局变量&数据库操作&第三方插件引用
-
知识点
-
1、PHP留言板前后端功能实现  
2、数据库创建&架构&增删改查  
3、内置超全局变量&HTML&JS混编  
4、第三方应用插件&传参&对象调用  

PHP、js、css
-  
功能：新闻列表，会员中心，资源下载，留言版，后台模块，模版引用，框架开发等   
技术：输入输出，超全局变量，数据库操作，逻辑架构，包含上传&下载删除;   
技术：JS&CSS混用，Cookie,Session操作，MVC架构，ThinkPHP引用等。  

开发环境： 
-
DW + PHPStorm + PhpStudy+ Navicat Premium  
DW: HTML&JS&CSS开发  
PHPStorm : 专业PHP开发IDE  
PhpStudy：Apache MYSQL环境  
NavicatPremium: 全能数据库管理工具  

虽然但是，我还是喜欢用Visual Studio Code  

数据导入-mysql架构&库表列  
-
1、数据库名，数据库表名，数据库列名  
2、数据库数据，格式类型，长度，键等  
#数据库操作-mysqli函数&增删改查  
PHP函数：连接，选择，执行，结果，关闭等  
参考：https://www.runoob.com/php/php-ref-mysqli.html  
常用：  
mysqli_connect()打开一个到MySQL的新的连接。  
mysqli_select_db()更改连接的默认数据库。  
mysqli_query()执行某个针对数据库的查询。  
mysqli_fetch_row()从结果集中取得一行，并作为枚举数组返回。  
mysqli_close()关闭先前打开的数据库连接。  

MYSQL增删改查：  
-
查：
```sql
select * from 表名where 列名='条件';  
```
增：
```sql
insert into 表名(`列名1`, `列名2`) value('列1值1', '列2值2');  
```
删：
```sql
delete from 表名where 列名= '条件';  
```
改：
```sql
update 表名set 列名= 数据where 列名= '条件';  
```
#数据接收输出-html混编&超全局变量  
1、html混编：使HTML(JS)在PHP语言中运行
```php
<?php
echo '<script>alert('x');</script>'
?>
```
2、超全局变量：
参考：
https://www.w3school.com.cn/php/php_superglobals.asp  
https://www.php.net/manual/zh/language.variables.superglobals.php  
$GLOBALS：这种全局变量用于在PHP 脚本中的任意位置访问全局变量  
$_SERVER：这种超全局变量保存关于报头、路径和脚本位置的信息。  
$_REQUEST：用于收集HTML 表单提交的数据。  
$_POST：广泛用于收集提交method="post" 的HTML表单后的表单数据。  
$_GET:收集URL中的发送的数据。也可用于收集提交HTML表单数据(method="get")  
$_FILES:文件上传且处理包含通过HTTP POST方法上传给当前脚本的文件内容。  
$_ENV:是一个包含服务器端环境变量的数组。  
$_COOKIE:是一个关联数组，包含通过cookie传递给当前脚本的内容。  
$_SESSION:是一个关联数组，包含当前脚本中的所有session内容  

#第三方插件引用-is传参&函数对象调用
引用:
```html
<script src='../xxx.js'></script>
```
函数对象调用:
```js
var obj={
value:0,
increment:function(inc){
this.value += typeof inc === ‘number’? inc :1;
}
}
```

实战
-
先决条件

index.php
```html
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
</head>

<body>
    <!-- 以下是使用html编写的一个评论区 -->
    <!-- ueditor配置文件 -->
    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <!-- ueditor源码文件 -->
    <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
    <!-- New form -->
    <form id="form1" name="form1" method="post" action="">
        <!-- 创建一个用户名的文本框 -->
        用户名：<input type="text" name="username" maxlength="2000"><br>
        <!-- 创建一个评论的输入框 -->
        Note:善语结善缘，恶语伤人心。<br>
        内容：
        <script id="content" name="content" type="text/plain"></script>
        <!-- 实例化编辑器,id为将要被替换的容器。-->
        <script type="text/javascript">
            var ue = UE.getEditor('content');
        </script>
        <!-- 提交按钮 -->
        <input type="submit" name="submit" id="submit" value="提交">
    </form>
</body>

</html>
```
```php
<?php
//导入MySQL数据库配置   
include 'config.php';

//定义评论功能，传入config.php数据库连接
function add_comment($con)
{
    //初始化用户名变量
    $u = @$_POST['username'];
    //当用户名不为空时，执行以下操作
    if (isset($u)) {
        //记录评论内容
        $c = @$_POST['content'];
        //获取用户的IP地址
        $i = @$_SERVER['REMOTE_ADDR'];
        //获取用户User-Agent
        $ua = @$_SERVER['HTTP_USER_AGENT'];
        //将用户的用户名、评论内容、ip、ua写入到数据库的blog表
        $sql = "insert into blog(`username`, `content`,`ipaddr`,`uagent`) value('$u', '$c','$i','$ua');";
        //如果数据库能正常连接，sql语句能正确执行，则提示“留言成功”。
        if (mysqli_query($con, $sql)) {
            echo "<script>alert('留言成功！')</script>";
        }
    }
}

//定义评论展示功能，同样也需要传入config.php数据库连接
function show_comment($con, $del): void
{
    //将查询评论的sql语句，存入$sql1变量中
    $sql1 = "select * from blog";
    //执行sql语句，并将查询结果存入$data变量中
    $data = mysqli_query($con, $sql1);
    //对$data进行进一步处理
    //mysqli_fetch_row是从结果中取一行
    //while是反复执行，直到输出所有内容
    while ($row = mysqli_fetch_row(result: $data)) {
        //按照模板提示进行展示。
        //row是列数，<br>换行
        echo '<hr>';
        echo '用户名：' . $row[0] . '<br>';
        echo '内容：' . $row[1] . '<br>';
        echo 'IP地址：' . $row[2] . '<br>';
        echo 'UA浏览器：' . $row[3] . '<br>';
        //如果
        if ($del == 'del') {
            //删除按钮
            echo "<a href='index.php?del=$row[0]'>删除</a>";
        }
    }
}

add_comment($con);
show_comment($con, 'x');

// if (!$connect)
// {
//     die("connect error:".mysqli_connect_error());
// }else{
//     $u=@$_POST['username'];
//     if(isset($u)){
//       $c=@$_POST['content'];
//       $ip=@$_SERVER['REMOTE_ADDR'];
//       $ua=@$_SERVER['HTTP_USER_AGENT'];
//       $sql="insert into blog(`username`,`content`,`ipaddr`,`uagent`) value('$u','$c','$ip','$ua');";
//       mysqli_query($connect,$sql);
//       echo "<script>alert('Success!')</script>";
//       $sql1="select * from blog";
//       $data=mysqli_query($connect,$sql1);
//       while($row=mysqli_fetch_row($data))
//       {
//         echo '<hr>';
//         echo 'username:'.$row[0].'<br>';
//         echo 'content:' .$row[1].'<br>';
//         echo 'ip address:' .$row[2].'<br>';
//         echo 'uagent:' .$row[3].'<br>';
//         echo "<br>";
//       }
//     }else{
//       echo "<script>alert('Failure!')</script>";
//     }
// }
```
config.php
```php
<?php
//本文件存储MySQL数据库的配置
//数据库ip地址
$dbip='localhost';
//用户名
$dbuser='root';
//密码
$dbpass='password';
//数据库名
$dbname='demo01';
//创建连接
$con=mysqli_connect($dbip,$dbuser,$dbpass,$dbname);
```

admin/index.php
```php
<?php
//
include '../config.php';
include '../index.php';

show_comment($con,'del');
//
$delstr=@$_GET['del'];
if(isset($delstr)){
    $sql2="delete from blog where username = '$delstr';";
    if(mysqli_query($con,$sql2)){
        echo "<script>alert('删除成功!')</script>";
    }
}

```

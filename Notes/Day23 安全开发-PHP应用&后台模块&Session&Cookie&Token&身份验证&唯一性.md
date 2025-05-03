Day23安全开发-PHP应用&后台模块&Session&Cookie&Token&身份验证&唯一性
=
前置知识
-
Cookie、Session-身份验证  
Cookie是某些网站为了辨别用户身份，进行Session跟踪而储存在用户本地终端上的数据（通常经过加密），由用户客户端计算机暂时或永久保存的信息。  
Session会话凭据  
Token-数据唯一性  

1、PHP后台身份验证模块实现  
2、Cookie&Session技术&差异  
3、Token数据包唯一性应用场景  

项目1：用cookie做后台身份验证  
项目2：用session做后台身份验证  
项目3：用token做用户登录判断  

身份验证-Cookie使用  
生成cookie的原理  
1、客户端向服务器发送HTTP请求。  
2、服务器检查请求头中是否包含cookie信息。  
3、如果请求头中包含cookie信息，则服务器使用该cookie来识别客户端，否则服务器将生成一个新的cookie。  
4、服务器在响应头中设置cookie信息并将其发送回客户端。  
5、客户端接收响应并将cookie保存在本地。  
6、当客户端发送下一次HTTP请求时，它会将cookie信息附加到请求头中。  
7、服务器收到请求并检查cookie的有效性。  
8、如果cookie有效，则服务器响应请求。否则，服务器可能会要求客户端重新登录。  

setcookie(): 设置一个cookie并发送到客户端浏览器。  
unset(): 用于删除指定的cookie。  

身份验证-Session使用  
1、客户端向服务器发送HTTP请求。  
2、服务器为客户端生成一个唯一的session ID，并将其存储在服务器端的存储器中（如文件、数据库等）。  
3、服务器将生成的session ID作为一个cookie发送给客户端。  
4、客户端将session ID保存为一个cookie，通常是在本地浏览器中存储。  
5、当客户端在发送下一次HTTP请求时，它会将该cookie信息附加到请求头中，以便服务器可以通过该session ID来识别客户端。  
6、服务器使用session ID来检索存储在服务器端存储器中的与该客户端相关的session数据，从而在客户端和服务器之间共享数据。  
session_start(): 启动会话，用于开始或恢复一个已经存在的会话。  
$_SESSION: 用于存储和访问当前会话中的所有变量。  
session_destroy(): 销毁当前会话中的所有数据。  
session_unset(): 释放当前会话中的所有变量。  
Session存储路径：PHP.INI中session.save_path设置路径  

暴露的安全问题：  
攻击者伪造cookie（登录请求伪造），可以非法进入后台。  
Cookie是一种不安全的验证  

Token的使用  
1.	生成Token并将其存储在Session  
2.	生成Token并将其绑定在cookie触发  
3.	尝试登录表单中带入Token验证逻辑  
4.	思考Token安全特性  
具体安全知识点  
Cookie和Session都是用来在Web应用程序中跟踪用户状态的机制  
1.	存储位置不同  
Cookie是存储在客户端（浏览器）上的，Session是存储在服务器上的  
2.	安全性不同  
Cookie存储在客户端上的，可能会被黑客窃取信息，而Session存储在服务器上，更加安全  
3.	存储容量不同  
Cookie的存储容量有限，一般为4KB，而session的存储容量理论上没有限制，取决于服务器的硬件和配置。  
4.	生命周期不同  
Cookie可以设置过期时间，即便关闭浏览器或者重新打开电脑，Cookie仍然存在，直到过期或者被删除。而session一般默认在浏览器关闭后就会过期，  
5.	访问方式不同  
Cookie可以通过JavaScript访问，而Session只能在服务器端进行访问  
6.	使用场景不同  
Cookie一般用于存储小型的数据，如用户的用户名和密码等信息。而Session一般用于存储大型数据。一般来说，如果需要存储敏感信息或者数据较大，建议使用Session;如果只需要存储少量的数据，  
-在web应用程序中，使用token和不使用token的主要差异在于身份验证和安全性。  
1.身份验证:采用token机制的web应用程序，用户在登录成功后会收到一个token，这个token可以在并且需要在客户端进行访问，可以选择使用Cookie。  
每次请求时发送给服务器进行身份验证，而不采用token机制的web应用程序，一般会使用session机制来保存用户登录状态，服务器会在用户登录成功创建一个sessiom，之后的每个请求都需要在HTTP头中附带这个session ID，以便服务能够验证用户身份。  
2、安全性:采用token机制的web应用程序，在服务器上不会存储用户的登录状态，只需要存储token即可。因此，即使token被盗取，黑客也无法获得用户的密码或者其他敏感信息。而不采用token机制的web应用程序，一般会在服务器上存储用户的登录状态，因此如果服务器被黑客攻击，黑客可能会获得用户的敏感信息。  
3、跨域访问:采用token机制的web应用程序，在跨域访问时，可以使用HTTP头中的Authorization字段来传递token信息，方便实现跨域访问。而不采用token机制的web应用程序，在跨域访问时，需使用cookie或session来传递用户身份信息，比较麻烦。  
总之，采用token机制可以提高web应用程序的安全性，并且方便实现跨域访问。不过，使用token机制也需要开发者自己来实现身份验证和token的生成和验证，相对来说比较复杂。而不采用token机制，使用session机制则相对简单，但是安全性相对较低。因此，具体采用哪种机制，需要根据实际情况进行权衡和选择。  

## 实战1-用cookie做后台身份验证

admin-c.php
-
```html
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="" method="post">
            <label for="username">username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>
```
```php
<?php
// 登录页面
// 1.接受输入的账号密码
// 2.判断密码是否正确
// 3.正确后生成的cookie进行保存
// 3.1错误的账号密码进行提示
// 4.跳转至成功登录的页面

//导入数据库连接配置
include '../config.php';
// 1.从html文本框接收输入的账号密码。
$user = $_POST['username'];
$pass = $_POST['password'];
// 2.判断密码是否正确。
// 连接数据库 进行数据查询 将数据进行对比
// select * from 表名where 列名='条件';  
$sql1 = "select * from admin where username='$user' and password ='$pass';";
//$user替换成刚刚输入的用户名，$pass同理。
$data = mysqli_query($con, $sql1);
//form中的post请求
if ($_SERVER["REQUEST_METHOD"] = "POST") {
    //可见，输入正确的用户名和密码，就会输出数据（1行），就会进入到if
    if (mysqli_num_rows($data) > 0) {
        //设置cookie 3分钟后过期
        $expire = time() + 60 * 3;
        //设置用户名cookie
        setcookie('username', $user, $expire, '/');
        //设置密码的cookie
        setcookie('password', $pass, $expire, '/');
        //跳转到index-c.php后台页面
        header('Location:index-c.php');
        exit();
    } else {
        //否则提示密码错误
        echo '<script>alert("Login Failed!")</script>';
    }
}

```
index-c.php
-
```php
<?php
//登录成功的首页文件
// include '../config.php';
// $sql1 = "select * from admin where username='$user' and password ='$pass';";
// $data = mysqli_query($con, $sql1);
if ($_COOKIE['username'] != 'wyw' or $_COOKIE['password'] != 'techismylife0.') {
    header('Location:admin-c.php');
}
?>
```
```html
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>后台首页</title>
</head>

<body>
    <h1>后台首页</h1>
    <p>欢迎您，<?php echo $_COOKIE['username'] ?>!</p>
    <p><a href="logout-c.php">退出登录</a></p>
</body>
```
logout-c.php
-
```php
<?php
//登出文件
setcookie('username',"", time() -3600,"/");
setcookie('password',"", time() -3600,"/");
header('Location:admin-c.php');
exit;
?>
```

## 实战2-用session做后台身份验证
admin-s.php
-
```html
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="" method="post">
            <label for="username">username:</label>
            <!-- required 请填写该字段 -->
            <input type="text" id="username" name="username" required>

            <label for="password">password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>
```
```php
<?php
//登录页面
include '../config.php';

// 1.从html文本框接受输入的账号密码。
$user = $_POST['username'];
$pass = $_POST['password'];
// 2.判断密码是否正确。
// 连接数据库 进行数据查询 将数据进行对比
// select * from 表名where 列名='条件';  
$sql1 = "select * from admin where username='$user' and password ='$pass';";
//$user替换成刚刚输入的用户名，$pass同理。
$data = mysqli_query($con, $sql1);
// mysql> select * from admin where username='wyw' and password ='techismylife0.';
// +----------+----------------+
// | username | password       |
// +----------+----------------+
// | wyw      | techismylife0. |
// +----------+----------------+
// 1 row in set (0.02 sec)
if ($_SERVER["REQUEST_METHOD"] = "POST") {
    //可见，输入正确的用户名和密码，就会输出数据（1行），就会进入到if
    if (mysqli_num_rows($data) > 0) {
        //启用session
        session_start();
        //将用户名、密码写入session
        $_SESSION['username'] = $user;
        $_SESSION['password'] = $pass;
        //Session存储路径：PHP.INI中session.save_path设置路径
        //phpstudy:session.save_path="D:\phpstudy_pro\Extensions\tmp\tmp"
        header('Location:index-s.php');
    }else{
        echo'<script>alert("用户名或密码错误。")</script>';
    }
}
?>
```
index-s.php
-
```php
<?php
//登录成功文件-采用session验证
//设置session.
session_start();
//省去查询操作 直接赋值 生产环境中应进行更改。。
if ($_SESSION['username'] != 'wyw' && $_SESSION['password'] != 'techismylife0.') {
    header('Location:admin-s.php');
}
?>
```
```html
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>后台首页</title>
</head>
<body>
    <h1>后台首页</h1>
    <p>欢迎您，<?php echo $_SESSION['username'] ?>!</p>
    <p><a href="logout-s.php">退出登录</a></p>
</body>
```
logout-s.php
-
```php
<?php
//登出文件

//设置session
session_start();
//取消设置session
session_unset();
//删除（摧毁）本次的session
session_destroy();

//返回登录页面
header('Location:admin-s.php');
exit();
?>
```

## 实战3-用token做出身份判断
token.php
-
```php
<?php
session_start();
$token = bin2hex(random_bytes(16));
$_SESSION['token']= $token;
setcookie('token', $token, time() + 3600,'/');
?>
```
```html
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="token-check.php" method="post">
            <input type="hidden" name="token" value="<?php echo $token; ?>">
            <label for="username">username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>
```
token-check.php
```php
<?php
include '../config.php';

//生成token并将其存储在Session中
//关闭浏览器插件导致访问失败
session_start();
//1.因为是用的session维持会话，token已经绑定到下面的表单了
//2.token，生成之后直接存到session里，主要是方便重置token
//每次token随表单提交后都需要重置以保持token的唯一性
$token = $_COOKIE['token'] ?? '';
// if ($_POST['username'] == 'wyw' && $_POST['password'] == 'techismylife0.' && $_SESSION['token'] == $token) {
//     echo 'success!';
// } else {
//     echo 'fail';
// }
if ($token !== $_SESSION['token'] ) {
    header('HTTP/1.1 403 Forbidden');
    $_SESSION['token']= bin2hex(random_bytes(16));
    echo 'Access denied';
    exit();
} else {
    $_SESSION['token'] = bin2hex(random_bytes(16));
    if ($_POST['username'] == 'admin' && $_POST['password'] == 'techismylife0.') {
        echo '登录成功，你现在是管理员身份!';
    } else {
        echo '用户名或密码错误';
    }
}
?>
```
测试时，请关闭所有浏览器的扩展插件（加载项）。


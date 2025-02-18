Day17 信息打点-语言框架&开发组件&FastJson&Shiro&Log4j&SpringBoot等
=

1、CMS指纹识别-不出网程序识别  
2、开发框架识别-PHP&Python&Java  
3、开发组件识别-Java常见安全漏洞组件  


演示案例：  
 指纹识别-本地工具-GotoScan  
 Python-开发框架-Django&Flask  
 PHP-开发框架-ThinkPHP&Laravel&Yii  
 Java-框架组件-FastJson&Shiro&Solr&Spring  

后端：  
CMS：一般PHP开发源码程序居多  
（去搜源码的漏洞情况，下载源码进行后期的代码审计）  
前端  
js框架（爬取更多的js，从里面筛选URL或敏感泄漏key等）  
也可以通过对js代码逻辑进行代码审计  
组件：java居多，  
常见有过安全漏洞组件（shiro solr log4j sprintboot等）  
框架：php java python都有  
框架：简单代码的一个整合库，如果使用框架就只需要学习使用框架调用即可  
如：文件上传功能是需要很多代码来实现的，框架把这个代码进行封封装，调用即可  
影响：如果采用框架开发，代码的安全性是取决于框架的过滤机制  
组件：第三方的功能模块（日志记录，数据监控，数据转换等）  

Web架构：  
1、最简单最入门的开发模型（功能代码全部手写）  
极易出现漏洞，程序员水平不一，没有第三方或团队的检测，单纯的自己写  
2、结合开发框架的开发模型（以框架为核心实现功能）  
第三方或团队的开发的封装代码框架，一般内置的过滤机制（框架漏洞）  
3、结合开发框架外加组件模型（以框架为核心，组件为辅实现功能）  
第三方或团队的开发的封装代码框架，一般内置的过滤机制（框架和组件漏洞）  


指纹识别-本地工具-GotoScan（CMSEEK）  
1、在线平台见前面的笔记，本地工具适用于不出网环境  
https://github.com/newbe3three/gotoscan  
2、网络空间：Fofa Quake Hunter  
3、网络空间：根据ICO图标判断  

Python开发框架  
Django  
1、识别插件  
2、Set-Cookie:expires=  

Flask   
1、识别插件  
2、Set-Cookie:expires=  

PHP开发框架  
ThinkPHP:  
0、识别插件  
1、X-Powered-By:ThinkPHP  
2、CMS识别到源码体系TP开发  

Laravel:  
1、识别插件  
2、Set-Cookie中特征的格式  

Yii :  
1、识别插件  
2、Set-Cookie中特征的格式  

#Java-框架组件-Fastjson&Shiro&Solr&Spring

52类110个主流Java组件和框架介绍:  
https://blog.csdn.net/agonie201218/article/details/125300729

Fastison/Jackson  
在提交JSON数据包中修改测试:  
-Fastjson组件会把01解析成1  
-Jackson组件在解析01时会抛出异常  
https://forum.butian.net/share/1679  
<del>https://www.iculture.cc/forum-post/24115.html</del>

Shiro
请求包的cookie中存在rememberMe字段。  
返回包中存在set-Cookie:remeberMe=deleteMe。  
请求包中存在rememberMe=x时，响应包中存在rememberMe=deleteMe。  
有时候服务器不会主动返回remeberMe=deleteMe，直接发包即可，将Cookie内容改为remember Me=1，若相应包有remeberMe=deleteMe，则基本可以确定网站apache shiro搭建的。  

Struts2
一般使用struts2框架后缀带do或action，可以尝试进行利用

Springboot
一般开放8983端口。访问页面也可以探针到  

番外：  
配置Django  
Django 是一个高级 Python Web 框架。  
1.	安装Python。  
2.	python -m pip install Django  
3.	若要验证 Django 是否能被 Python 识别，可以在 shell 中输入 python。 然后在 Python 提示符下，尝试导入 Django：

>>> import django
>>> print(django.get_version())
2. 创建项目(startproject)
2.1 创建项目  
cd Django
django-admin startproject first_try
2.2项目文件介绍  
first_try
	manage.py		// 好东西，项目管理、启动、创建app、数据管理都在这里，不要动它
    first_try
    	__init__.py
        settings.py	// 项目的配置文件，很多操作也在这里（链接数据库）
        urls.py		// url和python函数的对应关系都在这里，操作基本都在这里
        asgi.py		// 异步接受网络请求的
        wsgi.py		// 同步接受网络请求的
2.3APP(startapp)  
 app不是应用，是功能的划分。
 创建是靠manage.py创建的，终端输入
python manage.py startapp application01


appliction01
	__init__.py
	admin.py			// django默认的自带后台管理
	apps.py				// app启动类
	migrations			// 数据库变更记录
		__init__.py
	models.py			// 数据库的操作在这里
	test.py				// 单元测试
	views.py			// first_try里面的url里的函数一般都要在这里找（常用）

使用 pip 安装 Flask
我们可以使用 Python 的包管理器 pip 可以用来安装Flask。
pip install Flask
安装完成后，可以通过以下命令验证 Flask 是否安装成功：
pip show Flask

thinkphp：https://doc.thinkphp.cn/v8_0/setup.html
composer create-project topthink/think tp
cdyp
php think run


laravel：
composer create-project laravel/laravel example-app
cd example-app
php artisan serve


Yii：
composer create-project --prefer-dist yiisoft/yii2-app-basic basic
php yii serve --port=8888

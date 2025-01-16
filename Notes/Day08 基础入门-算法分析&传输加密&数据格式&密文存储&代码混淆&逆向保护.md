Day08 基础入门-算法分析&传输加密&数据格式&密文存储&代码混淆&逆向保护  
=
建议观看视频-MD5为何不再安全
-
<https://www.bilibili.com/video/BV1S541127qR>

2004年，山东大学王小云教授找到了快速大量MD5真碰撞的方法，发现了MD5的碰撞原理震惊了全世界。  

1、	存储密码加密-应用对象  
2、	传输加密编码-发送回显  
3、	数据传输格式-统一格式  
4、	代码特性混淆-开发语言  

例子：
https://indialms.in/wfp_login.php?r_id=1  
https://indialms.in/wfp_login.php?r_id=MQ==  

数据在传输的时候进行编码 为什么要了解?  
对方服务器可能会在接受的时候进行解码在带入如果我们还是按照原有思路不对自己的Pay1oad进行同样编码的话 传入过去的东西就是不认识的东西 测试无效  
安全测试漏洞时候 通常都会进行数据的修改增加提交测试  

正确:测试的话也要进行payload同样的加密或编码进行提交  

	#传输数据-编码型&加密型等  
	例：  
	某视频、某Web站、博客登录、APP-斗地主  
	影响：漏洞探针  
	
	#传输格式-常规&JSON&XML等  
	例：  
	-App-期H  
	-APP-斗地主  
	影响：发送漏洞探针,回显数据分析  
	
	#密码存储-Web&系统&三方应用  
	例：  
	-ZZZCMS&Dz  
	-Win&Linux  
	-MSSQL&MYSQL  
	影响：安全后渗透测试  
	
	#代码混淆-源代码加密&逆向保护  
	例：  
	-PHP&JS混淆加密  
	-EXE&JAR代码保护  
	影响：代码审计，逆向破解  
	
	https://indialms.in/wfp_login.php?r_id=1  
	base64编码   
	username=YWRtaW4=  
	https://indialms.in/wfp_login.php?r_id=MQ== 112123  
	
	数据在传输的时候进行编码 为什么要了解？  
	
	对方服务器可能会在接受的时候进行解码在带入  
	如果我们还是按照原有思路不对自己的Payload进行同样编码的话 传入过去的东西就是不认识的东西 测试无效  
	
	正确：测试的话也要进行payload同样的加密或编码进行提交  
	安全测试漏洞时候 通常都会进行数据的修改增加提交测试  
	以数据的正确格式发送 接受才行  
	
	
	登录的数据包：
	admin 123456
	
	MD5加密
	
	username=admin&password=123456
	username=admin&password=e10adc3949ba59abbe56e057f20f883e
	
	
	如果现在我要进行密码的破解爆破
	
	字典文件：
	帐号什么都不用更改 去替换username=值即可
	密码需要进行密码算法 保证和password=值同等加密才行
	
	https://tv.sohu.com/v/dXMvMzg1MjM2NzE5LzQyNzUyODUzOC5zaHRtbA==.html
	
	开发：数组 列表
	
	btnPost=%E7%99%BB%E5%BD%95&username=admin and &password=e10adc3949ba59abbe56e057f20f883e&savedate=1
	
	
	{
	
		btnPost:"%E7%99%BB%E5%BD%95"；
		username:"admin";
		password:"e10adc3949ba59abbe56e057f20f883e and";
		savedate:1;
	}
	
	
	json xml 常规
	x=123
	
	x=123
	{
		x:123
	}
	
	
	zzzcms admin /123456 密文利用md5加密
	
	md5(123456)=密文
	
	dz3.2 admin /123456 
	
	md5(md5(123456).salt)=密文
	
	dz3.5 admin / 123456
	aes des（密匙 偏移量 填充 模式等）
	$2y$10$OtsSmawENczg1BLcQCEn5OdLqJC9GLiDrClwEUooNnn8b609DfJc.
	
	大部分的解密都是碰撞式解密
	不是算法的逆向的还原解密
	
	1.常见加密编码进制等算法解析
	MD5，SHA，ASC，进制，时间戳，URL，BASE64，Unescape，AES，DES等
	2.常见加密编码形式算法解析
	直接加密，带salt，带密码，带偏移，带位数，带模式，带干扰，自定义组合等
	3.常见解密解码方式（针对）
	枚举，自定义逆向算法，可逆向
	4.常见加密解码算法的特性
	长度位数，字符规律，代码分析，搜索获取等
	
	#本课意义：
	1.了解加密编码进制在安全测试中的存在
	2.掌握常见的加密解密编码解码进制互转的操作
	3.了解常见的加密解密编码解密进制互转的影响
	
	识别算法编码方法：
	1、看密文位数
	2、看密文的特征（数字，字母，大小写，符号等）
	3、看当前密文存在的地方（Web，数据库，操作系统等应用）
	
	#拓展补充参考资料：
	-传输数据编码：
	BASE64 URL HEX ASCII 
	BASE64值是由数字"0-9"和字母"a-f"所组成的字符串,大小写敏感,结尾通常有符号=
	URL编码是由数字"0-9"和字母"a-f"所组成的字符串,大小写敏感,通常以%数字字母间隔
	HEX编码是计算机中数据的一种表示方法,将数据进行十六进制转换,它由0-9,A-F,组成
	ASCII编码是将128个字符进行进制数来表示,常见ASCII码表大小规则：0~9<A~Z<a~z
	-传输数据加密：同密码存储加密
	-传输数据格式：常规字符串 JSON XML等 
	
	-密码存储加密：
	MD5 SHA1 NTLM AES DES RC4
	MD5值是32或16位位由数字"0-9"和字母"a-f"所组成的字符串
	SHA1这种加密的密文特征跟MD5差不多，只不过位数是40
	NTLM这种加密是Windows的哈希密码，标准通讯安全协议
	AES,DES,RC4这些都是非对称性加密算法，引入密钥，密文特征与Base64类似
	
	代码混淆：
	JS前端代码加密：
	JS颜文字 jother JSFUCK
https://jsfuck.com/
	颜文字特征：一堆颜文字构成的js代码，在F12中可直接解密执行
	jother特征：只用! + ( ) [ ] { }这八个字符就能完成对任意字符串的编码。也可在F12中解密执行
	JSFUCK特征：与jother很像，只是少了{ }
	
	后端代码混淆：
	PHP .NET JAVA
	PHP：乱码，头部有信息
	.NET：DLL封装代码文件，加保护
	JAVA：JAR&CLASS文件，，加保护
	举例：加密平台 Zend ILSpy IDEA
	应用场景：版权代码加密，开发特性，CTF比赛等
	
	特定应用-数据库密文加密：
	MYSQL MSSQL Oracle Redis等
	
	数据显示编码：
	UTF-8 GBK2312等
	
	部分资源：
	https://www.cmd5.com
	http://tmxk.org/jother
	http://www.jsfuck.com
	http://www.hiencode.com
	http://tool.chacuo.net/cryptaes
	https://utf-8.jp/public/aaencode.html
	https://github.com/guyoung/CaptfEncoder
	
	https://blog.csdn.net/qq_40837276/article/details/83080460

Windows-NTLM

Mimikatz 是一款功能强大的开源后渗透测试工具，由法国安全研究员 Benjamin Delpy（网名 gentilkiwi）开发，主要用于 Windows 操作系统环境。  
功能特点  
1.	密码提取：能够从 Windows 系统内存中提取各种登录凭证信息，比如明文密码、哈希值等。例如可以获取本地登录用户的密码哈希，这对于后续进行密码破解或者尝试横向移动、权限提升等渗透测试环节十分有用。  
2.	票据操作：支持对 Kerberos 票据进行相关操作，像导出、注入票据等。攻击者可以利用这些功能，凭借合法获取的票据来冒充合法用户访问相应的网络资源，实现权限维持或在域环境中进行权限扩展等操作。  
3.	凭证获取与利用：除了常规的密码和票据外，还能获取如 Windows 的本地管理员账户密码、域用户账户密码等各类认证相关的凭证，方便攻击者在受控制的目标网络中进一步渗透、扩大控制范围。  
合法用途  
1.	安全测试：在经过授权的渗透测试场景中，安全专业人员可以使用 Mimikatz 来评估企业网络环境的安全性，检测系统是否存在可被利用的密码存储、传输等方面的漏洞，进而帮助企业更好地完善安全防护策略，提升整体安全水平。  
2.	应急响应：当怀疑系统遭受入侵，安全人员可以利用它来查看是否有非法获取的凭证信息遗留在内存中，辅助分析入侵的途径、范围以及攻击者可能获取到的权限等情况，以便采取有效的应对和恢复措施。  

Linux /etc/shadow  

Virbox Protector 
https://shell.virbox.com/

密码算法可以分为4个主要领域：  
1．	对称加密：用于加密任意大小的数据，包括消息、文件、加密密钥和口令  
2．	非对称加密：用于加密小的数据，如加密密钥或数字签名中使用的Hash函数值  
3．	数据完整性算法：用于保护数据块（例如一条消息）的内容免于被修改  
4．	认证协议：有许多基于密码算法的认证方案，用来认证实体的真实性

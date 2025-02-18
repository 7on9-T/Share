Day18信息打点-APP资产&知识产权&应用监控&静态提取&动态抓包&动态调试
=
APP资产-Web&备案信息&单位名称发现  
APP资产-静态提取&动态抓包&动态调试  

案例1：名称获取APP信息（爱企查/小蓝本/七麦/点点）  
1、爱企查知识产权  
2、七麦&点点查名称  
https://www.xiaolanben.com/   
https://aiqicha.baidu.com/   
https://www.qimai.cn/   
https://app.diandian.com/   
案例2：URL网站备案查APP  
1、查备案信息在搜  
2、网站上有APP下载  
3、市场直接搜单位名称  
通过获取App配置、数据包，去获取 url、api、osskey、js等敏感信息。  
1、资产信息-IP 域名 网站 -转到对应Web 测试 接口测试 服务测试  
2、泄露信息-配置 key 资源文件 - key（osskey利用，邮件配置等）  
3、代码信息-java代码安全问题- 逆向相关  
APP中收集资产  
1、抓包-动态表现  
2、提取-静态表现&动态调试  
3、搜索-静态表现  

1、抓包抓表现出来的数据  
优点：没有误报   
缺点：无法做到完整   
2、反编译从源码中提取数据    
优点：数据较为完整   
缺点：有很多无用的资产    
3、动态调试从表现中提取数据  
优点：没有误报，解决不能抓包不能代理等情况   
优点；搞逆向的人能看到实时的 app调用链等  
缺点：无法做到完整   
案例：某APP打开无数据包，登录有数据包（反编译后未找到目标资产，抓包住到了）
原因：那个登录界面是APP打包的资源，并没有对外发送数据  

案例3：APP提取信息-静态分析  
1、MobSF  
2、AppInfoScanner  
3、两个在线平台  
https://mogua.co/  
<https://www.zhihuaspace.cn:8888/>(南明离火，你只是无耻偷了MobSF的代码)


https://github.com/kelvinBen/AppInfoScanner  
https://github.com/MobSF/Mobile-Security-Framework-MobSF  
https://blog.csdn.net/ljh824144294/article/details/119181803  

APP提取信息-动态抓包  
-前期部分抓包技术  

实战-MobSF安装 
=  
### 环境要求  
#### 安装Python 3.12(其他版本可能会出现未知bug)
https://www.python.org/downloads/windows/    
配置环境变量（以下只作示例，请根据你具体的安装位置进行设置）  
在系统变量下的Path，新增以下条目：
```
C:\Python312\
C:\Python312\Scripts\
```
#### 安装JDK
https://www.oracle.com/cn/java/technologies/downloads/  
在系统变量下增加名为JAVA_HOME的变量：
```
C:\Program Files\Java\jdk-23
```
在系统变量下的Path，新增以下条目：
```
%JAVA_HOME%\bin
```
#### 安装 Visual Studio
https://visualstudio.microsoft.com/zh-hans/vs/  
安装Visual Studio时勾选“使用C++的桌面开发”

#### 安装OpenSSL
下载Win64 OpenSSL v3.4.0，exe和msi均可，不要更改默认的安装位置！  
https://slproweb.com/products/Win32OpenSSL.html  
在系统变量下的Path，新增以下条目：
```
C:\Program Files\OpenSSL-Win64\bin  
```

#### 安装 雷电模拟器（动态分析需要用到，也可以用其他的模拟器）
<https://www.ldmnq.com/>  

### 安装MobSF  
1.	下载MobSF https://github.com/MobSF/Mobile-Security-Framework-MobSF  
2.	解压，运行文件夹下的setup.bat  
3.	等待配置完成  
4.	运行：在mobsf目录下的双击 run.bat，浏览器打开http://127.0.0.1:8000  

//动态调试
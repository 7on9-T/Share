Day14信息打点-JS架构&框架识别&泄露提取&API接口枚举&FUZZ爬虫&插件项目  
=

>1、JS前端架构-识别&分析  
2、JS前端架构-开发框架分析  
3、JS前端架构-打包器分析  
4、JS前端架构-提取&FUZZ

>JS前端架构-手工搜索分析  
JS前端架构-半自动Burp分析  
JS前端架构-自动化项目分析

# 补充
CMS
-
>Ecshop、Discuz、WordPress、蝉知等

前端技术
-
>HTML5、jquery、bootstrap、Vue等

开发语言
-
>PHP、JAVA、Ruby、Python、C#，Js等

web服务器
-
>Apache、Nginx、IIs、lighttpd,Apache等

应用服务器:
-
>Tomcat、Jboss、Weblogic、Websphere等

数据库类型:
-
>Mysql、SqlServer、0racle、Redis、MongoDB等

操作系统信息
-
>Linux、windows等

应用服务信息:
-
>FTP、SSH、RDP、SMB、SMTP、LDAP、Rsync等

CDN信息
-
>帝联、Cloudflare、网宿、七牛云、阿里云等

WAF信息
-
>创宇盾、宝塔、Modsecurity、玄武盾、OpenRASP等。

蜜罐信息:
-
>HFish、TeaPot、T-Pot、Glastopf等

其他组件信息
-
>fastjson、shiro、log4j、0A办公等

### 什么是JS渗透测试? 

>在Javascript中也存在变量和函数，当存在可控变量及函数调用即可参数漏洞JS开发的WEB应用和PHP，JAVA,NET等区别在于即没有源代码，也可以通过浏览器的查看源代码获取真实的点。获取URL，获取Js敏感信息，获取代码传参等，所以相当于JS开发的WEB应用属于白盒测试(默认有源码参考)，一般会在JS中寻找更多的URL地址，在JS代码逻辑(加密算法，APIkey配置，验证逻辑等)进行后期安全测试。  
### JS安全问题  
>源码泄漏  
未授权访问  
敏感key泄漏  
API接口安全  

### 流行的Js框架有那些?   
>Vue NodeJs jQuery Angular等  
### 如何判定JS开发应用?   
浏览器插件wappalyzer  
源程序代码简短  
引入多个js文件  
一般有/static/js/app.js等顺序的js文件-般cookie中有connect.sid  
### 如何获取更多的JS文件?   
手工-浏览器搜索  
半自动-Burpsuite插件  
工具化-各类提取&FUZz项目  
如何快速获取价值信息?  
```
src=
path=
method:"get"
http.get("
method:"post"
http.post("
$.ajax
http://service.httppost
http://service.httpget
```
#前端架构-手工搜索分析  
浏览器全局搜索分析  
#前端架构-半自动Burp分析  
自带功能:Target->sitemap->Engagement tools->Find scripts  
官方插件:IS Link Finder&Js Miner  
第三方插件:HaE&Unexpected information  
插件加载器:jython-standalone-2.7.2  
Unexpected information:  
https://github.com/ScriptKid-Beta/Unexpected_information  
用来标记请求包中的一些敏感信息、Js接口和一些特殊字段，  
防止我们疏忽了一些数据包，使用它可能会有意外的收获信息  
HaE:  
https://github.com/gh0stkey/HaE  
https://raw.githubusercontent.com/ghOstkey/HaE/gh-pages/Config.yml  
基于BurpSuite插件JavaAPI开发的请求高亮标记与信息提取的辅助型插件。该插件可以通过自定义正则的方式匹配响应报文或请求报文，可以自行决定符合该自定义正则匹配的相应请求是否需要高亮标记、信息提取。


#前端架构-自动化项目分析
## Jsfinder
https://github.com/Threezh1/IsFinder  
一款用作快速在网站的js文件中提取URL，子域名的工具

## URLFinder
https://github.com/pingc0y/URLFinder  
一款用于快速提取检测页面中JS与URL的工具。
功能类似于JsFinder，但JsFinder好久没更新了。

## JSINFO-SCAN
https://github.com/p1g3/JSINFO-SCAN  
递归爬取域名(netloc/domain)，以及递归从JS中获取信息的工具

## FindSomething
https://github.com/momosecurity/FindSomething  
该工具是用于快速在网页的html源码或js代码中提取一些有趣的信息的浏览器插件,包括请求的资源，接口的url，请求的ip和域名，泄露的证件号，手机号，邮箱等信息

## ffuf 
找到更多的js文件分析更多的信息  
https://github.com/ffuf/ffuf  
https://wordlists.assetnote.io  
功能强大的模糊化工具，用它来FUZZ模糊化js文件。

## Packer-Fuzzer
针对JS框架开发打包器Webpack检测  
https://github.com/rtcatc/Packer-Fuzzer  
一款针对webpack等前端打包工具所构造的网站进行快速、高效安全检测的扫描工具
Day19信息打点-小程序应用&解包反编译&动态调试&抓包&静态分析&源码架构
=

#小程序获取-各大平台&关键字搜索
微信、百度、支付宝、抖音头条

#小程序体验-凡科建站&模版测试上线
测试：https://qz.fkw.com/
参考：https://blog.csdn.net/qq_52445443/article/details/122351865

1.主体结构
小程序包含一个描述整体程序的app 和多个描述各自页面的page。
一个小程序主体部分(即app)由三个文件组成，必须放在项目的根目录，如下：
文件必需作用
app.js               是小程序逻辑
app.json             是小程序公共配置
app.wxss             否小程序公共样式表
2.一个小程序页面由四个文件组成，分别是:     
xxx.js        页面逻辑
xxx.json      页面配置
xxx.wxml      页面结构
xxx.wxss      页面样式
3.项目整体目录结构
pages                页面文件夹
index                首页
logs                 日志
utils               
util                 工具类(mina框架自动生成,你也可以建立一个：api)
app.js               入口js(类似于java类中的main方法)、全局js
app.json             全局配置文件
app.wxss             全局样式文件
project.config.json  跟你在详情中勾选的配置一样
sitemap.json         用来配置小程序及其页面是否允许被微信索引
#小程序抓包-Proxifier&BurpSuite联动
-对抓到的IP或域名进行Web安全测试、API安全测试、端口服务测试

小程序逆向-解包反编译&动态调试&架构
对源码架构进行分析
更多的资产信息
敏感的配置信息
未授权访问测试
源码中的安全问题
反编译步骤（提前安装node.js）
1.	获取小程序包：
小程序包通常存储在C:\Users\你的用户名\Documents\WeChat Files\Applet 
一般格式为.wxapkg
2.	解包：
使用工具如wxapkgunpacker或wxappUnpacker解包.wxapkg文件，得到小程序的源代码。
3.	反编译：

4.	分析和调试：
可以使用微信开发者助手进行代码查阅
-小程序多功能组手
http://xcx.siqingw.top/
-微信官方开发工具
https://developers.weixin.qq.com/miniprogram/dev/devtools/stable.html

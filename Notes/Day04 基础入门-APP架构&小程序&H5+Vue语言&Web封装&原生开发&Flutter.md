Day04 基础入门-APP架构&小程序&H5+Vue语言&Web封装&原生开发&Flutter
=
APP应用开发架构(由于我不是应用开发者，此处笔记比较简略)
-
### 1．	原生开发  
>安卓一般使用java语言开发，当然现在也有kotlin语言进行开发。如何开发就涉及到具体编程了。简单描述就是使用安卓提供的一系列控件来实现页面，复杂点的页面可以通过自定义控件来实现。  
### 2．	使用H5语言开发  
>使用H5开发的好处有很多，可多端复用，比如浏览器端，ios端，当然H5开发的体验是没有原生好的。  
### 3．	使用flutter开发  
>flutter是近年来谷歌推出的一款UI框架，使用dart语言进行开发，支持跨平台，weight渲染直接操作硬件层，体验可媲美原生。但是flutter技术比较新，生态还不完善，开发起来效率相对偏低。  
### 4．	常规web开发  
>web App软件开发简单地说，就是开发一个网站，然后加入app的壳。web app一般非常小，内容都是app内的网页展示，受制于网页技术本身，可实现功能少，而且每次打开，几乎所有的内容都需要重新加载，所以反应速度慢，内容加载过多就容易卡死，用户体验差，而且app内的交互设计等非常有效。但开发周期长端，需要的技术人员少，成本低。  

原生开发(Android Studio)  
-
某安卓应用项目源码  
测试方法:反编译&抓包&常规测试  
安全影响：逆向的角度去分析逻辑涉及的安全问题  

小程序封装（网页打包成APP）  
-
变色龙云 <https://www.appbsl.cn/index>  
一门APP打包<https://www.appbsl.cn/index>  
某商城源码程序+一门APP/变色龙云（Android&IOS、微信支付宝小程序）  
安全影响:常规web安全测试  

H5&Vue开发(HBuilderX+微信开发者工具)
-
HBuilderX案例  
安全影响:API&JS框架安全问题  

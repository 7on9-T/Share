Day21 信息打点-公众号服务&Github监控&供应链&网盘泄漏&证书图标邮箱资产
演示案例：
 微信公众号-获取&三方服务
 Github监控-开发&配置&源码
 网盘资源搜索-全局文件机密
 敏感目录文件-目录扫描&爬虫
 网络空间进阶-证书&图标&邮箱
 实战案例四则-技术分享打击方位

微信公众号搜索
获取微信公众号途径
https://weixin.sogou.com/
自行判断微信公众号有无第三方服务

#Github监控-开发&配置&源码
目标中开发人员或者托管公司上传的项目存在源码泄漏或配置信息（密码密匙等），人员数据库等敏感信息，找到多个脆弱点。
1、人员&域名&邮箱等筛选
eg：xxx.cn password in:file
https://gitee.com/
https://github.com/
https://www.huzhan.com/
GITHUB资源搜索：
in:name test               #仓库标题搜索含有关键字
in:descripton test         #仓库描述搜索含有关键字
in:readme test             #Readme文件搜素含有关键字
stars:>3000 test           #stars数量大于3000的搜索关键字
stars:1000..3000 test      #stars数量大于1000小于3000的搜索关键字forks:>1000 test           #forks数量大于1000的搜索关键字
forks:1000..3000 test      #forks数量大于1000小于3000的搜索关键字size:>=5000 test           #指定仓库大于5000k(5M)的搜索关键字pushed:>2019-02-12 test    #发布时间大于2019-02-12的搜索关键字created:>2019-02-12 test   #创建时间大于2019-02-12的搜索关键字user:test      #用户名搜素
license:apache-2.0 test    #明确仓库的LICENSE 搜索关键字language:java test         #在java语言的代码中搜索关键字
user:test in:name test     #组合搜索,用户名test的标题含有test的
关键字配合谷歌搜索：
site:Github.com smtp   
site:Github.com smtp @qq.com   
site:Github.com smtp @126.com   
site:Github.com smtp @163.com   
site:Github.com smtp @sina.com.cn 
site:Github.com smtp password 
site:Github.com String password smtp
2、语法固定长期后续监控新泄露
-基于关键字监控

《视频没看完呢》
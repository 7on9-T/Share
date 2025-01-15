Day13信息打点-Web应用&源码泄露&开源闭源&指纹识别&Git&VN&DS&备份
#知识点:
1、业务资产-应用类型分类
2、web单域名获取-接口查询
3、web子域名获取-解析枚举
4、web架构资产_平台指纹识别
1、开源-CMS指纹识别源码获取方式
2、闭源-习惯&配置&特性等获取方式
3、闭源-托管资产平台资源搜索监控
https://down.chinaz.com/ 下载源码

#后端-开源-指纹识别-源码下载
CMS识别见上述项目
#后端-闭源-配置不当-源码泄漏
参考：https://www.secpulse.com/archives/124398.html
备份：敏感目录文件扫描
CVS：https://github.com/kost/dvcs-ripper
GIT：https://github.com/lijiejie/GitHack
SVN：https://github.com/callmefeifei/SvnHack
DS_Store：https://github.com/lijiejie/ds_store_exp
源码泄漏原因：
1、从源码本身的特性入口
2、从管理员不好的习惯入口
3、从管理员不好的配置入口
4、从管理员不好的意识入口
5、从管理员资源信息搜集入口
源码泄漏集合：
composer.json
git源码泄露：Git是一个开源的分布式版本控制系统，在执行git init初始化目录的时候，会在当前目录下自动创建一个.git目录，用来记录代码的变更记录等。发布代码的时候，如果没有把.git这个目录删除，就直接发布到了服务器上，攻击者就可以通过它来恢复源代码。

漏洞利用工具：GitHack

github项目地址：https://github.com/lijiejie/GitHack
svn源码泄露
hg源码泄漏
网站备份压缩文件：备份的源码数据在网站根目录下>御剑扫描
WEB-INF/web.xml泄露
DS_Store 文件泄露
SWP 文件泄露
CVS泄露
Bzr泄露
GitHub源码泄漏
#后端-方向-资源GITHUB-源码泄漏
解决1：识别出大致信息却无下载资源
解决2：未识别出信息使用码云资源获取
解决3：其他行业开发使用对口资源站获取
涉及：
https://gitee.com/
https://github.com/
https://www.huzhan.com/ 源码交易平台
资源搜索：
GITHUB资源搜索:
in:name test #仓库标题搜索含有关键字
in:descripton test #仓库描述搜索含有关键字
in:readme test #Readme文件搜素含有关键字
stars:>3000 test #stars数量大于3000的搜索关键字
stars:1000..3000 test #stars数量大于1000小于3000的搜索关键字
forks:>1000 test #forks数量大于1000的搜索关键字
forks:1000..3000 test  #forks数量大于1000小于3000的搜索关键字
size:>=5000 test #指定仓库大于5000k(5M)的搜索关键字
pushed:>2019-02-12 test #发布时间大于2019-02-12的搜索关键字
created:>2019-02-12 test #创建时间大于2019-02-12的搜索关键字
user:test	#用户名搜素
license:apache-2.0 test #明确仓库的LICENSE 搜索关键字
language:java test #在java语言的代码中搜索关键字

Githack

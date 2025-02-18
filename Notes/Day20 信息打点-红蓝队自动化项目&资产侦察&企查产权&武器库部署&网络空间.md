Day20 信息打点-红蓝队自动化项目&资产侦察&企查产权&武器库部署&网络空间
=

#各类红蓝队优秀工具项目集合：  
https://github.com/guchangan1/All-Defense-Tool  
本项目集成了全网优秀的开源攻防武器项目，包含信息收集工具（自动化利用工具、资产发现工具、目录扫描工具、子域名收集工具、指纹识别工具、端口扫描工具、各种插件...），漏洞利用工具（各大CMS利用工具、中间件利用工具等项目...），内网渗透工具（隧道代理、密码提取...）、应急响应工具、甲方运维工具、等其他安全攻防资料整理，供攻防双方使用。

#自动化-武器库部署-F8x  
项目地址：https://github.com/ffffffff0x/f8x  
1、介绍：  
一款红/蓝队环境自动化部署工具,支持多种场景,渗透,开发,代理环境,服务可选项等.  
2、配置：  
通过CF Workers 下载[推荐]  
wget : wget -O f8x https://f8x.io/  
curl : curl -o f8x https://f8x.io/  
3、	使用：见项目文档  


#自动化-网络空间-AsamF（免积分导出数据）  
项目地址：https://github.com/Kento-Sec/AsamF  
1、介绍：  
AsamF集成了Fofa、Hunter、Quake、Zoomeye、Shodan、爱企查、Chinaz、0.zone、subfinder。AsamF支持Fofa、Hunter、Quake、Zoomeye、Shodan、Chinaz、0.zone配置多个Key。  
2、配置：  
AsamF会在~/.config/asamf/目录下生成config.json文件。  
如果你有多个key，按照json的格式录入即可，建议键值按照阿拉伯数字依次录入,方便以阿拉伯数字来切换key。自动结果保存在~/asamf/目录下。  
4、	使用：见项目文档  

#自动化-企查信息-ENScan  
项目地址：https://github.com/wgpsec/ENScan_GO  
1、介绍：  
剑指HW/SRC，解决在HW/SRC场景下遇到的各种针对国内企业信息收集难题  
2、配置：  
ENScanGo在第一次使用时需要使用-v命令生成配置文件信息后进行配置  
3、使用：见项目文档  

#自动化-综合架构-ARL&Nemo  
-ARL灯塔  
ARL灯塔（Asset Reconnaissance Lighthouse，资产侦察灯塔系统）是一款开源的网络资产侦察工具，主要用于自动化发现和监控互联网上的资产信息。它可以帮助安全团队快速发现目标范围内的域名、IP、端口、服务、证书等信息，是渗透测试和红队行动中的重要工具。  

项目地址:<del>https://github.com/TophantTechnology/ARL</del>  
https://github.com/Aabyss-Team/ARL  
1、介绍:  
旨在快速侦察与目标关联的互联网资产，构建基础资产信息库。协助甲方安全团队或者渗透测试人员有效侦察和检索资产，发现存在的薄弱点和攻击面。  
2、配置:(docker搭建)  

3、使用:见直播操作  

-Nemo_Go  
项目地址:https://github.com/hanc00l/nemo_go  
1、介绍:  
Nemo是用来进行自动化信息收集的一个简单平台，通过集成常用的信息收集工具和技术实现对内网及互联网资产信息的自动收集，提高隐患排查和渗透测试的工作效率，用Golang完全重构了原Python版本。  
2、配置:(docker搭建)  
https://github.com/hanc00l/nemo_go/blob/main/v2/docs/install.md  
下载release的nemo linux amd64.tar后执行:  
mkdir nemo;tar xvf nemo_linux amd64.tar -C nemo;cd nemo  
docker compose up -d  
3、使用:  
浏览器打开http://ip:5000
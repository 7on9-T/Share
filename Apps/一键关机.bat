@echo off
ping 127.0.0.1 -n 1 >nul
chcp 65001
ping 127.0.0.1 -n 2 >nul
set /P c=是否执行关机命令？ (Y/N)?
if /I "%c%" EQU "N" goto end
if /I "%c%" EQU "Y" goto next

:next

echo 即将执行关机指令，将在5秒后关机！
ping 127.0.0.1 -n 5 >nul
shutdown -s -t 0

:end

echo 程序已结束，将在3秒后退出
ping 127.0.0.1 -n 4 >nul
exit
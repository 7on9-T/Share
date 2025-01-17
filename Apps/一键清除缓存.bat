@echo off
ping 127.0.0.1 -n 2 >nul
chcp 65001
ping 127.0.0.1 -n 1 >nul
set /P c=是否执行清除缓存命令？ (Y/N)?
if /I "%c%" EQU "N" goto end
if /I "%c%" EQU "Y" goto next

:next

ping 127.0.0.1 -n 2 >nul
echo 为您列出缓存列表.
ping 127.0.0.1 -n 4 >nul
dir %temp%
ping 127.0.0.1 -n 3 >nul
echo 当前缓存已列出.
ping 127.0.0.1 -n 3 >nul
echo 将在3秒后开始清理......
ping 127.0.0.1 -n 4 >nul
echo 正在清理......
echo 正在清理......
echo 正在清理......
ping 127.0.0.1 -n 3 >nul
rd %temp% /s /q
ping 127.0.0.1 -n 3 >nul
echo 清理完成。当前缓存有不可清除的文件，已列出.
ping 127.0.0.1 -n 3 >nul
dir %temp%
ping 127.0.0.1 -n 3 >nul
echo 程序已结束，将在3秒后退出
ping 127.0.0.1 -n 4 >nul

:end

echo 程序已结束，将在3秒后退出
ping 127.0.0.1 -n 4 >nul
exit
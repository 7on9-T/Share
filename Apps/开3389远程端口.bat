@echo off
%1 start "" mshta vbscript:createobject("shell.application").shellexecute("""%~0""","::",,"runas",1)(window.close)&exit

netsh advfirewall firewall add rule name="3389[TCP]-RDP" dir=in action=allow protocol=tcp localport=3389
netsh advfirewall firewall add rule name="3389[UDP]-RDP" dir=in action=allow protocol=udp localport=3389

exit /B



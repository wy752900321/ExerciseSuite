echo off

color 0a
mode con cols=60 lines=20
echo 当前JDK 版本:
java -version
ping 127.0.0.1 -n 2 -w 1000 > nul
echo.

:menu
echo =============================================
echo 请选择要切换的jdk版本
echo 1：切换至1.6版本
echo 2：切换至1.7版本
echo 3：切换至1.8版本
echo 4：切换至1.7_win32版本
echo 5：退出
echo =============================================
echo.
set /p ch=请输入：
if %ch% equ 1 set javapath=%JAVA8_HOME% && goto enable
if %ch% equ 2 set javapath=%JAVA7_HOME% && goto enable
if %ch% equ 3 set javapath=%JAVA8_HOME% && goto enable
if %ch% equ 4 set javapath=%JAVA7_HOME_32% && goto enable
if %ch% equ 5 goto exit
cls
echo 请确认您的输入(%ch%)是否正确。
goto menu

:enable
setx JAVA_HOME %javapath% /M
echo 已经成功为您切换了JDK版本。
echo Press any key to exit...
pause >nul
exit
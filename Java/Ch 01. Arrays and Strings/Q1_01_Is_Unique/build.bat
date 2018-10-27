@echo off
echo %~dp0
cd %~dp0
echo building...
for %%i in (Q*) do (
	echo %%i
	javac -d . %%i
	)
echo done
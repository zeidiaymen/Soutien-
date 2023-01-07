@ECHO OFF
SETLOCAL
CHCP 1252 >NUL
CD /D "%~dp0"

SET FULLPATH_ROOT=C:\dev23
SET JAVA_HOME=C:\dev23\jdk-18

SET UTILSVR_HOME=%FULLPATH_ROOT%\UtilServeurs

SET MODULEPATH=%UTILSVR_HOME%\lib;%UTILSVR_HOME%\lib\contrib;%UTILSVR_HOME%\lib\drivers

SET ARGS_VM=--module-path "%MODULEPATH%"
SET ARGS_APPLI= path.root.dev="%FULLPATH_ROOT%" path.dir.jdk="%JAVA_HOME%"

START "" "%JAVA_HOME%\bin\javaw.exe" %ARGS_VM% -m utilserveurs/utilserveurs.AppliUtilServeurs %ARGS_APPLI%

ENDLOCAL

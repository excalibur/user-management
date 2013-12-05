@echo off
echo [Pre-Requirement] Makesure install NodeJS and set PATH.
echo [Pre-Requirement] Makesure install Npm and set NODE_PATH.
echo [Pre-Requirement] Makesure install Grunt.
echo [Pre-Requirement] Makesure install bower.


echo [Step 1]  run grunt development task.
call grunt watch
if errorlevel 1 goto error

goto end
:error
echo Error Happen!!
pause
exit 0

:end
exit 0
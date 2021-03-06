@echo off
echo [Pre-Requirement] Makesure install NodeJS and set PATH.
echo [Pre-Requirement] Makesure install Npm and set NODE_PATH.
echo [Pre-Requirement] Makesure install Grunt.

echo [Step 1]  run grunt server task.
echo [INFO]  Please wait a moment. When you see "Waiting..." in both consoles, you can access below demo sites:
echo [INFO] http://localhost:9000
call grunt serve
if errorlevel 1 goto error

goto end
:error
echo Error Happen!!
pause
exit 0

:end
exit 0
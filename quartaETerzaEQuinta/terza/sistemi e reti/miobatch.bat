
cls

echo off
choice /M Scegli /T 10 /D S

if %errorlevel% EQU 1 (

  echo hai detto si

  )ELSE (

 echo hai detto no

)
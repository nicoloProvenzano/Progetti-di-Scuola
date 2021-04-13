FOR /L %%A IN (1, 1, 1) DO start chrome

choice /C AB /M "prmere A  creare la cartella e copiare tutti i file, premere B per anullare" /T 10 /D B


if %errorlevel% EQU 1 (

  echo "ciaone"

)




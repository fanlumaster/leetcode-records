$filename=$args[0]
$start=$filename.LastIndexOf("\") + 1
$strLength=$filename.Length - $start - 4
$outputName=$filename.Substring($start, $strLength)
$exeName=$outputName+".exe"
# echo $filename
# echo $exeName
g++ $filename -o .\bin\$outputName -I .\src\utils
# echo 'compile completed and start execute:'
& .\bin\$exeName

Write-Host "正在检查构建环境..."
if (-not (Test-Path -Path Env:JAVA_HOME)) {
  Write-Host "构建失败：请设置 JAVA_HOME 环境变量"
  return
}

if (-not (Test-Path -Path Env:MAVEN_HOME)) {
  Write-Host "构建失败：请设置 MAVEN_HOME 环境变量"
  return
}

try { npm -v > $null }
catch { Write-Host "请安装 nodejs 工具" ; return }

try { vue -V > $null }
catch { Write-Host "请安装 @vue/cli 工具" ; return }

$Base = Resolve-Path -Path ..
$FrontendBase = "$Base\vue-hello"
$BackendBase = "$Base\spring-hello"
$FrontendDeployment = "$Base\deploy\vue-hello\hello\"
$BackendDeployment = "$Base\deploy\spring-hello\hello.jar"

Set-Location $FrontendBase

Write-Host "正在下载前端包..."
npm init > $null

"正在构建 vue-hello ..."
npm run build > $null

if (Test-Path -Path $FrontendDeployment) {
  Remove-Item -Path $FrontendDeployment -Force -Recurse > $null
}

Move-Item -Path .\dist -Destination $FrontendDeployment > $null

Write-Host "正在构建 spring-hello ..."
Set-Location $BackendBase

$env:Path += ";$env:MAVEN_HOME\bin"
try { mvn clean package > $null }
catch { Write-Host $Error }

if (Test-Path -Path $BackendDeployment) {
  Remove-Item -Path $BackendDeployment
}

Move-Item -Path $BackendBase\target\spring-hello-0.0.1-SNAPSHOT.jar -Destination $BackendDeployment

Set-Location $Base\deploy


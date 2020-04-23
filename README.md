
- 下载[Git](https://mirrors.huaweicloud.com/git-for-windows/v2.26.0.windows.1/Git-2.26.0-64-bit.exe)，安装完成后执行```git --version```检查安装是否正确

- 下载[Maven](https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)，解压并将其bin目录配置到系统path环境变量下，执行```mvn --version```检查安装是否正确

- 下载[Node.js](https://mirrors.huaweicloud.com/nodejs/latest-v13.x/node-v13.13.0-x64.msi)，安装完成后执行```node --version```检查安装是否正确

- 分别执行```npm config set registry https://mirrors.huaweicloud.com/repository/npm/``` 和 ```npm cache clean -f```配置npm国内加速镜像

- 执行```git clone https://github.com/keepaliveon/scholarship.git```将后端代码拉取到本地，并执行```cd scholarship```切换到后端项目根目录

- 在后端项目根目录下执行```mvn spring-boot:run```启动后端

- 执行```git clone https://github.com/keepaliveon/scholarship_web.git``` 将前端代码拉取到本地，并执行 ```cd scholarship_web```切换到前端项目根目录

- 在前端项目根目录下执行```npm install```安装依赖，完成后执行```npm run serve```启动前端并会自动打开浏览器

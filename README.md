# **Cooper4-Framework-core**

Framework jar.

build.gradle中加入:

maven {url 'https://raw.githubusercontent.com/FredaTeam/cooper4-mvn-repo/repo/'}

compile 'org.freda.cooper4:cooper4-framework-core:1.0.1'

可引入Jar.


发布版本:
1.修改build.gradle中的 
    publishing => repositories => maven => url至 cooper4-mvn-repo项目.
2.项目运行 ./gradlew publish
3.将生成的文件提交至github.完成版本更新. 

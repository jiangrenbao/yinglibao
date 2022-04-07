# 一 逆向工程使用

需要GeneratorMapper.xml文件以及在pom.xml文件中配置插件:
<plugins>
     <!--mybatis代码自动生成插件-->
     <plugin>
           <groupId>org.mybatis.generator</groupId>
           <artifactId>mybatis-generator-maven-plugin</artifactId>
           <version>1.3.6</version>
           <configuration>
               <!--配置文件的位置-->
               <configurationFile>GeneratorMapper.xml</configurationFile>
               <verbose>true</verbose>
               <overwrite>true</overwrite>
            </configuration>
     </plugin>
</plugins>
在GeneratorMapper.xml文件中修改内容
选择Plugins下的mybatis-generator下的mybatis-generator:generator,双击


服务启动需要配置zookeeper,redis,mysql

# 一 项目介绍

利用互联网技术和信息通信技术实现资金融通、支付、投资和信息中介服务的新型金融业务模式

# 二 项目架构

项目架构.png

技术:

框架:SpringBoot

分布式框架:Dubbo

视图:Thymeleaf 

技术点:fastjson   HttpClient   Redis   MySQL

# 三 数据库架构

invest_info     投资信息表,每进行一次投资就在此表创建一条记录

user            记录用户信息

product_info    记录投资产品信息

income_record   记录每个用户的每次收益

finance_account 记录每个用户的金钱情况

recharge_record 记录每个用户的每次充值记录

# 四 项目基础搭建步骤

1 创建parent与common的maven项目,parent模块为父工程

2 创建dataservice的springboot项目,用到的依赖有:

common工程坐标

spring-boot-starter-data-redis

mybatis-spring-boot-starter

mysql-connector-java

dubbo-spring-boot-starter

dubbo-dependencies-zookeeper

commons-lang3

3 创建web的springboot项目,用到的依赖有:

common工程坐标

spring-boot-starter-web

spring-boot-start-thymeleaf

dubbo-spring-boot-starter

dubbo-dependencies-zookeeper

dubbo-spring-boot-starter

dubbo-dependencies-zookeeper

httpclient

fastjson

spring-boot-starter-data-redis

4 逆向工程
具体使用在util.txt中

5 修改继承结构

使parent工程的父工程为spring-boot-starter-parent,其他的工程都继承parent工程

# 五 首页面数据显示(redis)

如用户注册数量显示功能.使用dubbo实现web模块访问dataservice模块,将数据存到redis中,先从redis中取,redis没有,查询数据库中注册用户的数量,添加到缓存中,并通过thymeleaf模板显示该数据.平均利率以及总投资金额数也是放到缓存中

Integer countUsers = (Integer) redisTemplate.opsForValue().get("userNum");

if(countUsers == null){

        synchronized (this){
        
            countUsers = (Integer) redisTemplate.opsForValue().get("userNum");
            
            if(countUsers == null){
            
                countUsers = userMapper.selectCountUser();
                
                redisTemplate.opsForValue().set("userNum",
                                                countUsers,
                                                20, 
                                                TimeUnit.MINUTES);
                                                
            }
        }
    }
    
return countUsers;

1 common模块中添加UserService接口,提供方法SelectUserNum()

2 dataservice模块中,针对该接口写UserServiceImpl实现类,通过dubbo注解暴露服务,并写mapper接口与xml文件

3 web模块中通过dubbo注解引用远程服务dataservice,返回数据,用于前端展示

补充:投资排行榜

   使用ZSet存储投资手机号和投资金额 
   
Set<ZSetOperations.TypedTuple<String>> typedTuples =

          stringRedisTemplate.opsForZSet().reverseRangeWithScores("topList", 0, 4);

typedTuples.forEach( t->{

       TopBean top  = new TopBean(t.getValue(),t.getScore());
      
       topList.add(top);
   
});

# 六 分页显示产品功能

1 查询指定产品类型的产品数量

2 封装一个分页信息类PageInfo,字段有页数,每页的个数,总页数,总产品数

3 通过queryProductInfoPageByType()方法返回指定页数的数据

# 七 注册功能

1 收到请求的数据

手机号，密码（md5）, 短信验证码

2 检验数据

短信验证码要和redis中存储的数据对比。
京东万象短信接口:https://wx.jdcloud.com/market/datas/5/10665

3 注册用户

添加数据到u_user,创建一个u_finance_account账号，增加他的初始金额是888

# 八 spring-test定时任务

启动类上加注解@EnableScheduling

自定义的定时任务类上加注解@Component

定时任务方法上加注解@Scheduled(cron = "*/10 * * * * ?")


cron：秒    分    时    日（月中那天）   月    星期    年（可选）

## 定时任务一:生成满标产品的收益计划。

逻辑:

1 获取满标产品
  
2 计算某个满标产品所有投资记录

3 计算收益 = 投资金额 * 周期 * 利率

4 到期时间 = 满标时间 + cycle 天数
          
5 创建一条收益表数据
           
6 更新产品的状态为2(满标并生成收益)
     
## 定时任务二:收益返还

1 获取收益记录表中的今天到期的收益记录
  
2 循环每个到期的收益记录,userid,收益和本金

3 通过userid查询资金账号(需要for update上锁)
      
4 如果资金账号不为空的话,增加金额(账号金额+收益+本金)

5 更新收益记录的状态为1(以结算)
          
# 九 实名认证

用户在页面上输入姓名和身份证号号码，使用短信验证码功能

调用第三方的接口，做实名认证

认证成功后，更新u_user的记录的name和id_card字段

认证成功，跳转到用户中心页面

# 十 登录登出
## 登录
1 在多个页面中有登录的链接或者按钮,希望把所有页面中登录的操作都集中到一个位置

在一个公共页面中，写登录的逻辑，在其他页面中include这个页面

2 用户在某个页面中，发起登录的请求， 登录成功后，将当前用户信息存到Session作用域中,返回到来源页面

使用returnUrl参数
```html
  <script type="text/javascript" th:inline="javascript">
      // money
      var contextPath = [[${#request.getContextPath()}]]; 
      var returnUrl  = window.location.href;
      //登录的处理 class="btn-login"
      $(function(){
          $(".btn-login").on("click",function(){
              window.location.href = contextPath + "/loan/page/login?returnUrl="+returnUrl;
          })
      })
  </script>
```
## 登出
使session无效,重定向回到首页

session.invalidate();
return "redirect:/index";

# 十一投资功能(@Transactional,悲观锁for update)

1 接收请求的参数，投资金额money

2 判断money是否符合产品的购买要求，money在最小单笔投资金额和单笔最大投资金额之间

3 判断money小于leftMoney和账户金额

4 扣除用户资金

5 扣除产品的剩余可投资金额

6 创建一个投资记录invest_record

7 判断此产品是否满标,如果满标，更新此产品的状态是满标，和满标时间

使用for update注意:会锁定整个表或者行，在锁定的时候，其他事务不能对表或者行做修改操作.锁行效率高，需要在where条件中的字段有主键或者唯一索引

例子:select * from u_finance_account where id = 1 for update 

# 十二 拦截器

登录拦截器:判断用户是否登录，如果没有登录，定向到登录页面

实现步骤：

1 创建拦截器类LoginInterceptor，实现HandlerIntercepor接口(根据session指定域是否为空判断,ajax与普通页面请求处理方式不同)

2 把拦截器对象注入到容器中(配置类实现HandlerInterceptor接口并重写addInterceptor()方法)

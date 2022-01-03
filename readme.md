# CIDemo

请使用：`Windows 10`和`JDK8`，在`Mac`和`Linux`下可能报错

Q:这是什么？

A:为了配合`CodeInspector`自动化代码审计工具而编写的靶机

Q:怎么跑起来？

A:普通SpringBoot项目，Maven处理好依赖直接跑

Q:有无页面？

A:只做了个首页，页面不是重点，主要是功能测试

![](https://github.com/EmYiQing/CIDemo/blob/master/img/01.png)

Q:怎样用`CodeInspector`检测？

A:用Maven把当前项目打包好，然后执行:`java -jar CodeInspector.jar --boot SpringBoot.jar --pack org.sec.cidemo`

Q:怎样看自动代码审计的结果？

A:目前只做了最简单的一种SSRF，控制台应该有这样的打印:

```
   _____               ____        
  /  |  |____________ /_   | ____  
 /   |  |\_  __ \__  \ |   |/    \ 
/    ^   /|  | \// __ \|   |   |  \
\____   | |__|  (____  /___|___|  /
     |__|            \/         \/ 
21:53:48 [INFO] [org.sec.Main] start code inspector
21:54:08 [INFO] [org.sec.service.DiscoveryService] discover all classes
21:54:10 [INFO] [org.sec.service.InheritanceService] build inheritance
21:54:12 [INFO] [org.sec.service.MethodCallService] get method calls in method
21:54:15 [INFO] [org.sec.service.SortService] topological sort methods
21:54:16 [INFO] [org.sec.service.DataFlowService] get data flow
21:54:32 [INFO] [org.sec.service.CallGraphService] build call graph
21:57:54 [INFO] [org.sec.service.SSRFService] analysis ssrf...
21:57:54 [INFO] [org.sec.service.SSRFService] detect ssrf: org/sec/cidemo/service/impl/SSRFServiceImpl.ssrf1
```

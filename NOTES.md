
It's not common to run jUnits inside of an application but it can be done and it is useful.

https://stackoverflow.com/questions/2543912/how-do-i-run-junit-tests-from-inside-my-java-application

# Building
1. `gradle shadowJar`
2. `java -jar build/libs/ReportChecker-1.0-SNAPSHOT-all.jar command line parameter` 
   1. Note you can put that jar any where and call it from the command line.  Output looks like:

```
Matts-Mac-mini:Dave mpayne$ gradle shadowJar

> Task :compileJava
Note: /Users/mattpayne/CS/Dave/src/main/java/demo/HelloTests.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.

BUILD SUCCESSFUL in 2s
3 actionable tasks: 2 executed, 1 up-to-date
Matts-Mac-mini:Dave mpayne$ java -jar build/libs/ReportChecker-1.0-SNAPSHOT-all.jar command line arguments
Hello
        args[0]=command
        args[1]=line
        args[2]=arguments
COLUMN NAME: FIRSTNAME VALUE: JOHN
COLUMN NAME: LASTNAME VALUE: DOE
COLUMN NAME: ADDRESS VALUE: 1234 CIRCLE CT
COLUMN NAME: CITY VALUE: ELYRIA
COLUMN NAME: STATE VALUE: OH
COLUMN NAME: ZIP VALUE: 44035
===========================================================================
COLUMN NAME: FIRSTNAME VALUE: JIMMY
COLUMN NAME: LASTNAME VALUE: SMITH
COLUMN NAME: ADDRESS VALUE: 180 SOME ST
COLUMN NAME: CITY VALUE: AVON
COLUMN NAME: STATE VALUE: OH
COLUMN NAME: ZIP VALUE: 44011
===========================================================================
COLUMN NAME: FIRSTNAME VALUE: JANE
COLUMN NAME: LASTNAME VALUE: DOE
COLUMN NAME: ADDRESS VALUE: 111 MILKY WY
COLUMN NAME: CITY VALUE: AMHERST
COLUMN NAME: STATE VALUE: OH
COLUMN NAME: ZIP VALUE: 44001
===========================================================================
COLUMN NAME: FIRSTNAME VALUE: FRED
COLUMN NAME: LASTNAME VALUE: FLINTSTONE
COLUMN NAME: ADDRESS VALUE: 123 ROCKY WY
COLUMN NAME: CITY VALUE: BEDROCK
COLUMN NAME: STATE VALUE: AZ
COLUMN NAME: ZIP VALUE: 12345
===========================================================================
First name 'JIMMY' has a 'Y' in it.  This is forbidden.  Line number 4
junit.framework.AssertionFailedError: First name 'JIMMY' has a 'Y' in it.  This is forbidden.  Line number 4
        at junit.framework.Assert.fail(Assert.java:57)
        at junit.framework.Assert.assertTrue(Assert.java:22)
        at demo.HelloTests.firstNamesShallNotHaveLetterY(HelloTests.java:31)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runners.Suite.runChild(Suite.java:128)
        at org.junit.runners.Suite.runChild(Suite.java:27)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:105)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:94)
        at demo.Hello.run(Hello.java:69)
        at demo.Hello.main(Hello.java:32)



*************


Matts-Mac-mini:Dave mpayne$ nl src/main/resources/PEOPLE-FixedLength.txt 
     1  JOHN                               DOE                                1234 CIRCLE CT                                                                                      ELYRIA                                                                                              OH44035
     2  JIMMY                              SMITH                              180 SOME ST                                                                                         AVON                                                                                                OH44011
     3  JANE                               DOE                                111 MILKY WY                                                                                        AMHERST                                                                                             OH44001
     4  FRED                               FLINTSTONE                         123 ROCKY WY                                                                                        BEDROCK                                                                                             AZ12345
Matts-Mac-mini:Dave mpayne$ 

```   
   

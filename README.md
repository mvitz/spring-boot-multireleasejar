# Spring Boot Multi-Release JAR

Currently it seems Spring Boot is not able to support a
Java 9 Multi-Release JAR within it's executable JAR.

## Preparation

`lib` contains some code that is assembled into a
Multi-Release JAR and afterwards installed to the
local maven repository.

```
$ cd lib
$ javac --version
javac 9.0.4
$ java --version
java 9.0.4
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
./build.sh
```

## Maven Execution

If the application is started via maven everything works
as expected.

**Java 8**

```
$ java -version
java version "1.8.0_162"
Java(TM) SE Runtime Environment (build 1.8.0_162-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.162-b12, mixed mode)
$ ./mvnw clean spring-boot:run
...
2018-03-16 14:59:09.011  INFO 77583 --- [  restartedMain] c.i.s.SpringMultijarApplication          : Started SpringMultijarApplication in 0.847 seconds (JVM running for 1.248)
Hello from Java8: Michael
2018-03-16 14:59:09.016  INFO 77583 --- [       Thread-8] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@3950021d: startup date [Fri Mar 16 14:59:08 CET 2018]; root of context hierarchy
...
```

**Java 9**

```
$ java --version
java 9.0.4
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
$ ./mvnw clean spring-boot:run
...
2018-03-16 15:00:20.312  INFO 77666 --- [  restartedMain] c.i.s.SpringMultijarApplication          : Started SpringMultijarApplication in 0.966 seconds (JVM running for 1.393)
Hi Michael from Java9
2018-03-16 15:00:20.316  INFO 77666 --- [       Thread-7] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@2a3d0f33: startup date [Fri Mar 16 15:00:19 CET 2018]; root of context hierarchy
...
```

## Executable JAR

If the executable JAR (build by `./mvnw clean package`)
is invoked it doesn't work any longer.

**Java 8**

```
$ java -version
java version "1.8.0_162"
Java(TM) SE Runtime Environment (build 1.8.0_162-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.162-b12, mixed mode)
$ java -jar target/spring-multijar-0.0.1-SNAPSHOT.jar
...
2018-03-16 15:01:54.331  INFO 77768 --- [           main] c.i.s.SpringMultijarApplication          : Started SpringMultijarApplication in 0.777 seconds (JVM running for 1.178)
Hello from Java8: Michael
2018-03-16 15:01:54.333  INFO 77768 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@75828a0f: startup date [Fri Mar 16 15:01:53 CET 2018]; root of context hierarchy
...
```

**Java 9**

```
$ java --version
java 9.0.4
Java(TM) SE Runtime Environment (build 9.0.4+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)
$ java -jar target/spring-multijar-0.0.1-SNAPSHOT.jar
...
2018-03-16 15:02:34.984  INFO 77827 --- [           main] c.i.s.SpringMultijarApplication          : Started SpringMultijarApplication in 0.884 seconds (JVM running for 1.319)
Hello from Java8: Michael
2018-03-16 15:02:34.986  INFO 77827 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@76508ed1: startup date [Fri Mar 16 15:02:34 CET 2018]; root of context hierarchy
...
```

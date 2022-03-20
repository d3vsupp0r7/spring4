# Table of Contents

* [Scope](#scope)
* [Getting started](#getting-started)
  * [Spring Batch](#spring-batch)
    * [Flow](#flow)
    * [Spring Batch Component](#spring-batch-component)
        * [ItemReader](#itemreader)
        * [ItemProcessor](#itemprocessor)
        * [ItemWriter](#itemwriter)
  * [Prerequisite](#prerequisite)
    * [Installing](#installing)
  * [Running Test](#running-test)
  * [Built with](#built-with)
    * [Default library dependency](#default-library-dependency)
      * [Util libraries](#util-libraries)
      * [Test libraries](#test-libraries)
      * [In memory DB](#in-memory-db)
      * [Maven plugins](#maven-plugins)
  * [Authors](#authors)  
  * [Licence](#licence)

# Scope

Spring 4.X batch advanced example.

*TO_DO*

# Getting started

## Package org.lba.spring4
**Spring context file:** spring-context.xml

This package and spring context file configuration uses the **springBeans.properties** file to load bean into spring context. This is an example on how to externalize bean classes to instantiate with Spring Framework.

### Code notes

1. Inside the **springBeans.properties** define bean property and full qualified name (FQN) of class we want to instantiate with Spring Framework.

```
spring.beans.helloBean.fqn=org.lba.spring4.HelloWorldSpringBean
```

2. Inside the classes you now can use the @Autowired or Application context to get the bean.

## Package org.lba.spring4.crud.h2

**Class:** org.lba.spring4.crud.h2.app.EmployeeH2Main  
**Spring context file:** classpath:/h2-config/spring-context-h2.xml  

Load a spring context with a ready context in order to work with H2 database.
No initial load was executed.  

**Class:** org.lba.spring4.crud.h2.app.EmployeeH2InitialLoadMain  
**Spring context file:** classpath:/h2-config/spring-context-h2-initial-load.xml  

Load a spring context with a ready context in order to work with H2 database.
Initial load was executed with a custom file name.

### Notes
All the packages to manage CRUD application, divided into layer are:

* **Entity layer:** org.lba.spring4.model
* **Spring Repository layer:** org.lba.spring4.repository
* **Spring Service layer:** **org.lba.spring4.service** and **org.lba.spring4.service.impl**


# Spring Batch 

## Flow

## Spring Batch Component

### ItemReader

### ItemProcessor

**ItemProcessor** is Optional, and called after item read but before item write. It gives us the opportunity to perform a business logic on each item.

### ItemWriter

### JobListener
**JobListener** is Optional and provide the opportunity to execute some business logic before job start and after job completed.For example setting up environment can be done before job and cleanup can be done after job completed.

## Job Configuration (XML)

### Prerequisite
* Java version 1.8
* Maven 

### Installing
*TO_DO*

## Running Test
*TO_DO*

## Built with
* [Java SDK Version](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - 1.8
* [Maven](https://maven.apache.org/) - Dependency Management

### Default library dependency

#### Util libraries
* **log4j.version:** 1.2.17

#### Test libraries
* **junit.version:** 4.12

#### In memory DB
* **h2.version:** 1.4.199
* **hsqldb.version:** 2.5.0

#### Maven plugins
* **maven-compiler-plugin.version:** 3.6.1

#### Spring framework
* **spring.version:** 4.3.24.RELEASE  
* **spring-data.version:** 1.6.6.RELEASE  
* **spring-batch.version:** 3.0.10.RELEASE  

#### Hibernate
* **hibernate.version:** 4.3.11.Final

## Authors
*TO_DO*

## Licence
*TO_DO*

## Acknowledgments
*TO_DO*


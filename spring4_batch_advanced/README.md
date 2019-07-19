# Table of Contents

* [Scope](#scope)
  * [Getting started](#getting-started)
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

## Getting started
*TO_DO*

# Spring Batch 

## Flow

## Component (springBatch classes)

### ItemProcessor

**ItemProcessor** is Optional, and called after item read but before item write. It gives us the opportunity to perform a business logic on each item

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


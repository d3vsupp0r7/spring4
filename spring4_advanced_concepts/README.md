# spring4_advanced_concepts

# Table of Contents

* [Scope](#scope)
    * [Info](#info)
* [Prerequisite](#prerequisite)
* [Installing](#installing)
* [Getting started](#getting-started)
* [Database](#database)
* [Spring Configuration](#spring-configuration)
* [References](#references)
* [Built with](#built-with)
    * [Default library dependency](#default-library-dependency)
      * [Maven plugins](#maven-plugins)
  * [Authors](#authors)  
  * [Licence](#licence)

# Scope
Implements standard GoF Patterns using Spring context.

## Info
**Project name:** spring4_advanced_concepts

# Prerequisite
* Java version 1.8
* Maven 

# Installing


# Getting started

## Package org.lba.beans.interfaces.multiimpl.example

**Spring context file:** app-context-for-interfaces-multiimpl-example.xml

This package define structure for @Qualifier and multiple beans that implements the same interface.

## Package org.lba.spring.gof.factorymethod

**Spring context file:** spring-gof-factorymethod.xml

This package define structure for @Qualifier and multiple beans that implements the same interface. The approach is to use a GOF implementation with Spring Framework to implement Factory Method pattern.

## Package org.lba.spring.factorymethod

**Spring context file:** spring-factorymethod-example.xml

This package define structure for define Factory Method pattern using Spring XML configuration, defing bean with following xml tags:

**factory-bean**  
**factory-method**

# Database

None

# Spring Configuration

##  Using qualifier from xml files

We can use **qualifier** attribute inside Spring XML configuration file. To do this:  

Into xml spring context configuration file:

```xml
	<bean id="createOperationHandler" 
		class="org.lba.beans.interfaces.sample3.springfactorymethod.example.CreateOperationHandler"> 
			<qualifier value = "sfCreateOperationHandler" />
	</bean>
```

In java classes that uses the bean we need to define the bean autowiring like following code:

```java
		@Autowired
		@Qualifier("sfCreateOperationHandler")
		private CRUDOperationHandler createOperationHandler;
		
		The qualifier name for createOperationHandler was different 
		just to prove the concepts.
```

##  Using factory configuration for Spring Framework

**Package:** org.lba.spring.factorymethod  

1. Define Factory class (with it's interface) and the factory method that create Spring bean, based on parameter.  

```xml
	<bean id="factoryMethodImpl"
		class="org.lba.beans.interfaces.sample3.springfactorymethod.example.FactoryMethodImpl" /> 
```

2. Define Factory class with factory method.  

```	java
public class FactoryMethodImpl implements IFactoryMethod {

	private static final String ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR = "No Factory implementation for productSelector: ";

	private static final String FACTORY_MSG_CREATE_PRODUCT_2 = "createProduct(String productSelector) - PRODUCT_2";

	private static final String FACTORY_MSG_CREATE_PRODUCT_1 = "createProduct(String productSelector) - PRODUCT_1";

	private static final String PRODUCT2 = "PRODUCT2";

	private static final String PRODUCT1 = "PRODUCT1";

	static final Logger LOGGER = Logger.getLogger(FactoryMethodImpl.class);

	/*Save products created with factory-method approach */
	@Autowired
	@Qualifier("product1SFM")
	private Product product1SpringBean;
	
	@Autowired
	@Qualifier("product2SFM")
	private Product product2SpringBean;

	/**
	 * Create products - factory method
	 * @param productSelector
	 * @return
	 */
	public Product createProduct(String productSelector) {

		LOGGER.debug("createProduct(String productSelector): " + productSelector);
		productSelector = productSelector.toUpperCase();
		
		/**/
		switch (productSelector) {

		case PRODUCT1:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_1);
			return new ConcreteProduct1();

		case PRODUCT2:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_2);
			return  new ConcreteProduct2();

		default:
			throw new UnsupportedOperationException(ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR + productSelector);
		}
	}
	
	...
}
```

3. Define bean to create with factory class inside xml  

```	xml
	<!-- ConcreteProduct from factory -->
	<bean id="product1" 
		class="org.lba.beans.interfaces.sample3.springfactorymethod.example.ConcreteProduct1" 
		factory-bean="factoryMethodImpl"
		factory-method="createProduct"> 
		  <constructor-arg value="PRODUCT1"/>
			<qualifier value = "product1SFM" />
		</bean>

	<bean id="product2"  
		class="org.lba.beans.interfaces.sample3.springfactorymethod.example.ConcreteProduct2"
		factory-bean="factoryMethodImpl"
		factory-method="createProduct">
		 <constructor-arg value="PRODUCT2"/>
			<qualifier value = "product2SFM" />
		 </bean>
```

# References

None


# Built with
* [Java SDK Version](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - 1.8
* [Maven](https://maven.apache.org/) - Dependency Management

## Default library dependency

### Maven plugins
* **maven-compiler-plugin.version:** 3.6.1

### Spring framework
* **spring.version:** 4.3.23.RELEASE

### Utils library

#### Database
* **h2.version:** 1.4.199

## Authors
*TO_DO*

## Licence
*TO_DO*

## Acknowledgments
*TO_DO*


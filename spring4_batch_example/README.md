# Spring batch

## Define the spring batch table  folder

**IMPORTANT:** If the database not have the spring batch table the following error was present:

```
org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT JOB_INSTANCE_ID, JOB_NAME from BATCH_JOB_INSTANCE where JOB_NAME = ? and JOB_KEY = ?]; nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BATCH_JOB_INSTANCE" not found; SQL statement:
SELECT JOB_INSTANCE_ID, JOB_NAME from BATCH_JOB_INSTANCE where JOB_NAME = ? and JOB_KEY = ? [42102-199]
```

The Spring framework offer the initialization/drop script for different database on following jar file:  

**spring-batch-core-3.0.7.RELEASE**

# Spring CRUD package

## CRUD H2 Example

**Main class**: org.lba.spring4.MainAppEmployeeCRUDH2  
**Spring context file:** applicationContextCRUDExample_H2.xml  
**Package of implementation:** org.lba.spring4


# Spring Batch packages

## Partitioner example: org.lba.spring4.batch.partitioner

**Main class**: org.lba.spring4.batch.partitioner.SpringBatchApp  
**Spring context file:** springBatchJobPartitioner_example.xml  
**Package of implementation:** org.lba.spring4.batch.partitioner


# Cron expressions

##  Examples of CRON Expressions

**Cron expression:** 0 * * * * ?
**Description:** At second :00 of every minute

**Cron expression:** 0 0/20 * * * ? 
**Description:** At second :00, every 20 minutes starting at minute :00, of every hour
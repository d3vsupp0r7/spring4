package org.lba.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.lba.jdbc.util.sql.QueryObject;
import org.lba.jdbc.util.table.mapper.EmployeeTableFieldAndTypeEnum;
import org.lba.spring4.db.model.simple.Employee;

public class SQLPreparedStatementDynamicQueryParameterBuilder {

	static final  Logger logger = Logger.getLogger(SQLTokenUtil.class);

	public static void main(String[] args) {

		String SQL_INSERT_ODD = "insert into EMPLOYEE (ID, NAME, SURNAME ) values ( EMPLOYEE_SEQ  , '${name}' , '${surname}')";
		logger.debug("\n*** TOKENIZE SQL STATEMENT FROM KEYWORDS: values ***" );
		StringTokenizer tokenizerValues = new StringTokenizer(SQL_INSERT_ODD, " values "); 
		List<String> tokensForValues = new ArrayList<>();
		logger.debug("*** String tokens [values] ***");

		while (tokenizerValues.hasMoreElements()) {
			tokensForValues.add(tokenizerValues.nextToken().trim());
		}

		logger.debug("numers of token: " + tokensForValues.size() );
		for (String currentToken : tokensForValues) {
			logger.debug("currentToken: " + currentToken);
		}
		/**/
		logger.debug("\n*** SPLIT SQL STATEMENT BY WORDS ***" );
		String[] result = SQL_INSERT_ODD.split("\\s");
		for(int i = 0; i < result.length; i++) {
			logger.debug(result[i]);
		}
		/**/
		logger.debug("\n*** SPLIT SQL STATEMENT FROM KEYWORDS: values ***" );
		String[] parts = SQL_INSERT_ODD.split("values"); 
		String beforeValuesPart = parts[0]; 
		String afterValuesPart = parts[1]; 
		logger.debug("beforeValuesPart : " + beforeValuesPart);
		logger.debug("afterValuesPart  : " + afterValuesPart);
		/**/
		logger.debug("\n*** TOKENIZE SPLIT PART OF SQL STATEMENT (INSERT PART) ***");
		List<String> tokens = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(beforeValuesPart, ",");
		while (tokenizer.hasMoreElements()) {
			tokens.add(tokenizer.nextToken().trim());
		}
		logger.debug("numers of token: " + tokens.size() );
		for (String currentToken : tokens) {
			logger.debug("currentToken: " + currentToken);
		}
		/**/
		logger.debug("\n*** PROCESS TOKENIZER FOR COLUMNS NAME ***" );
		String[] partsOfInsertWithoutTable = beforeValuesPart.split("\\(");
		String beforeOfInsertWithoutTable = partsOfInsertWithoutTable[0]; 
		String afterOfInsertWithoutTable = partsOfInsertWithoutTable[1]; 
		logger.debug("beforeOfInsertWithoutTable : " + beforeOfInsertWithoutTable);
		logger.debug("afterOfInsertWithoutTable  : " + afterOfInsertWithoutTable);
		String processableColumns = afterOfInsertWithoutTable.replaceAll("\\)", "");
		logger.debug("processableColumns  : " + processableColumns);

		logger.debug("\n*** TOKENIZE SQL STATEMENT FROM processableColumns ***" );
		StringTokenizer tokenizerValuesColumn = new StringTokenizer(processableColumns, ","); 
		List<String> tokensForValuesColumn = new ArrayList<>();
		logger.debug("* String tokens  *");
		while (tokenizerValuesColumn.hasMoreElements()) {
			tokensForValuesColumn.add(tokenizerValuesColumn.nextToken().trim());
		}
		logger.debug("numers of token: " + tokensForValuesColumn.size() );
		for (String currentToken : tokensForValuesColumn) {
			logger.debug("currentToken: " + currentToken);
		}
		/**/
		logger.debug("\n*** PROCESS SQL STATEMENT FROM INSERT VALUES ***" ); 
		String[] partsOfInsertValuesTable = afterValuesPart.split("\\("); 
		String beforeOfInsertValuesTable = partsOfInsertValuesTable[0];  
		String afterOfInsertValuesTable = partsOfInsertValuesTable[1]; 
		logger.debug("beforeOfInsertValuesTable : " + beforeOfInsertValuesTable);
		logger.debug("afterOfInsertValuesTable  : " + afterOfInsertValuesTable);
		String processableInsertValues = afterOfInsertValuesTable.replaceAll("\\)", "");
		logger.debug("processableInsertValues  : " + processableInsertValues);
		/**/
		logger.debug("\n*** TOKENIZE SQL STATEMENT FROM processableInsertValues ***" );
		StringTokenizer tokenizerValuesToInsert = new StringTokenizer(processableInsertValues, ","); 
		List<String> tokensForValuesToInsert = new ArrayList<>();
		logger.debug("* String tokens *");
		while (tokenizerValuesToInsert.hasMoreElements()) {
			tokensForValuesToInsert.add(tokenizerValuesToInsert.nextToken().trim());
		}
		logger.debug("numers of token: " + tokensForValuesToInsert.size() );
		for (String currentToken : tokensForValuesToInsert) {
			logger.debug("currentToken: " + currentToken);
		}
		/*checks*/
		if(tokensForValuesColumn.size()==tokensForValuesToInsert.size()) {
			logger.debug("*** [OK] SPLIT EXECUTED SUCCESSFULLY [OK] ***");
		}else {
			logger.debug("*** [ERROR] - [ERROR] ***");
			logger.debug("*** [ERROR] SPLIT EXECUTED SUCCESSFULLY [ERROR] ***");
		}
		/**/
		logger.debug("\n*** BINDING PARAMETERS FOR PREPARED STATEMENT ***" );
		HashMap<String,String> mapColumnnameAndValue=new HashMap<String,String>();//Creating HashMap.
		HashMap<String,QueryObject> mapForPS=new HashMap<String,QueryObject>();//Creating HashMap.
		List<QueryObject> queryObjectList = new ArrayList<>();

		for(int i = 0; i < tokensForValuesColumn.size(); i++) {
			/**/
			mapColumnnameAndValue.put(tokensForValuesColumn.get(i),tokensForValuesToInsert.get(i));
			/**/
			EmployeeTableFieldAndTypeEnum q = EmployeeTableFieldAndTypeEnum.getEnumfromTableFieldName(tokensForValuesColumn.get(i));
			/**/
			QueryObject qObj = new QueryObject(q.getTableFieldName(),tokensForValuesToInsert.get(i),q.getPreparedStatementJavaType());
			logger.debug("Query obj: " + qObj.toString());
			/**/
			mapForPS.put(tokensForValuesColumn.get(i), qObj );
			queryObjectList.add(qObj);
		}
		for (Map.Entry currentEntry : mapColumnnameAndValue.entrySet()) {
			logger.debug("Key: "+ currentEntry.getKey() + " - Value: " + currentEntry.getValue());
		}
		/**/
		logger.debug("Build last part prepared statements: ");
		StringBuilder str = new StringBuilder(); 
		str.append("(");
		for(int i=0; i < tokens.size(); i++) {
			str.append("?,");
		}
		str.deleteCharAt( str.length() - 1 );
		str.append(")");
		String resultAppendPS = str.toString();
		logger.debug("resultAppendPS: " + resultAppendPS);
		/**/

		try {
			logger.debug("*** H2 Connection Configuration ***");
			Driver d = (Driver)Class.forName("org.h2.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:h2:mem:employeeH2DB","sa",""); 
			/**/
			//STEP 3: Execute a query 
			logger.debug("* [H2] Creating table in given database..."); 
			Statement stmt = null; 
			stmt = connection.createStatement(); 
			String sql =  "create table employee(\r\n" + 
					"\r\n" + 
					"   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n" + 
					"   name varchar(255) not null,\r\n" + 
					"   surname varchar(255) not null,\r\n" + 
					"   primary key(id)\r\n" + 
					"\r\n" + 
					");";  
			stmt.executeUpdate(sql);
			
			/**/
			logger.debug("* [H2] Create sequence for table in given database..."); 
			stmt = connection.createStatement(); 
			sql =  "CREATE SEQUENCE  IF NOT EXISTS  EMPLOYEE_SEQ  START WITH 1 "+
					" INCREMENT BY 1";
			stmt.executeUpdate(sql);
			logger.debug("Created sequence in given database..."); 		
			/**/
			logger.debug("* [H2] Select sequence next value from given database...");
			String nextSequenceVal = "SELECT EMPLOYEE_SEQ.NEXTVAL AS SEQ FROM DUAL";
			String sequenceValue = null;
			/**/
			PreparedStatement selectStatement = connection
					.prepareStatement(nextSequenceVal);
			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				sequenceValue = resultSet.getString("SEQ");
			}
			logger.debug("Sequence value: " + sequenceValue);
			
			logger.debug("* [H2] Update ID value with sequence value...");
			for(int i = 0; i < tokensForValuesColumn.size(); i++) {
				QueryObject currentParam = queryObjectList.get(i);
				if(currentParam.getColumnName().equals("ID")) {
					currentParam.setColumnValue(sequenceValue);
				}
			}
			/**/
			logger.debug("* [H2] Prepare insert statement...");
			String SQL_INSERT = "INSERT INTO EMPLOYEE (ID, NAME, SURNAME) VALUES " + resultAppendPS;
			
			logger.debug("* [H2] Prepare dynamic preparedStatement...");
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			int psCounter = 1;
			for(int i = 0; i < tokensForValuesColumn.size(); i++) {

				QueryObject currentParam = queryObjectList.get(i);

				switch (currentParam.getPsType()) {
				case "BigDecimal":
					preparedStatement.setBigDecimal(psCounter++, new BigDecimal(currentParam.getColumnValue() ) );
					break;
				case "String":
					preparedStatement.setString(psCounter++, currentParam.getColumnValue()  );
					break;

				default:
					break;
				}
			}
			/*End for*/
			int row = preparedStatement.executeUpdate();

			// rows affected
			logger.debug("Row affected form statement: " + row); //1

			if (row == 1) {
				logger.debug("[SUCCESS] Inserted successfully : " + SQL_INSERT); 
			}
			else {
				logger.debug("[ERROR] Insertion failed"); 
			}
			/**/
			logger.debug("*** FIND ALL ***"); 
			List<Employee> listToReturn = new ArrayList<Employee>();
			PreparedStatement selectAllStatement = connection
					.prepareStatement("SELECT * from EMPLOYEE");

			ResultSet resultSetFindAll = selectAllStatement.executeQuery();

			while (resultSetFindAll.next()) {

				long id= resultSetFindAll.getLong("id");
				String name= resultSetFindAll.getString("name");
				String surname= resultSetFindAll.getString("surname");
				/**/
				Employee currentEmployee = new Employee(id, name, surname);
				listToReturn.add(currentEmployee);
			}
			
			for (Employee currentEmployee : listToReturn) {
				logger.debug("currentEmployee: " + currentEmployee.toString());
			}

			connection.close(); 

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

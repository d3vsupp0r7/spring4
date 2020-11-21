package org.lba.jdbc.util.sql;

import java.io.Serializable;

public class QueryObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1061842413239834534L;
	private String columnName;
	private String columnValue;
	private String psType;
	
	public QueryObject() {
		// Implement if necessary
	}

	public QueryObject(String columnName, String columnValue, String psType) {
		super();
		this.columnName = columnName;
		this.columnValue = columnValue;
		this.psType = psType;
	}
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	public String getPsType() {
		return psType;
	}

	public void setPsType(String psType) {
		this.psType = psType;
	}

	@Override
	public String toString() {
		return "QueryObject [columnName=" + columnName + ", columnValue=" + columnValue + ", psType=" + psType + "]";
	}
	
}

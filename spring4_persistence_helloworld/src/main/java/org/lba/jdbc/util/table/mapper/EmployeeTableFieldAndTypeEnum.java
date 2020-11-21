package org.lba.jdbc.util.table.mapper;

public enum EmployeeTableFieldAndTypeEnum {

	ID("ID","BigDecimal"),
	NAME("NAME","String"),
	SURNAME("SURNAME","String"),
	INVALID_VALUE("INVALID_VALUE","null")
	;
	
	private String tableFieldName;
	private String preparedStatementJavaType;

	EmployeeTableFieldAndTypeEnum(String tableFieldName,String preparedStatementJavaType) {
		this.tableFieldName = tableFieldName;
		this.preparedStatementJavaType = preparedStatementJavaType;
	}
	

	public String getTableFieldName() {
		return tableFieldName;
	}


	public String getPreparedStatementJavaType() {
		return preparedStatementJavaType;
	}


	public static EmployeeTableFieldAndTypeEnum getEnumfromTableFieldName(String value) {
		
		EmployeeTableFieldAndTypeEnum result = EmployeeTableFieldAndTypeEnum.INVALID_VALUE;
		
		for (EmployeeTableFieldAndTypeEnum d: EmployeeTableFieldAndTypeEnum.values()) {
			if(value.equalsIgnoreCase(d.getTableFieldName()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static EmployeeTableFieldAndTypeEnum getFromEnumKey(String sampleEnumKey) {
		EmployeeTableFieldAndTypeEnum result = EmployeeTableFieldAndTypeEnum.INVALID_VALUE;
		
		for (EmployeeTableFieldAndTypeEnum d: EmployeeTableFieldAndTypeEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = EmployeeTableFieldAndTypeEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}

	
}

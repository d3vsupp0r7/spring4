package org.lba.spring.factorymethod;

public enum ProductTypeEnum {


	PRODUCT1("PRODUCT1"),
	PRODUCT2("PRODUCT2"),
	INVALID_VALUE("INVALID_VALUE")
	;

	private String field;

	ProductTypeEnum(String field) {
		this.field = field;
	}

	public String field() {
		return field;
	}
	
	public static ProductTypeEnum getFromEnumValue(String value) {
		
		ProductTypeEnum result = ProductTypeEnum.INVALID_VALUE;
		
		for (ProductTypeEnum d: ProductTypeEnum.values()) {
			if(value.equalsIgnoreCase(d.field()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static ProductTypeEnum getFromEnumKey(String sampleEnumKey) {
		ProductTypeEnum result = ProductTypeEnum.INVALID_VALUE;
		
		for (ProductTypeEnum d: ProductTypeEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = ProductTypeEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}

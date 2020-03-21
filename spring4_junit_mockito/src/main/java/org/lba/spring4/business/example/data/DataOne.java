package org.lba.spring4.business.example.data;

import java.io.Serializable;
import java.util.Date;

public class DataOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2396703010882002632L;
	
	private String dataOneField1;
	private String dataOneField2;
	private int dataOneField3;
	private Date dataOneField4;
	
	public DataOne() {
		// TODO Auto-generated constructor stub
	}

	public String getDataOneField1() {
		return dataOneField1;
	}

	public void setDataOneField1(String dataOneField1) {
		this.dataOneField1 = dataOneField1;
	}

	public String getDataOneField2() {
		return dataOneField2;
	}

	public void setDataOneField2(String dataOneField2) {
		this.dataOneField2 = dataOneField2;
	}

	public int getDataOneField3() {
		return dataOneField3;
	}

	public void setDataOneField3(int dataOneField3) {
		this.dataOneField3 = dataOneField3;
	}

	public Date getDataOneField4() {
		return dataOneField4;
	}

	public void setDataOneField4(Date dataOneField4) {
		this.dataOneField4 = dataOneField4;
	}
	
	

}

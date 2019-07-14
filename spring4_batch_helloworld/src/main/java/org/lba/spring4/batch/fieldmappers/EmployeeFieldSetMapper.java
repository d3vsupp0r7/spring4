package org.lba.spring4.batch.fieldmappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.model.Employee;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
 
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {
 
	static final Logger logger = Logger.getLogger(EmployeeFieldSetMapper.class);
	
    static Employee employeeObj;
    
    private SimpleDateFormat dateFormatObj = new SimpleDateFormat("dd/MM/yyyy");
 
    public Employee mapFieldSet(FieldSet fieldSetObj) throws BindException {
    	
        employeeObj = new Employee();
        employeeObj.setId(fieldSetObj.readInt(0));
        employeeObj.setSalary(fieldSetObj.readBigDecimal(1));
        employeeObj.setName(fieldSetObj.readString(2));
        employeeObj.setSurname(fieldSetObj.readString(3));
 
        String csvDate = fieldSetObj.readString(4);
        
        try {
            employeeObj.setDateOfBirth(dateFormatObj.parse(csvDate));
            
        } catch (ParseException parseExceptionObj) {
            parseExceptionObj.printStackTrace();
        }
        
        return employeeObj;
    }
}
package org.lba.json.util;

import java.io.IOException;

import org.lba.spring4.db.model.EmployeeDBModel;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {

	public static void main(String[] args) {

		ObjectMapper Obj = new ObjectMapper(); 

		EmployeeDBModel employee = new EmployeeDBModel(1L, "aName", "aSurname");
		
		try { 

			// get object as a json string 
			String jsonStr = Obj.writeValueAsString(employee); 

			// Displaying JSON String 
			System.out.println(jsonStr); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}
}

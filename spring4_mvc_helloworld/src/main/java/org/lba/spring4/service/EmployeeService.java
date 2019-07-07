package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.EmployeeDBModel;

public interface EmployeeService {

	public List<EmployeeDBModel> getAllEmployees();

	public EmployeeDBModel deleteEmployeeById(Long id);
}

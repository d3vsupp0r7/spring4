package org.lba.spring4.app.o2m;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.onetomany.unidirectional.DepartmentO2MUnidirectional;
import org.lba.spring4.db.model.relationship.onetomany.unidirectional.EmployeeOneToManyUnidirectional;

public class MainAppH2_O2M_Unidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_O2M_Unidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			logger.debug("******************************************");
			logger.debug("*** One-2-Many Unidirectional - TEST   ***");
			logger.debug("******************************************");
			
			logger.debug("*** O2M Unidirectional - START ***");
			logger.debug("* O2M Unidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			/*1. Define Departments*/
			DepartmentO2MUnidirectional departmentSales = new DepartmentO2MUnidirectional();
			departmentSales.setDepartmentName("Sales");
			
			/**/
			DepartmentO2MUnidirectional departmentAmministrative = new DepartmentO2MUnidirectional();
			departmentAmministrative.setDepartmentName("Amministrative");
		
			/**/
			DepartmentO2MUnidirectional departmentFinancial = new DepartmentO2MUnidirectional();
			departmentFinancial.setDepartmentName("Financial");
		

			/*2. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeOneToManyUnidirectional *");
			EmployeeOneToManyUnidirectional emp1 = new EmployeeOneToManyUnidirectional("Nina", "Mayers", "111");
			EmployeeOneToManyUnidirectional emp2 = new EmployeeOneToManyUnidirectional("Tony", "Almeida", "222");
			EmployeeOneToManyUnidirectional emp3 = new EmployeeOneToManyUnidirectional("John", "Carter", "333");
			EmployeeOneToManyUnidirectional emp4 = new EmployeeOneToManyUnidirectional("Vince", "Doe", "444");

			/*Define employees list to associate at department*/
			logger.debug("*3. Define Employee Object: EmployeeOneToManyUnidirectional *");
			List<EmployeeOneToManyUnidirectional> employeeOnSales = new ArrayList<>();
			employeeOnSales.add(emp1);
			employeeOnSales.add(emp4);
			
			List<EmployeeOneToManyUnidirectional> employeeOnAmministrative = new ArrayList<>();
			employeeOnAmministrative.add(emp2);
			
			List<EmployeeOneToManyUnidirectional> employeeOnFinancial = new ArrayList<>();
			employeeOnFinancial.add(emp3);

			/**/
			logger.debug("*4. Associate Employees to Department Object *");
			departmentSales.setEmployees(employeeOnSales);
			departmentAmministrative.setEmployees(employeeOnAmministrative);
			departmentFinancial.setEmployees(employeeOnFinancial);
			
			/**/
			logger.debug("*5. Save Department Object *");
			logger.debug("*5.1. Calling Hibernate session.save on DepartmentO2MUnidirectional Object *");
			session.save(departmentSales);
			session.save(departmentAmministrative);
			session.save(departmentFinancial);

			logger.debug("*6. Call to Hibernate transaction.commit *");
			session.getTransaction().commit();
			logger.debug("*7. Call to Hibernate session.close *");
			session.close();
			logger.debug("* Records saved successfully *");
			logger.debug("*** O2M Unidirectional Persist - END ***");
			
			/*READ */			
			logger.debug("*** O2M Unidirectional READ PERSISTED DATA - START ***");
			logger.debug("* READ Employee Object: EmployeeOneToManyUnidirectional using JPQL *");
			
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeOneToManyUnidirectional> employeeO2MUnidirectionalList = (List<EmployeeOneToManyUnidirectional>) session.createQuery("from EmployeeOneToManyUnidirectional").list();
			for (EmployeeOneToManyUnidirectional currentEmployeeO2MUnidirectional : employeeO2MUnidirectionalList) {

				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2MUnidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing DepartmentO2MUnidirectional from EmployeeOneToManyUnidirectional *");
			employeeO2MUnidirectionalList = (List<EmployeeOneToManyUnidirectional>) session.createQuery("from EmployeeOneToManyUnidirectional").list();
			for (EmployeeOneToManyUnidirectional currentEmployeeO2MUnidirectional : employeeO2MUnidirectionalList) {

				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2MUnidirectional.toString());
				logger.debug("*** [IMPO] - With this mapping we cannot access to employee object data from address obbject");
			}
			/**/
			logger.debug("* READ Type 3: Accessing DepartmentO2MUnidirectional*");
			List<DepartmentO2MUnidirectional> departmentO2MUnidirectionalList = (List<DepartmentO2MUnidirectional>) session.createQuery("from DepartmentO2MUnidirectional").list();
			for (DepartmentO2MUnidirectional currentDepartmentO2MUnidirectional : departmentO2MUnidirectionalList) {

				logger.debug("currentDepartmentO2MUnidirectional: " + currentDepartmentO2MUnidirectional.toString());
				logger.debug("currentDepartmentO2MUnidirectional - Employess: " + currentDepartmentO2MUnidirectional.getEmployees());
			}


		} catch (Exception e) {
			logger.debug("[ERROR] - Exception thows - [ERROR]");
			if (transaction != null) {
				logger.debug("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			logger.debug("[FINALLY] - To Close session");
			if (session != null) {
				logger.debug("[FINALLY] - SESSION CLOSED");
				session.close();
			}
		}
		
		HibernateStandaloneContextConfigUtil.shutdown();
		logger.debug("*** O2M Unidirectional - END ***");
		
	}
}

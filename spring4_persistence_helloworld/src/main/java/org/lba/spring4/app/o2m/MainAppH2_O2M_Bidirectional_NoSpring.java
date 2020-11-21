package org.lba.spring4.app.o2m;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.onetomany.bidirectional.DepartmentO2MBidirectional;
import org.lba.spring4.db.model.relationship.onetomany.bidirectional.EmployeeOneToManyBidirectional;

public class MainAppH2_O2M_Bidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_O2M_Bidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			logger.debug("******************************************");
			logger.debug("*** One-2-Many Bidirectional - TEST   ***");
			logger.debug("******************************************");
			
			logger.debug("*** O2M Bidirectional - START ***");
			logger.debug("* O2M Bidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			/*1. Define Departments*/
			DepartmentO2MBidirectional departmentSales = new DepartmentO2MBidirectional();
			departmentSales.setDepartmentName("Sales");
			
			/**/
			DepartmentO2MBidirectional departmentAmministrative = new DepartmentO2MBidirectional();
			departmentAmministrative.setDepartmentName("Amministrative");
		
			/**/
			DepartmentO2MBidirectional departmentFinancial = new DepartmentO2MBidirectional();
			departmentFinancial.setDepartmentName("Financial");
		

			/*2. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeOneToManyBidirectional *");
			EmployeeOneToManyBidirectional emp1 = new EmployeeOneToManyBidirectional("Nina", "Mayers", "111");
			EmployeeOneToManyBidirectional emp2 = new EmployeeOneToManyBidirectional("Tony", "Almeida", "222");
			EmployeeOneToManyBidirectional emp3 = new EmployeeOneToManyBidirectional("John", "Carter", "333");
			EmployeeOneToManyBidirectional emp4 = new EmployeeOneToManyBidirectional("Vince", "Doe", "444");

			/*Define employees list to associate at department*/
			logger.debug("*3. Define Employee Object: EmployeeOneToManyBidirectional *");
			logger.debug("*3.1 Sales Department *");
			List<EmployeeOneToManyBidirectional> employeeOnSales = new ArrayList<>();
			employeeOnSales.add(emp1);
			employeeOnSales.add(emp4);
			logger.debug("*3.1 Setting Department to Employee Object *");
			emp1.setDepartment(departmentSales);
			emp4.setDepartment(departmentSales);
			
			logger.debug("*3.2 Amministrative Department *");
			List<EmployeeOneToManyBidirectional> employeeOnAmministrative = new ArrayList<>();
			employeeOnAmministrative.add(emp2);
			logger.debug("*3.2 Setting Department to Employee Object *");
			emp2.setDepartment(departmentAmministrative);
			
			logger.debug("*3.3 Financial Department *");
			List<EmployeeOneToManyBidirectional> employeeOnFinancial = new ArrayList<>();
			employeeOnFinancial.add(emp3);
			logger.debug("*3.3 Setting Department to Employee Object *");
			emp3.setDepartment(departmentFinancial);

			/**/
			logger.debug("*4. Associate Employees to Department Object *");
			departmentSales.setEmployees(employeeOnSales);
			departmentAmministrative.setEmployees(employeeOnAmministrative);
			departmentFinancial.setEmployees(employeeOnFinancial);
			
			/**/
			logger.debug("*5. Save Department Object *");
			logger.debug("*5.1. Calling Hibernate session.save on DepartmentO2MBidirectional Object *");
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
			logger.debug("* READ Employee Object: EmployeeOneToManyBidirectional using JPQL *");
			
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeOneToManyBidirectional> employeeO2MUnidirectionalList = (List<EmployeeOneToManyBidirectional>) session.createQuery("from EmployeeOneToManyBidirectional").list();
			for (EmployeeOneToManyBidirectional currentEmployeeO2MUnidirectional : employeeO2MUnidirectionalList) {

				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2MUnidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing DepartmentO2MBidirectional from EmployeeOneToManyBidirectional *");
			employeeO2MUnidirectionalList = (List<EmployeeOneToManyBidirectional>) session.createQuery("from EmployeeOneToManyBidirectional").list();
			for (EmployeeOneToManyBidirectional currentEmployeeO2MUnidirectional : employeeO2MUnidirectionalList) {

				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2MUnidirectional.toString());
				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2MUnidirectional.getDepartment());
				logger.debug("*** [IMPO] - With this mapping we can access to department object data from employee obbject");
			}
			/**/
			logger.debug("* READ Type 3: Accessing DepartmentO2MBidirectional*");
			List<DepartmentO2MBidirectional> DepartmentO2MBidirectionalList = (List<DepartmentO2MBidirectional>) session.createQuery("from DepartmentO2MBidirectional").list();
			for (DepartmentO2MBidirectional currentDepartmentO2MBidirectional : DepartmentO2MBidirectionalList) {

				logger.debug("currentDepartmentO2MBidirectional: " + currentDepartmentO2MBidirectional.toString());
				logger.debug("currentDepartmentO2MBidirectional - Employess: " + currentDepartmentO2MBidirectional.getEmployees());
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

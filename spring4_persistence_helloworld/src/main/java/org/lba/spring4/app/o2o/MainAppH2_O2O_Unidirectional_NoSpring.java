package org.lba.spring4.app.o2o;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.onetoone.unidirectional.EmployeeDetailsOneToOneUnidirectional;
import org.lba.spring4.db.model.relationship.onetoone.unidirectional.EmployeeOneToOneUnidirectional;

public class MainAppH2_O2O_Unidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_O2O_Unidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			logger.debug("******************************************");
			logger.debug("*** One-2-One Unidirectional - TEST   ***");
			logger.debug("******************************************");
			
			logger.debug("*** O2O Unidirectional - START ***");
			logger.debug("* O2O Unidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			/*1. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeOneToOneUnidirectional *");
			EmployeeOneToOneUnidirectional emp1 = new EmployeeOneToOneUnidirectional("Nina", "Mayers", "111");
			EmployeeOneToOneUnidirectional emp2 = new EmployeeOneToOneUnidirectional("Tony", "Almeida", "222");
			EmployeeOneToOneUnidirectional emp3 = new EmployeeOneToOneUnidirectional("John", "Carter", "333");
			EmployeeOneToOneUnidirectional emp4 = new EmployeeOneToOneUnidirectional("Vince", "Doe", "444");

			/*Define employees details*/
			logger.debug("*3. Define Employee Details Object: EmployeeDetailsOneToOneUnidirectional *");
			//String firstName, String lastName, String email, LocalDate dob
			EmployeeDetailsOneToOneUnidirectional emp1Details = new EmployeeDetailsOneToOneUnidirectional("FN_1","LN_1","EMAIL1",LocalDate.of(1985, Month.APRIL, 1));
			EmployeeDetailsOneToOneUnidirectional emp2Details = new EmployeeDetailsOneToOneUnidirectional("FN_2","LN_2","EMAIL2",LocalDate.of(1985, Month.MAY, 10));
			EmployeeDetailsOneToOneUnidirectional emp3Details = new EmployeeDetailsOneToOneUnidirectional("FN_3","LN_3","EMAIL3",LocalDate.of(1985, Month.JUNE, 15));
			EmployeeDetailsOneToOneUnidirectional emp4Details = new EmployeeDetailsOneToOneUnidirectional("FN_4","LN_4","EMAIL4",LocalDate.of(1985, Month.JULY, 20));

			/**/
			logger.debug("*4. Associate Employees to Employee Details Object *");
			emp1.setEmployeeDetail(emp1Details);
			emp2.setEmployeeDetail(emp2Details);
			emp3.setEmployeeDetail(emp3Details);
			emp4.setEmployeeDetail(emp4Details);
			
			/**/
			logger.debug("*5. Save Employees Object *");
			logger.debug("*5.1. Calling Hibernate session.save on EmployeeOneToOneUnidirectional Object *");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);

			logger.debug("*6. Call to Hibernate transaction.commit *");
			session.getTransaction().commit();
			logger.debug("*7. Call to Hibernate session.close *");
			session.close();
			logger.debug("* Records saved successfully *");
			logger.debug("*** O2O Unidirectional Persist - END ***");
			
			/*READ */			
			logger.debug("*** O2O Unidirectional READ PERSISTED DATA - START ***");
			logger.debug("* READ Employee Object: EmployeeOneToOneUnidirectional using JPQL *");
			
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeOneToOneUnidirectional> employeeO2OUnidirectionalList = (List<EmployeeOneToOneUnidirectional>) session.createQuery("from EmployeeOneToOneUnidirectional").list();
			for (EmployeeOneToOneUnidirectional currentEmployeeO2OUnidirectional : employeeO2OUnidirectionalList) {

				logger.debug("currentEmployeeO2MUnidirectional: " + currentEmployeeO2OUnidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing DepartmentO2MUnidirectional from EmployeeOneToManyUnidirectional *");
			employeeO2OUnidirectionalList = (List<EmployeeOneToOneUnidirectional>) session.createQuery("from EmployeeOneToOneUnidirectional").list();
			for (EmployeeOneToOneUnidirectional currentEmployeeO2OMUnidirectional : employeeO2OUnidirectionalList) {

				logger.debug("currentEmployeeO2OUnidirectional: " + currentEmployeeO2OMUnidirectional.toString());
				logger.debug("currentEmployeeO2OUnidirectional - EmployeeDetails: " + currentEmployeeO2OMUnidirectional.getEmployeeDetail());

			}
			/**/
			logger.debug("* READ Type 3: Accessing EmployeeDetailsOneToOneUnidirectional*");
			List<EmployeeDetailsOneToOneUnidirectional> employeeDetailsO2OUnidirectionalList = (List<EmployeeDetailsOneToOneUnidirectional>) session.createQuery("from EmployeeDetailsOneToOneUnidirectional").list();
			for (EmployeeDetailsOneToOneUnidirectional currentEmployeeDetailsO2OUnidirectional : employeeDetailsO2OUnidirectionalList) {

				logger.debug("currentEmployeeDetailsO2OUnidirectional: " + currentEmployeeDetailsO2OUnidirectional.toString());
				logger.debug("*** [IMPO] - With this mapping we cannot access to employee object data from employeeDetails object");
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
		logger.debug("*** O2O Unidirectional - END ***");
		
	}
}

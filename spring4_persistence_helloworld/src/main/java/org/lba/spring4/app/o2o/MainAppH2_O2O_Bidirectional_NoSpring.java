package org.lba.spring4.app.o2o;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.onetoone.bidirectional.EmployeeDetailsOneToOneBidirectional;
import org.lba.spring4.db.model.relationship.onetoone.bidirectional.EmployeeOneToOneBidirectional;

public class MainAppH2_O2O_Bidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_O2O_Bidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			logger.debug("******************************************");
			logger.debug("*** One-2-One Bidirectional - TEST   ***");
			logger.debug("******************************************");
			
			logger.debug("*** O2O Bidirectional - START ***");
			logger.debug("* O2O Bidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			/*1. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeOneToOneBidirectional *");
			EmployeeOneToOneBidirectional emp1 = new EmployeeOneToOneBidirectional("Nina", "Mayers", "111");
			EmployeeOneToOneBidirectional emp2 = new EmployeeOneToOneBidirectional("Tony", "Almeida", "222");
			EmployeeOneToOneBidirectional emp3 = new EmployeeOneToOneBidirectional("John", "Carter", "333");
			EmployeeOneToOneBidirectional emp4 = new EmployeeOneToOneBidirectional("Vince", "Doe", "444");

			/*Define employees details*/
			logger.debug("*3. Define Employee Details Object: EmployeeDetailsOneToOneBidirectional *");
			//String firstName, String lastName, String email, LocalDate dob
			EmployeeDetailsOneToOneBidirectional emp1Details = new EmployeeDetailsOneToOneBidirectional("FN_1","LN_1","EMAIL1",LocalDate.of(1985, Month.APRIL, 1));
			EmployeeDetailsOneToOneBidirectional emp2Details = new EmployeeDetailsOneToOneBidirectional("FN_2","LN_2","EMAIL2",LocalDate.of(1985, Month.MAY, 10));
			EmployeeDetailsOneToOneBidirectional emp3Details = new EmployeeDetailsOneToOneBidirectional("FN_3","LN_3","EMAIL3",LocalDate.of(1985, Month.JUNE, 15));
			EmployeeDetailsOneToOneBidirectional emp4Details = new EmployeeDetailsOneToOneBidirectional("FN_4","LN_4","EMAIL4",LocalDate.of(1985, Month.JULY, 20));

			/**/
			logger.debug("*4. Associate Employees to Employee Details Object *");
			emp1.setEmployeeDetail(emp1Details);
			emp2.setEmployeeDetail(emp2Details);
			emp3.setEmployeeDetail(emp3Details);
			emp4.setEmployeeDetail(emp4Details);
			
			logger.debug("*4.1 Associate  Employee Details to Employees Object *");
			emp1Details.setEmployee(emp1);
			emp2Details.setEmployee(emp2);
			emp3Details.setEmployee(emp3);
			emp4Details.setEmployee(emp4);
			
			/**/
			logger.debug("*5. Save Employees Object *");
			logger.debug("*5.1. Calling Hibernate session.save on EmployeeOneToOneBidirectional Object *");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);

			logger.debug("*6. Call to Hibernate transaction.commit *");
			session.getTransaction().commit();
			logger.debug("*7. Call to Hibernate session.close *");
			session.close();
			logger.debug("* Records saved successfully *");
			logger.debug("*** O2O Bidirectional Persist - END ***");
			
			/*READ */			
			logger.debug("*** O2O Bidirectional READ PERSISTED DATA - START ***");
			logger.debug("* READ Employee Object: EmployeeOneToOneBidirectional using JPQL *");
			
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeOneToOneBidirectional> employeeO2OBidirectionalList = (List<EmployeeOneToOneBidirectional>) session.createQuery("from EmployeeOneToOneBidirectional").list();
			for (EmployeeOneToOneBidirectional currentEmployeeO2OBidirectional : employeeO2OBidirectionalList) {

				logger.debug("currentEmployeeO2OBidirectional: " + currentEmployeeO2OBidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing DepartmentO2OBidirectional from EmployeeOneToManyBidirectional *");
			employeeO2OBidirectionalList = (List<EmployeeOneToOneBidirectional>) session.createQuery("from EmployeeOneToOneBidirectional").list();
			for (EmployeeOneToOneBidirectional currentEmployeeO2OMBidirectional : employeeO2OBidirectionalList) {

				logger.debug("currentEmployeeO2OBidirectional: " + currentEmployeeO2OMBidirectional.toString());
				logger.debug("currentEmployeeO2OBidirectional - EmployeeDetails: " + currentEmployeeO2OMBidirectional.getEmployeeDetail());

			}
			/**/
			logger.debug("* READ Type 3: Accessing EmployeeDetailsOneToOneBidirectional*");
			List<EmployeeDetailsOneToOneBidirectional> employeeDetailsO2OBidirectionalList = (List<EmployeeDetailsOneToOneBidirectional>) session.createQuery("from EmployeeDetailsOneToOneBidirectional").list();
			for (EmployeeDetailsOneToOneBidirectional currentEmployeeDetailsO2OBidirectional : employeeDetailsO2OBidirectionalList) {

				logger.debug("currentEmployeeDetailsO2OBidirectional: " + currentEmployeeDetailsO2OBidirectional.toString());
				logger.debug("currentEmployeeDetailsO2OBidirectional - EMPLOYEE: " + currentEmployeeDetailsO2OBidirectional.getEmployee());
			
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
		logger.debug("*** O2O Bidirectional - END ***");
		
	}
}

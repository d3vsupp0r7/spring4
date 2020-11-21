package org.lba.spring4.app.m2m;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.manytomany.bidirectional.AddressM2MBidirectional;
import org.lba.spring4.db.model.relationship.manytomany.bidirectional.EmployeeM2MBidirectional;

public class MainAppH2_M2M_Bidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_M2M_Bidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			logger.debug("******************************************");
			logger.debug("*** Many-2-Many Bidirectional  - TEST  ***");
			logger.debug("******************************************");
			
			logger.debug("*** M2M Bidirectional - START ***");
			logger.debug("* M2M Bidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			/*1. Define Address*/
			logger.debug("*1. Define Address Object: AddressM2MBidirectional *");
			AddressM2MBidirectional address1 = new AddressM2MBidirectional("Bengaluru", "Karnataka", "India", "560016");
			AddressM2MBidirectional address2 = new AddressM2MBidirectional("Jaipur", "Rajasthan", "India", "302017");

			/*2. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeM2MBidirectional *");
			// Employee1 have 2 addresses
			EmployeeM2MBidirectional employee1 = new EmployeeM2MBidirectional("Ravindra Singh", "Sales Manager", 450000);
			employee1.getAddresses().add(address1);
			employee1.getAddresses().add(address2);

			// Employee2 have 1 address
			EmployeeM2MBidirectional employee2 = new EmployeeM2MBidirectional("Mohit Sharma", "Software Engineer", 850000);
			employee2.getAddresses().add(address1);

			logger.debug("*3. Calling Hibernate session.save on EmployeeM2MBidirectional Object *");
			session.save(employee1);
			session.save(employee2);
			logger.debug("*4. Call to Hibernate transaction.commit *");
			transaction.commit();
			logger.debug("*5. Call to Hibernate session.close *");
			session.close();

			logger.debug("* Records saved successfully *");
			logger.debug("*** M2M Bidirectional Persist - END ***");
			
			/*READ */
			logger.debug("*** M2M Unidirectional READ PERSISTED DATA - START ***");
			logger.debug("* READ Employee Object: EmployeeM2MBidirectional using JPQL *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeM2MBidirectional> employeeM2MBidirectionalList = (List<EmployeeM2MBidirectional>) session.createQuery("from EmployeeM2MBidirectional").list();
			for (EmployeeM2MBidirectional currentEmployeeM2MBidirectional : employeeM2MBidirectionalList) {

				logger.debug("\ncurrentEmployeeM2MBidirectional: " + currentEmployeeM2MBidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing AddressM2MBidirectional from EmployeeM2MBidirectional *");
			employeeM2MBidirectionalList = (List<EmployeeM2MBidirectional>) session.createQuery("from EmployeeM2MBidirectional").list();
			for (EmployeeM2MBidirectional currentEmployeeM2MBidirectional : employeeM2MBidirectionalList) {

				System.out.println("\ncurrentEmployeeM2MBidirectional: " + currentEmployeeM2MBidirectional.toString());
				System.out.println("currentEmployeeM2MBidirectional - ADDRESS: " + currentEmployeeM2MBidirectional.getAddresses());
			}
			/**/
			logger.debug("* READ Type 3: Accessing AddressM2MUnidirectional*");
			List<AddressM2MBidirectional> addressM2MBidirectional = (List<AddressM2MBidirectional>) session.createQuery("from AddressM2MBidirectional").list();
			for (AddressM2MBidirectional currentAddressM2MBidirectional : addressM2MBidirectional) {

				logger.debug("currentAddressM2MBidirectional: " + currentAddressM2MBidirectional.toString());
				logger.debug("currentAddressM2MBidirectional - Accessing to EmployeeM2MBidirectional: " + currentAddressM2MBidirectional.getEmployees());
				logger.debug("*** [IMPO] - With this mapping we can access to employee object data from address obbject");
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
				session.close();
				logger.debug("[FINALLY] - SESSION CLOSED");
			}
		}
		HibernateStandaloneContextConfigUtil.shutdown();
		logger.debug("*** M2M Bidirectional - END ***");
	}
}

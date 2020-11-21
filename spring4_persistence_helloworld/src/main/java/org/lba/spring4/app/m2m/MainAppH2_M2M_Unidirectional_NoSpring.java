package org.lba.spring4.app.m2m;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.lba.hibernate.standalone.config.annotated.entity.HibernateStandaloneContextConfigUtil;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.AddressM2MUnidirectional;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.EmployeeM2MUnidirectional;

public class MainAppH2_M2M_Unidirectional_NoSpring {

	static final  Logger logger = Logger.getLogger(MainAppH2_M2M_Unidirectional_NoSpring.class);

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			logger.debug("******************************************");
			logger.debug("*** Many-2-Many Unidirectional - TEST  ***");
			logger.debug("******************************************");
			
			logger.debug("*** M2M Unidirectional - START ***");
			logger.debug("* M2M Unidirectional Persist - START ***");
			logger.debug("*1. Define Hibernate session *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			/*1. Define Address*/
			logger.debug("*1. Define Address Object: AddressM2MUnidirectional *");
			AddressM2MUnidirectional address1 = new AddressM2MUnidirectional("Bengaluru", "Karnataka", "India", "560016");
			AddressM2MUnidirectional address2 = new AddressM2MUnidirectional("Jaipur", "Rajasthan", "India", "302017");

			/*2. Define Employees*/
			logger.debug("*2. Define Employee Object: EmployeeM2MUnidirectional *");
			// Employee1 have 2 addresses
			EmployeeM2MUnidirectional employee1 = new EmployeeM2MUnidirectional("Ravindra Singh", "Sales Manager", 450000);
			employee1.getAddresses().add(address1);
			employee1.getAddresses().add(address2);

			// Employee2 have 1 address
			EmployeeM2MUnidirectional employee2 = new EmployeeM2MUnidirectional("Mohit Sharma", "Software Engineer", 850000);
			employee2.getAddresses().add(address1);
			logger.debug("*3. Calling Hibernate session.save on EmployeeM2MUnidirectional Object *");
			session.save(employee1);
			session.save(employee2);
			logger.debug("*4. Call to Hibernate transaction.commit *");
			transaction.commit();
			logger.debug("*5. Call to Hibernate session.close *");
			session.close();

			logger.debug("* Records saved successfully *");
			logger.debug("*** M2M Unidirectional Persist - END ***");
			
			/*READ */
			logger.debug("*** M2M Unidirectional READ PERSISTED DATA - START ***");
			logger.debug("* READ Employee Object: EmployeeM2MUnidirectional using JPQL *");
			session = HibernateStandaloneContextConfigUtil.getSessionFactory().openSession();
			List<EmployeeM2MUnidirectional> employeeM2MUnidirectionalList = (List<EmployeeM2MUnidirectional>) session.createQuery("from EmployeeM2MUnidirectional").list();
			for (EmployeeM2MUnidirectional currentEmployeeM2MUnidirectional : employeeM2MUnidirectionalList) {

				logger.debug("currentEmployeeM2MUnidirectional: " + currentEmployeeM2MUnidirectional.toString());
			}

			/**/
			logger.debug("* READ Type 2: Accessing AddressM2MUnidirectional from EmployeeM2MUnidirectional *");
			employeeM2MUnidirectionalList = (List<EmployeeM2MUnidirectional>) session.createQuery("from EmployeeM2MUnidirectional").list();
			for (EmployeeM2MUnidirectional currentEmployeeM2MUnidirectional : employeeM2MUnidirectionalList) {

				logger.debug("currentEmployeeM2MUnidirectional: " + currentEmployeeM2MUnidirectional.toString());
				logger.debug("currentEmployeeM2MUnidirectional - ADDRESS: " + currentEmployeeM2MUnidirectional.getAddresses());
			}
			
			/**/
			logger.debug("* READ Type 3: Accessing AddressM2MUnidirectional*");
			List<AddressM2MUnidirectional> addressM2MUnidirectionalList = (List<AddressM2MUnidirectional>) session.createQuery("from AddressM2MUnidirectional").list();
			for (AddressM2MUnidirectional currentAddressM2MUnidirectional : addressM2MUnidirectionalList) {

				logger.debug("currentAddressM2MUnidirectional: " + currentAddressM2MUnidirectional.toString());
				logger.debug("currentAddressM2MUnidirectional - Country: " + currentAddressM2MUnidirectional.getCountry());
				logger.debug("*** [IMPO] - With this mapping we cannot access to employee object data from address obbject");
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
		logger.debug("*** M2M Unidirectional - END ***");
	}
}

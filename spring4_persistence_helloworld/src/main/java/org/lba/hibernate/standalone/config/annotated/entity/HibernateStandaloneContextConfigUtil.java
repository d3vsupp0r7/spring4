package org.lba.hibernate.standalone.config.annotated.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.lba.spring4.db.model.relationship.manytomany.bidirectional.AddressM2MBidirectional;
import org.lba.spring4.db.model.relationship.manytomany.bidirectional.EmployeeM2MBidirectional;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.AddressM2MUnidirectional;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.EmployeeM2MUnidirectional;
import org.lba.spring4.db.model.relationship.onetomany.bidirectional.DepartmentO2MBidirectional;
import org.lba.spring4.db.model.relationship.onetomany.bidirectional.EmployeeOneToManyBidirectional;
import org.lba.spring4.db.model.relationship.onetomany.unidirectional.DepartmentO2MUnidirectional;
import org.lba.spring4.db.model.relationship.onetomany.unidirectional.EmployeeOneToManyUnidirectional;
import org.lba.spring4.db.model.relationship.onetoone.bidirectional.EmployeeDetailsOneToOneBidirectional;
import org.lba.spring4.db.model.relationship.onetoone.bidirectional.EmployeeOneToOneBidirectional;
import org.lba.spring4.db.model.relationship.onetoone.unidirectional.EmployeeDetailsOneToOneUnidirectional;
import org.lba.spring4.db.model.relationship.onetoone.unidirectional.EmployeeOneToOneUnidirectional;

public class HibernateStandaloneContextConfigUtil {

	static final  Logger logger = Logger.getLogger(HibernateStandaloneContextConfigUtil.class);
	
	 private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {
	            StandardServiceRegistryBuilder registryBuilder = 
	                  new StandardServiceRegistryBuilder();
	            
				/** H2 CONFIG **/
	            Map<String, String> settings = new HashMap<>();
	            settings.put("hibernate.connection.driver_class", "org.h2.Driver");
	            settings.put("hibernate.connection.url", "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1");
	            settings.put("hibernate.connection.username", "sa");
	            settings.put("hibernate.connection.password", "");
	            /**/
	            settings.put("hibernate.show_sql", "true");
	            settings.put("hibernate.format_sql", "true");
	            /**/
	            settings.put("hibernate.hbm2ddl.auto", "create-drop");

	            registry = registryBuilder.applySettings(settings).build();

	            MetadataSources sources = new MetadataSources(registry)
	            		//M2M Uni
	                  .addAnnotatedClass(EmployeeM2MUnidirectional.class)
	                  .addAnnotatedClass(AddressM2MUnidirectional.class)
	                  //M2M Bi
	                  .addAnnotatedClass(EmployeeM2MBidirectional.class)
	                  .addAnnotatedClass(AddressM2MBidirectional.class)
	                  // O2M Uni
	                  .addAnnotatedClass(EmployeeOneToManyUnidirectional.class)
	                  .addAnnotatedClass(DepartmentO2MUnidirectional.class)
	                  //O2M Bi
	                  .addAnnotatedClass(EmployeeOneToManyBidirectional.class)
	                  .addAnnotatedClass(DepartmentO2MBidirectional.class)
	                  //O2O Uni
	                  .addAnnotatedClass(EmployeeOneToOneUnidirectional.class)
	                  .addAnnotatedClass(EmployeeDetailsOneToOneUnidirectional.class)
	                  //O2O Bi
	                  .addAnnotatedClass(EmployeeOneToOneBidirectional.class)
	                  .addAnnotatedClass(EmployeeDetailsOneToOneBidirectional.class)
	                  ;

	            Metadata metadata = sources.getMetadataBuilder().build();

	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	         } catch (Exception e) {
	            System.out.println("SessionFactory creation failed");
	            logger.debug(e.getMessage());
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
}

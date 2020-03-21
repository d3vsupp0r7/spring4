package org.lba.easymock.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.business.example.IBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath*:META-INF/spring4-test-easymock-config.xml") 
public class ConcreteBusinessTest {
	
	@Autowired
	private IBusiness businessClass;

	@Test
	public void when_business_called() {
		
		businessClass.businessMethod1();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

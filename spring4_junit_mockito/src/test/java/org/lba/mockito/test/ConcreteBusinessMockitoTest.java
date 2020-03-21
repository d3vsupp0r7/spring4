package org.lba.mockito.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lba.spring4.business.example.IBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath*:META-INF/spring4-test-mockito-config.xml") 
public class ConcreteBusinessMockitoTest {
	
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

package org.lba.spring4.integration.filter;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class ConcreteFilter extends AbstractFilter implements MessageSelector{

	@Override
	public boolean accept(Message<?> message) {
		// TODO Auto-generated method stub
		return false;
	}

}

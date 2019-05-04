package org.lba.spring4.message.provider;

public class HelloWorldMessageProvider implements MessageProvider {
	
	public String getMessage() {
		return "Hello World!";
	}
}
package org.lba.spring4.springintegration.adapter;

public class SimpleProducer {

	private static Integer value = 0;

	public String produce() {
		return (++value).toString();
	}
}

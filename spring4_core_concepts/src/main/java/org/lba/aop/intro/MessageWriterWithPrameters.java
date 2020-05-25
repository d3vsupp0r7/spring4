package org.lba.aop.intro;

public class MessageWriterWithPrameters {
	public void writeMessage() {
		System.out.print("World [called target class]");
	}
	
	public void writeMessageWithParameters(String param1, int param2) {
		System.out.print("World [called target class]- param1: " + param1 + " - param2: " + param2);
	}
}
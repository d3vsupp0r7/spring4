package org.lba.beancontextmanagement.xml.prototype;

public class MessagePrototypeBean {

	private Integer id;
	private String message;
	
	public MessagePrototypeBean() {
		 System.out.println("Prototype Bean Instantiated ...!!");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessagePrototypeBean [id=" + id + ", message=" + message + "]";
	}
	
	
}

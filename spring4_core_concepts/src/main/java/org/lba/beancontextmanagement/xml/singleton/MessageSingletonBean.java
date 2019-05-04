package org.lba.beancontextmanagement.xml.singleton;

public class MessageSingletonBean {

	private Integer id;
	private String message;
	
	public MessageSingletonBean() {
		 System.out.println("Singleton Bean Instantiated ...!!");
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
		return "MessageSingletonBean [id=" + id + ", message=" + message + "]";
	}
	
	
}

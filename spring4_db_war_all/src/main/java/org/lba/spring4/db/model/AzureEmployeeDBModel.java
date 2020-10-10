package org.lba.spring4.db.model;

import java.io.Serializable;
import java.sql.Blob;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.MessageBody;


@Entity
@Table(
		name = "AZURE_EMPLOYEE")
public class AzureEmployeeDBModel implements Serializable,IMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5674477463323457295L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "azureEmployeeSeq")
	@SequenceGenerator(name = "azureEmployeeSeq", sequenceName = "AZURE_EMPLOYEE_SEQ", allocationSize=1)
	@Column(name = "ID")
	@XmlTransient

	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;

	/*
	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="content", nullable=false)
    private byte[] content;*/
	@Column(name="document_1")
	private Blob document1;

	public Blob getDocument1() {
		return document1;
	}

	public void setDocument1(Blob document1) {
		this.document1 = document1;
	}

	public AzureEmployeeDBModel() {
		super();
	}

	public AzureEmployeeDBModel( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public AzureEmployeeDBModel(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

	@Override
	public String toString() {
		return "AzureEmployeeDBModel [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

	@Override
	public long getDeliveryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMessageId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageId(String messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Duration getTimeToLive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTimeToLive(Duration timeToLive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentType(String contentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instant getExpiresAtUtc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instant getLockedUntilUtc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instant getEnqueuedTimeUtc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instant getScheduledEnqueuedTimeUtc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScheduledEnqueuedTimeUtc(Instant scheduledEnqueueTimeUtc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instant getScheduledEnqueueTimeUtc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScheduledEnqueueTimeUtc(Instant scheduledEnqueueTimeUtc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getSequenceNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSessionId(String sessionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBody(byte[] body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageBody getMessageBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageBody(MessageBody body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCorrelationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorrelationId(String correlationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTo(String to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getReplyTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReplyTo(String replyTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getReplyToSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReplyToSessionId(String replyToSessionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPartitionKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPartitionKey(String partitionKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getViaPartitionKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setViaPartitionKey(String viaPartitionKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDeadLetterSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getLockToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMessage createCopy() {
		// TODO Auto-generated method stub
		return null;
	}


}

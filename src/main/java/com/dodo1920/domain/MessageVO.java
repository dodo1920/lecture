package com.dodo1920.domain;

import java.util.Date;

public class MessageVO {
	private int mid;
	private String targetId;
	private String message;
	private String sender;
	private Date openDate;
	private Date sendDate;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", targetId=" + targetId + ", message=" + message + ", sender=" + sender
				+ ", openDate=" + openDate + ", sendDate=" + sendDate + "]";
	}	
	
}

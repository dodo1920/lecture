package com.dodo1920.domain;

import java.util.Date;

public class ReplyVO {
	private int no;
	private int bno;
	private String replyText;
	private String replyer;
	private Date regdate;
	private Date updateDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [no=" + no + ", bno=" + bno + ", replyText=" + replyText + ", replyer=" + replyer + ", regdate="
				+ regdate + ", updateDate=" + updateDate + "]";
	}
	
}

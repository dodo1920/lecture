package com.dodo1920.domain;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int viewcnt;
	private String isDelete;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String writer, String content, Date regdate, int viewcnt, String isDelete) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.isDelete = isDelete;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", viewcnt=" + viewcnt + ", isDelete=" + isDelete + "]";
	}
	
}

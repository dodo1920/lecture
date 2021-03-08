package com.dodo1920.dto;

public class LoginDTO { // domain 패키지와 dto 패키지의 차이점
	// domain : DB의 데이터와 연동되는 VO class들 집합
	// dto : VO들 중 필요한 것만 뽑아서 새로운 class로 만들 때
	private String uid;
	private String upw;
	
	private boolean userCookie;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public boolean isUserCookie() {
		return userCookie;
	}

	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + ", userCookie=" + userCookie + "]";
	}
	
}

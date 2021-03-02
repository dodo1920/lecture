package com.dodo1920.service;

import com.dodo1920.domain.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(String uid, int mid) throws Exception;
}

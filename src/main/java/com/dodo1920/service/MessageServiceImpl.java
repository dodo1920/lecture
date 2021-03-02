package com.dodo1920.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dodo1920.domain.MessageVO;
import com.dodo1920.persistence.MessageDAO;
import com.dodo1920.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {
	@Inject
	private MessageDAO mdao;
	
	@Inject
	private PointDAO pdao;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mdao.create(vo);
		pdao.updatePoint(vo.getSender(), 10); // 메세지 발송자에게 10포인트 추가
	}

	@Override
	public MessageVO readMessage(String uid,int mid) throws Exception {
		mdao.updateState(mid); // 메세지를 읽은 상태로
		pdao.updatePoint(uid, 5); // 메세지 수신자에게 5점 추가
		
		return mdao.readMessage(mid);
	}

}

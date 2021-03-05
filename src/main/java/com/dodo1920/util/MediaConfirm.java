package com.dodo1920.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaConfirm {
	private static Map<String, MediaType> mediaMap;
	
	static {
		// 스테틱 멤버 변수 초기화 블럭
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("jpg", MediaType.IMAGE_JPEG);
		mediaMap.put("jpeg", MediaType.IMAGE_JPEG);
		mediaMap.put("gif", MediaType.IMAGE_GIF);
		mediaMap.put("png", MediaType.IMAGE_PNG);
	}
	
//	{
//		// 초기화 블럭 : 멤버 변수 초기화
//	}
	
	public static MediaType getMediaType(String ext) {
//		mediaMap.containsKey(ext); //  MediaType.IMAGE_JPEG값이 있는 지 확인
		return mediaMap.get(ext.toLowerCase());
	}
}

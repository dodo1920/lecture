package com.dodo1920.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dodo1920.domain.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("로그인 하기 전*************************************************");
		
		HttpSession ses = request.getSession();
		
		if(ses.getAttribute("loginMember") != null) {
			ses.removeAttribute("loginMember");
		}
			
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession ses = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		UserVO vo = (UserVO)modelMap.get("loginMember");
		
		if(vo != null) {
			logger.info("로그인 성공!");
			ses.setAttribute("loginMember", vo);
			
			response.sendRedirect("/");
		}
	}
	
}

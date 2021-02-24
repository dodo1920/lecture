package com.dodo1920.springProj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandle {
   private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandle.class);
   
   @ExceptionHandler
   public ModelAndView commonError(Exception ex) {
      logger.info(ex.toString());
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("error"); // "error" 를 ViewResolver 객체에 전송하여 /WEB-INF/views/error.jsp를 찾게 만든다
      mav.addObject("exception", ex); // mav에 ex객체 바인딩
      return mav;
   }
}

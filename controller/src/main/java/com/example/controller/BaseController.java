package com.example.controller;


import com.example.common.exception.JsApiTicketAcquireFailureException;
import com.example.common.exception.TokenExpiredException;
import com.example.common.exception.UnknownException;
import com.example.common.response.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({UnknownException.class})
    @ResponseBody
    public ResponseWrapper handleUnAuthorzied() {
        ResponseWrapper ResponseWrapper = new ResponseWrapper("");
        ResponseWrapper.setCode(HttpStatus.UNAUTHORIZED.value());
        ResponseWrapper.setMsg("unauthorized");
        return ResponseWrapper;
    }

    @ExceptionHandler({TokenExpiredException.class})
    @ResponseBody
    public ResponseWrapper Token() {
        ResponseWrapper ResponseWrapper = new ResponseWrapper("");
        ResponseWrapper.setCode(HttpStatus.UNAUTHORIZED.value());
        ResponseWrapper.setMsg("Token is invalid");
        return ResponseWrapper;
    }

    @ExceptionHandler({JsApiTicketAcquireFailureException.class})
    @ResponseBody
    public ResponseWrapper sApiTicket() {
        ResponseWrapper ResponseWrapper = new ResponseWrapper("");
        ResponseWrapper.setCode(HttpStatus.UNAUTHORIZED.value());
        ResponseWrapper.setMsg("JsApiTicket is error");
        return ResponseWrapper;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, ServletRequestBindingException.class})
    @ResponseBody
    public ResponseWrapper badRequest() {
        return ResponseWrapper.badRequest();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseWrapper handleError(Exception exception) {
        logger.error("api error", exception);
        return ResponseWrapper.error("server error");
    }
    
/*    protected String getIp(HttpServletRequest request){
        
        String ip = request.getHeader("x-forwarded-for");  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }
        return ip;
    }*/

    protected String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date());
    }

}
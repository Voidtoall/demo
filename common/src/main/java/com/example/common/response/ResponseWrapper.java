package com.example.common.response;

public class ResponseWrapper<T> {
	
	private Integer code;
	private String msg;
	private T obj;
	
	public ResponseWrapper(T obj){
		this.code = Message.SUCCESS.code;
		this.obj = obj;
	}
	
	public ResponseWrapper(Message message){
		this.code = message.code;
		this.msg = message.message;
	}
	
	public ResponseWrapper(Message message,T obj){
		this.code = message.code;
		this.msg = message.message;
		this.obj = obj;
	}
	
   public static ResponseWrapper<?> error(String message) {
	   ResponseWrapper<?> response = new ResponseWrapper<>(message);
	   response.code = 500;
       return response;
    }

    public static ResponseWrapper<?> badRequest() {
    	ResponseWrapper<String> response = new ResponseWrapper<String>("不可用的请求");
 	    response.code = 400;
        return response;
    }
	    
	/*public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}*/

    public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Integer getCode() {
		return code;
	}


	

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

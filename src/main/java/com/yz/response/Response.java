package com.yz.response;

public class Response {
	private static final String OK = "success";  
    private static final String ERROR = "error";  
  
    private int errorNo;
    private String errorMsg;
    
	private String token;
    private Object response;  
  
    public Response success() {  
//        this.meta = new Meta(true, OK);
        this.errorNo = 1;
        this.errorMsg = OK;
        return this;  
    }  
  
    public Response success(Object response) {  
//        this.meta = new Meta(true, OK);
        this.errorNo = 1;
        this.errorMsg = OK;
        this.response = response;  
        return this;  
    } 
    
    /**
     * 返回追加token参数的请求结果
     * @param token
     * @param data
     * @return
     */
    public Response success_Token(String token,Object response) {  
//        this.meta = new Meta(true, OK);
    	this.errorNo = 1;
        this.errorMsg = OK;
        this.token = token;
        this.response = response;  
        return this;  
    }
  
    public Response failure() {  
//        this.meta = new Meta(false, ERROR); 
        this.errorNo = 0;
        this.errorMsg = ERROR;
        return this;  
    }  
  
    public Response failure(String message) {  
//        this.meta = new Meta(false, message);
        this.errorNo = 0;
        this.errorMsg = message;
        return this;  
    }  
  
//    public Meta getMeta() {  
//        return meta;  
//    }  
  
    public Object getResponse() {  
        return response;  
    }  
  
    public int getErrorNo() {
		return errorNo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getToken() {
		return token;
	}

}

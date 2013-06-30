package com.tech_tec.qiitarian.model;

public class ResponseType {
    
    public static final ResponseType SUCCESS = new ResponseType();
    public static final ResponseType FAILED = new ResponseType();
    public static final ResponseType ERROR = new ResponseType();
    
    private ResponseType() {}
    
}

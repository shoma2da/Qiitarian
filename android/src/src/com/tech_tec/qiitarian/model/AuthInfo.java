package com.tech_tec.qiitarian.model;

public class AuthInfo {
    private LoginService mService;
    private String mUsername;
    private String mToken;
    
    public LoginService getService() {
        return mService;
    }

    public void setService(LoginService mService) {
        this.mService = mService;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String mToken) {
        this.mToken = mToken;
    }

}

package com.tech_tec.qiitarian.model;

public class AuthInfo {
    public static enum Service {
        TWITTER, GITHUB;
    }
    
    private Service mService;
    private String mUsername;
    private String mToken;
    
    public Service getService() {
        return mService;
    }

    public void setService(Service mService) {
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

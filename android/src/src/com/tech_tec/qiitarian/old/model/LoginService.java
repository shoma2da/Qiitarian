package com.tech_tec.qiitarian.old.model;

public abstract class LoginService {
    
    public abstract String convert(String username);
    
    public static LoginService getByName(String name) {
        if (TWITTER.toString().equals(name)) {
            return TWITTER;
        } else if (GITHUB.toString().equals(name)) {
            return GITHUB;
        }
        throw new IllegalArgumentException();
    }
    
    public static final LoginService TWITTER = new LoginService() {
        @Override
        public String convert(String username) {
            return username;
        }
        @Override
        public String toString() {
            return "twitter";
        }
    };
    
    public static final LoginService GITHUB = new LoginService() {
        @Override
        public String convert(String username) {
            return String.format("%s@github", username);
        }
        @Override
        public String toString() {
            return "github";
        }
    };
}

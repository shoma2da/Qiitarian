package com.tech_tec.qiitarian.model.detail;

public class ArticleBody {
    
    private String mBody;
    
    public ArticleBody(String body) {
        mBody = body;
    }
    
    @Override
    public String toString() {
        return mBody;
    }
    
}

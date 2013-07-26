package com.tech_tec.qiitarian.model.detail;

import com.tech_tec.qiitarian.model.ArticleTitle;
import com.tech_tec.qiitarian.model.User;

public class Detail {
    
    private User mUser;
    private ArticleTitle mArticleTitle;
    
    public Detail(User user, ArticleTitle articleTitle) {
        mUser = user;
        mArticleTitle = articleTitle;
    }
    
    public String getUserName() {
        return mUser.getUserName();
    }
    
    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
}

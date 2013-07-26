package com.tech_tec.qiitarian.model.detail;

import com.tech_tec.qiitarian.model.ArticleTitle;
import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.items.CreatedAt;

public class Detail {
    
    private User mUser;
    private ArticleTitle mArticleTitle;
    private CreatedAt mCreatedAt;
    
    public Detail(User user, ArticleTitle articleTitle, CreatedAt createdAt) {
        mUser = user;
        mArticleTitle = articleTitle;
        mCreatedAt = createdAt;
    }
    
    public String getUserName() {
        return mUser.getUserName();
    }
    
    public String getArticleTitle() {
        return mArticleTitle.toString();
    }
    
    public String getDateStr() {
        return mCreatedAt.getDateStr();
    }
}

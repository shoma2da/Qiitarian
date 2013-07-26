package com.tech_tec.qiitarian.model.detail;

import java.io.IOException;

import android.graphics.Bitmap;

import com.tech_tec.qiitarian.model.ArticleTitle;
import com.tech_tec.qiitarian.model.StockCount;
import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.task.icon.IconFechable;

public class Detail implements IconFechable {
    
    private User mUser;
    private ArticleTitle mArticleTitle;
    private CreatedAt mCreatedAt;
    private StockCount mStockCount;
    private ArticleBody mArticleBody;
    
    public Detail(User user, ArticleTitle articleTitle, CreatedAt createdAt, StockCount stockCount, ArticleBody articleBody) {
        mUser = user;
        mArticleTitle = articleTitle;
        mCreatedAt = createdAt;
        mStockCount = stockCount;
        mArticleBody = articleBody;
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
    
    public int getStockCount() {
        return mStockCount.toInt();
    }
    
    public String getArticleBodyStr() {
        return mArticleBody.toString();
    }

    @Override
    public Bitmap fetchIconImg() throws IOException {
        return mUser.fetchIconImg();
    }
}

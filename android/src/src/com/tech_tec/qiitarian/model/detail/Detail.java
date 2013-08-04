package com.tech_tec.qiitarian.model.detail;

import java.io.IOException;
import java.util.Iterator;

import android.graphics.Bitmap;

import com.tech_tec.qiitarian.model.common.ArticleTitle;
import com.tech_tec.qiitarian.model.common.StockCount;
import com.tech_tec.qiitarian.model.common.User;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.Tag;
import com.tech_tec.qiitarian.model.items.Tags;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.task.icon.IconFechable;

public class Detail implements IconFechable {
    
    private Uuid mUuid;
    private User mUser;
    private ArticleTitle mArticleTitle;
    private CreatedAt mCreatedAt;
    private StockCount mStockCount;
    private ArticleBody mArticleBody;
    private Comments mComments;
    private Tags mTags;
    private IsStocked mIsStocked;
    
    public Detail(Uuid uuid, User user, ArticleTitle articleTitle, CreatedAt createdAt, StockCount stockCount, ArticleBody articleBody, Comments comments, Tags tags, IsStocked stocked) {
        mUuid = uuid;
        mUser = user;
        mArticleTitle = articleTitle;
        mCreatedAt = createdAt;
        mStockCount = stockCount;
        mArticleBody = articleBody;
        mComments = comments;
        mTags = tags;
        mIsStocked = stocked;
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
    
    public Iterator<Comment> getCommentIterator() {
        return mComments.getCommentIterator();
    }
    
    public boolean hasComment() {
        return getCommentIterator().hasNext();
    }
    
    public Iterator<Tag> getTagIterator() {
        return mTags.getTagIterator();
    }
    
    public String getUuidStr() {
        return mUuid.toString();
    }
    
    public boolean isStocked() {
        return mIsStocked.value();
    }
}

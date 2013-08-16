package com.tech_tec.qiitarian.model.items;

import java.io.IOException;
import java.util.Iterator;

import com.tech_tec.qiitarian.model.common.User;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.task.icon.IconFechable;

import android.graphics.Bitmap;

public class Item implements IconFechable {
    
    private ArticleInfo mArticleInfo;
    private User mUser;
    private Uuid mUuid;
    
    public Item(ArticleInfo articleInfo, User user, Uuid uuid) {
        mArticleInfo = articleInfo;
        mUser = user;
        mUuid = uuid;
    }

    public String getArticleTitle() {
        return mArticleInfo.getArticleTitle();
    }
    
    public String getCreatedAt() {
        return mArticleInfo.getCreatedAt();
    }
    
    public Iterator<Tag> getTagIterator() {
        return mArticleInfo.getTagIterator();
    }
    
    public int getStockCount() {
        return mArticleInfo.getStockCount();
    }
    
    public int getCommentCount() {
        return mArticleInfo.getCommentCount();
    }
    
    public Bitmap getIconImg() {
        return mUser.getIconImg();
    }
    
    @Override
    public Bitmap fetchIconImg() throws IOException {
        return mUser.fetchIconImg();
    }
    
    public boolean hasIconImg() {
        return mUser.hasIconImg();
    }
    
    public String getUserName() {
        return mUser.getUserName();
    }
    
    public String getUuidStr() {
        return mUuid.toString();
    }
    
    public UserUrlName getUserUrlName() {
        return mUser.getUserUrlName();
    }
    
    @Override
    public boolean equals(Object object) {
        if ((object instanceof Item) == false) {
            return false;
        }
        Item item = (Item)object;
        return mUuid.equals(item.mUuid);
    }
    
}

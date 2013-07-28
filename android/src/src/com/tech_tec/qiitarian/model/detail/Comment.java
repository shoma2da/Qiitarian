package com.tech_tec.qiitarian.model.detail;

import java.io.IOException;

import android.graphics.Bitmap;

import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.task.icon.IconFechable;

public class Comment implements IconFechable {
    
    private User mUser;
    private CommentBody mCommentBody;
    
    public Comment(User user, CommentBody commentBody) {
        mUser = user;
        mCommentBody = commentBody;
    }

    @Override
    public Bitmap fetchIconImg() throws IOException {
        return mUser.fetchIconImg();
    }
    
    public String getUserName() {
        return mUser.getUserName();
    }
    
    public String getBodyStr() {
        return mCommentBody.toString();
    }
}

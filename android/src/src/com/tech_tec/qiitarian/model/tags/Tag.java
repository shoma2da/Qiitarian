package com.tech_tec.qiitarian.model.tags;

import java.io.IOException;

import android.graphics.Bitmap;

import com.tech_tec.qiitarian.task.icon.IconFechable;

public class Tag implements IconFechable {
    
    private Name mName;
    private UrlName mUrlName;
    private IconImage mIconImage;
    
    public Tag(Name name, UrlName urlName, IconImage iconImage) {
        mName = name;
        mUrlName = urlName;
        mIconImage = iconImage;
    }
    
    public String getNameStr() {
        return mName.toString();
    }

    @Override
    public Bitmap fetchIconImg() throws IOException {
        return mIconImage.fetchImg();
    }
    
    public Bitmap getIconImg() {
        return mIconImage.getIconImg();
    }
    
    public boolean hasIconImg() {
        return mIconImage.hasIconImg();
    }
    
    public String getUrlNameStr() {
        return mUrlName.toString();
    }
}

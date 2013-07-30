package com.tech_tec.qiitarian.model.tags;

public class Tag {
    
    private Name mName;
    private UrlName mUrlName;
    private IconImage mIconImage;
    private ItemCount mItemCount;
    private FollowerCount mFollowerCount;
    
    public Tag(Name name, UrlName urlName, IconImage iconImage, ItemCount itemCount, FollowerCount followerCount) {
        mName = name;
        mUrlName = urlName;
        mIconImage = iconImage;
        mItemCount = itemCount;
        mFollowerCount = followerCount;
    }
    
}

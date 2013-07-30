package com.tech_tec.qiitarian.model.tags;

public class Tag {
    
    private Name mName;
    private UrlName mUrlName;
    private IconImage mIconImage;
    private ItemCount mItemCount;
    
    public Tag(Name name, UrlName urlName, IconImage iconImage, ItemCount itemCount) {
        mName = name;
        mUrlName = urlName;
        mIconImage = iconImage;
        mItemCount = itemCount;
    }
    
}

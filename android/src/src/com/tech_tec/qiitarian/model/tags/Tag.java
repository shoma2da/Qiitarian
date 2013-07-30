package com.tech_tec.qiitarian.model.tags;

public class Tag {
    
    private Name mName;
    private UrlName mUrlName;
    private IconImage mIconImage;
    
    public Tag(Name name, UrlName urlName, IconImage iconImage) {
        mName = name;
        mUrlName = urlName;
        mIconImage = iconImage;
    }
    
}

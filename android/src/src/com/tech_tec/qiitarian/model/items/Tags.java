package com.tech_tec.qiitarian.model.items;

import java.util.ArrayList;
import java.util.Iterator;

public class Tags {
    
    private ArrayList<Tag> mTagList = new ArrayList<Tag>();
    
    public void add(Tag tag) {
        mTagList.add(tag);
    }
    
    public String getTagsText() {
        StringBuilder builder = new StringBuilder();
        for(Tag tag : mTagList) {
            builder.append(tag.toString() + " ");
        }
        
        return builder.toString();
    }
    
    public Iterator<Tag> getTagIterator() {
        return mTagList.iterator();
    }
    
}

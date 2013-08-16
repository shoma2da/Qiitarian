package com.tech_tec.qiitarian.model.items;

import java.util.ArrayList;
import java.util.Iterator;

public class Tags {
    
    private ArrayList<Tag> mTagList = new ArrayList<Tag>();
    
    public void add(Tag tag) {
        mTagList.add(tag);
    }
    
    public Iterator<Tag> getTagIterator() {
        return mTagList.iterator();
    }
    
}

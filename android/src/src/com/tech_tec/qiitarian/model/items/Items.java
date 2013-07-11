package com.tech_tec.qiitarian.model.items;

import java.util.ArrayList;
import java.util.Iterator;

public class Items {
    
    private ArrayList<Item> mItemList = new ArrayList<Item>();
    
    public Iterator<Item> getItemIterator() {
        return mItemList.iterator();
    }
    
    public boolean isEmpty() {
        return mItemList.isEmpty();
    }
    
    public int size() {
        return mItemList.size();
    }
    
    public void add(Item item) {
        mItemList.add(item);
    }
    
}

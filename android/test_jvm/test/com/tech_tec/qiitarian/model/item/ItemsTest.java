package com.tech_tec.qiitarian.model.item;

import static junit.framework.Assert.*;

import java.util.Iterator;

import org.junit.Test;


public class ItemsTest {
    
    @Test
    public void 空のitemsが返ってくることもある() {
        Items items = new Items();
        Iterator<Item> itemIterator = items.getItemIterator();
        
        assertNotNull(itemIterator);
        assertFalse(itemIterator.hasNext());
    }
    
}

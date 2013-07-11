package com.tech_tec.qiitarian.model.item;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Iterator;

import org.junit.Test;


public class ItemsTest {
    
    @Test
    public void 最初は空のitemsが返ってくる() {
        Items items = new Items();
        Iterator<Item> itemIterator = items.getItemIterator();
        
        assertNotNull(itemIterator);
        assertFalse(itemIterator.hasNext());
        assertTrue(items.isEmpty());
        assertEquals(0, items.size());
    }
    
    @Test
    public void Itemを追加できる() {
        Items items = new Items();
        
        items.add(mock(Item.class));
        items.add(mock(Item.class));
        items.add(mock(Item.class));
        
        Iterator<Item> itemIterator = items.getItemIterator();
        
        assertNotNull(itemIterator);
        itemIterator.next();
        itemIterator.next();
        itemIterator.next();
        assertFalse(itemIterator.hasNext());
        assertEquals(3, items.size());
        assertFalse(items.isEmpty());
    }
    
}

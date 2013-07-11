package com.tech_tec.qiitarian.model.item;

import static junit.framework.Assert.*;

import java.util.List;

import org.junit.Test;


public class ItemsTest {
    
    @Test
    public void 空のitemsが返ってくることもある() {
        Items items = new Items();
        List<Item> itemList = items.getItemList();
        
        assertNotNull(itemList);
        assertEquals(0, itemList.size());
    }
    
}

package com.tech_tec.qiitarian.model.items;

import static junit.framework.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UuidTest {
    
    @Test
    public void 同じ文字列を保持していたらequals判定で正() {
        Uuid uuid = new Uuid("abcde");
        assertTrue(new Uuid("abcde").equals(uuid));
    }
    
    @Test
    public void 異なる文字列を保持していたらequals判定で誤() {
        Uuid uuid = new Uuid("abcde");
        
        assertFalse(new Uuid("12345").equals(uuid));
        assertFalse(new Uuid(null).equals(uuid));
        assertFalse(new Uuid("").equals(uuid));
    }
    
    @Test
    public void 異なる型のオブジェクトは全てfalse() {
        Uuid uuid = new Uuid("abcde");
        
        assertFalse(uuid.equals(1));
        assertFalse(uuid.equals(new ArrayList<String>()));
        assertFalse(uuid.equals(null));
    }
}

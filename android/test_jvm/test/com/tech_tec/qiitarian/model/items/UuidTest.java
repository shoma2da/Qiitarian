package com.tech_tec.qiitarian.model.items;

import static junit.framework.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UuidTest {
    
    @Test
    public void 保持している値が同じなら同値とみなす() {
        assertTrue(new Uuid("hoge").equals(new Uuid("hoge")));
        assertTrue(new Uuid("").equals(new Uuid("")));
    }
    
    @Test
    public void 異なる値の場合は同値ではない() {
        assertFalse(new Uuid("hoge").equals(new Uuid("fuga")));
    }
    
    @Test
    public void 異なる型の値は全て同値ではない() {
        assertFalse(new Uuid("hoge").equals(false));
        assertFalse(new Uuid("hoge").equals(1));
        assertFalse(new Uuid("hoge").equals(null));
        assertFalse(new Uuid("hoge").equals(new Object()));
        assertFalse(new Uuid("hoge").equals(new ArrayList<String>()));
    }
    
}

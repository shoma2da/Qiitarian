package com.tech_tec.qiitarian.fragment.search;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.junit.Test;

public class SeachWordTest {
    
    @Test
    public void 単純な文字列を取得できる() {
        //単一文字
        do単純な文字列を取得できる("java", "java");
        do単純な文字列を取得できる("scala ", "scala");
        do単純な文字列を取得できる(" scala", "scala");
        do単純な文字列を取得できる(" scala ", "scala");
        do単純な文字列を取得できる("    ", "");
        do単純な文字列を取得できる("あいうえお", "あいうえお");
        do単純な文字列を取得できる(" あいうえお ", "あいうえお");
        do単純な文字列を取得できる("　あいうえお　　", "あいうえお");
        do単純な文字列を取得できる("　", "");
        
        //複数文字
        do単純な文字列を取得できる("java scala", "java scala");
        do単純な文字列を取得できる("java  scala", "java  scala");
    }
    private void do単純な文字列を取得できる(String resource, String expected) {
        SearchWord searchWord = new SearchWord(resource);
        try {
            assertEquals(encode(expected), searchWord.toUrlString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            fail();
        }
    }
    private String encode(String string) throws UnsupportedEncodingException {
        return URLEncoder.encode(string, Charset.defaultCharset().name());
    }
    
}

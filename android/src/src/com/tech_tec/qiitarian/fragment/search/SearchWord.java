package com.tech_tec.qiitarian.fragment.search;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class SearchWord {
    
    private String mWord;
    
    public SearchWord(String word) {
        mWord = word;
    }
    
    @Override
    public String toString() {
        return mWord;
    }
    
    public String toUrlString() throws UnsupportedEncodingException {
        String noZenkakuSpace = mWord.replaceAll("　", " ");
        String trimed = noZenkakuSpace.trim();
        String encoded = URLEncoder.encode(trimed, Charset.defaultCharset().name());
        return encoded;
    }
    
}

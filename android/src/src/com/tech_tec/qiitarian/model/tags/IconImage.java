package com.tech_tec.qiitarian.model.tags;

import java.net.URL;

public class IconImage {
    
    private URL mUrl;
    
    public IconImage(URL url) {
        mUrl = url;
    }
    
    public String toUrlStr() {
        return mUrl.toString();
    }
    
}

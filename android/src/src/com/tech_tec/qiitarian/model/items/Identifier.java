package com.tech_tec.qiitarian.model.items;

import java.net.URL;

public class Identifier {
    private Uuid mUuid;
    private URL mUrl;
    
    public Identifier(Uuid uuid, URL url) {
        mUuid = uuid;
        mUrl = url;
    }
}

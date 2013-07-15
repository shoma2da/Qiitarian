package com.tech_tec.qiitarian.model.items.meta;

import java.util.Date;

public class CreatedTime {
    
    private Date mCreatedAt;
    private String mCreatedAtInWords;
    
    public CreatedTime(Date createdAt, String createdAtInWords) {
        mCreatedAt = createdAt;
        mCreatedAtInWords = createdAtInWords;
    }
    
}

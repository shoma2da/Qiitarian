package com.tech_tec.qiitarian.model.items;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreatedAt {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
    
    private String mCreatedAtInWords;
    private Date mCreatedAt;
    
    public CreatedAt(String createdAtInWords, Date createdAt) {
        mCreatedAtInWords = createdAtInWords;
        mCreatedAt = createdAt;
    }
    
    public String getDateStr() {
        return DATE_FORMAT.format(mCreatedAt);
    }
    
    @Override
    public String toString() {
        return mCreatedAtInWords;
    }
    
}

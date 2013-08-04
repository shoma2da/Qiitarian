package com.tech_tec.qiitarian.model.user;

public class Description {
    
    private String mDescription;
    
    public Description(String description) {
        mDescription = description;
    }
    
    @Override
    public String toString() {
        return mDescription;
    }
    
    public boolean isEmpty() {
        return mDescription == null || mDescription.equals("");
    }
    
}

package com.tech_tec.qiitarian.model.items;

public class Uuid {
    
    private String mUuidStr;
    
    public Uuid(String uuidStr) {
        mUuidStr = uuidStr;
    }
    
    @Override
    public boolean equals(Object o) {
        if((o instanceof Uuid) == false) {
            return false;
        }
        
        Uuid uuid = (Uuid)o;
        if (uuid.mUuidStr == null || mUuidStr == null) {
            return false;
        }
        
        return mUuidStr.equals(uuid.mUuidStr);
    }
    
}

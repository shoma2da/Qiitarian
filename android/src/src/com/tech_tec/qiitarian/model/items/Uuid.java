package com.tech_tec.qiitarian.model.items;

public class Uuid {
    
    private String mUuid;
    
    public Uuid(String uuid) {
        mUuid = uuid;
    }
    
    @Override
    public String toString() {
        return mUuid;
    }
    
    @Override
    public boolean equals(Object object) {
        if ((object instanceof Uuid) == false) {
            return false;
        }
        
        Uuid target = (Uuid)object;
        return mUuid.equals(target.mUuid);
    }
}

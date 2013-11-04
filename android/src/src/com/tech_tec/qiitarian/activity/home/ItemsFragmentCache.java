package com.tech_tec.qiitarian.activity.home;

import com.tech_tec.qiitarian.fragment.list.ItemsFragment;

class ItemsFragmentCache {
    
    private ItemsFragment mItemsFragment;
    
    ItemsFragment get() {
        if (mItemsFragment == null) {
            mItemsFragment = new ItemsFragment();
            mItemsFragment.setIsCached(false);
            return mItemsFragment;
        }
        mItemsFragment.setIsCached(true);
        return mItemsFragment;
    }
    
}

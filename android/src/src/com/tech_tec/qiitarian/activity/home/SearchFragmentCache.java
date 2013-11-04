package com.tech_tec.qiitarian.activity.home;

import com.tech_tec.qiitarian.fragment.search.SearchFragment;

class SearchFragmentCache {
    
    private SearchFragment mSearchFragment;
    
    SearchFragment get() {
        if (mSearchFragment == null) {
            mSearchFragment = new SearchFragment();
        }
        return mSearchFragment;
    }
    
}

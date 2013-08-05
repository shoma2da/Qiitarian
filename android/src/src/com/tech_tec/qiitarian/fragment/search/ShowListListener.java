package com.tech_tec.qiitarian.fragment.search;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.ItemsFragment;

public class ShowListListener implements OnClickListener {
    
    private FragmentManager mFragmentManager;
    
    public ShowListListener(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.list_space, new ItemsFragment()).commit();
    }
    
}

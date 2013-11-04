package com.tech_tec.qiitarian.fragment.search;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.ItemsFragment;

public class ShowListListener implements OnClickListener {
    
    private FragmentActivity mFragmentActivity;
    
    public ShowListListener(FragmentActivity fragmentActivity) {
        mFragmentActivity = fragmentActivity;
    }
    
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = mFragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.list_space, new ItemsFragment()).commit();
    }
    
}

package com.tech_tec.qiitarian.fragment.user.logout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

public class LogoutViewClickListener implements OnClickListener {
    
    private FragmentManager mFragmentManager;
    
    public LogoutViewClickListener(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(new ConfirmDialogFragment(), null);
        transaction.commit();
    }

}

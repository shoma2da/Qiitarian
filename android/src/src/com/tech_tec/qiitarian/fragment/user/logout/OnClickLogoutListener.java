package com.tech_tec.qiitarian.fragment.user.logout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class OnClickLogoutListener implements OnClickListener {
    
    public Context mContext;
    
    public OnClickLogoutListener(Context context) {
        mContext = context;
    }
    
    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(mContext, "logout!!", Toast.LENGTH_SHORT).show();
    }

}

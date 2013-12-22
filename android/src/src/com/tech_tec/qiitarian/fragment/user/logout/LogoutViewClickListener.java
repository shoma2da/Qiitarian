package com.tech_tec.qiitarian.fragment.user.logout;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class LogoutViewClickListener implements OnClickListener {

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "logout!", Toast.LENGTH_SHORT).show();
    }

}

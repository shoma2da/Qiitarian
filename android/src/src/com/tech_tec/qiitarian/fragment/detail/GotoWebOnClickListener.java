package com.tech_tec.qiitarian.fragment.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class GotoWebOnClickListener implements OnClickListener {
    
    private Context mContext;
    private Uri mUri;
    
    public GotoWebOnClickListener(Context context, Uri uri) {
        mContext = context;
        mUri = uri;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, mUri);
        mContext.startActivity(intent);
    }

}

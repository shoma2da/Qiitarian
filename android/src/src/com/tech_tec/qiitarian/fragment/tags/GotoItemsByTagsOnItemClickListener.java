package com.tech_tec.qiitarian.fragment.tags;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.tech_tec.qiitarian.activity.ItemsByTagActivity;
import com.tech_tec.qiitarian.model.tags.Tag;

public class GotoItemsByTagsOnItemClickListener implements OnItemClickListener {
    
    private Activity mActivity;
    
    public GotoItemsByTagsOnItemClickListener(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tag tag = (Tag)parent.getItemAtPosition(position);
        
        Intent intent = new Intent(mActivity, ItemsByTagActivity.class);
        //引数の設定
        mActivity.startActivity(intent);
    }

}

package com.tech_tec.qiitarian.fragment.content.list;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.activity.DetailActivity;
import com.tech_tec.qiitarian.model.items.Item;

public class GotoDetailOnItemClickListener implements OnItemClickListener {
    
    private Activity mActivity;
    
    public GotoDetailOnItemClickListener(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = (Item)parent.getItemAtPosition(position);
        QiitarianLog.d("item title is [" + item.getArticleTitle() + "]");
        
        Intent intent = new Intent(mActivity, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_ARG_OF_ITEM_UUID, item.getUuidStr());
        mActivity.startActivity(intent);
    }
    
}

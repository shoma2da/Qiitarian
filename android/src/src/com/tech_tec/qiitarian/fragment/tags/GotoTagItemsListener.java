package com.tech_tec.qiitarian.fragment.tags;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.tech_tec.qiitarian.activity.tagitems.TagItemsActivity;
import com.tech_tec.qiitarian.model.tags.Tag;

public class GotoTagItemsListener implements OnItemClickListener {
    
    private Activity mActivity;
    
    public GotoTagItemsListener(Activity activity) {
        mActivity = activity;
    }
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tag tag = (Tag)parent.getItemAtPosition(position);
        
        Intent intent = new Intent(mActivity, TagItemsActivity.class);
        intent.putExtra(TagItemsActivity.KEY_TAG_NAME, tag.getNameStr());
        intent.putExtra(TagItemsActivity.KEY_TAG_URLNAME, tag.getUrlNameStr());
        mActivity.startActivity(intent);
    }

}

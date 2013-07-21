package com.tech_tec.qiitarian.fragment.content.list;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.items.Item;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class GotoDetailOnItemClickListener implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = (Item)parent.getItemAtPosition(position);
        QiitarianLog.d("item title is [" + item.getArticleTitle() + "]");
    }
    
}

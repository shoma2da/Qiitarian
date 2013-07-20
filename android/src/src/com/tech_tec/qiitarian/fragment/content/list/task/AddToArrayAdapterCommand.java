package com.tech_tec.qiitarian.fragment.content.list.task;

import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.model.items.ArticleTitle;
import com.tech_tec.qiitarian.model.items.Item.CommandWithArticleTitle;

class AddToArrayAdapterCommand implements CommandWithArticleTitle {
    
    private ArrayAdapter<String> mAdapter;
    
    public AddToArrayAdapterCommand(ArrayAdapter<String> adapter) {
        mAdapter = adapter;
    }
    
    @Override
    public void act(ArticleTitle title) {
        mAdapter.add(title.toString());
    }

}

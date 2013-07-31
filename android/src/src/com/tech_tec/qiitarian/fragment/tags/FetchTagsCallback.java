package com.tech_tec.qiitarian.fragment.tags;

import java.util.Iterator;

import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.Tags;
import com.tech_tec.qiitarian.task.tags.FetchTagsAsyncTask.Callback;

public class FetchTagsCallback implements Callback {
    
    private ArrayAdapter<Tag> mAdapter;
    
    public FetchTagsCallback(ArrayAdapter<Tag> adapter) {
        mAdapter = adapter;
    }
    
    @Override
    public void onSuccess(Tags tags) {
        Iterator<Tag> iterator = tags.getTagIterator();
        while (iterator.hasNext()) {
            Tag tag = iterator.next();
            mAdapter.add(tag);
        }
        
    }

    @Override
    public void onEmpty() {
        QiitarianLog.d("通信エラーです");
    }

    @Override
    public void onError() {
        QiitarianLog.d("一つもタグをフォローしていません");
    }

    @Override
    public void onPreExecute() {
        QiitarianLog.d("ほんとはダイアログ開始");
    }

}

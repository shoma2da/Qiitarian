package com.tech_tec.qiitarian.fragment.tags;

import java.util.Iterator;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tech_tec.qiitarian.fragment.user.ProgressManager;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.Tags;
import com.tech_tec.qiitarian.task.tags.FetchTagsAsyncTask.Callback;

public class FetchTagsCallback implements Callback {
    
    private ArrayAdapter<Tag> mAdapter;
    private ProgressManager mProgressManager;
    private Context mContext;
    
    public FetchTagsCallback(ArrayAdapter<Tag> adapter, Context context) {
        mAdapter = adapter;
        mProgressManager = new ProgressManager(context);
    }
    
    @Override
    public void onSuccess(Tags tags) {
        Iterator<Tag> iterator = tags.getTagIterator();
        while (iterator.hasNext()) {
            Tag tag = iterator.next();
            mAdapter.add(tag);
        }
        mProgressManager.dismiss();
    }

    @Override
    public void onEmpty() {
        Toast.makeText(mContext, "通信エラー", Toast.LENGTH_LONG).show();
        mProgressManager.dismiss();
    }

    @Override
    public void onError() {
        Toast.makeText(mContext, "一つもタグをフォローしていません", Toast.LENGTH_LONG).show();
        mProgressManager.dismiss();
    }

    @Override
    public void onPreExecute() {
        mProgressManager.show();
    }

}

package com.tech_tec.qiitarian.fragment.content.tags;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.tags.Tag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class TagArrayAdapter extends ArrayAdapter<Tag> {
    
    private LayoutInflater mInflater;
    
    public TagArrayAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_tab_item, null);
        return view;
    }
    
}

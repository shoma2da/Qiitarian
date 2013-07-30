package com.tech_tec.qiitarian.fragment.content.tags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.tags.Tag;

public class TagArrayAdapter extends ArrayAdapter<Tag> {
    
    private LayoutInflater mInflater;
    
    public TagArrayAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tag tag = getItem(position);
        
        View view = mInflater.inflate(R.layout.layout_tag_item, null);
        TextView nameText = (TextView)view.findViewById(R.id.text_name);
        
        nameText.setText(tag.getNameStr());
        
        return view;
    }
    
}

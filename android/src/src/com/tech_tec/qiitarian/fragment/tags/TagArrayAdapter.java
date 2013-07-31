package com.tech_tec.qiitarian.fragment.tags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

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
        ImageView iconImage = (ImageView)view.findViewById(R.id.image_icon);
        
        nameText.setText(tag.getNameStr());
        
        //画像の設定
        if (tag.hasIconImg()) {
            iconImage.setImageBitmap(tag.getIconImg());
        } else {
            iconImage.setTag(tag.getNameStr());
            new FetchIconTask(iconImage, tag, tag.getNameStr()).execute();
        }
        
        return view;
    }
    
}

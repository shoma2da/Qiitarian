package com.tech_tec.qiitarian.fragment.content.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.items.Item;

public class ItemArrayAdapter extends ArrayAdapter<Item> {
    
    private LayoutInflater mInflater;
    
    public ItemArrayAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.listraw_item, null);
        
        Item item = getItem(position);
        
        TextView titleText = (TextView)view.findViewById(R.id.text_item_title);
        titleText.setText(item.getArticleTitle());
        
        TextView usernameText = (TextView)view.findViewById(R.id.text_item_username);
        usernameText.setText(item.getUserName());
        
        return view;
    }
    
}

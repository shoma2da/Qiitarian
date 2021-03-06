package com.tech_tec.qiitarian.fragment.list;

import java.util.Iterator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Tag;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

public class ItemArrayAdapter extends ArrayAdapter<Item> {
    
    private Context mContext;
    private LayoutInflater mInflater;
    
    public ItemArrayAdapter(Context context) {
        super(context, 0);
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.listraw_item, null);
        }
        
        final Item item = getItem(position);
        
        TextView titleText = (TextView)view.findViewById(R.id.text_item_title);
        TextView usernameText = (TextView)view.findViewById(R.id.text_item_username);
        TextView createdAtText = (TextView)view.findViewById(R.id.text_item_created_at);
        ViewGroup tagsLayout = (ViewGroup)view.findViewById(R.id.layout_item_tags);
        tagsLayout.removeAllViews();
        TextView stockCountText = (TextView)view.findViewById(R.id.text_item_stock_count);
        TextView commentCountText = (TextView)view.findViewById(R.id.text_item_comment_count);
        ImageView iconImage = (ImageView)view.findViewById(R.id.image_item_user_profile);
        iconImage.setImageResource(android.R.drawable.ic_menu_gallery);
        
        titleText.setText(item.getArticleTitle());
        usernameText.setText(item.getUserName());
        createdAtText.setText(item.getCreatedAt());
        //tagsLayout.setText(item.getTagsText());
        Iterator<Tag> tagsIterator = item.getTagIterator();
        while(tagsIterator.hasNext()) {
            TextView tagText = (TextView)mInflater.inflate(R.layout.text_tag, null);
            tagText.setText(tagsIterator.next().toString());
            tagsLayout.addView(tagText);
        }
        stockCountText.setText("" + item.getStockCount());
        commentCountText.setText("" + item.getCommentCount());
        setIcon(iconImage, item);
        
        return view;
    }
    
    void setIcon(ImageView iconImage, Item item) {
        iconImage.setOnClickListener(new GotoUserActivityListener(mContext, item.getUserUrlName()));

        if (item.hasIconImg()) {
            iconImage.setImageBitmap(item.getIconImg());
            return;
        }
        
        //非同期画像取得
        iconImage.setTag(item.getUuidStr());
        new FetchIconTask(iconImage, item, item.getUuidStr()).execute();
    }
}

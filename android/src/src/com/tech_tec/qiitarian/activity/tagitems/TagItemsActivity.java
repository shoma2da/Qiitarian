package com.tech_tec.qiitarian.activity.tagitems;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.model.tags.Name;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagItemsActivity extends FragmentActivity implements FactoryGettable {
    
    public static final String KEY_TAG_URLNAME = "tag_urlname";
    public static final String KEY_TAG_NAME = "tag_name";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_by_tag);
        
        TextView titleText = (TextView)findViewById(R.id.text_title);
        String title = getString(R.string.tagitems_list_title, getName().toString());
        titleText.setText(title);
    }
    
    UrlName getUrlName() {
        String urlNameStr = getIntent().getStringExtra(KEY_TAG_URLNAME);
        return new UrlName(urlNameStr);
    }
    
    Name getName() {
        String nameStr = getIntent().getStringExtra(KEY_TAG_NAME);
        return new Name(nameStr);
    }
    
    @Override
    public CommandsAbstractFactory getFactory() {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        UrlName urlName = getUrlName();
        return new TagItemsFactory(inflater, urlName);
    }
    
}

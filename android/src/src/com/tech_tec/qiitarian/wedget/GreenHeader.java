package com.tech_tec.qiitarian.wedget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;

public class GreenHeader extends FrameLayout {

    public GreenHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        TextView textView = (TextView)inflater.inflate(R.layout.header_green, null);
        addView(textView);
        
        int resourceId = attrs.getAttributeResourceValue(null, "text", -1);
        if (resourceId == -1) {
            throw new IllegalArgumentException("textを設定してください");
        }
        textView.setText(resourceId);
    }
    
}

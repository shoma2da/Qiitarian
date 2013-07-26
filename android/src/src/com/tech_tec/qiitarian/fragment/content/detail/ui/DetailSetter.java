package com.tech_tec.qiitarian.fragment.content.detail.ui;

import android.view.View;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.detail.Detail;

public class DetailSetter {
    
    private Detail mDetail;
    private View mView;
    
    public DetailSetter(Detail detail, View view) {
        mDetail = detail;
        mView = view;
    }
    
    public void view() {
        TextView userNameText = (TextView)mView.findViewById(R.id.text_user_name);
        TextView titleText = (TextView)mView.findViewById(R.id.text_article_title);
        
        userNameText.setText(mDetail.getUserName());
        titleText.setText(mDetail.getArticleTitle());
    }
    
}

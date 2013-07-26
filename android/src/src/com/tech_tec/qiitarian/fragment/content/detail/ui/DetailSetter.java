package com.tech_tec.qiitarian.fragment.content.detail.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

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
        TextView createdAtText = (TextView)mView.findViewById(R.id.text_created_at);
        ImageView userIconImage = (ImageView)mView.findViewById(R.id.image_user_icon);
        
        userNameText.setText(mDetail.getUserName());
        titleText.setText(mDetail.getArticleTitle());
        createdAtText.setText(mDetail.getDateStr());
        
        //アイコンの非同期取得
        new FetchIconTask(userIconImage, mDetail).execute();
    }
    
}

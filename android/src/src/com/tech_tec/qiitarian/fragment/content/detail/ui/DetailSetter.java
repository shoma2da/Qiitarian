package com.tech_tec.qiitarian.fragment.content.detail.ui;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
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
        TextView stockCountText = (TextView)mView.findViewById(R.id.text_stock_count);
        TextView articleBodyText = (TextView)mView.findViewById(R.id.text_article_body);
        
        //本文内のリンク有効化
        MovementMethod movementmethod = LinkMovementMethod.getInstance();
        articleBodyText.setMovementMethod(movementmethod);
        
        //各テキストの設定
        userNameText.setText(mDetail.getUserName());
        titleText.setText(mDetail.getArticleTitle());
        createdAtText.setText(mDetail.getDateStr());
        stockCountText.setText("ストック数：" + mDetail.getStockCount());
        articleBodyText.setText(Html.fromHtml(mDetail.getArticleBodyStr()));
        
        //アイコンの非同期取得
        ImageView userIconImage = (ImageView)mView.findViewById(R.id.image_user_icon);
        new FetchIconTask(userIconImage, mDetail).execute();
        
    }
    
}

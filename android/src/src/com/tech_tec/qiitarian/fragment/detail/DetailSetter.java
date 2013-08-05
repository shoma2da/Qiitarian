package com.tech_tec.qiitarian.fragment.detail;

import java.util.Iterator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.model.detail.Comment;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.items.Tag;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

public class DetailSetter {
    
    private Detail mDetail;
    private View mView;
    private LayoutInflater mInflater;
    
    public DetailSetter(Detail detail, View view, LayoutInflater inflater) {
        mDetail = detail;
        mView = view;
        mInflater = inflater;
    }
    
    public void view() {
        TextView userNameText = (TextView)mView.findViewById(R.id.text_user_name);
        TextView titleText = (TextView)mView.findViewById(R.id.text_article_title);
        TextView createdAtText = (TextView)mView.findViewById(R.id.text_created_at);
        TextView stockCountText = (TextView)mView.findViewById(R.id.text_stock_count);
        WebView articleBodyWebView = (WebView)mView.findViewById(R.id.text_article_body);
        
        //各テキストの設定
        userNameText.setText(mDetail.getUserName());
        titleText.setText(mDetail.getArticleTitle());
        createdAtText.setText(mDetail.getDateStr());
        stockCountText.setText("ストック数：" + mDetail.getStockCount());
        articleBodyWebView.loadDataWithBaseURL("", mDetail.getArticleBodyStr(), "text/html", "UTF-8", "");
        
        //コメントの設定
        ViewGroup commentsLayout = (ViewGroup)mView.findViewById(R.id.layout_comments);
        TextView commentsLabelText = (TextView)mView.findViewById(R.id.text_comments_label);
        if (mDetail.hasComment()) {
            commentsLayout.setVisibility(View.VISIBLE);
            commentsLabelText.setVisibility(View.VISIBLE);
        }
        Iterator<Comment> commentIterator = mDetail.getCommentIterator();
        while (commentIterator.hasNext()) {
            Comment comment = commentIterator.next();
            View commentView = mInflater.inflate(R.layout.layout_article_comment, null);
            
            ImageView imageView = (ImageView)commentView.findViewById(R.id.image_icon);
            TextView commentUserNameText = (TextView)commentView.findViewById(R.id.text_user_name);
            WebView commentBodyWebView = (WebView)commentView.findViewById(R.id.text_body);
            
            new FetchIconTask(imageView, comment).execute();
            commentUserNameText.setText(comment.getUserName());
            commentBodyWebView.loadDataWithBaseURL("", comment.getBodyStr(), "text/html", "UTF-8", "");
            
            commentsLayout.addView(commentView);
        }
        
        //タグの設定
        ViewGroup tagsLayout = (ViewGroup)mView.findViewById(R.id.layout_tags);
        Iterator<Tag> tagIterator = mDetail.getTagIterator();
        while (tagIterator.hasNext()) {
            TextView view = (TextView)mInflater.inflate(R.layout.layout_detail_tag, null);
            
            Tag tag = tagIterator.next();
            view.setText(tag.toString());
            
            tagsLayout.addView(view);
        }
        
        //アイコンの非同期取得
        ImageView userIconImage = (ImageView)mView.findViewById(R.id.image_user_icon);
        new FetchIconTask(userIconImage, mDetail).execute();
        
        //ストック用の設定
        ToggleButton stockButton = (ToggleButton)mView.findViewById(R.id.button_stock);
        stockButton.setChecked(mDetail.isStocked());
        AuthInfo authInfo = new AuthInfoPreferences(mView.getContext()).load();
        OnCheckedChangeListener listener = new PutStockOnClickListener(authInfo, mDetail);
        stockButton.setOnCheckedChangeListener(listener);
    }
    
}

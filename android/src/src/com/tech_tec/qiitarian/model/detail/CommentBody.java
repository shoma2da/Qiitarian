package com.tech_tec.qiitarian.model.detail;

import android.text.Html;
import android.text.Spanned;

public class CommentBody {
    
    private String mBody;
    
    public CommentBody(String body) {
        mBody = body;
    }
    
    public Spanned getHtmlBody() {
        return Html.fromHtml(mBody);
    }
    
}

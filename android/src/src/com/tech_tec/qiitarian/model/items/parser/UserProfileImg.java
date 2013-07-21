package com.tech_tec.qiitarian.model.items.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.tech_tec.qiitarian.QiitarianLog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class UserProfileImg {
    
    private URL mUrl;
    
    public UserProfileImg(URL url) {
        mUrl = url;
    }
    
    public Bitmap fetchImg() throws IOException {
        QiitarianLog.d("start fetch user icon");
        
        URLConnection connection = mUrl.openConnection();
        InputStream input = connection.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(input);
        
        QiitarianLog.d("end fetch user icon");
        
        return bitmap;
    }
}

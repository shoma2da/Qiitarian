package com.tech_tec.qiitarian.model.items;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.tech_tec.qiitarian.QiitarianLog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class UserProfileImg {
    
    private URL mUrl;
    private Bitmap mCachedBitmap;
    
    public UserProfileImg(URL url) {
        mUrl = url;
    }
    
    public Bitmap getIconImg() {
        return mCachedBitmap;
    }
    
    public Bitmap fetchImg() throws IOException {
        if (mCachedBitmap != null) {
            return mCachedBitmap;
        }
        
        QiitarianLog.d("start fetch user icon");
        
        URLConnection connection = mUrl.openConnection();
        InputStream input = connection.getInputStream();
        mCachedBitmap = BitmapFactory.decodeStream(input);
        
        QiitarianLog.d("end fetch user icon");
        
        return mCachedBitmap;
    }
    
    public boolean hasIconImg() {
        return mCachedBitmap != null;
    }
}

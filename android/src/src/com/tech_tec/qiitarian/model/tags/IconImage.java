package com.tech_tec.qiitarian.model.tags;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tech_tec.qiitarian.QiitarianLog;

//TODO UserProfileImg.java と完全に重複
public class IconImage {
    
    private URL mUrl;
    private Bitmap mCachedBitmap;
    
    public IconImage(URL url) {
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

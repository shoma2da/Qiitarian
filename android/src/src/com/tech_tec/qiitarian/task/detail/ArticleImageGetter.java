package com.tech_tec.qiitarian.task.detail;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.drawable.Drawable;
import android.text.Html;

public class ArticleImageGetter implements Html.ImageGetter {

    @Override
    public Drawable getDrawable(String source) {
        try {
            URL url = new URL(source);
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            return Drawable.createFromStream(input, "downloaded image");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

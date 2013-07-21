package com.tech_tec.qiitarian.fragment.content.list;

import java.io.IOException;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.tech_tec.qiitarian.model.items.Item;

public class IconFetchTask extends AsyncTask<Void, Void, Bitmap> {
    
    private ImageView mImageView;
    private Item mItem;
    
    public IconFetchTask(ImageView imageView, Item item) {
        mImageView = imageView;
        mItem = item;
    }
    
    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            return mItem.fetchIconImg();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        
        if (result == null) {
            return;
        }
        mImageView.setImageBitmap(result);
    }

}

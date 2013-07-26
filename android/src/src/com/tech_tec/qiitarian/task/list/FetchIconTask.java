package com.tech_tec.qiitarian.task.list;

import java.io.IOException;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

import com.tech_tec.qiitarian.model.items.Item;

public class FetchIconTask {
    
    private ImageView mImageView;
    private Item mItem;
    private Handler mHandler = new Handler();
    
    public FetchIconTask(ImageView imageView, Item item) {
        mImageView = imageView;
        mItem = item;
    }
    
    protected Bitmap doInBackground(Void... params) {
        try {
            return mItem.fetchIconImg();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    protected void onPostExecute(Bitmap result) {
        if (result == null) {
            return;
        }
        mImageView.setImageBitmap(result);
    }
    
    public void execute() {
        new Thread(createRunnable()).start();
    }
    
    private Runnable createRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                Bitmap icon = doInBackground();
                mHandler.post(createRunnableForUi(icon));
            }
        };
    }
    
    private Runnable createRunnableForUi(final Bitmap icon) {
        return new Runnable() {
            @Override
            public void run() {
                onPostExecute(icon);
            }
        };
    }
    
}

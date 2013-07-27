package com.tech_tec.qiitarian.task.icon;

import java.io.IOException;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

public class FetchIconTask {
    
    private ImageView mImageView;
    private IconFechable mIconFechable;
    private Handler mHandler = new Handler();
    private Object mTag;
    
    public FetchIconTask(ImageView imageView, IconFechable iconFechable) {
        this(imageView, iconFechable, null);
    }
    
    public FetchIconTask(ImageView imageView, IconFechable iconFechable, Object tag) {
        mImageView = imageView;
        mIconFechable = iconFechable;
        mTag = tag;
    }
    
    protected Bitmap doInBackground(Void... params) {
        try {
            return mIconFechable.fetchIconImg();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    protected void onPostExecute(Bitmap result) {
        if (result == null) {
            return;
        }
        if (mTag == null) {
            mImageView.setImageBitmap(result);
            return;
        }
        if (mTag.equals(mImageView.getTag())) {
            mImageView.setImageBitmap(result);
            return;
        }
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

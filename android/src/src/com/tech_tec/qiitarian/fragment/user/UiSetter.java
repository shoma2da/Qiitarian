package com.tech_tec.qiitarian.fragment.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

public class UiSetter {
    
    private View mView;
    
    public UiSetter(View view) {
        mView = view;
    }
    
    void showErrorView() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
    }
    
    void showView(User user) {
        setToNameText(user);
        setToDescText(user);
        setToIconImage(user);
        setToFacebookName(user);
    }
    
    private void setToNameText(User user) {
        TextView nameText = (TextView)mView.findViewById(R.id.text_user_name);
        nameText.setText(user.getNameStr());
    }
    
    private void setToDescText(User user) {
        TextView descText = (TextView)mView.findViewById(R.id.text_description);
        if (user.hasDescription() == false) {
            descText.setVisibility(View.GONE);
            return;
        }
        
        descText.setText(user.getDescription());
    }
    
    private void setToIconImage(User user) {
        ImageView iconImage = (ImageView)mView.findViewById(R.id.image_user_icon);
        new FetchIconTask(iconImage, user).execute();
    }
    
    private void setToFacebookName(User user) {
        TextView facebookText = (TextView)mView.findViewById(R.id.text_facebook);
        if (user.hasFacebookNmae() == false) {
            facebookText.setVisibility(View.GONE);
            return;
        }
        
        facebookText.setText("Facebook:" + user.getFacebookName());
    }
    
}

package com.tech_tec.qiitarian.fragment.user;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;

public class UiSetter {
    
    private View mView;
    
    public UiSetter(View view) {
        mView = view;
    }
    
    void showView(User user) {
        TextView nameText = (TextView)mView.findViewById(R.id.text_user_name);
        nameText.setText(user.getNameStr());
    }
    
    void showErrorView() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
    }
    
}

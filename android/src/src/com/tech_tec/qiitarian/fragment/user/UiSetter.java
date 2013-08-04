package com.tech_tec.qiitarian.fragment.user;

import android.view.View;
import android.widget.Toast;

import com.tech_tec.qiitarian.model.user.User;

public class UiSetter {
    
    private View mView;
    
    public UiSetter(View view) {
        mView = view;
    }
    
    void showView(User user) {
        Toast.makeText(mView.getContext(), user.getDescription(), Toast.LENGTH_SHORT).show();
    }
    
    void showErrorView() {
        Toast.makeText(mView.getContext(), "エラー", Toast.LENGTH_SHORT).show();
    }
    
}

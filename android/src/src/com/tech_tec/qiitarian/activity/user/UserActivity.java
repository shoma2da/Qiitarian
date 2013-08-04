package com.tech_tec.qiitarian.activity.user;

import java.io.Serializable;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.user.UserUrlNameGettable;
import com.tech_tec.qiitarian.model.common.UserUrlName;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class UserActivity extends FragmentActivity implements UserUrlNameGettable {
    
    public static final String KEY_USER_URLNAME = "user_urlname";
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_user);
    }
    
    @Override
    public UserUrlName getUserUrlName() {
        Serializable maybeUrlName = getIntent().getSerializableExtra(KEY_USER_URLNAME);
        if (maybeUrlName instanceof UserUrlName == false) {
            throw new RuntimeException("パラメータにはUserUrlNameをSerializableとして渡してください");
        }
        
        return (UserUrlName)maybeUrlName;
    }

}

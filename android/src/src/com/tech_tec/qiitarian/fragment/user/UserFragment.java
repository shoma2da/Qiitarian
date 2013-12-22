package com.tech_tec.qiitarian.fragment.user;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;

public class UserFragment extends Fragment {
    
    private UserUrlNameGettable mUserUrlNameGettable;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        if (activity instanceof UserUrlNameGettable == false) {
            throw new RuntimeException("ActivityはUserUrlNameGettableを実装してください");
        }
        
        mUserUrlNameGettable = (UserUrlNameGettable)activity;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        
        //ログアウトボタンは使用者本人の場合のみ表示する
        AuthInfo authInfo = new AuthInfoPreferences(getActivity()).load();
        String loginUserName = authInfo.getUrlNameStr();
        String paramUserName = mUserUrlNameGettable.getUserUrlName().toString();
        if (loginUserName.equals(paramUserName) == false) {
            view.findViewById(R.id.button_logout).setVisibility(View.GONE);
        }
        
        Callback callback = new FetchUserCallback(getActivity(), view);
        FetchUserAsyncTask task = new FetchUserAsyncTask(mUserUrlNameGettable.getUserUrlName(), callback);
        task.execute();
        
        
        return view;
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        mUserUrlNameGettable = null;
    }
}

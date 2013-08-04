package com.tech_tec.qiitarian.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.user.FetchUserAsyncTask.Callback;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.user.User;

public class UserFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        
        //TODO サンプル
        FetchUserAsyncTask task = new FetchUserAsyncTask(new UserUrlName("himara2"), new Callback() {
            @Override
            public void onSuccess(User user) {
                Toast.makeText(getActivity(), "get user information " + user.getDescription(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError() {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPreExecute() {
            }
        });
        task.execute();
        
        return view;
    }
    
}

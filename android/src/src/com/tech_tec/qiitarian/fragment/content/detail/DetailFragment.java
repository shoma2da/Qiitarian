package com.tech_tec.qiitarian.fragment.content.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.content.detail.task.FetchDetailAsyncTask;
import com.tech_tec.qiitarian.fragment.content.detail.task.FetchDetailAsyncTask.Callback;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.items.Uuid;

public class DetailFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        if ((getActivity() instanceof ItemUuidGettable) == false) {
            throw new RuntimeException("ActivityはItemUuidGettableを実装してください");
        }
        
        ItemUuidGettable gettable = (ItemUuidGettable)getActivity();
        Uuid uuid = new Uuid(gettable.getUuid()); //TODO パラメータとして直接受け取る？？
        
        AuthInfo authInfo = new AuthInfoPreferences(getActivity().getApplicationContext()).load();
        
        new FetchDetailAsyncTask(uuid, authInfo, new Callback() {
            @Override
            public void onSuccess(Detail detail) {
                Toast.makeText(getActivity(), detail.toString(), Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onError() {
                Toast.makeText(getActivity(), "通信エラー", Toast.LENGTH_SHORT).show();
            }
        }).execute();
    }
    
    public interface ItemUuidGettable {
        String getUuid();
    }
}

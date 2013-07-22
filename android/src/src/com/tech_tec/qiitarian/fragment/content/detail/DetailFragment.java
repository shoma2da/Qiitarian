package com.tech_tec.qiitarian.fragment.content.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_tec.qiitarian.QiitarianLog;
import com.tech_tec.qiitarian.R;
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
        QiitarianLog.d(uuid.toString());
    }
    
    public interface ItemUuidGettable {
        String getUuid();
    }
}

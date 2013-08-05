package com.tech_tec.qiitarian.fragment.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;
import com.tech_tec.qiitarian.fragment.list.ItemsFragment;

public class SearchFragment extends Fragment implements FactoryGettable {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        
        view.findViewById(R.id.button_search).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.list_space, new ItemsFragment()).commit();
                
            }
        });
        
        return view;
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return new SearchFactory(new SearchWord("java"));
    }
    
}

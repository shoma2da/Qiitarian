package com.tech_tec.qiitarian.fragment.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.CommandsAbstractFactory;
import com.tech_tec.qiitarian.fragment.list.FactoryGettable;

public class SearchFragment extends Fragment implements FactoryGettable {
    
    private EditText mEditText;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        mEditText = (EditText)view.findViewById(R.id.edittext_search);
        
        ShowListListener listener = new ShowListListener(getChildFragmentManager());
        view.findViewById(R.id.button_search).setOnClickListener(listener);
        
        return view;
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        String word = mEditText.getText().toString();
        return new SearchFactory(new SearchWord(word));
    }
    
}

package com.tech_tec.qiitarian.fragment.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
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
        final View searchButton = view.findViewById(R.id.button_search);
        final ShowListListener listener = new ShowListListener(getChildFragmentManager());
        searchButton.setOnClickListener(listener);
        mEditText = (EditText)view.findViewById(R.id.edittext_search);
        
        mEditText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    listener.onClick(searchButton);
                }
                return false;
            }
        });
        
        return view;
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        String word = mEditText.getText().toString();
        return new SearchFactory(new SearchWord(word));
    }
    
}

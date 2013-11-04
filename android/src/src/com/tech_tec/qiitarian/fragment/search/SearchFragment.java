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
    
    private View mView;
    
    private boolean mIsCached = false;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        
        if (mIsCached) {
            ((ViewGroup)mView.getParent()).removeView(mView);
            return mView;
        }
        
        mView = inflater.inflate(R.layout.fragment_search, null);
        final View searchButton = mView.findViewById(R.id.button_search);
        final ShowListListener listener = new ShowListListener(getActivity());
        searchButton.setOnClickListener(listener);
        EditText editText = (EditText)mView.findViewById(R.id.edittext_search);
        
        editText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    listener.onClick(searchButton);
                }
                return false;
            }
        });
        
        return mView;
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        String word = ((EditText)mView.findViewById(R.id.edittext_search)).getText().toString();
        return new SearchFactory(new SearchWord(word));
    }
    
    public void setIsCached(boolean isCached) {
        mIsCached = isCached;
    }
    
}

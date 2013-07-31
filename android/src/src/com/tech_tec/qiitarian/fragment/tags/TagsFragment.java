package com.tech_tec.qiitarian.fragment.tags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.task.tags.FetchTagsAsyncTask;

public class TagsFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tags, null);
        
        GridView gridView = (GridView)view.findViewById(R.id.grid_tags);
        ArrayAdapter<Tag> adapter = new TagArrayAdapter(getActivity());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GotoItemsByTagsOnItemClickListener(getActivity()));
        
        AuthInfo authInfo = new AuthInfoPreferences(getActivity()).load();
        new FetchTagsAsyncTask(authInfo.getUrlName(), new FetchTagsCallback(adapter)).execute();
        
        return view;
    }
    
}

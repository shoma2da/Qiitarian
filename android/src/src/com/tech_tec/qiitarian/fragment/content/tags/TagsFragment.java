package com.tech_tec.qiitarian.fragment.content.tags;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.tech_tec.qiitarian.R;

public class TagsFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tags, null);
        
        GridView gridView = (GridView)view.findViewById(R.id.grid_tags);
        ArrayAdapter<Void> adapter = new TempAdapter(getActivity());
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        adapter.add(null);
        gridView.setAdapter(adapter);
        
        return view;
    }
    
    private class TempAdapter extends ArrayAdapter<Void> {
        
        private Context _Context;
        
        public TempAdapter(Context context) {
            super(context, 0);
            _Context = context;
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) {
                return convertView;
            }
            return LayoutInflater.from(_Context).inflate(R.layout.layout_tab_item, null);
        }
        
    }
    
}

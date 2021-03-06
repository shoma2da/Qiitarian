package com.tech_tec.qiitarian.fragment.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.activity.home.DefaultCommandsAbstractFactory;
import com.tech_tec.qiitarian.model.items.Item;

public class ItemsFragment extends Fragment implements FactoryGettable {
    
    private Activity mActivity;
    private PullToRefreshListView mListView;
    private boolean mIsCached = false;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        if (activity instanceof FactoryGettable == false) {
            throw new RuntimeException("ActivityはFactoryGettableを実装してください");
        }
        mActivity = activity;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mIsCached) {
            ((ViewGroup)mListView.getParent()).removeView(mListView);
            return mListView;
        }
        View view = inflater.inflate(R.layout.fragment_list, null);
        mListView = (PullToRefreshListView)view.findViewById(R.id.list);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mIsCached) {
            return;
        }
        
        CommandsAbstractFactory mCommandsAbstractFactory = ((FactoryGettable)mActivity).getFactory();
        LayoutInflater inflater = LayoutInflater.from(mActivity.getApplicationContext());
        
        final ArrayAdapter<Item> adapter = new ItemArrayAdapter(getActivity());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new GotoDetailOnItemClickListener(getActivity()));
        mListView.setOnRefreshListener(mCommandsAbstractFactory.createFetchLatestItemsCommand(mListView, adapter));
        mListView.setOnScrollListener(mCommandsAbstractFactory.createFetchMoreItemsCommand(mListView, adapter, inflater));
        
        mListView.prepareForRefresh();
        mListView.onRefresh();
    }
    
    public void setIsCached(boolean isCached) {
        mIsCached = isCached;
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public CommandsAbstractFactory getFactory() {
        return new DefaultCommandsAbstractFactory();
    }

}

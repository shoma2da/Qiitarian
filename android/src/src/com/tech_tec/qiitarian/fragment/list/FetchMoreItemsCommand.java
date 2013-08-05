package com.tech_tec.qiitarian.fragment.list;

import java.util.Iterator;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.list.FetchTask.Callback;
import com.tech_tec.qiitarian.fragment.list.FetchTask.UiCallback;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public abstract class FetchMoreItemsCommand implements OnScrollListener {
    
    static final int MAX_PAGE = 15;
    
    private ListView mListView;
    private ArrayAdapter<Item> mAdapter;
    private LayoutInflater mInflater;
    
    private View mFooter;
    private Integer mCurrentPage = 1;
    private AsyncTask<Integer, Void, Items> mAsyncTask;
    
    private boolean mHasMoreConent = true;
    
    public FetchMoreItemsCommand(ListView listView, LayoutInflater inflater, ArrayAdapter<Item> adapter) {
        mListView = listView;
        mInflater = inflater;
        mAdapter = adapter;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mHasMoreConent == false) {
            return;
        }
        
        if (mCurrentPage == MAX_PAGE) {
            return;
        }
        if (mAdapter.getCount() == 0) {
            return;
        }
        if (firstVisibleItem + visibleItemCount != totalItemCount) {//リストの最後尾でないなら
            return;
        }
        if (mAsyncTask != null) {
            return;
        }
        
        Callback callback = new Callback() {
            @Override
            public void onSuccess(Items items) {
                Iterator<Item> iterator = items.getItemIterator();
                while (iterator.hasNext()) {
                    mAdapter.add(iterator.next());
                }
            }
            @Override
            public void onError() {
            }
            @Override
            public void onEmptySuccess() {
                mHasMoreConent = false;
            }
        };
        UiCallback uiCallback = new UiCallback() {
            @Override
            public void onPreExecute() {
                if (mListView.getFooterViewsCount() == 0) {
                    mFooter = mInflater.inflate(R.layout.layout_list_footer, null);
                    mListView.addFooterView(mFooter);
                }
            }
            @Override
            public void onPostExecute() {
                mListView.removeFooterView(mFooter);
                mAsyncTask = null;
            }
        };
        mAsyncTask = createFetchTask(callback, uiCallback).execute(++mCurrentPage);
    }
    
    protected abstract FetchTask createFetchTask(Callback callback, UiCallback uiCallback);
    
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //なにもしない
    }
    
}

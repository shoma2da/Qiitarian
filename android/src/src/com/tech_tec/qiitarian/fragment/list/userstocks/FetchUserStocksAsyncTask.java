package com.tech_tec.qiitarian.fragment.list.userstocks;

import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.ItemsFetcher;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.user.stocks.http.UserStocksClient;

public class FetchUserStocksAsyncTask extends FetchTask {
    
    private UserUrlName mUserUrlName;
    
    public FetchUserStocksAsyncTask(Callback callback, UiCallback uiCallback, UserUrlName userUrlName) {
        super(callback, uiCallback);
        mUserUrlName = userUrlName;
    }

    @Override
    protected ItemsFetcher createItemsFetcher(int page) {
        return new ItemsFetcher(new UserStocksClient(page, mUserUrlName));
    }

}

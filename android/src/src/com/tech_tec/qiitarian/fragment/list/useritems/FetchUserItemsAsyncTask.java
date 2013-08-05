package com.tech_tec.qiitarian.fragment.list.useritems;

import com.tech_tec.qiitarian.fragment.list.FetchTask;
import com.tech_tec.qiitarian.fragment.list.ItemsFetcher;
import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.user.items.http.UserItemsClient;

public class FetchUserItemsAsyncTask extends FetchTask {
    
    private UserUrlName mUserUrlName;
    
    public FetchUserItemsAsyncTask(Callback callback, UiCallback uiCallback, UserUrlName userUrlName) {
        super(callback, uiCallback);
        mUserUrlName = userUrlName;
    }

    @Override
    protected ItemsFetcher createItemsFetcher(int page) {
        return new ItemsFetcher(new UserItemsClient(page, mUserUrlName));
    }

}

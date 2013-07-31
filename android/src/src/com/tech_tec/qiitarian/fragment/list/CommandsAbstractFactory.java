package com.tech_tec.qiitarian.fragment.list;

public abstract class CommandsAbstractFactory {
    
    public abstract FetchMoreItemsCommand createFetchMoreItemsCommand();
    public abstract GetLatestItemsCommand createGetLatestItemsCommand();
    
}

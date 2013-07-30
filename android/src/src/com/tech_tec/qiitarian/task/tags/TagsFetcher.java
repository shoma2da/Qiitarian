package com.tech_tec.qiitarian.task.tags;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;

import com.tech_tec.qiitarian.fragment.content.tags.http.TagsClient;
import com.tech_tec.qiitarian.model.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.model.tags.Tags;
import com.tech_tec.qiitarian.model.tags.UrlName;
import com.tech_tec.qiitarian.model.tags.parser.TagsParser;

public class TagsFetcher {
    
    public Tags fetch(UrlName urlName, int page) throws ClientProtocolException, IOException, ParseException, JSONException {
        HttpResponseWrapper response = sendRequest(urlName, page);
        if (response.isOK() == false) {
            return null;
        }
        
        Tags tags = parse(response.toJSONArray());
        return tags;
    }
    
    HttpResponseWrapper sendRequest(UrlName urlName, int page) throws ClientProtocolException, IOException {
        TagsClient client = new TagsClient(urlName, page);
        return client.execute();
    }
    
    Tags parse(JSONArray json) throws JSONException, MalformedURLException {
        Tags tags = new TagsParser().parse(json);
        return tags;
    }
}

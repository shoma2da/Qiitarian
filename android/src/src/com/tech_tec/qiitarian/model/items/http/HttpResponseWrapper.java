package com.tech_tec.qiitarian.model.items.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpResponseWrapper {
    
    private HttpResponse mResponse;
    
    public HttpResponseWrapper(HttpResponse response) {
        mResponse = response;
    }
    
    public JSONArray toJSONArray() throws ParseException, IOException, JSONException {
        HttpEntity entity = mResponse.getEntity();
        String responseContent = EntityUtils.toString(entity);
        return new JSONArray(responseContent);
    }
    
    public JSONObject toJSONObject() throws ParseException, IOException, JSONException {
        HttpEntity entity = mResponse.getEntity();
        String responseContent = EntityUtils.toString(entity);
        return new JSONObject(responseContent);
    }
    
    public boolean isOK() {
        return new StatusLineWrapper(mResponse.getStatusLine()).isOK();
    }
    
}

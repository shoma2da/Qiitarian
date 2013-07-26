package com.tech_tec.qiitarian.fragment.content.detail.task;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.detail.http.DetailClient;
import com.tech_tec.qiitarian.model.detail.parser.DetailParser;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.http.HttpResponseWrapper;

class DetailFetcher {
    
    Detail fetch(Uuid uuid, AuthInfo authInfo) throws ClientProtocolException, IOException, ParseException, JSONException {
        DetailClient client = new DetailClient(uuid, authInfo);
        HttpResponseWrapper response = client.execute();
        
        return processResponse(response);
    }
    
    private Detail processResponse(HttpResponseWrapper wrapper) throws JSONException, ParseException, IOException {
        if (wrapper.isOK()) {
            JSONObject json = wrapper.toJSONObject();
            return new DetailParser().parse(json);
        } else {
            return null;
        }
    }
    
}

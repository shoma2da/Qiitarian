package com.tech_tec.qiitarian.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class QiitaJsonHttpClient {
    
    HttpClient mRealClieant;
    
    public QiitaJsonHttpClient() {
        mRealClieant = new DefaultHttpClient();
    }
    
    InputStream execute(HttpUriRequest request) throws ClientProtocolException, IOException {
        HttpResponse response = mRealClieant.execute(request);
        InputStream input = response.getEntity().getContent();
        return input;
    }
    
    String readContent(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuilder builder = new StringBuilder();
        while(scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        return builder.toString();
    }
    
    public JSONObject fetchJson(HttpUriRequest request) throws JSONException, ClientProtocolException, IOException {
        InputStream inputStream = execute(request);
        String content = readContent(inputStream);
        return new JSONObject(content);
    }
    
}

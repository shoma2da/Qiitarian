package com.tech_tec.qiitarian.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

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
}

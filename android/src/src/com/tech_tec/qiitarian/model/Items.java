package com.tech_tec.qiitarian.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.net.http.AndroidHttpClient;

//TODO 実装途中！
public class Items {
    
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US);
    
    public class Item {
        int id;
        String uuid;
        int userId;
        String userUrlName;
        String userProfileImgUrl;
        String title;
        String body;
        Date createdTime;
        String createdTimeInWord;
        int stockCount;
        int commentCount;
        String url;
        ArrayList<Tag> tags;
    }
    
    public class Tag {
        String name;
        String urlName;
        String iconUrl;
    }
    
    private ArrayList<Item> itemList = new ArrayList<Items.Item>();
    private String mUserAgent;
    
    public Items(String useragent) {
        mUserAgent = useragent;
    }
    
    public void loadItems() {
        String url = "https://qiita.com/api/v1/items";
        
        AndroidHttpClient client = AndroidHttpClient.newInstance(mUserAgent);
        try {
            HttpResponse response = client.execute(new HttpGet(url));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outputStream);
            String rawJson = outputStream.toString();
            JSONTokener tokener = new JSONTokener(rawJson);
            
            JSONArray jsonArray = (JSONArray)tokener.nextValue();
            int size = jsonArray.length();
            for (int i = 0; i < size; i++) {
                Item item = loadItem(jsonArray.getJSONObject(i));
                itemList.add(item);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
    
    public Item loadItem(JSONObject json) throws JSONException {
        Item item = new Item();
        
        item.body = json.getString("body");
        item.commentCount = json.getInt("comment_count");
        item.id = json.getInt("id");
        item.uuid = json.getString("uuid");
        item.stockCount = json.getInt("stock_count");
        item.url = json.getString("url");
        item.title = json.getString("title");
        item.userId = json.getJSONObject("user").getInt("id");
        item.userProfileImgUrl = json.getJSONObject("user").getString("profile_image_url");
        item.userUrlName = json.getJSONObject("user").getString("url_name");
        item.createdTimeInWord = json.getString("created_at_in_words");
        try {
            item.createdTime = mDateFormat.parse(json.getString("created_at"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        ArrayList<Tag> tags = new ArrayList<Tag>();
        JSONArray tagsArray = json.getJSONArray("tags");
        int tagsArraySize = tagsArray.length();
        for (int i = 0; i < tagsArraySize; i++) {
            Tag tag = new Tag();
            
            JSONObject tagJson = tagsArray.getJSONObject(i);
            tag.iconUrl = tagJson.getString("icon_url");
            tag.name = tagJson.getString("name");
            tag.urlName = tagJson.getString("url_name");
            
            tags.add(tag);
        }
        item.tags = tags;
        
        return item;
    }
}

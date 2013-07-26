package com.tech_tec.qiitarian.model.detail.parser;

import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.detail.Comment;
import com.tech_tec.qiitarian.model.detail.Comments;

public class CommentsParser {
    
    public Comments parse(JSONArray array) throws JSONException, MalformedURLException {
        Comments comments = new Comments();
        CommentParser parser = new CommentParser();
        
        int arraySize = array.length();
        for (int i = 0; i < arraySize; i++) {
            JSONObject object = array.getJSONObject(i);
            Comment comment = parser.parse(object);
            comments.add(comment);
        }
        
        return comments;
    }
    
}

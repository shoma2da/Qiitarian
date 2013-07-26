package com.tech_tec.qiitarian.model.detail.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.User;
import com.tech_tec.qiitarian.model.detail.Comment;
import com.tech_tec.qiitarian.model.detail.CommentBody;
import com.tech_tec.qiitarian.model.parser.UserParser;

public class CommentParser {
    
    public Comment parse(JSONObject object) throws MalformedURLException, JSONException {
        User user = new UserParser().parse(object.getJSONObject("user"));
        CommentBody commentBody = new CommentBodyParser().parse(object);
        
        return new Comment(user, commentBody);
    }
    
}

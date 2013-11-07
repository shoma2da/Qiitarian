package com.tech_tec.qiitarian.model.detail.parser;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;

import com.tech_tec.qiitarian.model.common.ArticleTitle;
import com.tech_tec.qiitarian.model.common.StockCount;
import com.tech_tec.qiitarian.model.common.User;
import com.tech_tec.qiitarian.model.common.parser.ArticleTitleParser;
import com.tech_tec.qiitarian.model.common.parser.StockCountParser;
import com.tech_tec.qiitarian.model.common.parser.UserParser;
import com.tech_tec.qiitarian.model.detail.ArticleBody;
import com.tech_tec.qiitarian.model.detail.Comments;
import com.tech_tec.qiitarian.model.detail.Detail;
import com.tech_tec.qiitarian.model.detail.IsStocked;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.Tags;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.parser.CreatedAtParser;
import com.tech_tec.qiitarian.model.items.parser.TagsParser;
import com.tech_tec.qiitarian.model.items.parser.UuidParser;

public class DetailParser {
    
    public Detail parse(JSONObject object) throws MalformedURLException, JSONException, ParseException {
        Uuid uuid = new UuidParser().parse(object);
        User user = new UserParser().parse(object.getJSONObject("user"));
        ArticleTitle articleTitle = new ArticleTitleParser().parse(object);
        CreatedAt createdAt = new CreatedAtParser().parse(object);
        StockCount stockCount = new StockCountParser().parse(object);
        ArticleBody articleBody = new ArticleBodyParser().parse(object);
        Comments comments = new CommentsParser().parse(object.getJSONArray("comments"));
        Tags tags = new TagsParser().parse(object.getJSONArray("tags"));
        IsStocked isStocked = new IsStockedParser().parse(object);
        Uri uri = Uri.parse(object.getString("url"));
        
        return new Detail(uuid, user, articleTitle, createdAt, stockCount, articleBody, comments, tags, isStocked, uri);
    }
    
}

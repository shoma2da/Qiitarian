package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.ArticleMeta;
import com.tech_tec.qiitarian.model.items.CreatedAt;
import com.tech_tec.qiitarian.model.items.ReactionCounts;
import com.tech_tec.qiitarian.model.items.Tags;

public class ArticleMetaParser {

    public ArticleMeta parse(JSONObject object) throws JSONException {
        CreatedAt createdAt = new CreatedAtParser().parse(object);
        Tags tags = parseTags(object);
        ReactionCounts reactionCounts = new ReactionCountsParser().parseReactionCounts(object);
        
        return new ArticleMeta(createdAt, tags, reactionCounts);
    }
    
    private Tags parseTags(JSONObject object) throws JSONException {
        JSONArray tagsArray = object.getJSONArray("tags");
        return new TagsParser().parse(tagsArray);
    }
    
}

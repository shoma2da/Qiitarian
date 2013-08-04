package com.tech_tec.qiitarian.fragment.user;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.os.AsyncTask;

import com.tech_tec.qiitarian.model.common.UserUrlName;
import com.tech_tec.qiitarian.model.http.HttpResponseWrapper;
import com.tech_tec.qiitarian.model.user.User;
import com.tech_tec.qiitarian.model.user.http.UserClient;
import com.tech_tec.qiitarian.model.user.parser.UserParser;

public class FetchUserAsyncTask extends AsyncTask<Void, Void, ResponseHandler> {
    
    private UserUrlName mUrlName;
    private Callback mCallback;
    
    public FetchUserAsyncTask(UserUrlName userUrlName, Callback callback) {
        mUrlName = userUrlName;
        mCallback = callback;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallback.onPreExecute();
    }
    
    @Override
    protected ResponseHandler doInBackground(Void... params) {
        UserClient client = new UserClient(mUrlName);
        try {
            HttpResponseWrapper response = client.execute();
            User user = new UserParser().parse(response.toJSONObject());
            return new SuccessResponseHandler(mCallback, user);
        }
        catch (ClientProtocolException e) { e.printStackTrace(); return new ErrorResponseHandler(mCallback); }
        catch (IOException e)             { e.printStackTrace(); return new ErrorResponseHandler(mCallback); }
        catch (ParseException e)          { e.printStackTrace(); return new ErrorResponseHandler(mCallback); }
        catch (JSONException e)           { e.printStackTrace(); return new ErrorResponseHandler(mCallback); }
    }
    
    @Override
    protected void onPostExecute(ResponseHandler result) {
        super.onPostExecute(result);
        result.handle();
    }
    
    public interface Callback {
        void onPreExecute();
        void onSuccess(User user);
        void onError();
    }
    
}

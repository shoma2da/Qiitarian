package com.tech_tec.qiitarian.old.model;


public class AuthInfo {
    
    public static final AuthInfo NULL = new AuthInfo();
    
    private UrlName mUrlName;
    private Token mToken;
    
    private AuthInfo() {
    }
    
    public AuthInfo(UrlName urlName, Token token) {
        mUrlName = urlName;
        mToken = token;
    }
    
    public String getTokenStr() {
        return mToken.toString();
    }
    
    public String getUrlNameStr() {
        return mUrlName.toString();
    }
    
    /*
    private static final String PREF_NAME = "authinfo.xml";
    private static final String KEY_SERVICE = "service";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_TOKEN = "token";
    
    private SharedPreferences mPreferences;
    private HttpClientFactory mClientFactory;
    
    public AuthInfo(Context context, HttpClientFactory clientFactory) {
        mPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mClientFactory = clientFactory;
    }
    
    public interface HttpClientFactory {
        HttpClient create();
    }
    
    public LoginService getService() {
        String serviceStr = mPreferences.getString(KEY_SERVICE, null);
        return LoginService.getByName(serviceStr);
    }

    public void setService(LoginService service) {
        mPreferences.edit().putString(KEY_SERVICE, service.toString()).commit();
    }

    public String getUsername() {
        return mPreferences.getString(KEY_USERNAME, null);
    }

    public void setUsername(String username) {
        mPreferences.edit().putString(KEY_USERNAME, username).commit();
    }

    public String getToken() {
        return mPreferences.getString(KEY_TOKEN, null);
    }

    public void setToken(String token) {
        mPreferences.edit().putString(KEY_TOKEN, token).commit();
    }
    
    public interface OnUpdateCallback {
        void onUpdate(ResponseType responseType);
    }
    
    public void updateAuthInfo(String username, String password, LoginService service, OnUpdateCallback callback) {
        String url = String.format("https://qiita.com/api/v1/auth?url_name=%s&password=%s", service.convert(username), password);
        
        HttpClient client = mClientFactory.create();
        try {
            HttpResponse response = client.execute(new HttpPost(url));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outputStream);
            String rawJson = outputStream.toString();
            outputStream.close();
            
            JSONObject json = new JSONObject(rawJson);
            
            if (json.has("token")) {
                String token = json.getString("token");
                
                setToken(token);
                setUsername(username);
                setService(service);
                
                callback.onUpdate(ResponseType.SUCCESS);
            } else {
                setToken(null);
                setUsername(username);
                setService(service);
                
                callback.onUpdate(ResponseType.FAILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            callback.onUpdate(ResponseType.ERROR);
        } finally {
            client.getConnectionManager().shutdown();
        }
    }
    */
}

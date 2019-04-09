package com.fitbitml.Utils;

import com.fitbitml.service.auth.AuthService;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

import java.io.IOException;

@Component
public class Utils {

    AuthService authService;
    static OkHttpClient client = new OkHttpClient();
    private static final String clientId = "22DBSJ";
    private static final String secretId = "f5c5a80085a01ef93a7711d199a2cfbc";
    private static final String authorization = "556ae8feceb85434abd057542b3a6bec999c72ea";

    @Autowired
    public Utils(AuthService authService){
        this.authService = authService;
    }

    public String getAccessTokenRefreshToken(String url, String authorizationCode) throws IOException {

        String code = clientId+":"+secretId;
        String AuthorizationCodeBase64 = Base64.getEncoder().encodeToString(code.getBytes());
        System.out.println(AuthorizationCodeBase64);

        RequestBody body = RequestBody.create(MediaType.get("application/x-www-form-urlencoded; charset=utf-8"),
                "client_id=22DBSJ&grant_type=authorization_code&redirect_uri=https%3A%2F%2Ffitbit-41668.firebaseapp.com%2Fauth&code="+authorizationCode);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Authorization", "Basic "+AuthorizationCodeBase64)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public boolean isTokenExpired(String data)  {
        final JSONObject jsonObject = new JSONObject(data);
        final JSONArray jsonArray = jsonObject.getJSONArray("errors");
        final JSONObject errorType = jsonArray.getJSONObject(0);
        if (errorType.getString("errorType") == "expired_token"){
            return true;
        }
        return false;
    }


    public String refreshToken(String accessToken) throws IOException {

        String code = clientId+":"+secretId;
        String AuthorizationCodeBase64 = Base64.getEncoder().encodeToString(code.getBytes());
        System.out.println(AuthorizationCodeBase64);

        RequestBody body = RequestBody.create(MediaType.get("application/x-www-form-urlencoded; charset=utf-8"),
                "grant_type=refresh_token&refresh_token="+authService.getAccessToken());
        Request request = new Request.Builder()
                .url("https://api.fitbit.com/oauth2/token")
                .post(body)
                .header("Authorization", "Basic "+AuthorizationCodeBase64)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String getDistance(String authorizationCode) throws IOException {

        Request request = new Request.Builder()
                .url("https://api.fitbit.com/1/user/-/activities/tracker/distance/date/today/1m.json")
                .get()
                .header("Authorization", "Bearer "+authorizationCode)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }



}

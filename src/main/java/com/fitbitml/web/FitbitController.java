package com.fitbitml.web;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;


/**
 * Created by lahcen on 4/4/17.

@Controller
public class FitbitController {

    private String secretCode =  "f5c5a80085a01ef93a7711d199a2cfbc";


    @RequestMapping(value = {"/", "/auth"}, method = RequestMethod.GET)
    public String index() {
        System.out.println("+++++++++++++++ index +++++++++++");


        return "auth";

    }

    private String code;

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam String code, Model model) throws IOException, EncoderException {
        System.out.println("+++++++++++++++ callback+++++++++++");

        this.code = code;
        model.addAttribute("code", code);

        System.out.println(code);

        model.addAttribute("userInfo", new User());

        //model.addAttribute("token", getToken("https://api.fitbit.com/oauth2/token"));




        return "callback";
    }

    String getToken(String url) throws IOException, EncoderException {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        String urlBase64 = "22DBSJ:"+secretCode;

        byte[] encodedBytes = Base64.encodeBase64(urlBase64.getBytes());

        String bytesEncoded = Base64.encodeBase64String(encodedBytes);
        String basicAuth = "Basic " + bytesEncoded;
        System.out.println(basicAuth);
        con.setRequestProperty ("Authorization", basicAuth);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String urlParameters = "client_id=79KND8&grant_type=authorization_code&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Ffitbit%2Fcallback&code="+code;
        con.setDoOutput(true);

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();


        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        System.out.println(con.getURL());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        System.out.println(response.toString());


        // below code converts the json response to json object and reads each values
        JSONObject jsonObj = new JSONObject(response.toString());
        String access_token =jsonObj.getString("access_token");
        System.out.println("access_token : "+access_token);


        return access_token;

    }

    void getData(String token){

    }



}
 */
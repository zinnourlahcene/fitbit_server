package com.fitbitml.service.auth;

import com.fitbitml.api.IApi;
import com.fitbitml.dao.AuthRepository;
import com.fitbitml.domain.Auth;
import com.fitbitml.service.AbstractService;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
public class AuthServiceImpl extends AbstractService<Auth, Integer> implements AuthService {

    private AuthRepository authRepository;
    IApi api;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository, IApi api) {
        super(authRepository);
        this.authRepository = authRepository;
        this.api = api;
    }



    @Override
    public Auth findByAccessToken(String accessToken) {
        return authRepository.findByAccessToken(accessToken);
    }

    @Override
    public void updateAuthorizationCode(String authorizationCode) {
        authRepository.findTopByOrderByIdDesc().setAuthorizationCode(authorizationCode);
    }

    @Override
    public String getAuthorizationCode() {
        return authRepository.findTopByOrderByIdDesc().getAuthorizationCode();
    }

    @Override
    public String getAccessToken() throws IOException {
        String token = authRepository.findTopByOrderByIdDesc().getAccessToken();

        System.out.println("======= "+token);
        if (api.isTokenExpired(token)){
            api.refreshToken(authRepository.findTopByOrderByIdDesc().getRefreshToken(), authRepository.findTopByOrderByIdDesc());
        }
        return authRepository.findTopByOrderByIdDesc().getAccessToken();
    }

    @Override
    public int deleteByAccessToken(String accessToken) {
        return authRepository.deleteByAccessToken(accessToken);
    }

///***********************************************************


}

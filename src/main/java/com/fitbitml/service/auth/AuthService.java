package com.fitbitml.service.auth;

import com.fitbitml.domain.Auth;
import com.fitbitml.service.IService;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;

public interface AuthService extends IService<Auth, Integer> {

    Auth findByAccessToken(String accessToken);

    void updateAuthorizationCode(String authorizationCode);

    String getAccessToken() throws IOException;

    String getAuthorizationCode();

    int deleteByAccessToken(String accessToken);

    //***********************************


}

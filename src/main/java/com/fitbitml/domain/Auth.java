package com.fitbitml.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.*;
import javax.persistence.*;
import java.io.IOException;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Auth", schema = "public")
public class Auth {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "authorization_code")
    private String authorizationCode;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "expired_token")
    private boolean expiredToken;

    @Column(name = "expires_in")
    private int expiresIn;

    @Column(name = "scope")
    private String scope;

    @Column(name = "token_type")
    private String tokenType;

    @Column(name = "user_id")
    private String userId;

    public Auth(String authorizationCode, String accessToken, String refreshToken, boolean expiredToken, int expiresIn, String scope, String tokenType, String userId) {
        this.authorizationCode = authorizationCode;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiredToken = expiredToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.tokenType = tokenType;
        this.userId = userId;
    }

    public void setAccessTokenRefreshToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "authorizationCode='" + authorizationCode + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiredToken=" + expiredToken +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

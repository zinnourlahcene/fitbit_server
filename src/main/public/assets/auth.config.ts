import { AuthConfig } from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {

  // Url of the Identity Provider
  loginUrl: 'https://www.fitbit.com/oauth2/authorize/',

  // URL of the SPA to redirect the user to after login
  // redirectUri: /* window.location.origin +  */'http://localhost:4200/auth',
  redirectUri: /* window.location.origin +  */'https://fitbitml.herokuapp.com/auth',

  // The SPA's id. The SPA is registerd with this id at the auth-server
  clientId: '22DBSJ',
  oidc: false,


  // set the scope for the permissions the client should request
  // The first three are defined by OIDC. The 4th is a usecase-specific one
  scope: 'activity heartrate location nutrition profile settings sleep social weight',

  responseType: 'code',

  fallbackAccessTokenExpirationTimeInSec: 604800
}
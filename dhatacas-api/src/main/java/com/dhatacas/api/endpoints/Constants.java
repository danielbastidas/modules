package com.dhatacas.api.endpoints;

/**
 * Contains the client IDs and scopes for allowed clients consuming the dhatacas API.
 */
public class Constants {
	
  /** The Constant WEB_CLIENT_ID. */
  public static final String WEB_CLIENT_ID = "167191929228-lgh170fter8im7l77lu90a1gl1oobpeb.apps.googleusercontent.com";
  
  //For PRODUCTION purpose only
  //public static final String WEB_CLIENT_ID = "167191929228-mgl2vtp7cv596iiu5vb080f34v886ils.apps.googleusercontent.com";
  
  /** The Constant ANDROID_CLIENT_ID. */
  public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
  
  /** The Constant IOS_CLIENT_ID. */
  public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
  
  /** The Constant ANDROID_AUDIENCE. */
  public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

  /** The Constant EMAIL_SCOPE. */
  public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  
  /** The Constant API_EXPLORER_CLIENT_ID. */
  public static final String API_EXPLORER_CLIENT_ID = com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID;

}

package com.github.marcinciapa.tutorials.mads.apigw.security;

public interface ApiKeyAuthorizationChecker {

    boolean isAuthorized(String apiKey, String application);
}

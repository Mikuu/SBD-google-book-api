package com.ariman.book.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Biao on 07/11/2017.
 */
@Component
@ConfigurationProperties(prefix="backend")
public class MyConfig {

    private String googleApiUrl;
    private String googleApiPath;

    public String getGoogleApiUrl() {
        return googleApiUrl;
    }

    public void setGoogleApiUrl(String googleApiUrl) {
        this.googleApiUrl = googleApiUrl;
    }

    public String getGoogleApiPath() {
        return googleApiPath;
    }

    public void setGoogleApiPath(String googleApiPath) {
        this.googleApiPath = googleApiPath;
    }
}

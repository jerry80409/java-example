package com.example.service;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by jerry on 2017/1/11.
 */
public class DefaultQueryInterceptor implements Interceptor {
    /**
     * @see <a href="http://developer.simsimi.com/lclist">http://developer.simsimi.com/lclist</a>
     */
    private static final String LOCATION_LAN = "ch";
    private static final String BAD_WORD_DISCRIMINATOR = "1.0";

    /**
     * You should apply TRIAL_KEY
     * From <a href="http://developer.simsimi.com/">http://developer.simsimi.com/</a>
     */
    private static final String TRIAL_KEY = "you-should-apply-trial-key";


    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl keyQuery = chain.request().url()
                .newBuilder()
                .addQueryParameter("key", TRIAL_KEY)
                .addQueryParameter("lc", LOCATION_LAN)
                .addQueryParameter("ft", BAD_WORD_DISCRIMINATOR)
                .build();
        Request request = chain.request().newBuilder().url(keyQuery).build();
        return chain.proceed(request);
    }
}

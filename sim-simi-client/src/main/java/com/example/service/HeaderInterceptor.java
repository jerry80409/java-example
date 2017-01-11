package com.example.service;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by jerry on 2017/1/11.
 * 這邊用 攔截器 替 Request 附加 Header
 * 附加 User-Agent, Key, Secret
 * <p>
 */
public class HeaderInterceptor implements Interceptor {
    /**
     * It's a sample, you can put it like
     * Mozilla/[version]（[system and browser information]）[platform]（[platform details]）[extensions]
     */
    private static final String USER_AGENT = "Mozilla/5.0";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("User-Agent", USER_AGENT)
                .build();
        return chain.proceed(request);
    }
}

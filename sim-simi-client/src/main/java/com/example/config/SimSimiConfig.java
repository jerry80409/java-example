package com.example.config;

import com.example.service.SimSimiService;
import com.example.service.SimSimiServiceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jerry on 2017/1/11.
 */
@Configuration
public class SimSimiConfig {

    /**
     * 這邊可以調整 Request 公用的屬性。
     * 宣告為 Bean 為 single instance
     * @return
     */
    @Bean
    public SimSimiService simSimService() {
        return SimSimiServiceBuilder.create()
//                .apiEndPoint(OTHER_VERSION_ENDPOINT)
//                .connectTimeout(CONNECT_TIME_OUT)
//                .addInterceptor(CUSTOMER_INTERCEPTOR)
                .build();
    }

}

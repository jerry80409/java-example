package com.example.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

/**
 * Created by jerry on 2017/1/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimSimiServiceTest {

    @Inject
    private SimSimiService simSimiService;

    @Test
    public void assertResponseIs200() throws Exception {
        Assert.assertEquals(200, simSimiService.chat("hi").execute().code());
    }
}

package com.example;

import com.example.service.SimSimiService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimSimiClientApplicationTests {

    @Inject
    private SimSimiService simSimiService;

    /**
     * Assert SimSimiService has been Loaded
     */
    @Test
    public void contextLoads() {
        Assert.assertNotNull(simSimiService);
    }

}

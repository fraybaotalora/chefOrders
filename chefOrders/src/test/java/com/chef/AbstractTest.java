package com.chef;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChefOrdersApplication.class)
@WebAppConfiguration
@EnableConfigurationProperties
public class AbstractTest {

    protected MockMvc mvc;

    protected MockRestServiceServer mockRestServer;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    RestTemplate restTemplate;


    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockRestServer = MockRestServiceServer.createServer(restTemplate);
    }

}

package com.chef;


import com.chef.order.facade.OrderFacade;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.File;
import java.io.IOException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@ActiveProfiles("test")
public class ChefOrderTest extends AbstractTest {

    @Value("classpath:mock/json/ListOrderResponse.json")
    private File listOrderRestResponse;

    @Autowired
    OrderFacade orderFacade;

    @Value("${vtex.api.listorders}")
    private String URL;


    @Test
    public void listOrder() throws IOException {



        String uri =
                UriComponentsBuilder.fromUriString(URL)
                        .build().toUriString();

        mockRestServer.expect(requestTo(uri))
                .andRespond(MockRestResponseCreators.withSuccess(FileUtils.readFileToString(listOrderRestResponse),
                        MediaType.APPLICATION_JSON));



    }

}

package org.mydotey.kbear.rest.resource;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.mydotey.kbear.meta.MetaServiceTest;
import org.mydotey.kbear.rest.App;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author koqizhao
 *
 * Nov 29, 2018
 */
public class MetaServiceResourceTest extends MetaServiceTest {

    private MetaServiceClient _metaServiceClient;

    private ConfigurableApplicationContext _applicationContext;

    @Before
    public void setUp() {
        _applicationContext = SpringApplication.run(App.class);
        _metaServiceClient = new MetaServiceClient("http://localhost:8081");
    }

    @After
    public void tearDown() throws IOException {
        _applicationContext.close();
        _metaServiceClient.close();
    }

    @Override
    protected boolean useContextManager() {
        return false;
    }

    @Override
    protected Object getService() {
        return _metaServiceClient;
    }

}

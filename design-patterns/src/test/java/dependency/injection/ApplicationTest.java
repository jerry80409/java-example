package dependency.injection;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by jerry on 2017/11/21.
 */
public class ApplicationTest {

    @Mock
    private MessageService mockMessageService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void teardown() {
    }

    @Test
    public void assertEmailServiceTriggered() {
        Application app = new Application(mockMessageService);

        // trigger
        app.notification("test-message", "someone");

        // mock
        doNothing()
                .when(mockMessageService)
                .sendMessage(anyString(), anyString());

        // verify emailService will be call once
        verify(mockMessageService, times(1));
    }

}

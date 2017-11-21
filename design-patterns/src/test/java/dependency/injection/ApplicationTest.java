package dependency.injection;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by jerry on 2017/11/21.
 */
public class ApplicationTest {

    @Mock
    private EmailService mockEmailService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertApplication() {
        Application app = new Application(mockEmailService);

        // trigger
        app.notification("test-message", "someone");

        // mock
        doNothing()
                .when(mockEmailService)
                .sendEmail(anyString(), anyString());

        // verify emailService will be call once
        verify(mockEmailService, times(1));
    }

}

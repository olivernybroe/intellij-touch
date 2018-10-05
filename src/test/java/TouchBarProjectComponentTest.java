import com.intellij.openapi.project.Project;
import dk.lost_world.intellij_touch.TouchBar;
import dk.lost_world.intellij_touch.TouchBarProjectComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TouchBar.class)
public class TouchBarProjectComponentTest {

    private TouchBarProjectComponent touchBarProjectComponent;

    @Mock
    private Project project;

    @Before
    public void init() {
        System.out.println("Running Test: " + getClass().getSimpleName());
        // initialize @Mock annotations
        MockitoAnnotations.initMocks(this);
        touchBarProjectComponent = new TouchBarProjectComponent(project);
    }

    @Test
    public void testHappyCase() {
        PowerMockito.mockStatic(TouchBar.class);
        final TouchBar touchBar = Mockito.mock(TouchBar.class);
        PowerMockito.when(TouchBar.getInstance(project)).thenReturn(touchBar);
        touchBarProjectComponent.projectOpened();
        Mockito.verify(touchBar, Mockito.times(1)).refresh();
    }
}

package dk.lost_world.intellij_touch.Settings;

import com.intellij.openapi.project.ProjectManager;
import dk.lost_world.intellij_touch.TouchBar;

import javax.swing.*;
import java.util.stream.Stream;

public class TouchBarGUI {
    private JPanel rootPanel;
    private JButton refreshTouchBarButton;

    public TouchBarGUI() {
        refreshTouchBarButton.addActionListener(
            e -> Stream.of(ProjectManager.getInstance().getOpenProjects()).
                forEach(project -> TouchBar.getInstance(project).refresh())
        );
    }

    public JPanel getPanel() {
        return rootPanel;
    }
}

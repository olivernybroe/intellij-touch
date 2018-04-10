package dk.lost_world.intellij_touch;

import com.intellij.icons.AllIcons;
import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.ide.ui.customization.CustomisedActionGroup;
import com.intellij.ide.ui.customization.CustomizationUtil;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.application.ApplicationListener;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.remoteServer.impl.runtime.ui.ServersToolWindowContent;
import com.intellij.util.messages.MessageBusConnection;
import com.thizzer.jtouchbar.JTouchBar;
import dk.lost_world.intellij_touch.Button.ButtonBuilder;
import dk.lost_world.intellij_touch.Component.ComponentBuilder;
import jiconfont.icons.FontAwesome;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.Stream;

public class TouchBarComponent implements ProjectComponent {

    @Override
    public void initComponent() {
        System.out.println("works yes");


        JTouchBar jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier("intellij-touch");

        //jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFlexibleSpace));

        TouchBar touchBar = TouchBar.getInstance();

        ActionGroup touchBarGroup = (ActionGroup)
            CustomActionsSchema.getInstance().getCorrectedAction("dk.lost_world.intellij_touch.TouchBar");

        // Add all the buttons to the Touch bar.
        Stream.of(touchBarGroup.getChildren(null)).forEach(anAction ->
                ComponentBuilder.fromAction(anAction).add()
        );
        System.out.println(touchBarGroup.getClass());

        if(touchBarGroup instanceof CustomisedActionGroup) {

        }

        ActionManager.getInstance().addAnActionListener(new AnActionListener() {
            @Override
            public void beforeActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {
                System.out.println(action+" templateText:"+action.getTemplatePresentation().getText());
            }
        });

    }
}

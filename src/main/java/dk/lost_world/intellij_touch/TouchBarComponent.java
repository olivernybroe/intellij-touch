package dk.lost_world.intellij_touch;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.WindowManager;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Image;
import com.thizzer.jtouchbar.common.ImageAlignment;
import com.thizzer.jtouchbar.common.ImageName;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import com.thizzer.jtouchbar.item.view.TouchBarScrubber;
import com.thizzer.jtouchbar.item.view.TouchBarTextField;
import com.thizzer.jtouchbar.item.view.TouchBarView;
import com.thizzer.jtouchbar.item.view.action.TouchBarViewAction;
import com.thizzer.jtouchbar.scrubber.ScrubberActionListener;
import com.thizzer.jtouchbar.scrubber.ScrubberDataSource;
import com.thizzer.jtouchbar.scrubber.view.ScrubberImageItemView;
import com.thizzer.jtouchbar.scrubber.view.ScrubberTextItemView;
import com.thizzer.jtouchbar.scrubber.view.ScrubberView;
import dk.lost_world.intellij_touch.Button.ButtonBuilder;
import dk.lost_world.intellij_touch.Icons.FontAwesomePro;
import jiconfont.icons.FontAwesome;

import javax.swing.*;
import java.io.IOException;

public class TouchBarComponent implements ProjectComponent {

    @Override
    public void initComponent() {
        System.out.println("works yes");

        JTouchBar jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier("intellij-touch");

        //jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFlexibleSpace));

        TouchBar touchBar = TouchBar.getInstance();

        ButtonBuilder.builder()
            .action(IdeActions.ACTION_DEFAULT_RUNNER)
            .icon(AllIcons.Actions.Execute)
            .identifier("run_button")
        .add();

        ButtonBuilder.builder()
            .action(IdeActions.ACTION_DEFAULT_DEBUGGER)
            .icon(AllIcons.Actions.StartDebugger)
            .identifier("run_debug_button")
        .add();

        ButtonBuilder.builder()
            .action(IdeActions.ACTION_EDITOR_REFORMAT)
            .icon(FontAwesome.CODE)
            .identifier("reformat_button")
        .add();

        /*
        ButtonBuilder.builder()
            .action(IdeActions.ACTION_COMMENT_LINE)
            .icon(FontAwesome.COMMENT)
            .identifier("comment_button")
        .add();

        ButtonBuilder.builder()
            .action(IdeActions.ACTION_COMMENT_BLOCK)
            .icon(FontAwesome.COMMENTS)
            .identifier("comment_block_button")
        .add();
        */

        ButtonBuilder.builder()
            .action("Vcs.UpdateProject")
            .icon(AllIcons.Actions.CheckOut)
            .identifier("vcs_update_button")
        .add();


        ButtonBuilder.builder()
            .action("CheckinProject")
            .icon(AllIcons.Actions.Commit)
            .identifier("vcs_commit_button")
            .add();

        ActionManager.getInstance().addAnActionListener(new AnActionListener() {
            @Override
            public void beforeActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {
                System.out.println(action+" templateText:"+action.getTemplatePresentation().getText());
            }
        });
    }
}

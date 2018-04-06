package dk.lost_world.intellij_touch;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.ServiceManager;
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


        JFrame frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
        jTouchBar.show(WindowManager.getInstance().findVisibleFrame());

        // flexible space
        jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFlexibleSpace));

// fixed space
        jTouchBar.addItem(new TouchBarItem(TouchBarItem.NSTouchBarItemIdentifierFixedSpaceSmall));

// button
        TouchBarButton touchBarButtonImg = new TouchBarButton();
        touchBarButtonImg.setTitle("Button 1");
        touchBarButtonImg.setAction(new TouchBarViewAction() {
            @Override
            public void onCall( TouchBarView view ) {
                System.out.println("Clicked Button_1.");
            }
        });

        Image image = new Image(ImageName.NSImageNameTouchBarColorPickerFill, false);
        touchBarButtonImg.setImage(image);

        jTouchBar.addItem(new TouchBarItem("Button_1", touchBarButtonImg, true));

// label
        TouchBarTextField touchBarTextField = new TouchBarTextField();
        touchBarTextField.setStringValue("TextField 1");

        jTouchBar.addItem(new TouchBarItem("TextField_1", touchBarTextField, true));

// scrubber
        TouchBarScrubber touchBarScrubber = new TouchBarScrubber();
        touchBarScrubber.setActionListener(new ScrubberActionListener() {
            @Override
            public void didSelectItemAtIndex(TouchBarScrubber scrubber, long index) {
                System.out.println("Selected Scrubber Index: " + index);
            }
        });
        touchBarScrubber.setDataSource(new ScrubberDataSource() {
            @Override
            public ScrubberView getViewForIndex(TouchBarScrubber scrubber, long index) {
                if(index == 0) {
                    ScrubberTextItemView textItemView = new ScrubberTextItemView();
                    textItemView.setIdentifier("ScrubberItem_1");
                    textItemView.setStringValue("Scrubber TextItem");

                    return textItemView;
                }
                else {
                    ScrubberImageItemView imageItemView = new ScrubberImageItemView();
                    imageItemView.setIdentifier("ScrubberItem_2");
                    imageItemView.setImage(new Image(ImageName.NSImageNameTouchBarAlarmTemplate, false));
                    imageItemView.setAlignment(ImageAlignment.CENTER);

                    return imageItemView;
                }
            }

            @Override
            public int getNumberOfItems(TouchBarScrubber scrubber) {
                return 2;
            }
        });

        /*
        TouchBar touchBar = TouchBar.getInstance();


        ButtonBuilder.builder()
            .action(IdeActions.ACTION_EDITOR_REFORMAT)
            .icon(FontAwesome.CODE)
            .identifier("undo_button")
        .add();

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

        ButtonBuilder.builder()
            .action("Vcs.UpdateProject")
            .icon(FontAwesome.UPLOAD)
            .identifier("vcs_update_button")
        .add();

        ButtonBuilder.builder()
            .action("CheckinProject")
            .title("Commit")
            //.icon(getClass().getClassLoader().getResourceAsStream("icons/git-commit.png"))
            .identifier("vcs_commit")
            .add();

        */

        ActionManager.getInstance().addAnActionListener(new AnActionListener() {
            @Override
            public void beforeActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {
                System.out.println(action+" templateText:"+action.getTemplatePresentation().getText());
            }
        });
    }
}

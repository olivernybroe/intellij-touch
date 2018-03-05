package dk.lost_world.intellij_touch;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.ServiceManager;
import dk.lost_world.intellij_touch.Button.ButtonBuilder;
import dk.lost_world.intellij_touch.Icons.FontAwesomePro;
import jiconfont.icons.FontAwesome;

import java.io.IOException;

public class TouchBarComponent implements ProjectComponent {

    @Override
    public void initComponent() {
        System.out.println("works yes");
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

        try {
            ButtonBuilder.builder()
                .action("CheckinProject")
                .icon(
                    getClass().getClassLoader()
                        .getResourceAsStream("icons/test.png")
                )
                .identifier("vcs_commit")
                .add();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        ActionManager.getInstance().addAnActionListener(new AnActionListener() {
            @Override
            public void beforeActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {
                System.out.println(action+" templateText:"+action.getTemplatePresentation().getText());
            }
        });
    }
}

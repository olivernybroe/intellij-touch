package dk.lost_world.intellij_touch.Settings;

import com.intellij.icons.AllIcons;
import com.intellij.ide.ui.customization.ActionUrl;
import com.intellij.ide.ui.customization.CustomActionsSchema;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Separator;
import com.intellij.openapi.actionSystem.ex.QuickList;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.keymap.impl.ui.ActionsTree;
import com.intellij.openapi.keymap.impl.ui.ActionsTreeUtil;
import com.intellij.openapi.keymap.impl.ui.Group;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.packageDependencies.ui.TreeExpansionMonitor;
import com.intellij.ui.JBDefaultTreeCellRenderer;
import com.intellij.ui.TreeUIHelper;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ObjectUtils;
import com.intellij.util.containers.Convertor;
import com.intellij.util.ui.UIUtil;
import dk.lost_world.intellij_touch.TouchBar;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.stream.Stream;

public class TouchBarGUI {
    private JPanel rootPanel;
    private JButton refreshTouchBarButton;
    private JButton buttonblaButton;
    private JButton button2;
    private JButton button3;
    private JTree itemsTree;

    public TouchBarGUI() {
        refreshTouchBarButton.addActionListener(
            e -> ApplicationManager.getApplication().executeOnPooledThread(() ->
                Stream.of(ProjectManager.getInstance().getOpenProjects()).
                    forEach(project -> TouchBar.getInstance(project).refresh())
            )
        );
    }

    public JPanel getPanel() {
        return rootPanel;
    }

    private void createUIComponents() {

        Group rootGroup = new Group("root", null, null);
        final DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootGroup);
        itemsTree = new Tree(root);
        TreeUIHelper.getInstance().installTreeSpeedSearch(
            itemsTree, new TreePathStringConverter(), true);

        itemsTree.setRootVisible(false);
        itemsTree.setShowsRootHandles(true);
        UIUtil.setLineStyleAngled(itemsTree);
        itemsTree.setCellRenderer(new MyTreeCellRenderer());

        patchActionsTreeCorrespondingToSchema(root);

        TreeExpansionMonitor.install(itemsTree);
        reset();
    }

    protected void reset() {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) itemsTree.getModel().getRoot();
        root.removeAllChildren();
        root.add(ActionsTreeUtil.createNode(
            ActionsTreeUtil.createGroup(
                TouchBarCustomizableActionGroupProvider.getTouchBarSchema(),
                "Touchbar",
                null,
                null,
                true,
                null,
                false
            )
        ));
        ((DefaultTreeModel) itemsTree.getModel()).reload();
        itemsTree.setSelectionRow(0);
        itemsTree.expandRow(0);
    }

    private void patchActionsTreeCorrespondingToSchema(DefaultMutableTreeNode root) {

    }

    private static class MyTreeCellRenderer extends JBDefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree,
                                                      Object value,
                                                      boolean sel,
                                                      boolean expanded,
                                                      boolean leaf,
                                                      int row,
                                                      boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, false);
            if (value instanceof DefaultMutableTreeNode) {
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                Icon icon = null;
                if (userObject instanceof Group) {
                    Group group = (Group) userObject;
                    String name = group.getName();
                    setText(name != null ? name : group.getId());
                    icon = ObjectUtils.notNull(group.getIcon(), AllIcons.Nodes.Folder);
                } else if (userObject instanceof String) {
                    String actionId = (String) userObject;
                    AnAction action = ActionManager.getInstance().getAction(actionId);
                    String name = action != null ? action.getTemplatePresentation().getText() : null;
                    setText(!StringUtil.isEmptyOrSpaces(name) ? name : actionId);
                    if (action != null) {
                        Icon actionIcon = action.getTemplatePresentation().getIcon();
                        if (actionIcon != null) {
                            icon = actionIcon;
                        }
                    }
                } else if (userObject instanceof Pair) {
                    String actionId = (String) ((Pair) userObject).first;
                    AnAction action = ActionManager.getInstance().getAction(actionId);
                    setText(action != null ? action.getTemplatePresentation().getText() : actionId);
                    icon = (Icon) ((Pair) userObject).second;
                } else if (userObject instanceof Separator) {
                    setText("-------------");
                } else if (userObject instanceof QuickList) {
                    setText(((QuickList) userObject).getName());
                    icon = AllIcons.Actions.QuickList;
                } else if (userObject != null) {
                    throw new IllegalArgumentException("unknown userObject: " + userObject);
                }

                setIcon(ActionsTree.getEvenIcon(icon));

                if (sel) {
                    setForeground(UIUtil.getTreeSelectionForeground());
                } else {
                    setForeground(UIUtil.getTreeForeground());
                }
            }
            return this;
        }
    }

    public static class TreePathStringConverter implements Convertor<TreePath, String> {
        @Override
        public String convert(TreePath o) {
            Object node = o.getLastPathComponent();
            if (node instanceof DefaultMutableTreeNode) {
                Object object = ((DefaultMutableTreeNode) node).getUserObject();
                if (object instanceof Group) return ((Group) object).getName();
                if (object instanceof QuickList) return ((QuickList) object).getName();
                String actionId;
                if (object instanceof String) {
                    actionId = (String) object;
                } else if (object instanceof Pair) {
                    actionId = (String) ((Pair) object).first;
                } else {
                    return "";
                }
                AnAction action = ActionManager.getInstance().getAction(actionId);
                if (action != null) {
                    return action.getTemplatePresentation().getText();
                }
            }
            return "";
        }
    }
}

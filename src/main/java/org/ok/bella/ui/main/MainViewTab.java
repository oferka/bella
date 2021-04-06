package org.ok.bella.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import org.ok.bella.ui.EntityType;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewTab.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewTab extends Tab {

    public static final String VIEW_ID_SUFFIX = "main-view-tab";
    public static String ID_SUFFIX = "-tab";

    private final MainViewTabRouterLink mainViewTabRouterLink;

    public MainViewTab(String viewId, String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        String id = viewId + ID_SUFFIX;
        setId(id);
        mainViewTabRouterLink = new MainViewTabRouterLink(id, text, navigationTarget, vaadinIcon);
        add(mainViewTabRouterLink);
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }

    public MainViewTab(EntityType entityType) {
        this(entityType.getRoute(), entityType.getEntitiesViewName(), entityType.getEntitiesViewClass(), entityType.getEntitiesViewIcon());
    }
}

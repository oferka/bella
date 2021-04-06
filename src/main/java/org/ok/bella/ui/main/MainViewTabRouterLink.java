package org.ok.bella.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewTabRouterLink.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewTabRouterLink extends RouterLink {

    public static final String VIEW_ID_SUFFIX = "main-view-tab-router-link";
    public static String ID_SUFFIX = "-router-link";

    private final MainViewTabRouterLinkContent mainViewTabRouterLinkContent;

    public MainViewTabRouterLink(String mainViewTabId, String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        String id = mainViewTabId + ID_SUFFIX;
        setId(id);
        setRoute(navigationTarget);

        mainViewTabRouterLinkContent = new MainViewTabRouterLinkContent(id, text, vaadinIcon);
        add(mainViewTabRouterLinkContent);
    }
}

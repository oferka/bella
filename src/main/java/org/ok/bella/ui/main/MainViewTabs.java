package org.ok.bella.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import org.ok.bella.ui.feed.FeedView;
import org.ok.bella.ui.home.HomeView;

import java.util.Optional;

import static org.ok.bella.ui.EntityType.*;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewTabs.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewTabs extends Tabs {

    public static final String VIEW_ID_SUFFIX = "main-view-tabs";

    public MainViewTabs() {
        setId(VIEW_ID_SUFFIX);
        setOrientation(Tabs.Orientation.VERTICAL);
        addThemeVariants(TabsVariant.LUMO_MINIMAL);
        add(createTabs());
    }

    private Component[] createTabs() {
        return new Component[] {
                new MainViewTab(HomeView.HOME_VIEW_ID, HomeView.HOME_VIEW_NAME, HomeView.class, HomeView.HOME_VIEW_ICON),
                new MainViewTab(FeedView.FEED_VIEW_ID, FeedView.FEED_VIEW_NAME, FeedView.class, FeedView.FEED_VIEW_ICON),
                new MainViewTab(EMPLOYEE)
        };
    }

    public void selectTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}

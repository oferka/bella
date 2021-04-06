package org.ok.bella.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewDrawer.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewDrawer extends VerticalLayout {

    public static final String VIEW_ID_SUFFIX = "main-view-drawer";

    private final MainViewDrawerHeader mainViewDrawerHeader;
    private final MainViewTabs mainViewTabs;

    public MainViewDrawer() {
        setId(VIEW_ID_SUFFIX);

        getThemeList().set("dark", true);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);

        mainViewTabs = new MainViewTabs();
        mainViewDrawerHeader = new MainViewDrawerHeader();

        add(mainViewDrawerHeader, mainViewTabs);
    }

    public void selectTab(Component content) {
        mainViewTabs.selectTab(content);
    }
}

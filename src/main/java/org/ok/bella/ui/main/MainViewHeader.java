package org.ok.bella.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.validation.constraints.NotNull;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewHeader.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewHeader extends HorizontalLayout {

    public static final String VIEW_ID_SUFFIX = "main-view-header";

    private final MainViewDrawerToggle mainViewDrawerToggle;
    private final MainViewTitle mainViewTitle;
    private final MainViewActions mainViewActions;

    public MainViewHeader() {
        setId(VIEW_ID_SUFFIX);
        setWidthFull();
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.CENTER);

        mainViewDrawerToggle = new MainViewDrawerToggle();
        add(mainViewDrawerToggle);

        mainViewTitle = new MainViewTitle();
        add(mainViewTitle);

        mainViewActions = new MainViewActions();
        add(mainViewActions);
    }

    public void setTitleText(@NotNull String titleText) {
        mainViewTitle.setTitleText(titleText);
    }
}

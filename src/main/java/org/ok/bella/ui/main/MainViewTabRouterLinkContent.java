package org.ok.bella.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewTabRouterLinkContent.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewTabRouterLinkContent extends HorizontalLayout {

    public static final String VIEW_ID_SUFFIX = "main-view-tab-router-link-content";
    public static String ID_SUFFIX = "-content";

    public MainViewTabRouterLinkContent(String mainViewTabRouterLinkId, String text, VaadinIcon vaadinIcon) {
        setId(mainViewTabRouterLinkId + ID_SUFFIX);

        Span span = new Span(text);
        Icon icon = new Icon(vaadinIcon);
        add(icon, span);
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon, span);
    }
}

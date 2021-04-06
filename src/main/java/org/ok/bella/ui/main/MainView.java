package org.ok.bella.ui.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.PWA;

import static org.ok.bella.ui.Styles.*;

@CssImport(VIEWS_FOLDER + MainView.VIEW_ID_PREFIX + "/" + MainView.VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
@PWA(name = MainView.APPLICATION_NAME, shortName = MainView.APPLICATION_SHORT_NAME, enableInstallPrompt = false)
@JsModule(SHARED_STYLES_FILE)
public class MainView extends AppLayout {

    public static final String APPLICATION_NAME = "Bella";
    public static final String APPLICATION_SHORT_NAME = "Bella";
    public static final String VIEW_ID_PREFIX = "main";
    public static final String VIEW_ID_SUFFIX = "main-view";

    private final MainViewDrawer mainViewDrawer;
    private final MainViewHeader mainViewHeader;

    public MainView() {
        setId(VIEW_ID_SUFFIX);
        setPrimarySection(Section.DRAWER);

        mainViewHeader = new MainViewHeader();
        addToNavbar(true, mainViewHeader);

        mainViewDrawer = new MainViewDrawer();
        addToDrawer(mainViewDrawer);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        mainViewDrawer.selectTab(getContent());
        mainViewHeader.setTitleText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        return getContent().getClass().getAnnotation(PageTitle.class).value();
    }
}

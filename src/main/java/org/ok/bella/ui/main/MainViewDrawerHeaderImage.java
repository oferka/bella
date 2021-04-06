package org.ok.bella.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.main.MainView.VIEW_ID_PREFIX;
import static org.ok.bella.ui.main.MainViewDrawerHeaderImage.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + VIEW_ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainViewDrawerHeaderImage extends Image {

    public static final String VIEW_ID_SUFFIX = "main-view-drawer-header-image";

    public MainViewDrawerHeaderImage() {
        setId(VIEW_ID_SUFFIX);

        setSrc("images/logo.png");
        setAlt("DevForce logo");
    }
}

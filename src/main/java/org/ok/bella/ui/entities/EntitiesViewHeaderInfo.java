package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderInfo.VIEW_HEADER_INFO_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_INFO_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderInfo extends VerticalLayout {

    public static final String VIEW_HEADER_INFO_ID_SUFFIX = "-view-header-info";

    private final EntitiesViewHeaderTitlePanel entitiesViewHeaderTitlePanel;
    private final EntitiesViewHeaderDescription entitiesViewHeaderDescription;

    public EntitiesViewHeaderInfo(String idPrefix, String titleText, int count, String descriptionText, VaadinIcon vaadinIcon) {
        setId(idPrefix + VIEW_HEADER_INFO_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_INFO_ID_SUFFIX);

        entitiesViewHeaderTitlePanel = new EntitiesViewHeaderTitlePanel(idPrefix, titleText, count, vaadinIcon);
        add(entitiesViewHeaderTitlePanel);

        entitiesViewHeaderDescription = new EntitiesViewHeaderDescription(idPrefix, descriptionText);
        add(entitiesViewHeaderDescription);
    }
}

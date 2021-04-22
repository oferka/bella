package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderTitlePanel.VIEW_HEADER_TITLE_PANEL_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderTitlePanel extends HorizontalLayout {

    public static final String VIEW_HEADER_TITLE_PANEL_ID_SUFFIX = "-view-header-title-panel";

    private final EntitiesViewHeaderIcon entitiesViewHeaderIcon;
    private final EntitiesViewHeaderType entitiesViewHeaderType;
    private final EntitiesViewHeaderCount entitiesViewHeaderCount;

    public EntitiesViewHeaderTitlePanel(String idPrefix, String titleText, EntitiesDataProvider entitiesDataProvider, VaadinIcon vaadinIcon) {
        setId(idPrefix + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX);

        entitiesViewHeaderIcon = new EntitiesViewHeaderIcon(idPrefix, vaadinIcon, entitiesDataProvider);
        entitiesViewHeaderType = new EntitiesViewHeaderType(idPrefix, titleText, entitiesDataProvider);
        entitiesViewHeaderCount = new EntitiesViewHeaderCount(idPrefix, entitiesDataProvider);

        add(entitiesViewHeaderIcon, entitiesViewHeaderType, entitiesViewHeaderCount);
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, entitiesViewHeaderIcon, entitiesViewHeaderType, entitiesViewHeaderCount);
    }
}

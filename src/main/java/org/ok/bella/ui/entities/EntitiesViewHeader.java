package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeader.VIEW_HEADER_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeader<T extends EntitiesDataProvider> extends HorizontalLayout {

    public static final String VIEW_HEADER_ID_SUFFIX = "-view-header";

    private final EntitiesViewHeaderInfo<T> entitiesViewHeaderInfo;
    private final EntitiesViewHeaderActions<T> entitiesViewHeaderActions;

    public EntitiesViewHeader(String idPrefix, String titleText, T entitiesDataProvider, String descriptionText, String entityName, VaadinIcon vaadinIcon) {
        setId(idPrefix + VIEW_HEADER_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_ID_SUFFIX);

        setWidthFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        entitiesViewHeaderInfo = new EntitiesViewHeaderInfo<>(idPrefix, titleText, entitiesDataProvider, descriptionText, vaadinIcon);
        add(entitiesViewHeaderInfo);

        entitiesViewHeaderActions = new EntitiesViewHeaderActions<>(idPrefix, entityName, entitiesDataProvider);
        add(entitiesViewHeaderActions);
    }
}

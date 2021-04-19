package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderActions.VIEW_HEADER_ACTIONS_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_ACTIONS_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderActions<T extends EntitiesDataProvider> extends HorizontalLayout {

    public static final String VIEW_HEADER_ACTIONS_ID_SUFFIX = "-view-header-actions";

    private final EntitiesFilterButton<T> entitiesFilterButton;
    private final EntitiesNewButton<T> entitiesNewButton;

    public EntitiesViewHeaderActions(String idPrefix, String entityName, T entitiesDataProvider) {
        setId(idPrefix + VIEW_HEADER_ACTIONS_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_ACTIONS_ID_SUFFIX);

        entitiesFilterButton = new EntitiesFilterButton<>(idPrefix, entitiesDataProvider);
        add(entitiesFilterButton);

        entitiesNewButton = new EntitiesNewButton<>(idPrefix, entityName, entitiesDataProvider);
        add(entitiesNewButton);
    }
}

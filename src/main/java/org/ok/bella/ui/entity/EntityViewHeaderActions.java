package org.ok.bella.ui.entity;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityViewHeaderActions.VIEW_HEADER_ACTIONS_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + VIEW_HEADER_ACTIONS_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityViewHeaderActions extends HorizontalLayout {

    public static final String VIEW_HEADER_ACTIONS_ID_SUFFIX = "-view-header-actions";

    private final EntityShareButton entityShareButton;
    private final EntityExportButton entityExportButton;

    public EntityViewHeaderActions(String idPrefix, String entityName) {
        setId(idPrefix + VIEW_HEADER_ACTIONS_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + VIEW_HEADER_ACTIONS_ID_SUFFIX);

        entityShareButton = new EntityShareButton(idPrefix);
        add(entityShareButton);

        entityExportButton = new EntityExportButton(idPrefix, entityName);
        add(entityExportButton);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        entityShareButton.selectedEntityChanged(selectedEntityId);
        entityExportButton.selectedEntityChanged(selectedEntityId);
    }
}

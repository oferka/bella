package org.ok.bella.ui.entity;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityViewHeader.VIEW_HEADER_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + VIEW_HEADER_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityViewHeader extends HorizontalLayout {

    public static final String VIEW_HEADER_ID_SUFFIX = "-view-header";

    private final EntityViewHeaderInfo entityViewHeaderInfo;
    private final EntityViewHeaderActions entityViewHeaderActions;

    public EntityViewHeader(String idPrefix, String titleText, String descriptionText, String entityName, VaadinIcon vaadinIcon) {
        setId(idPrefix + VIEW_HEADER_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + VIEW_HEADER_ID_SUFFIX);

        setWidthFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        entityViewHeaderInfo = new EntityViewHeaderInfo(idPrefix, titleText, descriptionText, vaadinIcon);
        add(entityViewHeaderInfo);

        entityViewHeaderActions = new EntityViewHeaderActions(idPrefix, entityName);
        add(entityViewHeaderActions);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        entityViewHeaderInfo.selectedEntityChanged(selectedEntityId);
        entityViewHeaderActions.selectedEntityChanged(selectedEntityId);
    }
}

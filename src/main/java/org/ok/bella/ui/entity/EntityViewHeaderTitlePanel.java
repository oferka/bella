package org.ok.bella.ui.entity;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityViewHeaderTitlePanel.VIEW_HEADER_TITLE_PANEL_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityViewHeaderTitlePanel extends HorizontalLayout {

    public static final String VIEW_HEADER_TITLE_PANEL_ID_SUFFIX = "-view-header-title-panel";

    private final EntityViewHeaderIcon entityViewHeaderIcon;
    private final EntityViewHeaderTitle entityViewHeaderTitle;

    public EntityViewHeaderTitlePanel(String idPrefix, String titleText, VaadinIcon vaadinIcon) {
        setId(idPrefix + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + VIEW_HEADER_TITLE_PANEL_ID_SUFFIX);

        entityViewHeaderIcon = new EntityViewHeaderIcon(idPrefix, vaadinIcon);
        entityViewHeaderTitle = new EntityViewHeaderTitle(idPrefix, titleText);

        add(entityViewHeaderIcon, entityViewHeaderTitle);
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, entityViewHeaderIcon, entityViewHeaderTitle);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        entityViewHeaderIcon.selectedEntityChanged(selectedEntityId);
        entityViewHeaderTitle.selectedEntityChanged(selectedEntityId);
    }
}

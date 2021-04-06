package org.ok.bella.ui.entity;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import org.ok.bella.ui.EntityType;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityView.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public abstract class EntityView extends VerticalLayout implements HasUrlParameter<String> {

    public static final String ENTITY_ID_PREFIX = "entity";
    public static final String VIEW_ID_SUFFIX = "-view";

    private final EntityViewHeader entityViewHeader;
    private final EntityViewBody entityViewBody;

    public EntityView() {
        setId(getEntityType().getEntityIdPrefix() + VIEW_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + VIEW_ID_SUFFIX);

        setHeightFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        entityViewHeader = new EntityViewHeader(
                getEntityType().getEntityIdPrefix(),
                getEntityType().getEntityViewName(),
                getEntityType().getEntityViewDescription(),
                getEntityType().getEntityName(),
                getEntityType().getEntitiesViewIcon()
        );
        add(entityViewHeader);

        entityViewBody = getViewBody();
        add(entityViewBody);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        selectedEntityChanged(parameter);
    }

    private void selectedEntityChanged(String selectedEntityId) {
        entityViewHeader.selectedEntityChanged(selectedEntityId);
        entityViewBody.selectedEntityChanged(selectedEntityId);
    }

    protected abstract EntityType getEntityType();
    protected abstract EntityViewBody getViewBody();
}

package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.ok.bella.model.Entity;
import org.ok.bella.ui.EntityType;
import org.ok.bella.ui.entity.EntityView;

import java.util.List;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewBody.VIEW_BODY_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_BODY_ID_SUFFIX + CSS_FILE_EXTENSION)
public abstract class EntitiesViewBody<E extends Entity> extends VerticalLayout {

    public static final String VIEW_BODY_ID_SUFFIX = "-view-body";

    private EntitiesViewBody(String idPrefix, Class<? extends EntityView> entityNavigationTarget, EntitiesDataProvider<E> entitiesDataProvider) {
        setId(idPrefix + VIEW_BODY_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_BODY_ID_SUFFIX);
        addClassName(idPrefix + VIEW_BODY_ID_SUFFIX);

        setHeightFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        List<E> entities = entitiesDataProvider.getItems();
        for(Entity entity : entities) {
            add(new RouterLink(entity.getId(), entityNavigationTarget, entity.getId()));
        }
    }

    public EntitiesViewBody(EntityType entityType, EntitiesDataProvider<E> entitiesDataProvider) {
        this(entityType.getEntityIdPrefix(), entityType.getEntityViewClass(), entitiesDataProvider);
    }
}

package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.ok.bella.model.Entity;
import org.ok.bella.ui.EntityType;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesView.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public abstract class EntitiesView<E extends Entity> extends VerticalLayout {

    public static final String ENTITIES_ID_PREFIX = "entities";
    public static final String VIEW_ID_SUFFIX = "-view";

    private final EntitiesViewHeader entitiesViewHeader;
    private final EntitiesViewBody entitiesViewBody;

    public EntitiesView(EntitiesDataProvider<E> entitiesDataProvider) {
        setId(getEntityType().getEntitiesIdPrefix() + VIEW_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_ID_SUFFIX);

        setHeightFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        entitiesViewHeader = new EntitiesViewHeader<E>(
                getEntityType().getEntitiesIdPrefix(),
                getEntityType().getEntitiesViewName(),
                entitiesDataProvider,
                getEntityType().getEntitiesViewDescription(),
                getEntityType().getEntityName(),
                getEntityType().getEntitiesViewIcon()
        );
        add(entitiesViewHeader);

        entitiesViewBody = getViewBody(entitiesDataProvider);
        add(entitiesViewBody);
    }

    protected abstract EntityType getEntityType();
    protected abstract EntitiesViewBody<E> getViewBody(EntitiesDataProvider<E> entitiesDataProvider);
}

package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.ok.bella.model.Entity;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesPresentationTypeSelector.PRESENTATION_TYPE_SELECTOR_ID_SUFFIX;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + PRESENTATION_TYPE_SELECTOR_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesPresentationTypeSelector<E extends Entity> extends HorizontalLayout {

    public static final String PRESENTATION_TYPE_SELECTOR_ID_SUFFIX = "-presentation-type-selector";

    private final EntitiesGridPresentationTypeButton<E> entitiesGridPresentationTypeButton;
    private final EntitiesCardPresentationTypeButton<E> entitiesCardPresentationTypeButton;

    private final String idPrefix;
    private final EntitiesDataProvider<E> entitiesDataProvider;

    public EntitiesPresentationTypeSelector(String idPrefix, EntitiesDataProvider<E> entitiesDataProvider) {
        this.idPrefix = idPrefix;
        this.entitiesDataProvider = entitiesDataProvider;
        setId(idPrefix + PRESENTATION_TYPE_SELECTOR_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + PRESENTATION_TYPE_SELECTOR_ID_SUFFIX);

        setSpacing(false);

        entitiesGridPresentationTypeButton = new EntitiesGridPresentationTypeButton<>(idPrefix, entitiesDataProvider);
        add(entitiesGridPresentationTypeButton);

        entitiesCardPresentationTypeButton = new EntitiesCardPresentationTypeButton<>(idPrefix, entitiesDataProvider);
        add(entitiesCardPresentationTypeButton);
    }
}

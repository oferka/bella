package org.ok.bella.ui.entities;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.ok.bella.model.Entity;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + EntitiesGridPresentationTypeButton.GRID_PRESENTATION_TYPE_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesGridPresentationTypeButton<E extends Entity> extends Button {

    public static final String GRID_PRESENTATION_TYPE_BUTTON_ID_SUFFIX = "-grid-presentation-type-button";

    private final String idPrefix;
    private final EntitiesDataProvider<E> entitiesDataProvider;

    public EntitiesGridPresentationTypeButton(String idPrefix, EntitiesDataProvider<E> entitiesDataProvider) {
        this.idPrefix = idPrefix;
        this.entitiesDataProvider = entitiesDataProvider;
        setId(idPrefix + GRID_PRESENTATION_TYPE_BUTTON_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + GRID_PRESENTATION_TYPE_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.TABLE.create());
        addClickListener(this::gridPresentationTypeClicked);
        addClickShortcut(Key.KEY_G, KeyModifier.ALT);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        long count = entitiesDataProvider.count();
        Notification.show("Grid Presentation Type " + idPrefix + " (" + count + ")", 3000, MIDDLE);
    }
}

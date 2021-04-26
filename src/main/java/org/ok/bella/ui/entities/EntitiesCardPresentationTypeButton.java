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
import static org.ok.bella.ui.entities.EntitiesCardPresentationTypeButton.CARD_PRESENTATION_TYPE_BUTTON_ID_SUFFIX;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + CARD_PRESENTATION_TYPE_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesCardPresentationTypeButton<E extends Entity> extends Button {

    public static final String CARD_PRESENTATION_TYPE_BUTTON_ID_SUFFIX = "-card-presentation-type-button";

    private final String idPrefix;
    private final EntitiesDataProvider<E> entitiesDataProvider;

    public EntitiesCardPresentationTypeButton(String idPrefix, EntitiesDataProvider<E> entitiesDataProvider) {
        this.idPrefix = idPrefix;
        this.entitiesDataProvider = entitiesDataProvider;
        setId(idPrefix + CARD_PRESENTATION_TYPE_BUTTON_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + CARD_PRESENTATION_TYPE_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.LIST.create());
        addClickListener(this::cardPresentationTypeClicked);
        addClickShortcut(Key.KEY_C, KeyModifier.ALT);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        long count = entitiesDataProvider.count();
        Notification.show("Card Presentation Type " + idPrefix + " (" + count + ")", 3000, MIDDLE);
    }
}

package org.ok.bella.ui.entities;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesNewButton.NEW_BUTTON_ID_SUFFIX;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + NEW_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesNewButton<T extends EntitiesDataProvider> extends Button {

    public static final String NEW_BUTTON_ID_SUFFIX = "-new-button";

    private final String idPrefix;
    private final String entityName;

    public EntitiesNewButton(String idPrefix, String entityName, T entitiesDataProvider) {
        this.idPrefix = idPrefix;
        this.entityName = entityName;
        setId(idPrefix + NEW_BUTTON_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + NEW_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.PLUS_CIRCLE.create());
        setText("New " + entityName);
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::newClicked);
        addClickShortcut(Key.KEY_N, KeyModifier.ALT);
    }

    private void newClicked(ClickEvent<Button> event) {
        Notification.show("New " + entityName, 3000, MIDDLE);
    }
}

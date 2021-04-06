package org.ok.bella.ui.entities;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesFilterButton.FILTER_BUTTON_ID_SUFFIX;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + FILTER_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesFilterButton extends Button {

    public static final String FILTER_BUTTON_ID_SUFFIX = "-filter-button";

    private final String idPrefix;

    public EntitiesFilterButton(String idPrefix) {
        this.idPrefix = idPrefix;
        setId(idPrefix + FILTER_BUTTON_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + FILTER_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.FILTER.create());
        setText("Filter");
        addClickListener(this::filterClicked);
        addClickShortcut(Key.KEY_F, KeyModifier.ALT);
    }

    private void filterClicked(ClickEvent<Button> event) {
        Notification.show("Filter " + idPrefix, 3000, MIDDLE);
    }
}

package org.ok.bella.ui.entity;

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
import static org.ok.bella.ui.entity.EntityExportButton.EXPORT_BUTTON_ID_SUFFIX;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + EXPORT_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityExportButton extends Button {

    public static final String EXPORT_BUTTON_ID_SUFFIX = "-export-button";

    private final String idPrefix;
    private final String entityName;

    public EntityExportButton(String idPrefix, String entityName) {
        this.idPrefix = idPrefix;
        this.entityName = entityName;
        setId(idPrefix + EXPORT_BUTTON_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + EXPORT_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export " + entityName);
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
        addClickShortcut(Key.KEY_E, KeyModifier.ALT);
    }

    private void exportClicked(ClickEvent<Button> event) {
        Notification.show("Export " + entityName, 3000, MIDDLE);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        System.out.println(selectedEntityId);
    }
}

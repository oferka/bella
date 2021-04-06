package org.ok.bella.ui.entity;

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
import static org.ok.bella.ui.entity.EntityShareButton.SHARE_BUTTON_ID_SUFFIX;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + SHARE_BUTTON_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityShareButton extends Button {

    public static final String SHARE_BUTTON_ID_SUFFIX = "-share-button";

    private final String idPrefix;

    public EntityShareButton(String idPrefix) {
        this.idPrefix = idPrefix;
        setId(idPrefix + SHARE_BUTTON_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + SHARE_BUTTON_ID_SUFFIX);

        setIcon(VaadinIcon.SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(Key.KEY_S, KeyModifier.ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        Notification.show("Share " + idPrefix, 3000, MIDDLE);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        System.out.println(selectedEntityId);
    }
}

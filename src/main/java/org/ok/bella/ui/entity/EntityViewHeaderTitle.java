package org.ok.bella.ui.entity;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import javax.validation.constraints.NotNull;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entity.EntityView.ENTITY_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityViewHeaderTitle.VIEW_HEADER_TITLE_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITY_ID_PREFIX + "/" + ENTITY_ID_PREFIX + VIEW_HEADER_TITLE_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntityViewHeaderTitle extends H2 {

    public static final String VIEW_HEADER_TITLE_ID_SUFFIX = "-view-header-title";

    public EntityViewHeaderTitle(String idPrefix, String titleText) {
        setId(idPrefix + VIEW_HEADER_TITLE_ID_SUFFIX);
        addClassName(ENTITY_ID_PREFIX + VIEW_HEADER_TITLE_ID_SUFFIX);

        setTitleText(titleText);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }

    public void selectedEntityChanged(String selectedEntityId) {
        setTitleText(selectedEntityId);
    }
}

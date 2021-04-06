package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;

import javax.validation.constraints.NotNull;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderDescription.VIEW_HEADER_DESCRIPTION_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_DESCRIPTION_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderDescription extends Span {

    public static final String VIEW_HEADER_DESCRIPTION_ID_SUFFIX = "-view-header-description";

    public EntitiesViewHeaderDescription(String idPrefix, String descriptionText) {
        setId(idPrefix + VIEW_HEADER_DESCRIPTION_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_DESCRIPTION_ID_SUFFIX);

        setDescriptionText(descriptionText);
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}

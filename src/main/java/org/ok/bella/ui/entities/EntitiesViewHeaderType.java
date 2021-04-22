package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import javax.validation.constraints.NotNull;

import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderType.VIEW_HEADER_TYPE_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX  + VIEW_HEADER_TYPE_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderType extends H2 {

    public static final String VIEW_HEADER_TYPE_ID_SUFFIX = "-view-header-type";

    public EntitiesViewHeaderType(String idPrefix, String titleText, EntitiesDataProvider entitiesDataProvider) {
        setId(idPrefix + VIEW_HEADER_TYPE_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_TYPE_ID_SUFFIX);

        setTitleText(titleText);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}

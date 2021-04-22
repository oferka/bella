package org.ok.bella.ui.entities;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import org.ok.bella.model.Entity;

import static java.lang.String.format;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.entities.EntitiesView.ENTITIES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesViewHeaderCount.VIEW_HEADER_COUNT_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ENTITIES_ID_PREFIX + "/" + ENTITIES_ID_PREFIX + VIEW_HEADER_COUNT_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EntitiesViewHeaderCount<E extends Entity> extends H2 {

    public static final String VIEW_HEADER_COUNT_ID_SUFFIX = "-view-header-count";

    public EntitiesViewHeaderCount(String idPrefix, EntitiesDataProvider<E> entitiesDataProvider) {
        setId(idPrefix + VIEW_HEADER_COUNT_ID_SUFFIX);
        addClassName(ENTITIES_ID_PREFIX + VIEW_HEADER_COUNT_ID_SUFFIX);

        setTitleText(entitiesDataProvider.count());
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}

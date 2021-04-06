package org.ok.bella.ui.feed;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.ok.bella.ui.main.MainView;

import static com.vaadin.flow.component.icon.VaadinIcon.LINES_LIST;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.feed.FeedView.*;

@Route(value = FEED_ROUTE, layout = MainView.class)
@PageTitle(FEED_VIEW_NAME)
@CssImport(VIEWS_FOLDER + FEED_ROUTE + "/" + FEED_VIEW_ID + CSS_FILE_EXTENSION)
public class FeedView extends HorizontalLayout {

    public static final String FEED_ROUTE = "feed";
    public static final String FEED_ID_PREFIX = "feed";
    public static final String FEED_ID_SUFFIX = "-view";
    public static final String FEED_VIEW_ID = FEED_ID_PREFIX + FEED_ID_SUFFIX;
    public static final String FEED_VIEW_NAME = "Feed";
    public static final VaadinIcon FEED_VIEW_ICON = LINES_LIST;

    public FeedView() {
        setId(FEED_VIEW_ID);
        setAlignItems(FlexComponent.Alignment.CENTER);

        Text text = new Text(FEED_VIEW_NAME);
        add(text);
    }
}

package org.ok.bella.ui.employees;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.ok.bella.ui.EntityType;
import org.ok.bella.ui.employees.dp.EmployeesDataProvider;
import org.ok.bella.ui.entities.EntitiesDataProvider;
import org.ok.bella.ui.entities.EntitiesView;
import org.ok.bella.ui.entities.EntitiesViewBody;
import org.ok.bella.ui.main.MainView;

import static org.ok.bella.ui.EntityType.EMPLOYEE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.employees.EmployeesView.*;

@Route(value = EMPLOYEES_ROUTE, layout = MainView.class)
@PageTitle(EMPLOYEES_VIEW_NAME)
@CssImport(VIEWS_FOLDER + EMPLOYEES_ID_PREFIX + "/" + EMPLOYEES_ID_PREFIX + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EmployeesView extends EntitiesView {

    public static final String EMPLOYEES_ROUTE = "employees";
    public static final String EMPLOYEES_VIEW_NAME = "Employees";
    public static final String EMPLOYEES_ID_PREFIX = "employees";

    public EmployeesView(EntitiesDataProvider entitiesDataProvider) {
        super(entitiesDataProvider);
    }

    @Override
    protected EntityType getEntityType() {
        return EMPLOYEE;
    }

    @Override
    protected EntitiesViewBody getViewBody(EntitiesDataProvider entitiesDataProvider) {
        return new EmployeesViewBody(entitiesDataProvider);
    }
}
